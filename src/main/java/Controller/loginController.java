package Controller;
import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.memberDao;

@WebServlet("/loginController")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public loginController() {
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 接收-->request
		 * 2. 判斷-->query(帳號,密碼)
		 * 3. true-->member/loginSuccess.jsp
		 * 4. false-->member/loginError
		 */
		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("big5"); 
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		if(new memberDao().query(username, password)) {
			response.sendRedirect("member/loginSuccess.jsp");
		} else {
			response.sendRedirect("member/loginError.jsp");
		}			
	}

}
