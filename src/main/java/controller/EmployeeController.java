package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.dao.EmployeeDao;
import com.model.Employee;

public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;  
	public EmployeeController() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException	{

		int eid=Integer.parseInt(request.getParameter("eid"));
		String ename=request.getParameter("name");	
		String addr=request.getParameter("addr");
		double sal=Double.parseDouble(request.getParameter("sal"));
		String gen=request.getParameter("gen");
		String dob=request.getParameter("dob");

		Employee emp=new Employee();
		emp.setEmployeeid(eid);
		emp.setEname(ename);
		emp.setBirthdate(dob);
		emp.setGender(gen);
		emp.setAddr(addr);
		emp.setSalary(sal);

		EmployeeDao EmployeeDao=new EmployeeDao();
		int i=EmployeeDao.insertdata(emp);
		if(i>0){
			response.sendRedirect("insert.html");
		}	
		else{
			response.sendRedirect("Employee Exist.html");	
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
