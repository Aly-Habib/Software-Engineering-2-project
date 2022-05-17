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
public class TeamLeaderDB {
    private String USER = "root", PASSWORD = "1234";
    private String DB_URL = "jdbc:mysql://localhost:3306/swe2";
    private String DB_MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    Connection connection;
    
    public TeamLeaderDB(){
        
    }
    
    public void updateTeamLeader(int id, TeamLeader leader){
        try{
            Class.forName(DB_MYSQL_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            String query = "UPDATE TEAMLEADER SET id=?, fname=?, lastname=?, username=?, password=?, age=?, salary=? where id=?";
            PreparedStatement preStat = connection.prepareStatement(query);
            preStat.setInt(1,leader.getID());
            preStat.setString(2, leader.getFname());
            preStat.setString(3, leader.getLname());
            preStat.setString(4, leader.getUserName());
            preStat.setString(5, leader.getPassword());
            preStat.setInt(6, leader.getAge());
            preStat.setInt(7, (int) leader.getSalary());
            preStat.setInt(8, id);
            preStat.execute();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void deleteTeamLeader(int EmpId){

        try{
            Class.forName(DB_MYSQL_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preStat = connection.prepareStatement("DELETE FROM TEAMLEADER WHERE id = ?");
            preStat.setInt(1, EmpId);
            preStat.execute();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void insertTeamLeader(TeamLeader leader){
         try{
             //insert into swe2.employee values(1, "Ali", "Ahmed", "alihabib", "123", 30, 5000)
            Class.forName(DB_MYSQL_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preStat = connection.prepareStatement("INSERT INTO TEAMLEADER VALUES(?, ?, ?, ?, ?, ?, ?)");
            preStat.setInt(1,leader.getID());
            preStat.setString(2, leader.getFname());
            preStat.setString(3, leader.getLname());
            preStat.setString(4, leader.getUserName());
            preStat.setString(5, leader.getPassword());
            preStat.setInt(6, leader.getAge());
            preStat.setInt(7, (int) leader.getSalary());
            preStat.execute();
            connection.close();
        }catch(Exception e){ 
            e.printStackTrace();
        }
    }

    public boolean checkTeamLeaderLogin(String username, String password){
        try{
            Class.forName(DB_MYSQL_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stat = connection.createStatement();
            String query = "select username, password from teamleader where username = '" + username + "' and password = '" + password + "'";
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
    
    public ArrayList<TeamLeader> getAllTeamLeaders(){
        ArrayList<TeamLeader> leaders = new ArrayList<TeamLeader>();
        ResultSet resultSet = null;
        Statement statement = null;
        TeamLeader leader = null;
        int id, age;
        String fName, lastName, username, password;
        double salary;
        try{
            Class.forName(DB_MYSQL_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from TEAMLEADER");
            while(resultSet.next()){
                id = resultSet.getInt("ID");
                age = resultSet.getInt("age");
                fName = resultSet.getString("fName");
                lastName = resultSet.getString("lastName");
                username = resultSet.getString("username");
                password = resultSet.getString("password");
                salary = resultSet.getDouble("salary");
                //(int ID, String fname, String lname, int age, double salary, String userName, String password)
                leader = new TeamLeader(id, fName, lastName, age, salary, username, password);
                leaders.add(leader);
            }
            connection.close();
        }catch(Exception e){ 
            e.printStackTrace();
        }
        
        return leaders;
    }
}
