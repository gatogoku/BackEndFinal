package org.sistema.springmvc.forms.controllers;

import java.util.List;
import java.util.Map;

import org.sistema.springmvc.forms.dao.UserDAO;
import org.sistema.springmvc.forms.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for users.
 * 
 * @author Eugenia Pérez Martínez
 *
 */
@Controller
public class UserController {

	@Autowired
	private UserDAO userDAO;

	/**
	 * handles default /users
	 * 
	 * @param model
	 * @return the name of the view to show RequestMapping({"/users"})
	 */

	@RequestMapping(method = RequestMethod.GET, value = {"/", "/users" })
	public String showUsers(Map<String, Object> model) {
		List<User> users = userDAO.get();
		model.put("users", users);

		return "user/users";
	}

	/**
	 * handles default /users/id
	 * 
	 * @param model
	 * @return the name of the view to show RequestMapping({"/users/{id}"})
	 */
	@RequestMapping(method = RequestMethod.GET, value = { "/users/{id}" })
	public String userDetail(@PathVariable(value = "id") Integer id,
			Map<String, Object> model) {
		User user = userDAO.find(id);
		model.put("user", user);
		// We return view name
		return "user/userdetail";
	}

	/**
	 * handles /users/new by GET
	 * 
	 * @return the name of the view to show RequestMapping({"/users/new"})
	 */
	@RequestMapping(method = RequestMethod.GET, value = { "/users/new" })
	public String newUser(Map<String, Object> model) {
		model.put("user", new User());
		// We return view name
		return "user/newuser";
	}

	/**
	 * handles /users/new by POST
	 * 
	 * @return the name of the view to show RequestMapping({"/users/new"})
	 */
	@RequestMapping(method = RequestMethod.POST, value = { "/users/new" })
	public ModelAndView createUser(User user) {
		ModelAndView modelAndView = new ModelAndView();

		if (userDAO.create(user) > 0) {
			// We return view name
			modelAndView.setViewName("user/created");
			modelAndView.addObject("user", user);
		} else {
			modelAndView.setViewName("error");
			modelAndView
					.addObject("error",
							"An error ocurred while trying to create a new user. Please, try again");
		}
		return modelAndView;
	}
}
