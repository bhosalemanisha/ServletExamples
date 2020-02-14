package com.tdnservlet.practise;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchCustomerServlet")
public class SearchCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SearchCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		
		Customerpojo customer = new Customerpojo();
		CustomerpojoDAOImpl customerdao=new  CustomerpojoDAOImpl();
		
		String txtdata=request.getParameter("txtsearch");
		String radiochoice=	request.getParameter("customer");
		PrintWriter out=resp.getWriter();
		System.out.println(radiochoice+txtdata);
		if (radiochoice.equalsIgnoreCase("id")) {
			if(!txtdata.isEmpty()) {
				System.out.println(customer);
				customer = customerdao.findById(Integer.parseInt((txtdata)));
				
				if(customer!=null) {
					out.println("Id: "+customer.getId());
					out.println("Name: "+customer.getName());
					out.println("Address: "+customer.getAddress());
					out.println("Number: "+customer.getNumber());
					resp.setContentType("text/html");
					out.println("<input type ='button' value ='update'>");
					out.println("<input type ='button' value ='delete'>");
				}else {
					out.println("No data Found");
				}
				
			}else {
				out.print("Enter Id");
			}
			
		}else if (radiochoice.equalsIgnoreCase("Number")) {
			if (!txtdata.isEmpty()) {
				customer=customerdao.findByNumber(txtdata);
				if(customer!=null) {
					out.println("Id: "+customer.getId());
					out.println("Name: "+customer.getName());
					out.println("Address: "+customer.getAddress());
					out.println("Number: "+customer.getNumber());
				}else {
					out.println("No data Found");
				}
			}else {
				out.print("Enter Number");
			}
		}
		
						
	
	}
	
}
