package arcsight.com;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import com.amazonaws.services.cloudtrail.processinglibrary.model.CloudTrailEventData;

public class FileHandler 
{
	 public static FileOutputStream fileOutputStream;
	 public static PrintStream printStream;
     public static void updateClouTrailProcessingFile()
     {
    	  try 
    	  {
			   fileOutputStream = new FileOutputStream("/cloudtrailprocessing.properties",false);
		  } 
    	  catch (FileNotFoundException e)
    	  {
			  e.printStackTrace();
		  } 
		  printStream = new PrintStream(fileOutputStream);
		  System.out.println("Details Updated");
		  printStream.print
		  ("# AWS access key. (Required)\naccessKey = "
		  +AWSValue.accessKey+"\n\n# AWS secret key. (Required)\nsecretKey = "
		  +AWSValue.secretKey+"\n\n# The SQS URL used to pull CloudTrail notification from. (Required)\nsqsUrl = "
		  +AWSValue.sqsUrl+"\n\n# The SQS end point specific to a region.\nsqsRegion = "
		  +AWSValue.sqsRegion+"\n\n# A period of time during which Amazon SQS prevents other consuming components\n# from receiving and processing that message.\nvisibilityTimeout = "
		  +AWSValue.visibilityTimeout+"\n\n# The S3 region to use.\ns3Region = "
		  +AWSValue.s3Region+"\n\n# Number of threads used to download S3 files in parallel. Callbacks can be\n# invoked from any thread.\nthreadCount = "
		  +AWSValue.threadCount+"\n\n# The time allowed, in seconds, for threads to shut down after\n# AWSCloudTrailEventProcessingExecutor.stop() is called. If they are still\n# running beyond this time, they will be forcibly terminated.\nthreadTerminationDelaySeconds = "
		  +AWSValue.threadTerminationDelaySeconds+"\n\n# The maximum number of AWSCloudTrailClientEvents sent to a single invocation\n# of processEvents().\nmaxEventsPerEmit = "
		  +AWSValue.maxEventsPerEmit+"\n\n#Whether to include raw event information in CloudTrailDeliveryInfo.\nenableRawEventInfo = "
		  +AWSValue.enableRawEventInfo+"\n\n#Whether to delete SQS message when the CloudTrail Processing Library is unable to process the notification.\ndeleteMessageUponFailure = "
		  +AWSValue.deleteMessageUponFailure
		  );
     }
     public static void UpdateLogBase(CloudTrailEventData event,String rawEvent)
     {
    	 try 
   	     {
			   fileOutputStream = new FileOutputStream(MainViewer.tt.getText()+"/"+event.getEventSource()+".txt",true);
		 } 
   	     catch (FileNotFoundException e)
   	     {
			  e.printStackTrace();
	     } 
	     printStream = new PrintStream(fileOutputStream);
	     System.out.println("Details Updated");
	     printStream.println(rawEvent);
      }
}