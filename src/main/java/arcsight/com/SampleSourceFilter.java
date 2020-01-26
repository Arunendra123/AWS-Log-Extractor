package arcsight.com;

import java.awt.List;
import java.util.ArrayList;
import java.util.Map;

import com.amazonaws.services.cloudtrail.processinglibrary.exceptions.CallbackException;
import com.amazonaws.services.cloudtrail.processinglibrary.interfaces.SourceFilter;
import com.amazonaws.services.cloudtrail.processinglibrary.model.CloudTrailSource;
import com.amazonaws.services.cloudtrail.processinglibrary.model.SQSBasedSource;
import com.amazonaws.services.cloudtrail.processinglibrary.model.SourceAttributeKeys;

public class SampleSourceFilter implements SourceFilter{
	  private static final int MAX_RECEIVED_COUNT = 3;

	  private static ArrayList<Object> accountIDs ;
	  static {
	    accountIDs = new ArrayList<>();
	    accountIDs.add("123456789012");
	    accountIDs.add("234567890123");
	  }

	  @Override
	  public boolean filterSource(CloudTrailSource source) throws CallbackException {
	    source = (SQSBasedSource) source;
	    Map<String, String> sourceAttributes = source.getSourceAttributes();

	    String accountId = sourceAttributes.get(
	      SourceAttributeKeys.ACCOUNT_ID.getAttributeKey());

	    String receivedCount = sourceAttributes.get(
	      SourceAttributeKeys.APPROXIMATE_RECEIVE_COUNT.getAttributeKey());

	    int approximateReceivedCount = Integer.parseInt(receivedCount);

	    return approximateReceivedCount <= MAX_RECEIVED_COUNT && accountIDs.contains(accountId);
	  }

	
}