package practiceProject.card2.three;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import javax.servlet.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet() {
		super();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("fname");
		String price = request.getParameter("price");
		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);
		float price1 = Float.parseFloat(price);
		HttpSession session1 = request.getSession(true);
		SessionFactory sessionFactory;

		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		Session session = sessionFactory.openSession();
		org.hibernate.Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Eproduct product = new Eproduct(id1, name, price1);
			System.out.println(product);
			session.save(product); response.sendRedirect("success");
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				e.printStackTrace();
			}
		} finally {
			session.close();
		}
	}
}