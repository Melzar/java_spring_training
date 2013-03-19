package net.raven.core.dao.user;

import java.util.List;

import net.raven.core.entity.User;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class UserManagerImpl implements UserManager
{

	private HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	public void saveUser(User user)
	{
		hibernateTemplate.saveOrUpdate(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> getUserList()
	{
		return hibernateTemplate.find("Select * from User");
	}

}
