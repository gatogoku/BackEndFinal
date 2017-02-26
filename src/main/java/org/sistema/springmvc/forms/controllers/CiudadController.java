package org.sistema.springmvc.forms.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.sistema.springmvc.forms.impl.CiudadDAOHibernate;
import org.sistema.springmvc.forms.impl.DelegacionDAOHibernate;
import org.sistema.springmvc.forms.models.Ciudad;
import org.sistema.springmvc.forms.models.Delegacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CiudadController {
	private static final Logger logger = LoggerFactory.getLogger(CiudadController.class);
	@Autowired
	private DelegacionDAOHibernate delegacionDAO;
	// private FakeDelegacionDAO delegacionDAO;
	@Autowired
	private CiudadDAOHibernate ciudadDAO;

	@RequestMapping(method = RequestMethod.GET, value = { "/", "/ciudades" })
	public String showCitys(Map<String, Object> model) {
		List<Ciudad> citys = ciudadDAO.selectAll(Ciudad.class);
		model.put("citys", citys);
		return "ciudad/ciudades";
	}

	public DelegacionDAOHibernate getDelegacionDAO() {
		return delegacionDAO;
	}

	public void setDelegacionDAO(DelegacionDAOHibernate delegacionDAO) {
		this.delegacionDAO = delegacionDAO;
	}

	public CiudadDAOHibernate getCiudadDAO() {
		return ciudadDAO;
	}

	public void setCiudadDAO(CiudadDAOHibernate ciudadDAO) {
		this.ciudadDAO = ciudadDAO;
	}

	@RequestMapping(method = RequestMethod.GET, value = { "/ciudad/newcity/" })
	public String newUser(Map<String, Object> model) {
		model.put("ciudad", new Ciudad());
		return "ciudad/newcity";
	}

	@RequestMapping(method = RequestMethod.POST, value = { "/ciudad/newcity/new" })
	public ModelAndView createUser(@Valid Ciudad ciudad, BindingResult bindingResult) {
		logger.info("Saveview POST " + ciudad.getId());
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("ciudad/newcity");
			modelAndView.addObject("user", ciudad);
			return modelAndView;
		}

		if (ciudadDAO.insert(ciudad)) {
			modelAndView.setViewName("ciudad/created");
			modelAndView.addObject("user", ciudad);
		} else {
			modelAndView.setViewName("error");
			modelAndView.addObject("error", "An error ocurred while trying to create a new user. Please, try again");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/ciudad/saveupdate", method = RequestMethod.POST)
	public ModelAndView saveUpdate(@Valid Ciudad user, BindingResult bindingResult) {
		logger.info("Save update " + user.getId());
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("ciudad/update");
			modelAndView.addObject("ciudad", user);
			return modelAndView;
		}
		ciudadDAO.update(user);
		modelAndView.addObject("user", user);
		modelAndView.setViewName("ciudad/saveUpdated");
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = { "/ciudad/{id}" })
	public String userDetail(@PathVariable(value = "id") Integer id, Map<String, Object> model) {
		logger.info("User detail");
		Ciudad user = ciudadDAO.selectById(id, Ciudad.class);
		model.put("user", user);
		return "ciudad/citydetail";
	}

	@RequestMapping(value = "/ciudad/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable(value = "id") Integer userId, Model model) {
		logger.info("Showing update view GET ");
		model.addAttribute("ciudad", ciudadDAO.selectById(userId, Ciudad.class));
		return "ciudad/update";
	}

	@RequestMapping(value = "/ciudad/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable(value = "id") Integer userId, Model model) {
		logger.info("Product detail /delete");
		ciudadDAO.delete(ciudadDAO.selectById(userId, Ciudad.class));
		model.addAttribute("userId", userId);
		return "ciudad/deleted";
	}

	@RequestMapping(value = "/createdelegation/{id}", method = RequestMethod.GET)
	public String createDelegation(Map<String, Object> model, @PathVariable(value = "id") Integer id) {
		Delegacion delegacion = new Delegacion();
		Ciudad ciudad = ciudadDAO.selectById(id, Ciudad.class);
		delegacion.setCiudad(ciudad);
		model.put("delegacion", delegacion);
		return "delegacion/newdelegacion";

	}

}
