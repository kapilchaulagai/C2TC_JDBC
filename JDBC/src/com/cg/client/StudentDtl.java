package com.cg.client;
import java.sql.*;
import com.cg.util.StudUtil;

public class StudentDtl {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Connection con = StudUtil.getconnection();
		
		if(con!=null)
		{
			System.out.println("JDBC: Connection has been established.");
		}
		studentCreate();
		insertVal();
		viewQuery();
	}
	private static void studentCreate()throws Exception
	{
		Connection con = StudUtil.getconnection();
		String drop = "drop table stud_dtl";
		String create = "create table stud_dtl ( stud_usn varchar(10) primary key not null, "
				+ "		stud_name varchar(40) not null, stud_dept varchar(60) not null, "
				+ "stud_age int not null)";
		PreparedStatement stmt = con.prepareStatement(drop);
		int executeUpdate = stmt.executeUpdate();
		
		stmt = con.prepareStatement(create);
		executeUpdate = stmt.executeUpdate();
		
		if(executeUpdate == 1)
		{
			System.out.println(executeUpdate+"row(s) affected.");
		}
	}
	private static void insertVal() throws SQLException
	{
		Connection con = StudUtil.getconnection();
		String update = "insert into stud_dtl(stud_usn, stud_name, stud_dept, stud_age) "
				+ "values ('1SP18CS031','Kapil','CSE',23)";
		PreparedStatement prst = con.prepareStatement(update);
		int executeUpdate = prst.executeUpdate();
		
		if(executeUpdate >=1)
		{
			System.out.println(executeUpdate+" row(s) affected.");
		}
	}
	private static void viewQuery() throws SQLException
	{
		Connection con = StudUtil.getconnection();
		Statement stmt = con.createStatement();
		String viewQuery = "select * from stud_dtl";
		ResultSet rs = stmt.executeQuery(viewQuery);
		while(rs.next())
		{
			String stud_usn = rs.getString(1);
			String stud_name = rs.getString(2);
			String stud_dept = rs.getString(3);
			String stud_age = rs.getString(2);
			
			System.out.println(stud_usn+" "+stud_name+" "+stud_dept+" "+stud_age);
		}
		String descTable = "desc stud_dtl";
		rs = stmt.executeQuery(descTable);
		System.out.println(rs);
	}
}
