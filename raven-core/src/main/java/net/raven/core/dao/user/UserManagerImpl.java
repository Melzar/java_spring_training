package net.raven.core.dao.user;

import java.util.List;

import net.raven.core.entity.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public void addUser(User user)
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
	}

	@Override
	@Transactional
	public List<User> getUserList()
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		return session.createSQLQuery("SELECT * FROM raven_users")
				.addEntity(User.class).list();
	}

}
