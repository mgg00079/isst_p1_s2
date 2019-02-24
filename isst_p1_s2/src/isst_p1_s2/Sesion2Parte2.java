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

	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String url = "/isst_p1_s2/Formulario.html";
		
		HttpSession session = request.getSession(true);
		
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String email = request.getParameter("email");
		
		Usuario usuario = new Usuario(nombre, apellidos, email);
		
		session.setAttribute("usuario", usuario);
		
		Cookie c = new Cookie("emailCookie", email); //Asignar el valor de email a la cookie emailCookie.
		c.setMaxAge(60*60*60*365*2); //Tiempo de permanencia en el cliente. Para eliminar la cookie, poner el valor de este campo a 0.
		c.setPath("/");
		response.addCookie(c); //Añadir cookie a la respuesta.
		
	}

}
