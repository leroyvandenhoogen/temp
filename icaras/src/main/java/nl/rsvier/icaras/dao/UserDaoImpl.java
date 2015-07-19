package nl.rsvier.icaras.dao;

import java.util.ArrayList;
import java.util.List;

import nl.rsvier.icaras.core.User;
import nl.rsvier.icaras.core.UserRole;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements IUserDao {

	public UserDaoImpl() {
		super(User.class);
	}

	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {

		List<User> users = new ArrayList<User>();

		users = getSessionFactory().getCurrentSession()
				.createQuery("from User where username=?")
				.setParameter(0, username).list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	public boolean exists(String username) {
		String sql = "SELECT p FROM User p WHERE p.username like :string";
		Query query = getSessionFactory().getCurrentSession().createQuery(sql)
				.setParameter("string", username.trim());

		if(query.list().isEmpty())
			return false;
		else
			return true;
	}

}
