package nl.rsvier.icaras.service;

import javax.transaction.Transactional;

import nl.rsvier.icaras.core.User;
import nl.rsvier.icaras.core.UserRole;
import nl.rsvier.icaras.dao.UserDaoImpl;
import nl.rsvier.icaras.dao.UserRoleDaoImpl;
import nl.rsvier.icaras.util.MailMail;
import nl.rsvier.icaras.util.PasswordGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
		String password = PasswordGenerator.generate();
		String email = user.getEmail();
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		user.setPassword(hashedPassword);
		user.setEnabled(true);

		userDao.save(user);
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole("ROLE_USER");
		userRoleDao.save(userRole);
		user.addUserRole(userRole);

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Spring-Mail.xml");

		MailMail mm = (MailMail) context.getBean("mailMail");
		mm.sendMail(
				"icaras@rsvier.nl",
				email,
				"Icaras account", String.format("%s%n%n%s%n%n%s%n%s%n%n%s%n", "Beste gebruiker,",
						"er is een account voor je aangemaakt bij Icaras.",
						"Gebruikersnaam: " + user.getUsername(),
						"Wachtwoord: " + password,
						"Na het inloggen kan je de wachtwoord wijzigen"));
	}

	public void update(User user) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(hashedPassword);
		userDao.update(user);
	}

	public void delete(User user) {
		userDao.delete(user);
	}

	public boolean exists(String username) {
		return userDao.exists(username);
	}
}
