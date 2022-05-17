
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


public class Employee extends User {
    
    public Employee() {
    }

    public Employee(int ID, String fname, String lname, int age, double salary, String userName, String password) {
        super(ID,fname,lname,age,salary,userName,password);
    }


    @Override
    public String toString() {
        return super.toString(); 
    }

    public boolean login(String userName, String pass) {
        EmployeeDB d = new EmployeeDB();
        if(d.checkEmployeeLogin(userName, pass))
        {
            return true;
        }
        return false;
    }
    
    
}
