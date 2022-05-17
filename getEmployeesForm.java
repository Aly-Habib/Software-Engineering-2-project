/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Employee;
import Model.EmployeeDB;
import Model.TeamLeader;
import Model.TeamLeaderDB;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class getEmployeesForm {
    JFrame frame;
    JInternalFrame listFrame;
   //JTable t=new JTable()
   public getEmployeesForm()
   {
       frame = new JFrame("Employees");
       frame.setSize(700, 700);
       listFrame=new JInternalFrame("List All Employees");
        JTable t=new JTable();
        DefaultTableModel model=new DefaultTableModel();
       Object[] columnData={"ID","First Name","Last Name","Age","Salary","User Name","Password"};
       model.setColumnIdentifiers(columnData);
       Object[] rowData =new Object[7];
      
       ArrayList<Employee> employees=new ArrayList<Employee>();
       EmployeeDB empDB = new EmployeeDB();
       employees = empDB.getAllEmployees();

       for(Employee x : employees)
       {
           rowData[0]=x.getID();
           rowData[1]=x.getFname();
           rowData[2]=x.getLname();
           rowData[3]=x.getAge();
           rowData[4]=x.getSalary();
           rowData[5]=x.getUserName();
           rowData[6]=x.getPassword();
           
           model.addRow(rowData);
            t.setModel(model);
             t.setBounds(30, 40, 200, 300);
             JScrollPane s=new JScrollPane(t);
             listFrame.add(s);
             listFrame.setSize(600, 600);
             listFrame.setVisible(true);
             listFrame.setClosable(false);
        }
       frame.add(listFrame);
       frame.show();
       frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
       
    }
   
}
