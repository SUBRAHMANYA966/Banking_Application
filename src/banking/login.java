	package banking;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class login extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)
			{
		    try {
		    	System.out.println("true");
			String custid=request.getParameter("CUSTID");
			String password=request.getParameter("PASS");
			Model m=new Model();
			m.setCustomerid(custid);
			m.setPassword(password);
			boolean status=m.login();
			if(status==true)

			{
				String accno=m.getAccountNumber();
				HttpSession session=request.getSession(true);
			     session.setAttribute("accno", accno);
				response.sendRedirect("/banking/home.jsp");
			}
			else
			{
				response.sendRedirect("/banking/loginFail.jsp");
			}
		    }
			catch(Exception e)
			{
				e.printStackTrace();
			}
			}
}