package net.raven.core.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User
{
	long id;
	String name;
	String surname;
	String login;
	String password;
	String mail;
	int logoncount;
	Date lastlogin;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	@Column(name = "name")
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Column(name = "surname")
	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	@Column(name = "login")
	public String getLogin()
	{
		return login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	@Column(name = "password")
	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Column(name = "mail")
	public String getMail()
	{
		return mail;
	}

	public void setMail(String mail)
	{
		this.mail = mail;
	}

	@Column(name = "logoncount")
	public int getLogoncount()
	{
		return logoncount;
	}

	public void setLogoncount(int logoncount)
	{
		this.logoncount = logoncount;
	}

	@Column(name = "lastlogin")
	public Date getLastlogin()
	{
		return lastlogin;
	}

	public void setLastlogin(Date lastlogin)
	{
		this.lastlogin = lastlogin;
	}
}
