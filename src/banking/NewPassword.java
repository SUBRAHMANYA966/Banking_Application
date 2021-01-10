package banking;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class NewPassword extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
    try {
    	String npass=request.getParameter("NPASS");
    	//String cnpass=request.getParameter("CNPASS");
    	HttpSession ses=request.getSession();
    	String toEmail=(String)ses.getAttribute("toEmail");
    	Model m=new Model();
    	boolean status=m.forgotPassword(npass,toEmail);
    	if(status==true) {
    		response.sendRedirect("/banking/PasswordSuccess1.jsp");
    	}
    	else {
    		response.sendRedirect("/banking/PasswordFail1.jsp");
    	}
    
	}
    catch (Exception e) {
    	e.printStackTrace();
    }
}
}
