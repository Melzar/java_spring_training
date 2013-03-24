package net.raven.core.dao.user;

import java.util.List;

import net.raven.core.entity.User;

public interface UserManager
{
	public void addUser(User user);

	public List<User> getUserList();
}
