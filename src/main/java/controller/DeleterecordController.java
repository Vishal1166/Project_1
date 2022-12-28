package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.dao.EmployeeDao;
import com.model.Employee;

public class DeleterecordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleterecordController() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int eid=Integer.parseInt(request.getParameter("eid"));
		Employee emp=new Employee();
		emp.setEmployeeid(eid);

		EmployeeDao empd=new EmployeeDao();
		int i=empd.delete(eid);
		if(i>0)
		{
			response.sendRedirect("DisplayList.jsp");
		}	
		else
		{
			response.sendRedirect("Employee not found.html");	
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
