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
public class TaskDB {
    private String USER = "root", PASSWORD = "1234";
    private String DB_URL = "jdbc:mysql://localhost:3306/swe2";
    private String DB_MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    Connection connection;
    
    public TaskDB(){
        
    }

    public void updateTask(int id, Task task){
        try{
            Class.forName(DB_MYSQL_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            String query = "UPDATE TASK SET id=?, title=?, assignEmp=?, Description=?, fromTime=?, toTime=?, taskPhase=? where id=?";
            PreparedStatement preStat = connection.prepareStatement(query);
            preStat.setInt(1,task.getCode());
            preStat.setString(2, task.getTitle());
            preStat.setInt(3, task.getAssignEmp());
            preStat.setString(4, task.getDescription());
            preStat.setString(5, task.getFromTime());
            preStat.setString(6, task.getToTime());
            preStat.setString(7, task.getTaskPhase());
            preStat.setInt(8, id);
            preStat.execute();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void deleteTask(int id){

        try{
            Class.forName(DB_MYSQL_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preStat = connection.prepareStatement("DELETE FROM TASK WHERE ID = ?");
            preStat.setInt(1, id);
            preStat.execute();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void insertTask(Task task){
         try{
             //insert into swe2.task values(1, 1, "His task is done", "2/2", "6/3", "Underwork");
            Class.forName(DB_MYSQL_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preStat = connection.prepareStatement("INSERT INTO TASK VALUES(?, ?, ?, ?, ?, ?, ?)");
            preStat.setInt(1,task.getCode());
            preStat.setString(2, task.getTitle());
            preStat.setInt(3, task.getAssignEmp());
            preStat.setString(4, task.getDescription());
            preStat.setString(5, task.getFromTime());
            preStat.setString(6, task.getToTime());
            preStat.setString(7, task.getTaskPhase());
            preStat.execute();
            connection.close();
        }catch(Exception e){ 
            e.printStackTrace();
        }
    }
    
    public ArrayList<Task> getAllTasks(){
        ArrayList<Task> tasks = new ArrayList<Task>();
        ResultSet resultSet = null;
        Statement statement = null;
        Task task = null;
        int id, assignEmp;
        String title, description, taskPhase, fromTime, toTime;
        try{
            Class.forName(DB_MYSQL_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from TASK");
            while(resultSet.next()){
                id = resultSet.getInt("ID");
                assignEmp = resultSet.getInt("assignEmp");
                title = resultSet.getString("title");
                description = resultSet.getString("description");
                fromTime = resultSet.getString("fromTime");
                toTime = resultSet.getString("toTime");
                taskPhase = resultSet.getString("taskPhase");
                //(int tCode, String tTitle, String tDescription, int assignEmp, String taskPhase,String fromTime,String toTime)
                task = new Task(id, title, description, assignEmp, taskPhase, fromTime, toTime);
                tasks.add(task);
            }
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return tasks;
    }
    
    public Task getTask(int TaskID){
        ResultSet resultSet = null;
        Statement statement = null;
        PreparedStatement preStat = null;
        Task task = null;
        int id, assignEmp;
        String title, description, taskPhase, fromTime, toTime;
        try{
            Class.forName(DB_MYSQL_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            statement = connection.createStatement();
            preStat = connection.prepareStatement("select * from task where id=?");
            preStat.setInt(1, TaskID);
            resultSet = preStat.executeQuery();
            if(resultSet.next()){
                id = resultSet.getInt("ID");
                assignEmp = resultSet.getInt("assignEmp");
                title = resultSet.getString("title");
                description = resultSet.getString("description");
                fromTime = resultSet.getString("fromTime");
                toTime = resultSet.getString("toTime");
                taskPhase = resultSet.getString("taskPhase");
                //(int tCode, String tTitle, String tDescription, int assignEmp, String taskPhase,String fromTime,String toTime)
                task = new Task(id, title, description, assignEmp, taskPhase, fromTime, toTime);
            }
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return task;
    }
    
}
