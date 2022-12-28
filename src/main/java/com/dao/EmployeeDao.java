package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import com.model.Employee;
public class EmployeeDao {

	Connection connection= null;
	PreparedStatement PreparedStatement=null;
	int i=0;
	public int insertdata(Employee Employee)
	{
		connection=DatabaseConnection.myconnection();
		try {
			PreparedStatement=connection.prepareStatement("insert into Employee1 values(?,?,?,?,?,?)");
			PreparedStatement.setInt(1,Employee.getEmployeeid());
			PreparedStatement.setString(2,Employee.getEname());
			PreparedStatement.setString(3,Employee.getAddr());
			PreparedStatement.setDouble(4,Employee.getSalary());
			PreparedStatement.setString(5,Employee.getGender());
			PreparedStatement.setString(6,Employee.getBirthdate());

			i =PreparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	public int delete(int eid) {
		connection=DatabaseConnection.myconnection();
		try {
			PreparedStatement=connection.prepareStatement("delete from Employee1 where Employeeid=?" );
			PreparedStatement.setInt(1,eid);
			i=PreparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	public List<Employee> DisplayAll()
	{
		Employee emp=null;
		connection=DatabaseConnection.myconnection();
		LinkedList<Employee> lst=new LinkedList<>();
		ResultSet rs=null;
		Statement st=null;
		try 
		{
			st=connection.createStatement();
			rs=st.executeQuery("select * from Employee1");
			while(rs.next())
			{
				emp=new Employee();
				emp.setEmployeeid(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setAddr(rs.getString(3));
				emp.setSalary(rs.getDouble(4));
				emp.setGender(rs.getString(5));
				emp.setBirthdate(rs.getString(6));
				lst.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return lst;	
	}
}
