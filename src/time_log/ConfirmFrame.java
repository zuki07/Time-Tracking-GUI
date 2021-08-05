
package time_log;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;


public class ConfirmFrame extends javax.swing.JFrame {

    Time_log log_frame;
    RunningFrame run_frame;
    ConfigureFrame config_frame;
    ViewProjectFrame view_project_frame;
    String to_do, header_str, project_input_lowercase, type_input_lowercase;
    
    
    /**
     * Creates new form Error_stage
     * @param log_frame
     * @param to_do
     * @param header_str
     */
    
    public ConfirmFrame(Time_log log_frame, String to_do, String header_str) {
        initComponents();
        this.log_frame=log_frame;
        this.to_do=to_do;
        this.header_str="<HTML>"+header_str+"<HTML>";
        header_label.setText(this.header_str);
        project_input_lowercase=this.log_frame.project_input.getText().toLowerCase();
        type_input_lowercase=this.log_frame.type_input.getText().toLowerCase();
        run_frame=new RunningFrame();
    }
    
    public ConfirmFrame(ConfigureFrame config_frame, String to_do, String header_str){
        initComponents();
        this.config_frame=config_frame;
        this.to_do=to_do;
        this.header_str="<HTML>"+header_str+"<HTML>";
        header_label.setText(this.header_str);
        run_frame=new RunningFrame();
    }
    
    public ConfirmFrame(ViewProjectFrame view_project_frame,String to_do, String header_str){
        initComponents();
        this.view_project_frame=view_project_frame;
        this.to_do=to_do;
        this.header_str="<HTML>"+header_str+"<HTML>";
        this.project_input_lowercase=view_project_frame.time_log_stage.project_name;
        header_label.setText(this.header_str);
        run_frame=new RunningFrame();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header_label = new javax.swing.JLabel();
        yes_btn = new javax.swing.JButton();
        no_btn = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Confirmation");
        setLocation(new java.awt.Point(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header_label.setFont(new java.awt.Font("Elephant", 1, 24)); // NOI18N
        header_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        header_label.setText("jLabel1");
        getContentPane().add(header_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 600, 70));

        yes_btn.setBackground(new java.awt.Color(51, 255, 51));
        yes_btn.setFont(new java.awt.Font("Elephant", 1, 16)); // NOI18N
        yes_btn.setText("YES");
        yes_btn.setBorderPainted(false);
        yes_btn.setFocusPainted(false);
        yes_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yes_btnActionPerformed(evt);
            }
        });
        getContentPane().add(yes_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 90, 40));

        no_btn.setBackground(new java.awt.Color(51, 255, 51));
        no_btn.setFont(new java.awt.Font("Elephant", 1, 16)); // NOI18N
        no_btn.setText("NO");
        no_btn.setBorderPainted(false);
        no_btn.setFocusPainted(false);
        no_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                no_btnActionPerformed(evt);
            }
        });
        getContentPane().add(no_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 90, 40));

        background.setBackground(new java.awt.Color(255, 51, 0));
        background.setOpaque(true);
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 190));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void yes_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yes_btnActionPerformed
        run_frame.setVisible(true);
        switch (to_do){
            case "delete_project_click":
                log_frame.dml.deleteProjectName(log_frame.jTable1.getValueAt(log_frame.jTable1.getSelectedRow(), 0).toString().toLowerCase());
                log_frame.list.remove(log_frame.jTable1.getSelectedRow());
                log_frame.table_model.removeRow(log_frame.jTable1.getSelectedRow());
                log_frame.jTable1.clearSelection();
                setDatabaseSize();
                log_frame.project_input.setText("--PROJECT NAME--");
                break;
            case "delete_project_input":
                log_frame.dml.deleteProjectName(project_input_lowercase);
                log_frame.table_model.removeRow(log_frame.list.indexOf(project_input_lowercase));
                log_frame.list.remove(project_input_lowercase);
                setDatabaseSize();
                log_frame.project_input.setText("--PROJECT NAME--");
                break;
            case "create_project":
                log_frame.dml.types_str=log_frame.menu_box.getSelectedItem().toString();
                log_frame.dml.insertProjectNamesValues(project_input_lowercase);
                log_frame.list.add(project_input_lowercase);
                log_frame.table_model.addRow(new Object[]{toCapitalize(project_input_lowercase), "", "OPEN"});
                setDatabaseSize();
                log_frame.project_input.setText("--PROJECT NAME--");
                break;
            case "create_type":
                log_frame.dml.insertType(type_input_lowercase);
                log_frame.types_list.add(type_input_lowercase);
                log_frame.menu_box.addItem(toCapitalize(type_input_lowercase));
                log_frame.menu_box.setSelectedItem(toCapitalize(type_input_lowercase));
                setDatabaseSize();
                log_frame.table_model.setNumRows(0);
                log_frame.type_input.setText("--TYPE OF PROJECT--");
                log_frame.hideTypeTools();
                break;
            case "delete_type":
                if(log_frame.list!=null){
                    for(int i=0;i<log_frame.list.size();i++){
                        log_frame.dml.deleteProjectName(log_frame.list.get(i).toString());
                    }
                }
                log_frame.dml.deleteType(type_input_lowercase);
                log_frame.menu_box.removeItem(toCapitalize(type_input_lowercase));
                log_frame.types_list.remove(type_input_lowercase);
                setDatabaseSize();
                log_frame.type_input.setText("--TYPE OF PROJECT--");
                log_frame.hideTypeTools();
                break;
            case "delete_project_data":
                int project_row=view_project_frame.row;
                String project_duration=view_project_frame.time_log_stage.dml.getRecordDuration(project_row);
                int[] project_duration_array=tokenize(project_duration);
                Map<Integer, String> map=new HashMap();
                map.putAll(view_project_frame.time_log_stage.dml.getRecordTotalTime(project_row));
                map.forEach((key,value)->{
                    int[] row_time_array=tokenize(value);
                    int update_min;
                    int update_hour=row_time_array[0]-project_duration_array[0];
                    if(row_time_array[1]>project_duration_array[1]){
                        update_min=row_time_array[1]-project_duration_array[1];
                    }
                    else{
                        update_min=project_duration_array[1]-row_time_array[1];
                    }
                    map.replace(key, update_hour+":"+update_min);
                });
                view_project_frame.time_log_stage.dml.updateRecordTotalTime(map, project_input_lowercase);
                view_project_frame.time_log_stage.dml.deleteProjectData(project_row);
                view_project_frame.setProjectName(project_input_lowercase);
                view_project_frame.pushProjectNames();
                break;
            case "clear":
                config_frame.database_input.setText("");
                config_frame.username_input.setText("");
                config_frame.password_input.setText("");
                config_frame.host_input.setText("");
                config_frame.port_input.setText("");
                config_frame.test_btn.setBackground(new Color(0,0,0));
                config_frame.save_btn.setBackground(new Color(0,0,0));
                break;
        }
        run_frame.dispose();
        this.dispose();
    }//GEN-LAST:event_yes_btnActionPerformed

    private void no_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_no_btnActionPerformed
        this.dispose();
    }//GEN-LAST:event_no_btnActionPerformed
    
    private String toCapitalize(Object object){
        String str=object.toString();
        if(str==null){
            return str;
        }
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }
    
    private void setDatabaseSize(){
        String database_size=log_frame.dml.getDatabaseSize()+" MB";
        log_frame.mb_label.setText(database_size);
    }
    
    private int[] tokenize(String str){
        String[] token=str.split(":");
        int duration_hour=Integer.parseInt(token[0]);
        int duration_min=Integer.parseInt(token[1]);
        int[] duration_array={duration_hour, duration_min};
        return duration_array;
    }
    
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
            java.util.logging.Logger.getLogger(ConfirmFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfirmFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfirmFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfirmFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel header_label;
    private javax.swing.JButton no_btn;
    private javax.swing.JButton yes_btn;
    // End of variables declaration//GEN-END:variables
}
