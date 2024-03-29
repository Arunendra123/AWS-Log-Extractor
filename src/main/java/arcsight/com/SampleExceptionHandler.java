package arcsight.com;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.amazonaws.services.cloudtrail.processinglibrary.exceptions.ProcessingLibraryException;
import com.amazonaws.services.cloudtrail.processinglibrary.impl.DefaultProgressReporter;
import com.amazonaws.services.cloudtrail.processinglibrary.interfaces.ExceptionHandler;
import com.amazonaws.services.cloudtrail.processinglibrary.progress.ProgressInfo;
import com.amazonaws.services.cloudtrail.processinglibrary.progress.ProgressState;
import com.amazonaws.services.cloudtrail.processinglibrary.progress.ProgressStatus;

public class SampleExceptionHandler implements ExceptionHandler{
	  private static final Log logger =
	    LogFactory.getLog(DefaultProgressReporter.class);

	  @Override
	  public void handleException(ProcessingLibraryException exception) {
	    ProgressStatus status = exception.getStatus();
	    ProgressState state = status.getProgressState();
	    ProgressInfo info = status.getProgressInfo();

	    System.err.println(String.format(
	      "Exception. Progress State: %s. Progress Information: %s.", state, info));
	  }

	}