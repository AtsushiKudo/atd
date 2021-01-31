package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import bean.Employee;

public class EmployeeDAO extends DAO{

	public int insert(Employee employee) throws Exception {
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"insert into employees values(?, ?, ?, ?, ?, ?)");

		st.setInt(1, employee.getEmpId());
		st.setString(2, employee.getFirstName());
		st.setString(3, employee.getLastName());

		LocalDate lastClockInDate = employee.getLastClockInDate();
		st.setInt(4, lastClockInDate.getYear());
		st.setInt(5, lastClockInDate.getMonthValue());
		st.setInt(6, lastClockInDate.getDayOfMonth());
		int line=st.executeUpdate();

		st.close();
		con.close();
		return line;
	}

}
