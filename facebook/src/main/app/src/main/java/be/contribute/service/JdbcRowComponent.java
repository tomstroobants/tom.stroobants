package be.contribute.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

public class JdbcRowComponent implements Callable
{

	@Override
	public Object onCall(MuleEventContext muleEventContext) throws Exception
	{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		List<Map> recordList = new ArrayList<Map>();
		Map<String,String> recordMap = new HashMap<String,String>();
		
		recordList = (ArrayList)muleEventContext.getMessage().getOutboundProperty("headerOAuthAccessToken");
		recordMap = recordList.get(0);
		
		resultMap.put("token", recordMap.get("token"));
		resultMap.put("secret", recordMap.get("secret"));
		
		return resultMap;	
	}
}
