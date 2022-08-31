package com;

import javax.servlet.RequestDispatcher;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class RegisterUserTag extends TagSupport {
	private String uid,uname,upass;
	

	
	public String uid() {
		return uid;
	}
	public void setuid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	
	DBCon dbc=new DBCon();
	@Override
	public int doEndTag() throws JspException {
		JspWriter out=pageContext.getOut();
		if(uid!=""&&uname!=""&&upass!="") {			
			int Uid=Integer.parseInt(uid);
			dbc.register(Uid, uname, upass);	
			try {
			out.println("registered successfully...");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
		try {
			out.println("Please enter all details-correctly!");
			}
		    catch(Exception e){ e.printStackTrace();}
		}		
		return super.doEndTag();
	}
}
	
