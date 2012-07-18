package be.contribute.service;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import be.contribute.service.OauthSecurityToken;

public class FacebookTransformer extends AbstractMessageTransformer
{

	@Override
	public Object transformMessage(MuleMessage muleMessage, String arg1) throws TransformerException
	{
		OauthSecurityToken token = new OauthSecurityToken();
		
		token.setToken((String)muleMessage.getInvocationProperty("OAuthAccessToken"));
		token.setSecret((String)muleMessage.getInvocationProperty("OAuthAccessTokenSecret"));
		
		return token;	
	}
}
