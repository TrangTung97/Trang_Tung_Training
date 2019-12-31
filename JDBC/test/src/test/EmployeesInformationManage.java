package test;

import java.sql.*;
import java.util.Scanner;

public class EmployeesInformationManage {
	private static Scanner input= new Scanner(System.in);
	public static void main(String args[]) throws SQLException{
		Connection conn= null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb","postgres","123456");
            boolean flag= true;
            System.out.println("Welcome to Icheck Information System");
            printChoice();
            while(flag) {
            	System.out.println("Moi ban chon :");
            	int choice= input.nextInt();
            	switch(choice) {
            	case 0: 
            		printChoice();
            		break;
            	case 1:
            		addEmployee(conn);
            		break;
            	case 2:
            		editInf(conn);
            		break;
            	case 3:
            		removeEmp(conn);
            		break;
            	case 4:
            		viewInf(conn);
            		break;
            	case 5:
            		flag= false;
            		System.out.println("Hen gap lai ban");
            		break;
            	}
            }
            conn.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void printChoice() {
		System.out.println("0 : In cac su lua chon");
		System.out.println("1 : Them nhan vien");
		System.out.println("2 : Sua thong tin nhan vien");
		System.out.println("3 : Xoa nhan vien");
		System.out.println("4 : In toan bo nhan vien trong cong ty");
		System.out.println("5 : Thoat chuong trinh");
	}
	public static void addEmployee(Connection conn) throws SQLException {
		System.out.println("Nhap id cho nhan vien moi: ");
		int id= input.nextInt();
		input.nextLine();
		System.out.println("Nhap ho ten nhan vien moi: ");
		String name= input.nextLine();
		System.out.println("Nhap tuoi cua nhan vien moi: ");
		int age= input.nextInt();
		input.nextLine();
		PreparedStatement ps= conn.prepareStatement("insert into employees(id,fullname,age) values(?,?,?)");
		ps.setInt(1,id);
		ps.setString(2,name);
        ps.setInt(3,age);
        ps.executeUpdate();
		System.out.println("Ban da them thanh cong");
	}
	public static void viewInf(Connection conn) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("select * from employees");
 		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		}
	}
	public static void editInf(Connection conn) throws SQLException {
		System.out.println("Nhap id cua nhan vien can sua:");
		int idCurrent= input.nextInt();
		input.nextLine();
		System.out.println("Nhap id moi cua nhan vien:");
		int idNew= input.nextInt();
		input.nextLine();
		System.out.println("Nhap ho ten moi cua nhan vien:");
		String fullNameNew= input.nextLine();
		System.out.println("Nhap tuoi moi cua nhan vien:");
		int ageNew= input.nextInt();
		input.nextLine();
		PreparedStatement ps= conn.prepareStatement("update employees set id= "+idNew+", fullname= '"+ fullNameNew+"', age= "+ageNew+" where id = "+ idCurrent);
		ps.executeUpdate();
		System.out.println("Da sua thanh cong");
	}
	public static void removeEmp(Connection conn) throws SQLException {
		System.out.println("Nhap id nhan vien nghi viec: ");
		int idCurrent= input.nextInt();
		input.nextLine();
		PreparedStatement ps= conn.prepareStatement("delete from employees where id = " + idCurrent);
		ps.executeUpdate();
		System.out.println("Da xoa thanh cong");
	}
}
