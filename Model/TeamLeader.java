/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author workstation
 */
public class TeamLeader extends User{

    public static ArrayList<TeamLeader> teamLeaders=new ArrayList<TeamLeader>();

    public TeamLeader() {
    }

    public TeamLeader(int ID, String fname, String lname, int age, double salary, String userName, String password) {
        super(ID, fname, lname, age, salary, userName, password);
    }

    @Override
    public boolean login(String username, String pass) {
        TeamLeaderDB d = new TeamLeaderDB();
        if(d.checkTeamLeaderLogin(username, pass))
        {
            return true;
        }
        return false;
    }

    
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
}
