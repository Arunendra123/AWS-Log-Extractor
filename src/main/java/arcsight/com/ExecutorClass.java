package arcsight.com;

import com.amazonaws.services.cloudtrail.processinglibrary.AWSCloudTrailProcessingExecutor;
public class ExecutorClass
{
	 static AWSCloudTrailProcessingExecutor executor=null;
	 public AWSCloudTrailProcessingExecutor getExecutor()
	 {
		 if(executor==null)
		 {
			 executor=new AWSCloudTrailProcessingExecutor.Builder(new SampleEventsProcessor(),"/cloudtrailprocessing.properties").build();
		 }
		 return executor;
	 }			 
}
