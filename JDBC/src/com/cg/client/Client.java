package com.cg.client;
import java.sql.*;
import com.cg.util.DBUtil;

public class Client {

	public static void main(String[] args) throws SQLException 
	{
		// TODO Auto-generated method stub
		Connection connection =DBUtil.getconnection();
		
		//checking the connection establishment
		if(connection !=null) 
		{
			System.out.println("JDBC: Connection is established.");
		}
		addEmployee();
		UpdateEmployee();
		DeleteEmployee();
		RetrieveByIdEmployee();
		GetEmployee();
	}
		//Create Operation
		private static void addEmployee() throws SQLException 
		{
			Connection connection =DBUtil.getconnection();
			String sqlinsert = "insert into emp(emp_id,emp_name,emp_insur_id,emp_dept,emp_rank,emp_grade,emp_exp,emp_salary,emp_inc_perct,emp_country,emp_state,emp_city)" 
					+ "values(8,'Kapil','888','Programmer','1','A+','10','400000','11','India','Uttarakhand','Sikkim')";
			PreparedStatement stmt = connection.prepareStatement(sqlinsert);
			int executeupdate = stmt.executeUpdate();
			if(executeupdate==1) 
			{
				System.out.println("Entry is added.");
			}
		}
		//Update Operation
		private static void UpdateEmployee() throws SQLException 
		{
			Connection connection =DBUtil.getconnection();
			String sqlupdate = "update emp set emp_salary = 100000 where emp_id=4";
			PreparedStatement stmt = connection.prepareStatement(sqlupdate);
			int executeupdate = stmt.executeUpdate();
			if(executeupdate==1) 
			{
				System.out.println("Update is successfull.");
			}
		}
		//Delete Operation
		private static void DeleteEmployee() throws SQLException 
		{
			Connection connection =DBUtil.getconnection();
			String sqldelete = "delete from emp where emp_id =2";
			PreparedStatement stmt = connection.prepareStatement(sqldelete);
			int executeupdate = stmt.executeUpdate();
			if(executeupdate==1) 
			{
				System.out.println("Delete is successfull.");
			}
		}
		
		//Retrieve Operation
		private static void GetEmployee() throws SQLException {
			Connection connection =DBUtil.getconnection();
			Statement stmt = connection.createStatement();
			String sqlretrieve="Select * from emp";
			ResultSet rs = stmt.executeQuery(sqlretrieve);
			while(rs.next()) {
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
			
		}
		//RetrieveById Operation
		private static void RetrieveByIdEmployee() throws SQLException {
		Connection connection = DBUtil.getconnection();
		Statement stmt = connection.createStatement();
		String sqlretrieve = "select * from emp where emp_id =3";
		ResultSet rs = stmt.executeQuery(sqlretrieve);
		if(rs.next()) 
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
		else 
		{
			System.out.println("Employee is not available with the mentioned ID...!");
		}

	}


}
