import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "Add", urlPatterns = {"/add"})
public class Add extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html><body>");

        out.println("<h2><a href=\"search.jsp\">Search Product</a> | <a href=\"add.jsp\">Add Product</a> </h2>");

        try {

            String product_name = request.getParameter("product_name");
            String product_price = request.getParameter("product_price");

            out.println("<br/>");

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp", "root", "mypassword");

                Statement st = conn.createStatement();
                String sql = "INSERT INTO products (product_name, product_price) VALUES('" + product_name + "'," + product_price +")";
                System.out.println(sql);
                st.executeUpdate(sql);
                conn.close();

                out.println("Product is added<br/>");

            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            out.println("</body></html>");
            out.close();

        }

        response.sendRedirect("search.jsp");


    }
}
