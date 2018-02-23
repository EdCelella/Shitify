/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testingcoursework;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.*;
import java.net.Socket;
import infopacket.InfoPacket;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author samal
 */
public class LogInScreen extends javax.swing.JFrame {

    /**
     * Creates new form LogInScreen
     */
    
    
    
    public LogInScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        lblLogInForm = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        cmdLogIn = new javax.swing.JButton();
        cmdNewUser = new javax.swing.JButton();
        txtPassword = new javax.swing.JTextField();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblLogInForm.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblLogInForm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogInForm.setText("Log In Form");

        lblUserName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUserName.setText("User Name:");

        lblPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPassword.setText("Password:");

        txtUserName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        cmdLogIn.setText("Log In!");
        cmdLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLogInActionPerformed(evt);
            }
        });

        cmdNewUser.setText("New User");
        cmdNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNewUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogInForm, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblUserName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(txtPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmdNewUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdLogIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogInForm, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdLogIn))
                .addGap(17, 17, 17)
                .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdNewUser, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPassword)
                        .addGap(2, 2, 2)))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLogInActionPerformed
        String UserName = txtUserName.getText();
        String Password = txtPassword.getText();
        
        InfoPacket NamePass = new InfoPacket();
        InfoPacket ServerReply = new InfoPacket();
        
        ArrayList<String> LogInDetails = new ArrayList<>();
        LogInDetails.add(UserName);
        LogInDetails.add(Password);
            
        
        
        //DataPacket with Log in details.
        NamePass.CreateArrayPacket("LGN", LogInDetails );
        
        //Syntax to retrieve from aray
        //System.out.println(NamePass.GetArray().get(1));
        
        try {
            
            Socket MainServer = new Socket("localhost", 9090);            
            
            //Make Object Streams
            ObjectOutputStream ToServerStream = new ObjectOutputStream(MainServer.getOutputStream());
            System.out.println("Made Output Stream");
            
            //Send the NamePass infopacket
            ToServerStream.writeObject(NamePass);
            
            //Set up stream to recieve reply from server
            ObjectInputStream FromServerStream = new ObjectInputStream(MainServer.getInputStream());
            
            //Get reply 
            ServerReply = (InfoPacket) FromServerStream.readObject();
            
            if ("CORRECT".equals(ServerReply.GetData()))
            {
                //Load Main Screen Form and Pass Current User Name that Logged in
                System.out.println("Log In Granted");
            }
            else
            {
                System.out.println("Incorrect");
                txtUserName.setText("");
                txtPassword.setText("");
            }
                                    
                        
            MainServer.close();
        }
        catch (IOException e)
        {
            System.err.println("Error - " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogInScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdLogInActionPerformed

    private void cmdNewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNewUserActionPerformed
        //Open new Register User Form
        new RegisterUser().setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_cmdNewUserActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LogInScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogInScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdLogIn;
    private javax.swing.JButton cmdNewUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblLogInForm;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
