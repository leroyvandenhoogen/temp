package nl.rsvier.icaras.dao;

import nl.rsvier.icaras.core.UserRole;

import org.springframework.stereotype.Repository;

@Repository
public class UserRoleDaoImpl extends GenericDaoImpl<UserRole> implements IUserRoleDao {

	public UserRoleDaoImpl() {
		super(UserRole.class);
	}
}
