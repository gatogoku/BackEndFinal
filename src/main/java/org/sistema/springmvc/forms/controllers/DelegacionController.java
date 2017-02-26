package org.sistema.springmvc.forms.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.sistema.springmvc.forms.impl.CiudadDAOHibernate;
import org.sistema.springmvc.forms.impl.DelegacionDAOHibernate;
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
public class DelegacionController {
	private static final Logger logger = LoggerFactory.getLogger(DelegacionController.class);

	@Autowired
	private DelegacionDAOHibernate delegacionDAO;

	@Autowired
	private CiudadDAOHibernate ciudadDAO;

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

	@RequestMapping(value = { "/delegaciones" }, method = RequestMethod.GET)
	public String showDelegaciones(Map<String, Object> model) {
		List<Delegacion> delegations = delegacionDAO.selectAll(Delegacion.class);
		model.put("delegations", delegations);
		return "delegacion/delegaciones";
	}

	@RequestMapping(method = RequestMethod.GET, value = { "/delegacion/newdelegacion/" })
	public String newDelegacion(Map<String, Object> model) {
		model.put("delegacion", new Delegacion());
		return "delegacion/newdelegacion";
	}

	@RequestMapping(method = RequestMethod.POST, value = { "/delegacion/newdelegacion/new" })
	public ModelAndView createDelegacion(@Valid Delegacion delegacion, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("delegacion/newdelegacion");
			modelAndView.addObject("delegacion", delegacion);
			return modelAndView;
		}
		if (delegacionDAO.insert(delegacion)) {
			modelAndView.setViewName("delegacion/created");
			modelAndView.addObject("delegacion", delegacion);
		} else {
			modelAndView.setViewName("error");
			modelAndView.addObject("error", "An error ocurred while trying to create a new user. Please, try again");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/delegacion/saveupdate", method = RequestMethod.POST)
	public ModelAndView saveUpdateD(@Valid Delegacion delegacion, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("delegacion/update");
			modelAndView.addObject("delegacion", delegacion);
			return modelAndView;
		}
		delegacionDAO.update(delegacion);

		modelAndView.addObject("delegacion", delegacion);
		modelAndView.setViewName("delegacion/saveUpdated");
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = { "/delegacion/{id}" })
	public String delegacionDetail(@PathVariable(value = "id") Integer id, Map<String, Object> model) {
		Delegacion delegacion = delegacionDAO.selectById(id, Delegacion.class);
		model.put("delegacion", delegacion);
		return "delegacion/delegaciondetail";
	}

	@RequestMapping(value = "/delegacion/update/{id}", method = RequestMethod.GET)
	public String updateD(@PathVariable(value = "id") Integer userId, Model model) {
		logger.info("Showing update view GET ");
		Delegacion delegacion = delegacionDAO.selectById(userId, Delegacion.class);
		model.addAttribute("delegacion", delegacionDAO.selectById(userId, Delegacion.class));
		return "delegacion/update";
	}

	@RequestMapping(value = "/delegacion/delete/{id}", method = RequestMethod.GET)
	public String deleteD(@PathVariable(value = "id") Integer userId, Model model) {
		Delegacion delegacion = delegacionDAO.selectById(userId, Delegacion.class);
		delegacionDAO.delete(delegacion);
		model.addAttribute("userId", userId);
		return "delegacion/deleted";
	}

}
