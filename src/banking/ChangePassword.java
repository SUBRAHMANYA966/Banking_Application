package banking;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangePassword extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
    try {
    	HttpSession session=request.getSession();
    	String accno=(String)session.getAttribute("accno");
    	String password=request.getParameter("NPASS");
    	Model m=new Model();
    	m.setAccountNumber(accno);
    	m.setPassword(password);
    	boolean status=m.ChangePassword();
    	if(status==true)
    		response.sendRedirect("/banking/PassSuccess.jsp");
    	else 
    		response.sendRedirect("/banking/PassFail.jsp");
    }
    catch(Exception e)
    {
    	e.printStackTrace();
    }
}
}