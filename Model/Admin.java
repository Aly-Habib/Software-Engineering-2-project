/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author workstation
 */
public class Admin extends User{

    public Admin(){
        
    }
    
    @Override
    public boolean login(String username, String password) {
        if(username.equals("admin") && password.equals("admin"))
            return true;
        return false;
    }
    
    
}
