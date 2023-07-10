package practiceProject.card2.three;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Success extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Success() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.println("<html>" + "<body>" + "<center><h3><font color='green'>" + "Details are added successfully via Hibernate. " + "</font></h3></center>" + "</body>" + "</html>");
	}
}