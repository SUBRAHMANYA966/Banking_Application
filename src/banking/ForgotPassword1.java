package banking;

import java.io.IOException;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



 class ForgotPassword1 extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
    try {
    	String fromEmail="pavansl96@gmail.com"; //sender's mail id.
    			String pwd="";		//sender's mail pwd.
    			String toEmail=request.getParameter("EMAIL");//reciever's mail id.
    			HttpSession ses=request.getSession();
    	    	ses.getAttribute("toEmail");
    	    	

    	
    		//String fromEmail=""; //sender's mail id.
    		//String ="";		//sender's mail pwd.
    		//String toEmail="";  //reciever's mail id.
    		
    		String subject="DO NOT REPLY: Mail from Java Program"; // mail subject line
    		//String msg="Hi, How are you?"; //mail body
    		String msg="http://localhost:8080/banking/NewPassword.jsp"; //mail body
    			
    		//Creating Session Object
    		Properties prop = new Properties();
    		prop.put("mail.smtp.host", "smtp.gmail.com");
    		prop.put("mail.smtp.port", 587);
    		prop.put("mail.smtp.auth", "true");
    		prop.put("mail.smtp.starttls.enable", "true");

    		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator()
    		{
    			protected PasswordAuthentication getPasswordAuthentication()
    			{
    			
					//sender's mail id and pwd is encapsulated inside "SendersCredentials.java"
    				return new PasswordAuthentication(fromEmail, pwd);
    			}
    		});

    		
    		//Composing the Mail
    		MimeMessage mesg = new MimeMessage(session);
    		mesg.setFrom(new InternetAddress(fromEmail));
    		mesg.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));
    		mesg.setSubject(subject);  
    		mesg.setText(msg);  
    		
    		//Sending the Mail
    		Transport.send(mesg);
    		System.out.println("Mail Sent!!");
    		response.sendRedirect("/banking/SuccessPassword.jsp");
    	}
    	
    
    catch(Exception e) {
    	e.printStackTrace();
    }
}
}
//Sending the Mail
		//Transport.send(mesg);
		//System.out.println("Mail Sent!!");
		//response.sendRedirect("/successPassword.jsp");
  	
		
		
		
		//String fromEmail="pavansl96@gmail.com"; //sender's mail id.
		//String pwd="slsshastry";		//sender's mail pwd.
		//String toEmail=request.getParameter("EMAIL");//reciever's mail id.
		//HttpSession ses=request.getSession();
    	//ses.getAttribute("toEmail");
    	
		//String subject="DO NOT REPLY: Mail from Java Program"; // mail subject line
		//String msg="http://localhost:8086/banking/NewPassword.jsp"; //mail body
		