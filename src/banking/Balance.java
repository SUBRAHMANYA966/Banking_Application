package banking;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import banking.Model;

class Balance extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
    try {
    	HttpSession session=request.getSession();
    	String accno=(String)session.getAttribute("accno");
    	Model m=new Model();
    	m.setAccountNumber(accno);
    	boolean status=m.Balance();
    	if(status==true)
    	{
    		String balance=m.getBalance();
    		System.out.println(m.getBalance());
    		session.setAttribute("balance", balance);
    		try {
    		
    		response.sendRedirect("/banking/balance.jsp");
    	}
    		catch(Exception e){
    	e.printStackTrace();
    		}
    	}
    			else
    	{
    		response.sendRedirect("/banking/balanceFail.jsp");
    	}
    }
    catch(Exception e)
    {
    	e.printStackTrace();
    }
    	}
	}
