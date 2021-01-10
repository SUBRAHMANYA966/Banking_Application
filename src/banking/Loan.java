package banking;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Loan extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		try {
			HttpSession session=request.getSession();
	    	String accno=(String)session.getAttribute("accno");
	    	Model m=new Model();
	    	m.setAccountNumber(accno);
	    	boolean status=m.applyloan();
	    	if(status==true)
	    	{
	    		String name=m.getName();
	    		String email=m.getEmail();
	    		session.setAttribute("name",name);
	    		session.setAttribute("email", email);
	    		response.sendRedirect("/banking/LoanSuccess.jsp");
	    	}
	    	else
	    		response.sendRedirect("/banking/LoanFail.jap");
	    	
		
}
		catch(Exception e) {
			e.printStackTrace();
		}
}}