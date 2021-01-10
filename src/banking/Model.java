package banking;
0
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Model {
	private String Name;
	private String AccountNumber;
	private String Balance;
	private String Customerid;
	private String Password;
	private String Email;
	String url="jdbc:oracle:thin:@//localhost:1521/XE";
	String un="system";
	String pw="system";
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet res=null;
	private String taccno;
	public String getName() {
		return Name;
	}
	public String getAccountNumber() {
		return AccountNumber;
	}
	public String getBalance() {
		return Balance;
	}
	public String getCustomerid() {
		return Customerid;
	}
	public String getPassword() {
		return Password;
	}
	public String getEmail() {
		return Email;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}
	public void setBalance(String balance) {
		Balance = balance;
	}
	public void setCustomerid(String customerid) {
		Customerid = customerid;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Model()
	 {
	 	try
	 	{
	 		Class.forName("oracle.jdbc.driver.OracleDriver");
	 		con=DriverManager.getConnection(url,un,pw);
	 	}
	 	catch (Exception e) 
	 	{
	 		e.printStackTrace();
	 	}
	 }
	  public boolean login() {
	 	{
	 		try {
	 			String s="SELECT * FROM BANK WHERE CUSTOMERID=? AND PASSWORD=?";
	 			pstmt=con.prepareStatement(s);
	 			pstmt.setString(1,Customerid);
	 			pstmt.setString(2,Password);
	 			res=pstmt.executeQuery();
	 			if(res.next()==true)
	 			{
	 				AccountNumber=res.getString(2);
	 				return true;
	 				}
	 			else
	 			
	 				return false;
	 			
	 		}	
	 			catch(Exception e)
	 			{
	 				e.printStackTrace();
	 			}
	 		return false;
	 	}
	 	
	  }
	public boolean Balance()
	{
		try {
			String s="SELECT * FROM BANK WHERE ACCOUNTNUMBER=?";
			pstmt=con.prepareStatement(s);
			pstmt.setString(1,AccountNumber);
			res=pstmt.executeQuery();
			if(res.next()==true)
			{
				Balance=res.getString("BALANCE");
				return true;
			}
			else
			{
				return  false;
			}	
		}
		catch (Exception e)
		{
		e.printStackTrace();	
		}
		return false;
	}
	public boolean ChangePassword() {
		try {
			String s="UPDATE BANK SET PASSWORD=? WHERE ACCOUNTNUMBER=?";
			pstmt=con.prepareStatement(s);
			pstmt.setString(1, Password);
			pstmt.setString(2, AccountNumber);
			int status=pstmt.executeUpdate();
			if(status==0)
				return false;
			else
				return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public boolean transfer(String tamt)
	{
		try {
			String s="UPDATE BANK SET BALANCE=BALANCE-? WHERE ACCOUNTNUMBER=?";
			pstmt=con.prepareStatement(s);
			pstmt.setString(1, tamt);
			pstmt.setString(2,AccountNumber);
			int rows=pstmt.executeUpdate();
			String s2="UPDATE BANK SET BALANCE=BALANCE+? WHERE ACCOUNTNUMBER=?";
			pstmt=con.prepareStatement(s2);
			pstmt.setString(1,tamt);
			pstmt.setString(2,AccountNumber);
			pstmt.executeUpdate();
			String s1="INSERT INTO BANKSTATEMENT VALUES(?,?)";
			pstmt=con.prepareStatement(s1);
			pstmt.setString(1, AccountNumber);
			pstmt.setString(2, tamt);
			pstmt.executeUpdate();
			if(rows==0)
			{
				return false;
			}
			else
				return true;
			}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
		}
	public  ArrayList getStatement() {
	ArrayList al1=new ArrayList();
		try {
			String s="SELECT *FROM BANKSTATEMENT WHERE ACCOUNTNUMBER=?";
			pstmt=con.prepareStatement(s);
			pstmt.setString(1, AccountNumber);
			res=pstmt.executeQuery();
			while(res.next()==true)
			{ 
				String temp=res.getString("AMOUNT");
				al1.add(temp);
			
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al1;
	}
	public boolean applyloan()
	{
		try {
			String s="SELECT * FROM BANK WHERE ACCOUNTNUMBER=?";
			pstmt=con.prepareStatement(s);
			pstmt.setString(1, AccountNumber);
			res=pstmt.executeQuery();
			if(res.next()==true)
			{
				Name=res.getString("NAME");
				Email=res.getString("EMAIL");
				return true;
			}
			else
				return false;
		}
		
		catch(Exception e) {
			e.printStackTrace();}
		
		return false;
		
	}
	
public boolean forgotPassword(String npass, String toEmail) {
	try {
		
		
		String s="UPDATE BANK SET PASSWORD=? WHERE EMAIL=?";
		pstmt=con.prepareStatement(s);
		pstmt.setString(1, npass);
		pstmt.setString(2, toEmail);
		int rows=pstmt.executeUpdate();
		if(rows==0)
		{
			return true;
		}
		else
			return false;
		}
		
	
	catch(Exception e) {
		e.printStackTrace();
	}
	return false;
}


	
	
	}
	