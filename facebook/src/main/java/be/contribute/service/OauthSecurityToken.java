package be.contribute.service;

import java.io.Serializable;

public class OauthSecurityToken implements Serializable
{
	private String token;
	private String secret;
	
	public String getToken()
	{
		return token;
	}
	public void setToken(String token)
	{
		this.token = token;
	}
	public String getSecret()
	{
		return secret;
	}
	public void setSecret(String secret)
	{
		this.secret = secret;
	}
	@Override
	public String toString()
	{
		return "Yo de mannen";
	}
}
