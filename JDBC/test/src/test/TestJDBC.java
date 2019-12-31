package test;

import java.sql.*;

public class TestJDBC {
    public static void main(String args[]){
    	try{
            Class.forName("org.postgresql.Driver");
            Connection conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb","postgres","123456");// ten host - ten port - ten db , username, password
//            PreparedStatement stmt = conn.prepareStatement("select * from test");
            Statement stmt= conn.createStatement();
            System.out.println("Qua trinh read: ");
            ResultSet rs= stmt.executeQuery("select * from employee");
            
            while (rs.next()){
                System.out.println(rs.getInt(1)+" :"+rs.getString(2) +" :"+rs.getString(3) );
            }
            System.out.println("Qua trinh add : ");
            stmt.executeUpdate("insert into employee(id,fullname,fullnumber) values (5,'Nguyen Thi Thao','0234412345')");
            ResultSet rs1= stmt.executeQuery("select * from employee");
            
            while (rs1.next()){
                System.out.println(rs1.getInt(1)+" :"+rs1.getString(2) +" :"+rs1.getString(3) );
            }
            System.out.println("Qua trinh update: ");
            stmt.executeUpdate("update employee set id=4, fullname='Ngo The Thang', fullnumber='021212199' where id=4");
            rs1= stmt.executeQuery("select * from employee");
            
            while (rs1.next()){
                System.out.println(rs1.getInt(1)+" :"+rs1.getString(2) +" :"+rs1.getString(3) );
            }
            conn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
