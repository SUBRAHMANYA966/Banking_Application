package banking;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Transfer extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		try {
		HttpSession session=request.getSession();
    	String accno=(String)session.getAttribute("accno");
    	String tamt=request.getParameter("TAMT");
    	String taccno=request.getParameter("TACCNO");
    	Model m=new Model();
    	m.setAccountNumber(accno);
    	m.setAccountNumber(taccno);
    	boolean status=m.transfer(tamt);
    	if(status==true)
    	response.sendRedirect("/banking/TransferSuccess.jsp");
    	else
    		response.sendRedirect("/banking/TransferFail.jsp");
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}		
    		
    		
    		
	}

}
