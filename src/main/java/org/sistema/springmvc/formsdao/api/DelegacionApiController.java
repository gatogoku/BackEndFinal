package org.sistema.springmvc.formsdao.api;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;


import org.sistema.springmvc.forms.impl.CiudadDAOHibernate;
import org.sistema.springmvc.forms.impl.DelegacionDAOHibernate;
import org.sistema.springmvc.forms.models.Delegacion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/web")

public class DelegacionApiController {
	private static final Logger logger = LoggerFactory.getLogger(DelegacionApiController.class);

	@Autowired
	private DelegacionDAOHibernate delegacionDAOHibernate;

	@Autowired
	private CiudadDAOHibernate ciudadDAO;

	public DelegacionDAOHibernate getDelegacionDAO() {
		return delegacionDAOHibernate;
	}

	public void setDelegacionDAO(DelegacionDAOHibernate delegacionDAOHibernate) {
		this.delegacionDAOHibernate = delegacionDAOHibernate;
	}

	public CiudadDAOHibernate getCiudadDAO() {
		return ciudadDAO;
	}

	public void setCiudadDAO(CiudadDAOHibernate ciudadDAO) {
		this.ciudadDAO = ciudadDAO;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody  List<Delegacion> showDelegaciones(Map<String, Object> model) {
			return  delegacionDAOHibernate.selectAll(Delegacion.class);
	}

		@RequestMapping(method = RequestMethod.GET, value = { "/{id}" })
		public @ResponseBody  Delegacion getById(@PathVariable(value = "id") Integer id) {
			return delegacionDAOHibernate.selectById(id, Delegacion.class);
		}

		@RequestMapping(method = RequestMethod.POST , value = { "/insert" })
		public void insert(@RequestBody Delegacion series) {
			delegacionDAOHibernate.insert(series);
		}

		@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
		public @ResponseBody void  update(@PathVariable Integer id,
				@RequestBody @Valid Delegacion series) {
			series.setId(id);
			delegacionDAOHibernate.update(series);
		}

		@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
		
		public void delete(@PathVariable(value = "id") Integer id) {
			delegacionDAOHibernate.delete(delegacionDAOHibernate.selectById(id, Delegacion.class));
			// return new ResponseEntity(HttpStatus.OK);
		}


	
	
	

	
		

	/*@RequestMapping(method = RequestMethod.GET, value = { "/web/newdelegacion/" })
	public String newDelegacion(Map<String, Object> model) {
		model.put("delegacion", new Delegacion());
		return "delegacion/newdelegacion";
	}

	@RequestMapping(method = RequestMethod.POST, value = { "/web/newdelegacion/new" })
	public ModelAndView createDelegacion(@Valid Delegacion delegacion, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("web/newdelegacion");
			modelAndView.addObject("delegacion", delegacion);
			return modelAndView;
		}
		if (delegacionDAOHibernate.insert(delegacion)) {
			modelAndView.setViewName("web/created");
			modelAndView.addObject("delegacion", delegacion);
		} else {
			modelAndView.setViewName("error");
			modelAndView.addObject("error", "An error ocurred while trying to create a new user. Please, try again");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/web/saveupdate", method = RequestMethod.POST)
	public ModelAndView saveUpdateD(@Valid Delegacion delegacion, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("delegacion/update");
			modelAndView.addObject("delegacion", delegacion);
			return modelAndView;
		}
		delegacionDAOHibernate.update(delegacion);

		modelAndView.addObject("delegacion", delegacion);
		modelAndView.setViewName("delegacion/saveUpdated");
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = { "/web/{id}" })
	public String delegacionDetail(@PathVariable(value = "id") Integer id, Map<String, Object> model) {
		Delegacion delegacion = delegacionDAOHibernate.selectById(id, Delegacion.class);
		model.put("delegacion", delegacion);
		return "delegacion/delegaciondetail";
	}

	@RequestMapping(value = "/web/update/{id}", method = RequestMethod.GET)
	public String updateD(@PathVariable(value = "id") Integer userId, Model model) {
		logger.info("Showing update view GET ");
		Delegacion delegacion = delegacionDAOHibernate.selectById(userId, Delegacion.class);
		model.addAttribute("delegacion", delegacionDAOHibernate.selectById(userId, Delegacion.class));
		return "delegacion/update";
	}

	@RequestMapping(value = "/web/delete/{id}", method = RequestMethod.GET)
	public String deleteD(@PathVariable(value = "id") Integer userId, Model model) {
		Delegacion delegacion = delegacionDAOHibernate.selectById(userId, Delegacion.class);
		delegacionDAOHibernate.delete(delegacion);
		model.addAttribute("userId", userId);
		return "delegacion/deleted";
	}*/

}
