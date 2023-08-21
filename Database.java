package Package;

import java.sql.*;
import java.util.ArrayList;

public class Database {
	public ArrayList<Employee> getEmployees(){
		ArrayList<Employee> res=null;
		Connection c=null;
		Statement s=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName("org.postgresql.Driver");
			c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?user=postgres&password=Bhara@1234");
			s=c.createStatement();
			rs=s.executeQuery("select * from Emp");
			res=new ArrayList<>();
			while(rs.next()) {
				res.add(new Employee(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	public void addEmployee(Employee e) {
		ArrayList<Employee> res=null;
		Connection c=null;
		Statement s=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName("org.postgresql.Driver");
			c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?user=postgres&password=Bhara@1234");
			ps=c.prepareStatement("insert into Emp values(?,?,?,?,?)");
			ps.setString(1, e.getName());
			ps.setString(2, e.getEno());
			ps.setString(3, e.getSal());
			ps.setString(4, e.getJob());
			ps.setString(5, e.getDept());
			ps.execute();
		}
		catch(Exception ee) {
			ee.printStackTrace();
		}
	}public void deleteEmployee(String eno) {
		ArrayList<Employee> res=null;
		Connection c=null;
		Statement s=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName("org.postgresql.Driver");
			c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?user=postgres&password=Bhara@1234");
			ps=c.prepareStatement("delete from Emp where eno=?");
			ps.setString(1,eno);
			ps.execute();
		}
		catch(Exception ee) {
			ee.printStackTrace();
		}
	}
	public void editEmployee(Employee er) {
		ArrayList<Employee> res=null;
		Connection c=null;
		Statement s=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName("org.postgresql.Driver");
			c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?user=postgres&password=Bhara@1234");
			ps=c.prepareStatement("update Emp  set name=?,sal=?,job=?,dept=? where eno=?");
			ps.setString(1,er.getName());
			ps.setString(2,er.getSal());
			ps.setString(3,er.getJob());
			ps.setString(4,er.getDept());
			ps.setString(5,er.getEno());
			ps.execute();
		}
		catch(Exception ee) {
			ee.printStackTrace();
		}
	}
}
