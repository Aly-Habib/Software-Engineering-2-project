/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Task;
import Model.TaskDB;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author workstation
 */
public class getTasksForm {
    JFrame frame;
    JInternalFrame listFrame;
    
    public getTasksForm(){
        start();
    }
    
    public void start(){
       frame = new JFrame("Tasks");
       frame.setSize(700, 700);
       listFrame=new JInternalFrame("List All Tasks");
        JTable t=new JTable();
        DefaultTableModel model=new DefaultTableModel();
       Object[] columnData={"code","Title","Description","Assigned Employee","From time","To time"};
       model.setColumnIdentifiers(columnData);
       Object[] rowData =new Object[6];
      
       ArrayList<Task> tasks=new ArrayList<Task>();
       TaskDB taskDB = new TaskDB();
       tasks = taskDB.getAllTasks();

       for(Task x : tasks)
       {
           rowData[0] = x.getCode();
           rowData[1] = x.getTitle();
           rowData[2] = x.getDescription();
           rowData[3] = x.getAssignEmp();
           rowData[4] = x.getFromTime();
           rowData[5] = x.getToTime();
           
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
