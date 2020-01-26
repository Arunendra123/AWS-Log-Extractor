package arcsight.com;

import java.util.HashMap;
import java.util.LinkedList;

import com.amazonaws.services.cloudtrail.processinglibrary.model.CloudTrailEventData;

public class UniqueEventFinder 
{
	static HashMap<String,HashMap<String,Integer>> sourceList=new HashMap<String,HashMap<String,Integer>>();
	public static boolean CheckUniqueness(CloudTrailEventData event)
	{
		if(sourceList.containsKey(event.getEventSource())==false)
		{
	       sourceList.put(event.getEventSource(),new HashMap<String, Integer>());
	       sourceList.get(event.getEventSource()).put(event.getEventName(),new Integer(event.toString().length()));
	       return true;
		}
		else
		{
			if(sourceList.get(event.getEventSource()).containsKey(event.getEventName())==false)
			{
				sourceList.get(event.getEventSource()).put(event.getEventName(),new Integer(event.toString().length()));
				return true;
			}
			else
			{
				if(sourceList.get(event.getEventSource()).get(event.getEventName()).intValue()>(event.toString().length()))
				{
					 return false;
				}
				else
				{
					sourceList.get(event.getEventSource()).put(event.getEventName(),new Integer(event.toString().length()));
					return true;
				}
			}
		}
	}
}