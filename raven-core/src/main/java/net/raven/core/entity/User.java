package net.raven.core.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "raven_users")
@XmlRootElement
public class User
{
	@Id
	@SequenceGenerator(name = "sequence", sequenceName = "user_id_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
	@Column(name = "id", insertable = false, updatable = false)
	private long id;

	@Column(name = "name")
	String name;

	@Column(name = "surname")
	String surname;

	@Column(name = "login", insertable = true)
	String login;

	@Column(name = "password")
	String password;

	@Column(name = "mail")
	String mail;

	@Column(name = "logoncount")
	int logoncount;

	@Column(name = "lastlogin")
	Date lastlogin;

	public User()
	{

	}

	public long getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public String getLogin()
	{
		return login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getMail()
	{
		return mail;
	}

	public void setMail(String mail)
	{
		this.mail = mail;
	}

	public int getLogoncount()
	{
		return logoncount;
	}

	public void setLogoncount(int logoncount)
	{
		this.logoncount = logoncount;
	}

	public Date getLastlogin()
	{
		return lastlogin;
	}

	public void setLastlogin(Date lastlogin)
	{
		this.lastlogin = lastlogin;
	}

	@Override
	public String toString()
	{
		return "User: Id[" + id + "] Login[" + login + "] Name[" + name
				+ "] Surname[" + surname + "] Mail[" + mail + "] LogonCount["
				+ logoncount + "]+ LastLogin[" + lastlogin + "]";
	}
}
