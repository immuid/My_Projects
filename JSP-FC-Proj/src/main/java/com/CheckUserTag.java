package com;

import javax.servlet.RequestDispatcher;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class CheckUserTag extends TagSupport {
	private String uname,upass;

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
		boolean uStatus,fStatus;
		RequestDispatcher rd;
		
		if(uname!=""&&upass!="") {
			uStatus=dbc.checkUser(uname, upass);
			fStatus=dbc.checkFlag(uname, upass);
			if(uStatus){
				if (fStatus) {
					try {
						pageContext.getRequest().setAttribute("Auname", uname);
						pageContext.getRequest().setAttribute("Aupass", upass);
						rd = pageContext.getServletContext().getRequestDispatcher("/welcome.jsp");
						rd.forward(pageContext.getRequest(), pageContext.getResponse());
						}catch(Exception e) {e.printStackTrace();}
				} else {
					
					try {
						out.println("You are Already logged in");
						}catch(Exception e) {e.printStackTrace();}
				}
			}else{
				try {
				    rd = pageContext.getServletContext().getRequestDispatcher("/register.jsp");
					rd.forward(pageContext.getRequest(), pageContext.getResponse());
					}catch(Exception e) {e.printStackTrace();}
			}
		}else {
			try {
				out.println("Please enter all details");
				}catch(Exception e) {e.printStackTrace();}
		}
		return super.doEndTag();
	}

}
