package bean;

import java.time.LocalDate;


public class Employee {

	private int empId;
	private String firstName;
	private String lastName;
	private LocalDate LastClockInDate;

	public int getEmpId() {
		return empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public LocalDate getLastClockInDate() {
		return LastClockInDate;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setLastClockInDate(LocalDate lastClockInDate) {
		LastClockInDate = lastClockInDate;
	}
}
