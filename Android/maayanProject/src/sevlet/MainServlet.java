package sevlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
   
    public MainServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String movieName = request.getParameter("s");
		String year = request.getParameter("year");
		System.out.println("Movie " + movieName + ", year: " + year);
		PrintWriter writer = response.getWriter();
		writer.write("Thank you: " + movieName);
	}
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String movieName = request.getParameter("s");
		String year = request.getParameter("year");
		System.out.println("POST - Movie " + movieName + ", year: " + year);
		PrintWriter writer = response.getWriter();
		writer.write("Thank you:(POST) " + movieName);
	}

}
