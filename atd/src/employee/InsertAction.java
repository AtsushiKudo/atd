package employee;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Employee;
import dao.EmployeeDAO;
import tool.Action;

public class InsertAction extends Action{

	public String execute(
			HttpServletRequest request, HttpServletResponse response
		) throws Exception {

			int empId;

		    try {
		    	empId=Integer.parseInt(request.getParameter("emp-id"));
		    }catch(Exception nfe){
		    	return "/employee/touroku-emp.jsp";
		    }

			String firstName=request.getParameter("first-name");
			String lastName=request.getParameter("last-name");
			LocalDate lastClockInDate = LocalDate.parse("9999-11-11");

			Employee e=new Employee();
			e.setEmpId(empId);
			e.setFirstName(firstName);
			e.setLastName(lastName);
			e.setLastClockInDate(lastClockInDate);
			EmployeeDAO dao=new EmployeeDAO();
			dao.insert(e);

			return "/menu/top.jsp";
		}

}
