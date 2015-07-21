package nl.rsvier.icaras.dao;

import java.util.ArrayList;
import java.util.List;

import nl.rsvier.icaras.core.User;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements IUserDao {

	public UserDaoImpl() {
		super(User.class);
	}

	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {
		List<User> users = new ArrayList<User>();
		String sql = "SELECT p FROM User p WHERE p.username is :string";
		Query query = getSessionFactory().getCurrentSession().createQuery(sql)
				.setParameter("string", username.trim());
		users = query.list();
		if (users.isEmpty())
			return null;
		return users.get(0);
	}

	public boolean exists(String username) {
		String sql = "SELECT p FROM User p WHERE p.username is :string";
		Query query = getSessionFactory().getCurrentSession().createQuery(sql)
				.setParameter("string", username.trim());

		if (query.list().isEmpty())
			return false;
		else
			return true;
	}

	public boolean exists(String username, String email) {
		String sql = "SELECT p FROM User p WHERE p.username is :string AND p.email is :email";
		Query query = getSessionFactory().getCurrentSession().createQuery(sql)
				.setParameter("string", username.trim()).setParameter("email", email);

		if (query.list().isEmpty())
			return false;
		else
			return true;
	}

}
