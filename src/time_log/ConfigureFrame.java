/*

 */
package time_log;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Point;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wildzuk
 */
public class ConfigureFrame extends javax.swing.JFrame {

    SqlConnection sql_conn;
    Map <String,String> data_map=new HashMap();
    Map <String,String> test_map=new HashMap();
    boolean is_saved=true, error_with_connection=false, changes_made=false, is_tested=false;
    Time_log log_frame;
    
    /**
     * Creates new form ConfigureFrame
     * @param log_frame
     */
    public ConfigureFrame(Time_log log_frame) {
        initComponents();
        this.log_frame=log_frame;
        setFrameLocation(this.log_frame, this);
        readData();
        test_map.putAll(data_map);
        database_input.setText(data_map.get("database"));
        username_input.setText(data_map.get("username"));
        password_input.setText(data_map.get("password"));
        host_input.setText(data_map.get("host"));
        port_input.setText(data_map.get("port"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        database_label = new javax.swing.JLabel();
        username_label = new javax.swing.JLabel();
        password_label = new javax.swing.JLabel();
        host_label = new javax.swing.JLabel();
        port_label = new javax.swing.JLabel();
        database_input = new javax.swing.JTextField();
        username_input = new javax.swing.JTextField();
        password_input = new javax.swing.JTextField();
        host_input = new javax.swing.JTextField();
        port_input = new javax.swing.JTextField();
        test_btn = new javax.swing.JButton();
        close_btn = new javax.swing.JButton();
        clear_btn = new javax.swing.JButton();
        save_btn = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Configure Server");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        database_label.setFont(new java.awt.Font("Elephant", 1, 18)); // NOI18N
        database_label.setForeground(new java.awt.Color(0, 153, 255));
        database_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        database_label.setText("Database");
        getContentPane().add(database_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 140, 40));

        username_label.setFont(new java.awt.Font("Elephant", 1, 18)); // NOI18N
        username_label.setForeground(new java.awt.Color(0, 153, 255));
        username_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        username_label.setText("User Name");
        getContentPane().add(username_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 140, 40));

        password_label.setFont(new java.awt.Font("Elephant", 1, 18)); // NOI18N
        password_label.setForeground(new java.awt.Color(0, 153, 255));
        password_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        password_label.setText("Password");
        getContentPane().add(password_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 140, 40));

        host_label.setFont(new java.awt.Font("Elephant", 1, 18)); // NOI18N
        host_label.setForeground(new java.awt.Color(0, 153, 255));
        host_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        host_label.setText("Host");
        getContentPane().add(host_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 140, 40));

        port_label.setFont(new java.awt.Font("Elephant", 1, 18)); // NOI18N
        port_label.setForeground(new java.awt.Color(0, 153, 255));
        port_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        port_label.setText("Port");
        getContentPane().add(port_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 140, 40));

        database_input.setBackground(new java.awt.Color(0, 153, 255));
        database_input.setFont(new java.awt.Font("Elephant", 0, 16)); // NOI18N
        database_input.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(database_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 260, 40));

        username_input.setBackground(new java.awt.Color(0, 153, 255));
        username_input.setFont(new java.awt.Font("Elephant", 0, 16)); // NOI18N
        username_input.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(username_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 260, 40));

        password_input.setBackground(new java.awt.Color(0, 153, 255));
        password_input.setFont(new java.awt.Font("Elephant", 0, 16)); // NOI18N
        password_input.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(password_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 260, 40));

        host_input.setBackground(new java.awt.Color(0, 153, 255));
        host_input.setFont(new java.awt.Font("Elephant", 0, 16)); // NOI18N
        host_input.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(host_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 260, 40));

        port_input.setBackground(new java.awt.Color(0, 153, 255));
        port_input.setFont(new java.awt.Font("Elephant", 0, 16)); // NOI18N
        port_input.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(port_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 260, 40));

        test_btn.setBackground(new java.awt.Color(0, 0, 0));
        test_btn.setFont(new java.awt.Font("Elephant", 1, 16)); // NOI18N
        test_btn.setForeground(new java.awt.Color(0, 153, 255));
        test_btn.setText("TEST");
        test_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                test_btnActionPerformed(evt);
            }
        });
        getContentPane().add(test_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 100, 60));

        close_btn.setBackground(new java.awt.Color(0, 0, 0));
        close_btn.setFont(new java.awt.Font("Elephant", 1, 16)); // NOI18N
        close_btn.setForeground(new java.awt.Color(242, 5, 48));
        close_btn.setText("CLOSE");
        close_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_btnActionPerformed(evt);
            }
        });
        getContentPane().add(close_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, 125, 56));

        clear_btn.setBackground(new java.awt.Color(0, 0, 0));
        clear_btn.setFont(new java.awt.Font("Elephant", 1, 16)); // NOI18N
        clear_btn.setForeground(new java.awt.Color(242, 5, 48));
        clear_btn.setText("CLEAR");
        clear_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_btnActionPerformed(evt);
            }
        });
        getContentPane().add(clear_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 530, 125, 41));

        save_btn.setBackground(new java.awt.Color(0, 0, 0));
        save_btn.setFont(new java.awt.Font("Elephant", 1, 16)); // NOI18N
        save_btn.setForeground(new java.awt.Color(0, 153, 255));
        save_btn.setText("SAVE");
        save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btnActionPerformed(evt);
            }
        });
        getContentPane().add(save_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 100, 60));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/time_log/background.jpg"))); // NOI18N
        background.setText("jLabel1");
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 590));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void close_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_btnActionPerformed
        if(!is_saved && is_tested && !error_with_connection){
            String error_str="Are you sure you want to close without saving?";
            ErrorSaveFrame error_frame=new ErrorSaveFrame(error_str, this, log_frame);
            error_frame.setVisible(true);
        }
        else{
            setFrameLocation(this, log_frame);
            this.dispose();
            log_frame.setVisible(true);
        }
    }//GEN-LAST:event_close_btnActionPerformed

    private void test_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_test_btnActionPerformed
        changesMade();
        if(changes_made){
            try {
                log_frame.dml.testConnection(test_map);
                test_btn.setBackground(new Color(51, 255, 51));
                error_with_connection=false;
            } catch (SQLException ex) {
                error_with_connection=true;
                showErrorStage(ex.toString());
            }
        }
        is_tested=true;
        is_saved=false;
    }//GEN-LAST:event_test_btnActionPerformed

    private void clear_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_btnActionPerformed
        ConfirmFrame confirm_frame=new ConfirmFrame(this, "clear","Are you sure you want to clear everything?");
        confirm_frame.setVisible(true);
    }//GEN-LAST:event_clear_btnActionPerformed

    private void save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btnActionPerformed
        if(is_tested && !error_with_connection){
            log_frame.dml.replaceValuesMap(test_map);
            clearLogFrame();
            log_frame.pushTypes(false);
            writeData();
            save_btn.setBackground(new Color(51, 255, 51));
            log_frame.setTitle("Database: "+log_frame.dml.getDatabase());
            error_with_connection=false;
            error_with_connection=true;
            changes_made=false;
        }
        else if(!is_tested){
            showErrorStage("Please test the connection before saving");
        }
        else if(error_with_connection){
            showErrorStage("Please get a successful test connection before saving");
        }
        test_btn.setBackground(new Color(0,0,0));
        is_saved=true;
        is_tested=false;
    }//GEN-LAST:event_save_btnActionPerformed

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
            java.util.logging.Logger.getLogger(ConfigureFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfigureFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfigureFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfigureFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }
    
    private void readData(){
        String str;
        try {
            FileInputStream fstream=new FileInputStream("server_data.dat");
            DataInputStream input_file = new DataInputStream(fstream);
            while(input_file.available()>0){
                str=input_file.readUTF();
                String[] token=str.split("=");
                data_map.put(token[0], token[1]);
            }
        } 
        catch (IOException ex) {
            showErrorStage(ex.toString());
        }
    }
    
    public void writeData(){
        try {
            FileOutputStream fstream2=new FileOutputStream("server_data.dat");
            DataOutputStream output_file = new DataOutputStream(fstream2);
            test_map.forEach((key,value)->{
                try {
                    output_file.writeUTF(key+"="+value);
                } catch (IOException ex) {
                    showErrorStage(ex.toString());
                }
            });
            output_file.close();
            fstream2.close();
        } 
        catch (IOException ex) {
            showErrorStage(ex.toString());
        } 
    }
    
    private void clearLogFrame(){
        log_frame.table_model.setNumRows(0);
    }
    
    private void showErrorStage(String error_str){
        DisplayErrorFrame error_stage=new DisplayErrorFrame(error_str, this);
        error_stage.setVisible(true);
    }
    
    private void changesMade(){
        changes_made=false;
        if(database_input.getText().compareTo(test_map.get("database"))!=0){
            test_map.replace("database", database_input.getText());
            changes_made=true;
        }
        if(username_input.getText().compareTo(test_map.get("username"))!=0){
            test_map.replace("username", username_input.getText());
            changes_made=true;
        }
        if(password_input.getText().compareTo(test_map.get("password"))!=0){
            test_map.replace("password", password_input.getText());
            changes_made=true;
        }
        if(host_input.getText().compareTo(test_map.get("host"))!=0){
            test_map.replace("host", host_input.getText());
            changes_made=true;
        }
        if(port_input.getText().compareTo(test_map.get("port"))!=0){
            test_map.replace("port", port_input.getText());
            changes_made=true;
        }
    }
    
    private void setFrameLocation(Frame frame_value_from, Frame frame_to_set){
        Point location_on_screen=frame_value_from.getLocationOnScreen();
        location_on_screen.setLocation(location_on_screen.getX()-(frame_to_set.getWidth()-frame_value_from.getWidth())/2, location_on_screen.getY());
        frame_to_set.setLocation(location_on_screen);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    public javax.swing.JButton clear_btn;
    public javax.swing.JButton close_btn;
    public javax.swing.JTextField database_input;
    private javax.swing.JLabel database_label;
    public javax.swing.JTextField host_input;
    private javax.swing.JLabel host_label;
    public javax.swing.JTextField password_input;
    private javax.swing.JLabel password_label;
    public javax.swing.JTextField port_input;
    private javax.swing.JLabel port_label;
    public javax.swing.JButton save_btn;
    public javax.swing.JButton test_btn;
    public javax.swing.JTextField username_input;
    private javax.swing.JLabel username_label;
    // End of variables declaration//GEN-END:variables
}
