package arcsight.com;
	
	import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

import com.amazonaws.services.cloudtrail.processinglibrary.AWSCloudTrailProcessingExecutor;
import com.amazonaws.services.cloudtrail.processinglibrary.manager.S3Manager;
import com.amazonaws.services.cloudtrail.processinglibrary.manager.SqsManager;
public class MainViewer  extends JFrame implements ActionListener 
{ 
	private static final long serialVersionUID = 1L;
			static TextField t,t1,t2,t3,t4,tt; 
			static Frame f,f1; 
			static Button b,b1,b2,bb,bb1,bb2; 
			static Label l,l1,l2,l3,l4; 
			static TextArea tArea;
			static JPanel p,pp;
			MainViewer() 
			{ 
				
			} 
			@SuppressWarnings("deprecation")
			public void viewer() 
			{ 
				f1  = new Frame("AWS-Log-Collector"); 
				f  = new Frame("Input Details"); 
				f.addWindowListener(new WindowAdapter() 
				{
			         public void windowClosing(WindowEvent windowEvent)
			         {
			            System.exit(0);
			         }
			         
			    });
				f1.addWindowListener(new WindowAdapter() 
				{
			         public void windowClosing(WindowEvent windowEvent)
			         {
			            System.exit(0);
			         }
			         
			    });
				
				MainViewer te = new MainViewer();
				//>--------------------------------------------First-Page-----------------------------------------<
				Dimension dim1 = Toolkit.getDefaultToolkit().getScreenSize();
				f1.setLocation((dim1.width/2-f.getSize().width/2)-250, (dim1.height/2-f.getSize().height/2)-100);
				bb = new Button("Start");
				bb.addActionListener(te);
				bb1= new Button("open");
				bb1.addActionListener(te);
				bb2= new Button("Upate AWS Details");
				bb2.addActionListener(te);
				bb.setPreferredSize(new Dimension(90,20));
				bb1.setPreferredSize(new Dimension(90,20));
				tt = new TextField(40);
				tArea=new TextArea(8,55);
				pp = new JPanel();
				pp.setBorder(BorderFactory.createTitledBorder("Hello Arcsight V1.0: "));
				pp.add(tt);
				pp.add(bb1);
				pp.add(bb);
				pp.add(bb2);
				pp.add(tArea);
				//>--------------------------------------------First-Page-----------------------------------------<
				//>--------------------------------------------Second frame---------------------------------------<
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				f.setLocation((dim.width/2-f.getSize().width/2)-250, (dim.height/2-f.getSize().height/2)-100);
				b  = new Button("Save");
				b1  = new Button("cancle");
				b.setPreferredSize(new Dimension(90,20));
				b1.setPreferredSize(new Dimension(90,20));
				l  = new Label("AWS AceesKey   ");
				t  = new TextField(40);
				l1 = new Label("AWS SecretKey  ");
				t1 = new TextField(40);
				l2 = new Label("SQS Url               ");
				t2 = new TextField(40);
				l3 = new Label("SQS Region        ");
				t3 = new TextField(40);
				l4 = new Label("S3 Region           ");
				t4 = new TextField(40); 
				b.addActionListener(te);
				b1.addActionListener(te);
				p = new JPanel();
				p.setBorder(BorderFactory.createTitledBorder("Hello Arcsight V1.0: "));
				p.add(l) ;
				p.add(t) ;
				p.add(l1);
				p.add(t1);
				p.add(l2);
				p.add(t2);
				p.add(l3);
				p.add(t3);
				p.add(l4);
				p.add(t4);
				p.add(b) ;
				p.add(b1);
				//>--------------------------------------------Second frame---------------------------------------<
		        
		        f1.add(pp);
		        f1.setSize(450, 260);
		        f1.show();
			} 
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) 
			{ 
				String s = e.getActionCommand(); 
				
			if(s.equals("open"))
			{
				if(ExecutorClass.executor!=null)
			    {
				           JOptionPane.showMessageDialog(this,"AWS Log-collector is running Please stop it",
						   "Warning",JOptionPane.WARNING_MESSAGE);
			    }
				else
				{
					JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
					jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					tt.setText(jfc.getCurrentDirectory().getAbsolutePath());
					System.out.println("open");
				}
					
			}
			else if(s.equals("Start"))
			{
				 ExecutorClass ex=new ExecutorClass();
				 LogPrinterThread lg= new LogPrinterThread();
				 LogPrinterThread.flags=true;
				 ex.getExecutor().start();
				 lg.start();
				 bb.setLabel("Stop");
			}
			else if(s.equals("Stop"))
			{
				ExecutorClass ex=new ExecutorClass();
				ex.getExecutor().stop();
				ExecutorClass.executor=null;
				bb.setLabel("Start");
				LogPrinterThread.flags=false;
			}
			else if(s.equals("Upate AWS Details"))
			{
				if(ExecutorClass.executor!=null)
				{
					JOptionPane.showMessageDialog(this,"AWS Log-collector is running Please stop it",
							   "Warning",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					f.add(p) ; 
					f.setSize(450, 260); 
			        f.show();
				}
				
		       
			}
			else if (s.equals("Save")) 
			{ 				
				
				if(t.getText().equals(""))
				{
					 JOptionPane.showMessageDialog(this,"Please Input AccessKey",
							   "Warning",JOptionPane.WARNING_MESSAGE);    
				}
				else if(t1.getText().equals(""))
				{
					 JOptionPane.showMessageDialog(this,"Please Input SecreteKey",
							   "Warning",JOptionPane.WARNING_MESSAGE);
				}
				else if(t2.getText().equals(""))
				{
					 JOptionPane.showMessageDialog(this,"Please Input SQS Url",
							   "Warning",JOptionPane.WARNING_MESSAGE);
				}
				else if(t3.getText().equals(""))
				{
					 JOptionPane.showMessageDialog(this,"Please Input SQS Region",
							   "Warning",JOptionPane.WARNING_MESSAGE);
				}
				else if(t4.getText().equals(""))
				{
					 JOptionPane.showMessageDialog(this,"Please Input S3 Region",
							   "Warning",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					AWSValue.accessKey=t.getText();
					AWSValue.secretKey=t1.getText();
					AWSValue.sqsUrl=t2.getText();
					AWSValue.sqsRegion=t3.getText();
					AWSValue.s3Region=t4.getText();
					FileHandler.updateClouTrailProcessingFile();
					f.hide();
				}
	    } 
		else if(s.equals("cancle"))
		{
				f.hide();
		}
	}      
}
