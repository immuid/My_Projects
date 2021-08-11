package mailProject;

import java.util.ArrayList;
import java.util.List;

public class JavaMail {
	public static void main(String[] args) throws Exception {
		
		String s[]=new String[3];
		s[0]="imranhash510@gmail.com";
		s[1]="abdulthedon007@gmail.com";
		s[2]="immuimran2k@gmail.com";
		
		for(String str:s) {
			JavaMailUtil.sendMails(str);
		}
		
		//JavaMailUtil.sendMails("dddivyadharshini2525@gmail.com");
		//JavaMailUtil.sendMails("imranhash510@gmail.com");
		//JavaMailUtil.sendMails("abdulthedon007@gmail.com");
	}

}
