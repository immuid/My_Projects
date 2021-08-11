package mailProject;

import java.util.Properties;


import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailUtil {
 public static void sendMails(String recipient) throws Exception {
	 System.out.println("Preparing to send Email...");
	 Properties properties=new Properties();
	 	
	 	//mail.smtp.auth  //  if it is a gmail then for (Authentication) it is madatory to have user name and password to login to this 
		//mail.smtp.starttls.enable
		//mail.smtp.host -smtp.gmail.com
		//mail.smtp.post -587
	 
	 properties.put("mail.smtp.auth", "true");
	 properties.put("mail.smtp.starttls.enable","true");
	 properties.put("mail.smtp.host","smtp.gmail.com");
	 properties.put("mail.smtp.port","587");
	 
	 String myAccountEmail=" ********@gmail.com"; //enter the mail id
	 String Password =" **********";//enter the Password 
	 
	 Session session = Session.getInstance(properties,new Authenticator() {
		 @Override
		protected PasswordAuthentication getPasswordAuthentication() {		
			return new PasswordAuthentication(myAccountEmail, Password);
		}
	
	 });
	 Message message = prepareMessage(session,myAccountEmail, recipient);
	 
	Transport.send(message);
	System.out.println("Email sent Successfully...");
 }

private static Message prepareMessage(Session session,String myAccountEmail,String recipient) {
	try {
		Message message=new MimeMessage(session);
		message.setFrom(new InternetAddress(myAccountEmail) );
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
		message.setSubject("My First Email From Java App");
		message.setText("Hey there, \n look my Email" );
		return message;
		
	} catch (Exception e) {
		
	}
	
	return null;
}
}
