/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicClient;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.*;
import java.net.Socket;
import infopacket.InfoPacket;
import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
/**
 *
 * @author samal
 */
public class LogInScreen extends javax.swing.JFrame {

    /**
     * Creates new form LogInScreen
     */
    
    //#2B2D42
    // Sets colours to be used in design
    Color foreground = Color.decode("#FDFFFC");
    Color background = Color.decode("#2E2F2F");
    Color highlight = Color.decode("#5DFDCB");
    
    public LogInScreen() {
        initComponents();
        
        int buttonBorder = 4;
        
        //Sets frame background colour
        getContentPane().setBackground(background);
        
        
        //Sets background, text and border colours for buttons
        cmdNewUser.setContentAreaFilled(false);
        cmdNewUser.setBackground(background);
        cmdNewUser.setBorder(new LineBorder(foreground, buttonBorder));
	cmdNewUser.setForeground(foreground);
        
        cmdLogIn.setContentAreaFilled(false);
        cmdLogIn.setBackground(background);
        cmdLogIn.setBorder(new LineBorder(foreground, buttonBorder));
	cmdLogIn.setForeground(foreground);
        
        txtUserName.setBorder(new LineBorder(foreground, 4));
        PFPassword.setBorder(new LineBorder(foreground, 4));
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
        PFPassword = new javax.swing.JPasswordField();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(43, 45, 66));
        setForeground(new java.awt.Color(43, 45, 66));

        lblLogInForm.setFont(new java.awt.Font("Futura", 1, 48)); // NOI18N
        lblLogInForm.setForeground(new java.awt.Color(93, 253, 203));
        lblLogInForm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogInForm.setText("LOG IN");

        lblUserName.setFont(new java.awt.Font("Futura", 0, 24)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(253, 255, 252));
        lblUserName.setText("User Name:");

        lblPassword.setFont(new java.awt.Font("Futura", 0, 24)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(253, 255, 252));
        lblPassword.setText("Password:");

        txtUserName.setFont(new java.awt.Font("Futura", 0, 14)); // NOI18N

        cmdLogIn.setFont(new java.awt.Font("Futura", 1, 18)); // NOI18N
        cmdLogIn.setText("LOG IN");
        cmdLogIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmdLogInMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmdLogInMouseEntered(evt);
            }
        });
        cmdLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLogInActionPerformed(evt);
            }
        });

        cmdNewUser.setFont(new java.awt.Font("Futura", 1, 18)); // NOI18N
        cmdNewUser.setText("REGISTER");
        cmdNewUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmdNewUserMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmdNewUserMouseEntered(evt);
            }
        });
        cmdNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNewUserActionPerformed(evt);
            }
        });

        PFPassword.setFont(new java.awt.Font("Futura", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmdNewUser, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PFPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cmdLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(lblLogInForm, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogInForm, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PFPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmdLogIn, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addComponent(cmdNewUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLogInActionPerformed
        String UserName = txtUserName.getText();
        String Password = new String (PFPassword.getPassword());
        
        InfoPacket NamePass = new InfoPacket();
        InfoPacket ServerReply = new InfoPacket();
        
        ArrayList<String> LogInDetails = new ArrayList<>();
        LogInDetails.add(UserName);
        LogInDetails.add(Password);
            
        
        
        //DataPacket with Log in details.
        NamePass.SetService("LGN");
        NamePass.SetArray(LogInDetails);
        
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
                new MainScreen(UserName).setVisible(true);
                this.dispose();
            }
            else
            {
                System.out.println("Incorrect");
                txtUserName.setText("");
                PFPassword.setText("");
                
                JOptionPane.showMessageDialog(this,
                "Your account details do not match any records on the system. Please retry and enter them again",
                "Incorrect Details",
                JOptionPane.PLAIN_MESSAGE);
                
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

    private void cmdNewUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdNewUserMouseEntered
        // Changes colour of button when hovered over
        cmdNewUser.setContentAreaFilled(true);
        cmdNewUser.setBackground(foreground);
        cmdNewUser.setForeground(highlight);
    }//GEN-LAST:event_cmdNewUserMouseEntered

    private void cmdNewUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdNewUserMouseExited
        // Changes colour of button when mouse isn't hovering
        cmdNewUser.setContentAreaFilled(false);
        cmdNewUser.setForeground(foreground);
    }//GEN-LAST:event_cmdNewUserMouseExited

    private void cmdLogInMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdLogInMouseEntered
        // Changes colour of button when hovered over
        cmdLogIn.setContentAreaFilled(true);
        cmdLogIn.setBackground(foreground);
        cmdLogIn.setForeground(highlight);
    }//GEN-LAST:event_cmdLogInMouseEntered

    private void cmdLogInMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdLogInMouseExited
        // Changes colour of button when mouse isn't hovering
        cmdLogIn.setContentAreaFilled(false);
        cmdLogIn.setForeground(foreground);
    }//GEN-LAST:event_cmdLogInMouseExited

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
    private javax.swing.JPasswordField PFPassword;
    private javax.swing.JButton cmdLogIn;
    private javax.swing.JButton cmdNewUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblLogInForm;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
