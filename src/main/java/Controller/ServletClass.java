package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DaoClass;
@WebServlet("/formlink")
public class ServletClass extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		int ticket=Integer.parseInt(req.getParameter("ticket"));
		
		DaoClass d1=new DaoClass();
		
		double price=d1.fetchprice(name);
		int totalTicket=d1.fetchticket(name);
		int remainingTicket=d1.remainingTicket(ticket, totalTicket);
		d1.update(remainingTicket, name);
		double bill=d1.bill(price, ticket,remainingTicket);
		
		req.setAttribute("name", name);
		req.setAttribute("ticket", ticket);
		req.setAttribute("remaining", remainingTicket);
		req.setAttribute("bill", bill);
		
		RequestDispatcher rs=req.getRequestDispatcher("view.jsp");
		rs.forward(req, resp);
	}
}

