/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Task{
    private int tCode;
    private String tTitle;
    private String tDescription;
    private int assignEmp;
    private String taskPhase;
    private String fromTime;
    private String toTime;
      
    public Task() {
    }

    public Task(int tCode, String tTitle, String tDescription, int assignEmp, String taskPhase,String fromTime,String toTime) {
        this.tCode = tCode;
        this.tTitle = tTitle;
        this.tDescription = tDescription;
        this.assignEmp = assignEmp;
        this.taskPhase = taskPhase;
        this.fromTime=fromTime;
        this.toTime=toTime;
    }

    public int getCode() {
        return tCode;
    }

    public void setCode(int tCode) {
        this.tCode = tCode;
    }

    public String getTitle() {
        return tTitle;
    }

    public void setTitle(String tTitle) {
        this.tTitle = tTitle;
    }

    public String getDescription() {
        return tDescription;
    }

    public void setDescription(String tDescription) {
        this.tDescription = tDescription;
    }

    public int getAssignEmp() {
        return assignEmp;
    }

    public void setAssignEmp(int assignEmp) {
        this.assignEmp = assignEmp;
    }

    public String getTaskPhase() {
        return taskPhase;
    }
    
    public void setTaskPhase(String taskPhase) {
        this.taskPhase = taskPhase;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }


}

