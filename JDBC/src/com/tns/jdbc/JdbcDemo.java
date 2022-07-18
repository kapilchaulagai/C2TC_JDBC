package com.tns.jdbc;
import java.sql.*;
public class JdbcDemo {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");	
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM emp");
		
		while(rs.next())
		{
			int emp_id = rs.getInt("emp_id");
			String emp_name = rs.getString("emp_name");
			String emp_insur_id = rs.getString(3);
			String emp_dept = rs.getString(4);
			int emp_rank = rs.getInt(5);
			String emp_grade = rs.getString(6);
			int emp_exp = rs.getInt(7);
			int emp_salary = rs.getInt(8);
			int emp_inc_perct = rs.getInt(9);
			String emp_country = rs.getString(10);
			String emp_state = rs.getString(11);
			String emp_city = rs.getString(12);
			
			System.out.println(emp_id+" "+emp_name+" "+emp_insur_id+" "+emp_dept+" "+emp_rank+" "+emp_grade+" "+emp_exp+" "+emp_salary+" "+emp_inc_perct+" "+emp_country+" "+emp_state+" "+emp_city);
		}
		st.close();
		con.close();
	}//,,emp_salary,emp_inc_perct,emp_country,emp_state,emp_city

}
