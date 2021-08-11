package mailProject;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailUtil {
	
	public void process(String string) throws Exception{
		sendMails(string);
		prepareMessage(null, string, string);
		
	}

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
	 
	 ResourceBundle rb=ResourceBundle.getBundle("password",new Locale("en"));// Locale.getdefault()
		
	 
	 String myAccountEmail="imranhash510@gmail.com";
	 String Password =rb.getString("p1");  //used properties
	 
	 Session session = Session.getInstance(properties,new Authenticator() {
		 @Override
		protected PasswordAuthentication getPasswordAuthentication() {		
			return new PasswordAuthentication(myAccountEmail, Password);
		}
	
	 });
	 Message message = prepareMessage(session,myAccountEmail,recipient);
	 
	Transport.send(message);
	System.out.println("Email sent Successfully...");
 }

public static Message prepareMessage(Session session,String myAccountEmail,String recipient) {
	
	Message message=new MimeMessage(session);
	
	try {
	
		message.setFrom(new InternetAddress(myAccountEmail) );
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
		message.setSubject("My First Email From Java App");
		
		String[] splittedArray = recipient.split("@");
		String name = splittedArray[0];
	//	System.out.println("Message sent to..:"+name);
		
		message.setText("Dear Mr." +name
				
				+ ",\n Greetings To You,\n" 
				+ "Welcome to my GitHub Account:https://github.com/immuid/JAVA-programs.\n" 
				+ "\nThanks & Regards,\n" 
				+ "Mr.Imran Ahmed, FullStack Developement Trainee,\n"  
				+ "Harris Infotech Pvt.Ltd,\n" 
				+ " E-mail:imranhash510@gmail.com,\n" 
				+"Phone: +91-8072946976 ");
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return message;
}


}
