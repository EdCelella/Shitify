/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicClient;

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
    private boolean Request;
    
    public TimerThread SetForm(MainScreen screen)
    {
        this.form = screen;
        TimerThread PassBack = new TimerThread();
        return PassBack;
    }
    
    public void SetRequest (boolean request)
    {
        this.Request = request;
    }
    
    @Override
    public void run() 
    {
        while(Request == true)
        {
            try {
                  form.RefreshActiveFriendsList();
                  form.RefreshFriendsRequestList();
                  Thread.sleep(2000);
            } catch (IOException | ClassNotFoundException | InterruptedException ex) {
                  Logger.getLogger(TimerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
        }
    }
    
}
