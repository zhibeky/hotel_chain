package kz.edu.nu.cs.se.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kz.edu.nu.cs.se.project.model.Registration;
import kz.edu.nu.cs.se.project.dao.RegistrationDao;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RegistrationDao registrationDao;

    public void init() {
    	registrationDao = new RegistrationDao();
    }
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//user_id, username, password, ident_type, ident_numb, address, home_phone#, mobile_phone
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String ident_type = request.getParameter("ident_type");
        String ident_number = request.getParameter("ident_numb");
        String address = request.getParameter("address");
        String home_phone = request.getParameter("home_phone#");
        String mobile_phone = request.getParameter("mobile_phone");
        
        Registration registration = new Registration();
        registration.setUsername(username);
        registration.setPassword(password);
        registration.setIdent_type(ident_type);
        registration.setIdent_number(ident_number);
        registration.setAddress(address);
        registration.setHome_phone(home_phone);
        registration.setMobile_phone(mobile_phone);
        
        try {
        	registrationDao.registerUser(registration);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("registersuccess.jsp");
	}

}
