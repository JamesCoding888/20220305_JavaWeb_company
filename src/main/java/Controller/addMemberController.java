package Controller;
import java.io.IOException;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.memberDao;
import Model.member;
@WebServlet("/addMemberController")
public class addMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public addMemberController() {
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 判斷-->query(帳號)
		 * 2. true-->重複-->addMemberError-->重新註冊
		 * 3. false-->request 所有資料-->add 新增
		 * 4. addMemberSuccess.jsp
		 */
		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("big5"); 
		String username = request.getParameter("username");
		if(new memberDao().query(username)) {
			response.sendRedirect("member/addMemberError.jsp");
		} else {
			String password = request.getParameter("password");
			String address = request.getParameter("address");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String mobile = request.getParameter("mobile");
			
			member m = new member(username, password, address, name, phone, mobile);
			new memberDao().addMember(m);
			
			response.sendRedirect("member/addMemberSuccess.jsp");			
		}
	}		
}
