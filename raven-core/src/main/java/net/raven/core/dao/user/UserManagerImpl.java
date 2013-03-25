package net.raven.core.dao.user;

import java.util.Collections;
import java.util.List;

import net.raven.core.annotations.logger.Loggable;
import net.raven.core.entity.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserManagerImpl implements UserManager
{
	private final SessionFactory sessionFactory;
	@Loggable
	private Logger logger;

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

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<User> getUserList()
	{
		Session session = sessionFactory.openSession();
		List<User> list = Collections.emptyList();
		try
		{
			list = session.createSQLQuery("SELECT * FROM raven_users")
					.addEntity(User.class).list();

		} catch (Exception e)
		{
			logger.error("Failed to get user list - transaction error", e);
		} finally
		{
			session.close();
		}
		return list;
	}

	@Override
	public User getUserByMail(String email)
	{
		Session session = sessionFactory.openSession();
		User user = new User();
		try
		{
			Query query = getQueryByParameterAndTable("raven_users", "email",
					email, session);
			user = (User) query.uniqueResult();
		} catch (Exception e)
		{
			logger.error("Failed to get user by mail", e);
		} finally
		{
			session.close();
		}
		return user;
	}

	@Override
	public User getUsetByLogin(String login)
	{
		Session session = sessionFactory.openSession();
		User user = new User();
		try
		{
			Query query = getQueryByParameterAndTable("raven_users", "login",
					login, session);
			user = (User) query.uniqueResult();
		} catch (Exception e)
		{
			logger.error("Failed to get user by mail", e);
		} finally
		{
			session.close();
		}
		return user;
	}

	@Override
	public boolean isLoginUnique(String login)
	{
		Session session = sessionFactory.openSession();
		try
		{
			Query query = getQueryByParameterAndTable("raven_users", "login",
					login, session);
			if (query.list().isEmpty())
			{
				return true;
			}
		} catch (Exception e)
		{
			logger.error("Failed to get user by mail", e);
		} finally
		{
			session.close();
		}
		return false;
	}

	@Override
	public boolean isEmailUnique(String email)
	{
		Session session = sessionFactory.openSession();
		try
		{
			Query query = getQueryByParameterAndTable("raven_users", "email",
					email, session);
			if (query.list().isEmpty())
			{
				return true;
			}
		} catch (Exception e)
		{
			logger.error("Failed to get user by mail", e);
		} finally
		{
			session.close();
		}
		return false;
	}

	private Query getQueryByParameterAndTable(String tableName, String colName,
			String value, Session session)
	{
		Query query = session.createQuery("from " + tableName + " where "
				+ colName + " = :" + colName);
		query.setString(colName, value);
		return query;
	}
}
