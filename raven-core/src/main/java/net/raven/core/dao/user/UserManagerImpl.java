package net.raven.core.dao.user;

import java.util.List;

import net.raven.core.entity.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagerImpl implements UserManager
{
	private final SessionFactory sessionFactory;

	@Autowired
	public UserManagerImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveUser(User user)
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> getUserList()
	{
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("Select * from User").list();
	}

}
