package nl.rsvier.icaras.dao;

import nl.rsvier.icaras.core.User;

public interface IUserDao {

	User findByUserName(String username);
}
