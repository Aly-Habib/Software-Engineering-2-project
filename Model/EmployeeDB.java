/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author workstation
 */
public class EmployeeDB {
    private String USER = "root", PASSWORD = "1234";
    private String DB_URL = "jdbc:mysql://localhost:3306/swe2";
    private String DB_MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    Connection connection;
    
    public EmployeeDB(){
        
    }
//    UPDATE swe2.employee 
//SET 
//    id = 1,
//    fname = 'Ali',
//    lastname = 'Ben habib',
//    username = 'ali',
//    password = '111',
//    age = 21,
//    salary = 600
//WHERE
//    id = 1;
    public void updateEmployee(int id, Employee emp){
        try{
            Class.forName(DB_MYSQL_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            String query = "UPDATE EMPLOYEE SET id=?, fname=?, lastname=?, username=?, password=?, age=?, salary=? where id=?";
            PreparedStatement preStat = connection.prepareStatement(query);
            preStat.setInt(1,emp.getID());
            preStat.setString(2, emp.getFname());
            preStat.setString(3, emp.getLname());
            preStat.setString(4, emp.getUserName());
            preStat.setString(5, emp.getPassword());
            preStat.setInt(6, emp.getAge());
            preStat.setInt(7, (int) emp.getSalary());
            preStat.setInt(8, id);
            preStat.execute();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void deleteEmployee(int EmpId){

        try{
            Class.forName(DB_MYSQL_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preStat = connection.prepareStatement("DELETE FROM EMPLOYEE WHERE id = ?");
            preStat.setInt(1, EmpId);
            preStat.execute();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void insertEmployee(Employee emp){
         try{
             //insert into swe2.employee values(1, "Ali", "Ahmed", "alihabib", "123", 30, 5000)
            Class.forName(DB_MYSQL_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preStat = connection.prepareStatement("INSERT INTO EMPLOYEE VALUES(?, ?, ?, ?, ?, ?, ?)");
            preStat.setInt(1,emp.getID());
            preStat.setString(2, emp.getFname());
            preStat.setString(3, emp.getLname());
            preStat.setString(4, emp.getUserName());
            preStat.setString(5, emp.getPassword());
            preStat.setInt(6, emp.getAge());
            preStat.setInt(7, (int) emp.getSalary());
            preStat.execute();
            connection.close();
        }catch(Exception e){ 
            e.printStackTrace();
        }
    }
    
    public boolean checkEmployeeLogin(String username, String password){
        try{
            Class.forName(DB_MYSQL_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stat = connection.createStatement();
            String query = "select username, password from employee where username = '" + username + "' and password = '" + password + "'";
            ResultSet result = stat.executeQuery(query);
            if(!result.isBeforeFirst()){
                return false;
            }
            else{
                return true;
            }
        }catch(Exception e){ 
            e.printStackTrace();
        }
        return false;
    }
 
    public ArrayList<Employee> getAllEmployees(){
        ArrayList<Employee> employees = new ArrayList<Employee>();
        ResultSet resultSet = null;
        Statement statement = null;
        Employee employee = null;
        int id, age;
        String fName, lastName, username, password;
        double salary;
        try{
            Class.forName(DB_MYSQL_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from employee");
            while(resultSet.next()){
                id = resultSet.getInt("ID");
                age = resultSet.getInt("age");
                fName = resultSet.getString("fName");
                lastName = resultSet.getString("lastName");
                username = resultSet.getString("username");
                password = resultSet.getString("password");
                salary = resultSet.getDouble("salary");
                //(int ID, String fname, String lname, int age, double salary, String userName, String password)
                employee = new Employee(id, fName, lastName, age, salary, username, password);
                employees.add(employee);
            }
            connection.close();
        }catch(Exception e){ 
            e.printStackTrace();
        }
        
        return employees;
    }
}
