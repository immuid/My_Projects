package com;

import javax.servlet.RequestDispatcher;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class ReSetFlagTag extends TagSupport {
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
		boolean status=dbc.reSetFlag(uname, upass);
		if(status) {
			try {
				RequestDispatcher rd = pageContext.getServletContext().getRequestDispatcher("/login.jsp");
				rd.forward(pageContext.getRequest(), pageContext.getResponse());
				}catch(Exception e) {e.printStackTrace();}
		}else {
			try {
				out.println("Log out Failed - Something went wrong!");
				}catch(Exception e) {e.printStackTrace();}
		}
		return super.doEndTag();
	}
	
}
