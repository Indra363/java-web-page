package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet
{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		
		String myname = req.getParameter("name1");
		String mypass = req.getParameter("pass1");
		
		PrintWriter out = resp.getWriter();
		
		if(myname.equals("Indra") && mypass.equals("indra123")) 
		{
			//request obj gets destroy after redirecting to one page
			//so it cant redirect to 2nd page
			//req.setAttribute("name_key", "Indra");
			
			HttpSession session = req.getSession();
			session.setAttribute("name_key", "Indra");
			
			RequestDispatcher rd = req.getRequestDispatcher("/profile.jsp");
			rd.forward(req, resp);		
		}
		else 
		{
			resp.setContentType("text/html");
			out.print("<h3 style='color:red'> name and password didnt match");
			RequestDispatcher rd = req.getRequestDispatcher("/index.html");
			rd.include(req, resp);
		}
		
	}

}

