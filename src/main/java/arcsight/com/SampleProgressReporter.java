package arcsight.com;



import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.amazonaws.services.cloudtrail.processinglibrary.impl.DefaultProgressReporter;
import com.amazonaws.services.cloudtrail.processinglibrary.interfaces.ProgressReporter;
import com.amazonaws.services.cloudtrail.processinglibrary.progress.ProgressStatus;

public class SampleProgressReporter implements ProgressReporter {
	  private static final Log logger =LogFactory.getLog(DefaultProgressReporter.class);

	  @Override
	  public Object reportStart(ProgressStatus status) {
	    return new Date();
	  }

	  @Override
	  public void reportEnd(ProgressStatus status, Object startDate) {
	    System.out.println(status.getProgressState().toString() + " is " +
	      status.getProgressInfo().isSuccess() + " , and latency is " +
	      Math.abs(((Date) startDate).getTime()-new Date().getTime()) + "milliseconds.");
	  }


	}