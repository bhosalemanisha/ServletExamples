package com.tdnservlet.practise;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerServlet1 extends HttpServlet {

	private static final long serialVersionUID = 1902855394526507426L;

	public CustomerServlet1() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Customerpojo customer = new Customerpojo();
		CustomerpojoDAOImpl customerdao=new  CustomerpojoDAOImpl();
		

		customer.setId(Integer.parseInt(req.getParameter("txtid")));
		customer.setName(req.getParameter("txtname"));
		customer.setAddress(req.getParameter("txtaddress"));
		customer.setNumber(req.getParameter("txtmobilenumber"));
		PrintWriter out=resp.getWriter();
		int r=customerdao.insertcustomer(customer);
		if (r==1) {
			out.println("successfully inserted");
			out.println("Id:" +customer.getId());
			out.println("Name:" +customer.getName());
			out.println("Address:" +customer.getAddress());
			out.println("Mobile number:" +customer.getNumber());
		
		} else {
			out.println("fail");

		}
		
		
	}
	
	

}
