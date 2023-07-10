import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductDetails() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId = request.getParameter("id");
		System.out.println(productId);
		int id = Integer.valueOf(productId);
		final String URL = "jdbc:mysql://localhost:3306/Products";
		final String USER = "root";
		final String PASSWORD = "root";
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		Connection conn = null;

		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connection Established");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
 
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<h3>Product Details</h3>");
			out.println("<table border=1><tr>" + "<td><b>ID</b></td>" + "<td><b>Name</b></td>" + "<td><b>Price</b></td>" + "<td><b>Date Added</b></td>");
			PreparedStatement ps=conn.prepareStatement("select * from eproduct where id=?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int sno = rs.getInt("id");
				String brand = rs.getString("name");
				float price = rs.getFloat("price");
				String date = rs.getString("date_added");
				out.println("<tr>" + "<td>" + sno + "</td>" + "<td>" + brand + "</td>" + "<td>" + price + "</td>" + "<td>" + date + "</td></tr>");
			}
			out.println("</table></body></html>");
			rs.close(); ps.close();
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
