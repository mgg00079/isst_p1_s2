package isst_p1_s2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Sesion2Parte2
 */
@WebServlet("/Sesion2Parte2")
public class Sesion2Parte2 extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String email = request.getParameter("email");
		
		Usuario usuario = new Usuario(nombre, apellidos, email);
		
		HttpSession session = request.getSession(true);
		session.setAttribute("usuario", usuario);
		
		Cookie c = new Cookie("emailCookie", email);
		c.setMaxAge(10);
		c.setPath("/");
		response.addCookie(c);
		
		//Para eliminar la cookie:
		c.setMaxAge(0);
		c.setPath("/");
		response.addCookie(c);
		
	}


}
