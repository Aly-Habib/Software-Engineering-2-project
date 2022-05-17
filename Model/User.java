/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


public abstract class User {
    private int ID;
    private String fName;
    private String lastName;
    private String userName;
    private String password;
    private int age;
    private double salary;
    String typeOfEmployee;

    public User() {
    }

    public User(int ID, String fname, String lname, int age, double salary, String userName, String password) {
        this.ID = ID;
        this.fName = fname;
        this.lastName = lname;
        this.userName = userName;
        this.password = password;
        this.age=age;
        this.salary=salary;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFname() {
        return fName;
    }

    public void setFname(String fname) {
        this.fName = fname;
    }

    public String getLname() {
        return lastName;
    }

    public void setLname(String lname) {
        this.lastName = lname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getTypeOfEmployee() {
        return typeOfEmployee;
    }

    public void setTypeOfEmployee(String typeOfEmployee) {
        this.typeOfEmployee = typeOfEmployee;
    }
    public abstract boolean login(String userName, String Pass); 
}