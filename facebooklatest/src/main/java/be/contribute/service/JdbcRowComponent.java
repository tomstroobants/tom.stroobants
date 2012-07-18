package be.contribute.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

/**
 * 
 * It would be better to implement the ResultSetHandler interface for this but the component has the same purpose.
 * 
 * When using JDBC Mule by defaults returns the results of your query in a List containing Maps.
 * Each entry in the list represents one record. And the map represents the column name and the values 
 * where the id of the map is the column name and the value of the map is the value of the column for 
 * that specific record.
 * 
 * 
 * @author tom.stroobants@c4j.be
 *
 */

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
