package batu.dev.sem.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailer 
{
	
	
	public static boolean sendMail(String pToCSV, String pCcCSV, String pSubject, String pMailbody)
	{
		final String MailUser = Util.getProperty("Config", "mail.smtp.user");
		final String MailUserEmail = Util.getProperty("Config", "mail.smtp.user.from");
		final String MailPass = Util.getProperty("Config", "mail.smtp.pass");
		Properties prop = new Properties();
		prop.setProperty("mail.smtp.host", Util.getProperty("Config", "mail.smtp.host"));
		prop.setProperty("mail.smtp.port", Util.getProperty("Config", "mail.smtp.port"));
		prop.setProperty("mail.smtp.auth", Util.getProperty("Config", "mail.smtp.auth"));
		prop.setProperty("mail.smtp.starttls.enable", Util.getProperty("Config", "mail.smtp.starttls.enable"));
		
		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(MailUser, MailPass);
				
			}
		});
		
		
		
		try {
			Message lMessage = new MimeMessage(session);
			lMessage.setFrom(new InternetAddress(MailUserEmail));
			lMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(pToCSV));
			if(!pCcCSV.equals(""))
				lMessage.setRecipient(Message.RecipientType.CC, new InternetAddress(pCcCSV));
			lMessage.setSubject(pSubject);
			lMessage.setContent(pMailbody,"text/html");
			Transport.send(lMessage);
			return true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
