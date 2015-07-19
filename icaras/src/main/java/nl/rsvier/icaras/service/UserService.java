package nl.rsvier.icaras.service;

import javax.transaction.Transactional;

import nl.rsvier.icaras.core.User;
import nl.rsvier.icaras.core.UserRole;
import nl.rsvier.icaras.dao.UserDaoImpl;
import nl.rsvier.icaras.dao.UserRoleDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service("userService")
@Transactional
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserService {

	@Autowired
	UserDaoImpl userDao;
	@Autowired
	UserRoleDaoImpl userRoleDao;

	public void save(User user) {
		userDao.save(user);
	}

	public void save(User user, String role) {
		userDao.save(user);
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		userRoleDao.save(userRole);
		user.addUserRole(userRole);

	}

	public void update(User user) {
		userDao.update(user);
	}

	public void delete(User user) {
		userDao.delete(user);
	}
}
