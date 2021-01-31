package tool;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"*.action"})
public class FrontController extends HttpServlet {

	private static String charCode = "UTF-8";

	public void doPost(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

		//文字コードをセット(文字化け防止)
		request.setCharacterEncoding(charCode);
	    response.setContentType("text/html; charset=" + charCode);

		PrintWriter out=response.getWriter();
		try {
			String path=request.getServletPath().substring(1);
			String name=path.replace(".a", "A").replace('/', '.');
			Action action=(Action)Class.forName(name).newInstance();
			String url=action.execute(request, response);
			request.getRequestDispatcher(url).
				forward(request, response);
		} catch (Exception e) {
			e.printStackTrace(out);
		}
	}

	public void doGet(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException{

		//文字コードをセット(文字化け防止)
		request.setCharacterEncoding(charCode);
	    response.setContentType("text/html; charset=" + charCode);

		doPost(request, response);
	}
}
