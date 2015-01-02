package org.sistema.springmvc.forms.dao.impl.fakes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.sql.DataSource;

import org.sistema.springmvc.forms.dao.UserDAO;
import org.sistema.springmvc.forms.models.User;

/**
 * Fake implementation for a UserDAO.
 * 
 * @author Eugenia Pérez Martínez.
 *
 */
public class FakeUserDAO implements UserDAO {

	public void setDataSource(DataSource ds) {

	}

	/**
	 * Returns a number greater or equal than 0 if everything goes well.
	 */
	public int create(User user) {
		user.setId(new Random().nextInt());
		return user.getId();
	}

	public User find(Integer id) {
		List<User> users = get();
		User result = null;

		for (User u : users) {
			if (u.getId() == id)
				result = u;
		}

		return result;
	}

	public List<User> get() {
		List<User> users = new ArrayList<User>();
		User user1 = new User(1, "sjobs", "Apple CEO", "stewie");
		User user2 = new User(2, "lellison", "Oracle CEO", "larry");
		User user3 = new User(3, "bgates", "Microsoft CEO", "imrich");
		User user4 = new User(4, "mzuckerberg", "Facebook CEO", "selfie");

		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);

		return users;
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
	}

	public void update(Integer id, Integer age) {
		// TODO Auto-generated method stub
	}
}
