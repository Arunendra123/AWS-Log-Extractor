package arcsight.com;

import com.amazonaws.services.cloudtrail.processinglibrary.manager.S3Manager;
import com.amazonaws.services.cloudtrail.processinglibrary.manager.SqsManager;

public class LogPrinterThread extends Thread
{
   static boolean flags=false;
   public void run()
   {
	 int count=0;
	 try 
	 {
		Thread.sleep(2000);
	 } 
	 catch (InterruptedException e1)
	 {
		e1.printStackTrace();
	 }
	 while(flags)
	 {
		 
	  	 try 
	  	 {
	  		     if(S3Manager.s3_1!=null)
	  			 MainViewer.tArea.append(S3Manager.s3_1+"...check your configuration\n");
	  			 if(S3Manager.s3_2!=null)
	  		  	 MainViewer.tArea.append(S3Manager.s3_2+"...check your configuration\n");
	  			 if(S3Manager.s3_3!=null)
	  		  	 MainViewer.tArea.append(S3Manager.s3_3+"...check your configuration\n");
	  			 if(SqsManager.sqs_1!=null)
	  		  	 MainViewer.tArea.append(SqsManager.sqs_1+"...check your configuration\n");
	  			 if(SqsManager.sqs_2!=null)
	  		  	 MainViewer.tArea.append(SqsManager.sqs_2+"...check your configuration\n");
	  			 if(SqsManager.sqs_3!=null)
	  		  	 MainViewer.tArea.append(SqsManager.sqs_3+"...check your configuration\n");
	  			 if(SqsManager.sqs_4!=null)
	  		  	 MainViewer.tArea.append(SqsManager.sqs_4+"...check your configuration\n");
			     Thread.sleep(200);
			     if(count>11)
			     {
			           MainViewer.tArea.setText(" ");
			           count=0;
			     }
			     count=count+1;
		 } 
	  	 catch (InterruptedException e) 
	  	 {
			e.printStackTrace();
		 }
	 }
   }
}
