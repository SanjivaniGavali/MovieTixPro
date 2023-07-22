package Model;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoClass {
	static Connection con=null;
	static {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernate","root","sql123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void update(int remain,String name) {
		if(remain>=0) {
		int count=0;
		PreparedStatement pstmt=null;
		String query = "update movie set ticket=? where name=?";
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, remain);
			pstmt.setString(2, name);
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}else {
		int var=0;
		int count=0;
		PreparedStatement pstmt=null;
		String query = "update movie set ticket=? where name=?";
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, var);
			pstmt.setString(2, name);
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}	
}	
	 public double fetchprice(String name) {
	    	ResultSet rs=null;
	    	Statement stmt=null;
	    	String query="select price from movie where name='"+name+"'";
	    	double price=0.0;

			try {
				stmt=con.createStatement();
				rs=stmt.executeQuery(query);
				while(rs.next()) {
					price=rs.getDouble("price");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return price;
	    }
	 public String fetchtheater(String name) {
	    	ResultSet rs=null;
	    	Statement stmt=null;
	    	String query="select theater from movie where name='"+name+"'";
	    	String theater="";

			try {
				stmt=con.createStatement();
				rs=stmt.executeQuery(query);
				while(rs.next()) {
					theater=rs.getString("theater");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return theater;
	    }
	 public int fetchticket(String name) {
		    int totalTicket=0;
	    	ResultSet rs=null;
	    	Statement stmt=null;
	    	String query="select ticket from movie where name='"+name+"'";

			try {
				stmt=con.createStatement();
				rs=stmt.executeQuery(query);
				while(rs.next()) {
					totalTicket=rs.getInt("ticket");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return totalTicket;
	    }
	 public int remainingTicket(int ticket,int totalTicket) {
		 int remainingTicket=0;
		 remainingTicket=totalTicket-ticket;
//		 if(ticket<=totalTicket) {
//			 remainingTicket=totalTicket-ticket;
//			 bill=(price*ticket)+((price*ticket)*0.18);
//		 }
		 return remainingTicket;
	 }
	 public double bill(double price,int ticket,int ramains) {
		 double bill=0.0;
		 if(ramains>=0) {
			 bill=(price*ticket)+((price*ticket)*0.18);
		 }
		 return bill;
	 }
}
