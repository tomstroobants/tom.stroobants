package be.contribute.service;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import be.contribute.service.OauthSecurityToken;

/**
 * I use this transformer to get the authentication information from the message put it on object
 * and return it as the payload.
 * 
 * @author tom.stroobants@c4j.be
 *
 */

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
