package banking;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class GetStatement extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		try {
			HttpSession session=request.getSession();
	    	String accno=(String)session.getAttribute("accno");
	    	Model m=new Model();
	    	m.setAccountNumber(accno);
	    	ArrayList al1=m.getStatement();
	        if(al1.isEmpty()==true)
	    	{
	    		response.sendRedirect("/banking/GetStatementFail.jsp");
	    		
	    	}
	    	else
	    	{
	    		session.setAttribute("al1",al1);
	    		response.sendRedirect("/banking/GetStatementSuccess.jsp");
	    	}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
}
}
