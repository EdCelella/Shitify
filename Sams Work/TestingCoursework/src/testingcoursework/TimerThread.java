/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testingcoursework;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samal
 */
public class TimerThread extends Thread{
    
    private MainScreen form;
    
    public TimerThread SetForm(MainScreen screen)
    {
        this.form = screen;
        TimerThread PassBack = new TimerThread();
        return PassBack;
    }
    
    @Override
    public void run() 
    {
        while(true)
        {
            try {
                  form.RefreshPosts();
                  form.RefreshAllFriendsList();
                  form.RefreshFriendsRequestList();
                  System.out.println("Printing");
                  Thread.sleep(2000);
            } catch (IOException | ClassNotFoundException | InterruptedException ex) {
                  Logger.getLogger(TimerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
        }
    }
    
}
