package arcsight.com;

import java.util.List;
import com.amazonaws.services.cloudtrail.processinglibrary.interfaces.EventsProcessor;
import com.amazonaws.services.cloudtrail.processinglibrary.model.CloudTrailEvent;
import com.amazonaws.services.cloudtrail.processinglibrary.model.CloudTrailEventMetadata;
import com.amazonaws.services.cloudtrail.processinglibrary.model.LogDeliveryInfo;

public class SampleEventsProcessor implements EventsProcessor
{
  public void process(List<CloudTrailEvent> events) 
  { 
        for (CloudTrailEvent event : events) 
        {
            if((event != null) && (event.getEventData() != null)) 
            {
                String rawEvent = "";               
                CloudTrailEventMetadata metadata = event.getEventMetadata();
                if((metadata != null) && (metadata instanceof LogDeliveryInfo)) 
                {
                    rawEvent = ((LogDeliveryInfo)metadata).getRawEvent();
                    MainViewer.tArea.append("\n"+rawEvent); 
                    if(UniqueEventFinder.CheckUniqueness(event.getEventData()))
                    {
                    	FileHandler.UpdateLogBase(event.getEventData(),rawEvent);
                    }
                }
            }
        }
    }
}