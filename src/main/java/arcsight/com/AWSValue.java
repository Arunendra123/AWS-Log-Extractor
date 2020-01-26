package arcsight.com;

public class AWSValue
{
	//AWS access key. (Required)
	static String accessKey="";

	//AWS secret key. (Required)
    static String secretKey="";

	//The SQS URL used to pull CloudTrail notification from. (Required)
    static String  sqsUrl="";

	//The SQS end point specific to a region.
    static String sqsRegion="";

	//A period of time during which Amazon SQS prevents other consuming components
	//from receiving and processing that message.
    static int visibilityTimeout = 60;

	//The S3 region to use.
    static String  s3Region="";

	//Number of threads used to download S3 files in parallel. Callbacks can be
	//invoked from any thread.
    static int threadCount = 1;

	//The time allowed, in seconds, for threads to shut down after
	//AWSCloudTrailEventProcessingExecutor.stop() is called. If they are still
	//running beyond this time, they will be forcibly terminated.
    static int threadTerminationDelaySeconds = 60;

	//The maximum number of AWSCloudTrailClientEvents sent to a single invocation
	//of processEvents().
    static int maxEventsPerEmit = 10;

	//Whether to include raw event information in CloudTrailDeliveryInfo.
    static boolean enableRawEventInfo = true;

	//Whether to delete SQS message when the CloudTrail Processing Library is unable to process the notification.
    static Boolean deleteMessageUponFailure = false;
}
