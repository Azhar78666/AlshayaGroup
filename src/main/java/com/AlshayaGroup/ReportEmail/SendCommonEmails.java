package com.AlshayaGroup.ReportEmail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;


public class SendCommonEmails 
{
	
	
	public static void sendEmail() throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("", ""));
		email.setSSLOnConnect(true);
		email.setFrom("azharhashmat512@gmail.comm");
		email.setSubject("Send Test Cases Report");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("ahmad.faizan11@gmail.com");
		email.send();
	}
	
	
	//@factory

	
	public static void sendAttachmentReportEmail() throws EmailException 
	{
		
		System.out.println("===========Test Started===============");

		 // Create the attachment
		  EmailAttachment attachment = new EmailAttachment();
		  attachment.setPath("./downloadFilePath.zip");
		  attachment.setDisposition(EmailAttachment.ATTACHMENT);
		  attachment.setDescription("Report of HNM Websites Attachment");
		  attachment.setName("downloadFilePath.zip");

		  // Create the email message
		  MultiPartEmail email = new MultiPartEmail();
		  email.setHostName("smtp.gmail.com");
		  email.setAuthenticator(new DefaultAuthenticator("azharhashmat217@gmail.com", "Athar@12345"));
			email.setSSLOnConnect(true);
		  email.addTo("azhar.hashmat@syncrasytech.com", "Alshaya Group");
		  email.setFrom("azharhashmat217@gmail.com", "Alshaya Group");
		  email.setSubject("Automation Scripts Report");
		  email.setMsg("Please find the attached Report of Websites functionalities");

		  // add the attachment
		  email.attach(attachment);

		  // send the email
		  email.send();
		  
		  System.out.println("===========Email Send Successfully===============");
	}
}

/*
Two Step Verification should be turned off.
Allow Less Secure App(should be turned on).
Please Check Your UserName and Password.
Check the code(which was my Problem), Above three You can change form google help center and by Yourself 
.*/