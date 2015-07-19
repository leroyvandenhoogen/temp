package nl.rsvier.icaras.dao;

import java.util.ArrayList;
import java.util.List;

import nl.rsvier.icaras.core.User;
import nl.rsvier.icaras.core.UserRole;

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

}
