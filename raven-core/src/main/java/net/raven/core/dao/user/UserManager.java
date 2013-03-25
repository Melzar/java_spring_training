package net.raven.core.dao.user;

import java.util.List;

import net.raven.core.entity.User;

public interface UserManager
{
	public void addUser(User user);

	public User getUserByMail(String email);

	public User getUsetByLogin(String login);

	public boolean isLoginUnique(String login);

	public boolean isEmailUnique(String email);

	public List<User> getUserList();
}
