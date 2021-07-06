/*

 */
package time_log;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wildzuk
 */
public class Time_log extends javax.swing.JFrame {

    DML dml=new DML();
    List list, types_list;
//    TableMouseListener table_mouse_listener; 
    boolean value_match=false, drop_btn_selected=false, display_type_changes=true;
    DefaultTableModel table_model;
    ConfirmFrame drop_project;
    String header_str, to_do_str, input_str, database_value, database_size;
    ViewProjectFrame project_frame;
    
    /**
     * Creates new form Time_log
     */
    public Time_log(){
        initComponents();
        table_model=(DefaultTableModel) jTable1.getModel();
        project_frame=new ViewProjectFrame(this);
        try {
            dml.startConnection(true);
            dml.closeConnection();
            pushTypes(false);
            setDatabaseSize();
            this.setTitle("Time log -- "+dml.getDatabase());
        } catch (SQLException ex) {
            showErrorStage(ex.toString());
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu_box = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        add_btn = new javax.swing.JButton();
        drop_btn = new javax.swing.JButton();
        project_input = new javax.swing.JTextField();
        mb_label = new javax.swing.JLabel();
        plus_minus_btn = new javax.swing.JButton();
        type_add = new javax.swing.JButton();
        type_drop = new javax.swing.JButton();
        type_input = new javax.swing.JTextField();
        config_btn = new javax.swing.JButton();
        menu_background = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Time Logger");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu_box.setBackground(new java.awt.Color(0, 0, 0));
        menu_box.setFont(new java.awt.Font("Elephant", 0, 15)); // NOI18N
        menu_box.setForeground(new java.awt.Color(0, 153, 255));
        menu_box.setMaximumRowCount(4);
        menu_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TYPES" }));
        menu_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_boxActionPerformed(evt);
            }
        });
        getContentPane().add(menu_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 40));
        menu_box.setRenderer(new DefaultListCellRenderer() {
            public void paint(Graphics g){
                setBackground(new Color(0,0,0));
                setForeground(new Color(0,153,255));
                setHorizontalAlignment(DefaultListCellRenderer.CENTER);
                super.paint(g);
            }
        });

        jScrollPane1.setBorder(null);

        jTable1.setBackground(new java.awt.Color(0, 0, 0));
        jTable1.setFont(new java.awt.Font("Elephant", 0, 16)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 153, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PROJECT NAME", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setFocusable(false);
        jTable1.setOpaque(false);
        jTable1.setRequestFocusEnabled(false);
        jTable1.setRowHeight(28);
        jTable1.setSelectionBackground(new java.awt.Color(247, 0, 38));
        jTable1.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        ((DefaultTableCellRenderer) jTable1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        for(int i=0; i<jTable1.getColumnCount(); i++){
            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setHorizontalAlignment(SwingConstants.CENTER);
            jTable1.getColumnModel().getColumn(i).setCellRenderer(render);
            render.setBackground(new Color(0,0,0,175));
            render.setForeground(new Color(0,153,255));
            jTable1.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(render);
            jTable1.getTableHeader().setPreferredSize(new Dimension(jScrollPane1.getWidth(), 40));
        }
        jTable1.getAccessibleContext().setAccessibleName("");

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 400, 300));
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        ((DefaultTableCellRenderer)jTable1.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane1.getAccessibleContext().setAccessibleName("jScrollPane1");

        add_btn.setBackground(new java.awt.Color(0, 0, 0));
        add_btn.setFont(new java.awt.Font("Elephant", 1, 14)); // NOI18N
        add_btn.setForeground(new java.awt.Color(242, 5, 48));
        add_btn.setText("ADD");
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });
        getContentPane().add(add_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 510, 90, 36));
        add_btn.getAccessibleContext().setAccessibleName("add_btn");

        drop_btn.setBackground(new java.awt.Color(0, 0, 0));
        drop_btn.setFont(new java.awt.Font("Elephant", 1, 14)); // NOI18N
        drop_btn.setForeground(new java.awt.Color(242, 5, 48));
        drop_btn.setText("DROP");
        drop_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drop_btnActionPerformed(evt);
            }
        });
        getContentPane().add(drop_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 510, 90, 36));
        drop_btn.getAccessibleContext().setAccessibleName("drop_btn");

        project_input.setBackground(new java.awt.Color(0, 153, 255));
        project_input.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        project_input.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        project_input.setText("PROJECT NAME");
        project_input.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                project_inputFocusGained(evt);
            }
        });
        getContentPane().add(project_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 465, 200, 30));
        project_input.getAccessibleContext().setAccessibleName("");

        mb_label.setFont(new java.awt.Font("Elephant", 1, 20)); // NOI18N
        mb_label.setForeground(new java.awt.Color(0, 153, 255));
        mb_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mb_label.setText("DB Size");
        getContentPane().add(mb_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 110, 40));
        mb_label.getAccessibleContext().setAccessibleName("");

        plus_minus_btn.setBackground(new java.awt.Color(0, 0, 0));
        plus_minus_btn.setFont(new java.awt.Font("Impact", 1, 18)); // NOI18N
        plus_minus_btn.setForeground(new java.awt.Color(0, 153, 255));
        plus_minus_btn.setText("+ / -");
        plus_minus_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plus_minus_btnActionPerformed(evt);
            }
        });
        getContentPane().add(plus_minus_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 60, 40));
        plus_minus_btn.getAccessibleContext().setAccessibleName("plus_minus_btn");

        type_add.setBackground(new java.awt.Color(0, 0, 0));
        type_add.setFont(new java.awt.Font("Elephant", 1, 14)); // NOI18N
        type_add.setForeground(new java.awt.Color(242, 5, 48));
        type_add.setText("INSERT");
        type_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type_addActionPerformed(evt);
            }
        });
        getContentPane().add(type_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, -1, -1));
        type_add.setVisible(false);
        type_add.getAccessibleContext().setAccessibleName("type_add");

        type_drop.setBackground(new java.awt.Color(0, 0, 0));
        type_drop.setFont(new java.awt.Font("Elephant", 1, 14)); // NOI18N
        type_drop.setForeground(new java.awt.Color(242, 5, 48));
        type_drop.setText("DELETE");
        type_drop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type_dropActionPerformed(evt);
            }
        });
        getContentPane().add(type_drop, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, -1, -1));
        type_drop.setVisible(false);
        type_drop.getAccessibleContext().setAccessibleName("type_drop");

        type_input.setBackground(new java.awt.Color(0, 153, 255));
        type_input.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        type_input.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        type_input.setText("TYPE OF PROJECT");
        type_input.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                type_inputFocusGained(evt);
            }
        });
        getContentPane().add(type_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 190, 30));
        type_input.setVisible(false);
        type_input.getAccessibleContext().setAccessibleName("");

        config_btn.setBackground(new java.awt.Color(0, 0, 0));
        config_btn.setFont(new java.awt.Font("Elephant", 1, 14)); // NOI18N
        config_btn.setForeground(new java.awt.Color(0, 153, 255));
        config_btn.setText("CONFIGURE");
        config_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                config_btnActionPerformed(evt);
            }
        });
        getContentPane().add(config_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 140, 40));
        config_btn.getAccessibleContext().setAccessibleName("config_btn");

        menu_background.setBackground(new Color(242,5,48,90));
        menu_background.setOpaque(true);
        getContentPane().add(menu_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 60));
        menu_background.getAccessibleContext().setAccessibleName("menu_background");

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/time_log/background.jpg"))); // NOI18N
        background.setText("jLabel1");
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 560));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
        boolean is_empty=isEmpty(project_input),
                is_valid=false,
                is_all_match;
        if(!is_empty){
            is_valid=isValidSql(project_input);
        }
        else{
            showErrorStage("Enter something!");
            return;
        }
        if(list!=null && !is_empty && menu_box.getSelectedItem().toString().compareTo("TYPES")!=0){
            is_all_match=isAllMatch(project_input);
        }
        else{
            showErrorStage("Please select a project type from the drop down menu");
            project_input.setText("PROJECT NAME");
            return;
        }
        
        if(list!=null && is_valid && !is_all_match){
            header_str="Are you sure you want to create: "+project_input.getText();
            to_do_str="create_table";
            drop_project=new ConfirmFrame(this, to_do_str, header_str);
            drop_project.setVisible(true);
        }
        else if(list!=null && is_all_match){
            showErrorStage(project_input.getText()+" already exsists in type "+dml.getTypeFromProject(project_input.getText()));
        }
        else if(!is_valid){
            showErrorStage(project_input.getText()+" is not a valid table name <no spaces>");
        }
    }//GEN-LAST:event_add_btnActionPerformed

    private void drop_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drop_btnActionPerformed
        drop_btn_selected=true;
        boolean is_empty=isEmpty(project_input);
        if(jTable1.isColumnSelected(0)){
            header_str="Are you sure you want to drop: "+jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            to_do_str="drop_click";
            drop_project=new ConfirmFrame(this, to_do_str, header_str);
            drop_project.setVisible(true);
        }
        else if(!is_empty && list!=null && isMatch(list, project_input)){
            header_str="Are you sure you want to drop: "+project_input.getText();
            to_do_str="drop_input";
            drop_project=new ConfirmFrame(this, to_do_str, header_str);
            drop_project.setVisible(true);
        }
        else if(list==null && !is_empty){
            showErrorStage("Please select a project type from the drop down menu");
        }
        else if(list!=null && is_empty){
            showErrorStage("Enter Something!");
        }
        drop_btn_selected=false;
    }//GEN-LAST:event_drop_btnActionPerformed

    private void plus_minus_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plus_minus_btnActionPerformed
        if(display_type_changes){
            showTypeTools();
        }
        else{
            hideTypeTools();
        }
    }//GEN-LAST:event_plus_minus_btnActionPerformed

    private void type_inputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_type_inputFocusGained
        if(type_input.getText().compareTo("TYPE OF PROJECT")==0){
            type_input.setText("");
        }
    }//GEN-LAST:event_type_inputFocusGained

    private void type_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type_addActionPerformed
        boolean is_empty=isEmpty(type_input),
                is_valid=false, is_match=false;
        
        if(is_empty){
            showErrorStage("Enter something!");
        }
        else if(types_list!=null && !is_empty){
            is_valid=isValidSql(type_input);
            is_match=isMatch(types_list, type_input);
        }
        
        if(!is_empty && types_list!=null && is_valid && !is_match){
            header_str="Are you sure you want to insert: "+type_input.getText();
            to_do_str="create_type";
            drop_project=new ConfirmFrame(this, to_do_str, header_str);
            drop_project.setVisible(true);
        }
        else if(!is_empty && types_list!=null && is_match){
            showErrorStage(type_input.getText()+" already exsists");
        }
        else if(!is_empty && !is_valid && types_list!=null){
            showErrorStage(type_input.getText()+" is not a valid table name <no spaces>");
        }
        else if(types_list==null){
            showErrorStage("Please configure a server");
        }
    }//GEN-LAST:event_type_addActionPerformed

    private void type_dropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type_dropActionPerformed
        drop_btn_selected=true;
        boolean is_empty=isEmpty(type_input),
                is_valid=false, is_match=false;
        
        if(is_empty){
            showErrorStage("Enter something!");
        }
        if(types_list!=null && !is_empty){
            is_valid=isValidSql(type_input);
        }
        if(types_list!=null && !is_empty && is_valid){
            is_match=isMatch(types_list, type_input);
        }
        
        if(!is_empty && types_list!=null && is_valid && is_match){
            header_str="Deleting "+type_input.getText()+" will also delete all projects. <br>Are you sure?";
            to_do_str="delete_type";
            drop_project=new ConfirmFrame(this, to_do_str, header_str);
            drop_project.setVisible(true);
        }
        else if(!is_empty && types_list!=null && is_match){
            showErrorStage(type_input.getText()+" already exsists");
        }
        else if(!is_empty && !is_valid && types_list!=null){
            showErrorStage(type_input.getText()+" is not a valid table name <no spaces>");
        }
        else if(types_list==null){
            showErrorStage("Please configure a server");
        }
        drop_btn_selected=false;
    }//GEN-LAST:event_type_dropActionPerformed

    private void config_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_config_btnActionPerformed
        ConfigureFrame configure=new ConfigureFrame(this);
        this.setVisible(false);
        configure.setVisible(true);
    }//GEN-LAST:event_config_btnActionPerformed

    private void menu_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_boxActionPerformed
        if(menu_box.getSelectedItem().toString().compareTo("TYPES")!=0){
            pushProjectNames(menu_box.getSelectedItem().toString());
        }
        else{
            table_model.setNumRows(0);
        }
    }//GEN-LAST:event_menu_boxActionPerformed

    private void project_inputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_project_inputFocusGained
        if(project_input.getText().compareTo("PROJECT NAME")==0){
            project_input.setText("");
        }
    }//GEN-LAST:event_project_inputFocusGained

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        Point point=evt.getPoint();
        int row=jTable1.rowAtPoint(point);
        int column=jTable1.columnAtPoint(point);
        if(column==1){
            String project_name=jTable1.getValueAt(row, 0).toString().toLowerCase();
            project_frame.setProjectName(project_name);
            this.setVisible(false);
            project_frame.setVisible(true);
        }
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(Time_log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Time_log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Time_log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Time_log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Time_log().setVisible(true);
            }
        });
    }
    
    private boolean isEmpty(JTextField input){
        boolean empty=false;
        if(input.getText().compareTo("PROJECT NAME")==0 || input.getText().compareTo("TYPE OF PROJECT")==0){
            empty=true;
        }
        return empty;
    }
    
    private boolean isMatch(List list, JTextField input){
        value_match=false;
        for(int i=0;i<list.size();i++){
            if(input.getText().toLowerCase().compareTo(list.get(i).toString())==0){
                value_match=true;
                break;
            }
        }
        if(!value_match && drop_btn_selected){
            showErrorStage(input.getText()+" does not exist!");
        }
        return value_match;
    }
    
    private boolean isAllMatch(JTextField input){
        value_match=false;
        List all_projects_list=dml.getAllProjects();
        for(int i=0;i<all_projects_list.size();i++){
            if(input.getText().toLowerCase().compareTo(all_projects_list.get(i).toString())==0){
                value_match=true;
                break;
            }
        }
        if(!value_match && drop_btn_selected){
            showErrorStage(input.getText()+" does not exist!");
        }
        return value_match;
    }
    
    private boolean isValidSql(JTextField input){
        boolean valid=true;
        String str=input.getText();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                valid=false;
                break;
            }
        }
        return valid;
    }
    
    private void pushProjectNames(String project_type){
        table_model.setRowCount(0);
        list=dml.getProjectsRecords(project_type);
        if(!list.isEmpty()){
            for(int i=0; i<list.size(); i++){
                table_model.addRow(new Object[]{toCapitalize(list.get(i)), "OPEN"});
            }
        }
    }
    
    public void pushTypes(boolean first_connection){
        types_list=dml.getProjectTypes(first_connection);
        int itmes_num=menu_box.getItemCount();
        for(int i=0;i<itmes_num;i++){
            if(i!=0){
                menu_box.removeItemAt(1);
            }
        }
        if(!types_list.isEmpty()){
            for(int i=0; i<types_list.size(); i++){
                menu_box.addItem(toCapitalize(types_list.get(i)));
            }
        }
    }
    
    private String toCapitalize(Object object){
        String str=object.toString();
        if(str==null){
            return str;
        }
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }
    
    private void setDatabaseSize(){
        database_size=dml.getDatabaseSize()+" MB";
        mb_label.setText(database_size);
    }
    
    public void hideTypeTools(){
        menu_box.setPopupVisible(false);
        type_input.setVisible(false);
        type_add.setVisible(false);
        type_drop.setVisible(false);
        display_type_changes=true;
    }
    
    public void showTypeTools(){
        type_input.setVisible(true);
        type_add.setVisible(true);
        type_drop.setVisible(true);
        menu_box.setPopupVisible(true);
        display_type_changes=false;
    }
    
    
    
    private void showErrorStage(String error_str){
        DisplayErrorFrame error_stage=new DisplayErrorFrame(error_str);
        error_stage.setVisible(true);
    }
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_btn;
    private javax.swing.JLabel background;
    private javax.swing.JButton config_btn;
    private javax.swing.JButton drop_btn;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    public javax.swing.JLabel mb_label;
    private javax.swing.JLabel menu_background;
    public javax.swing.JComboBox<String> menu_box;
    private javax.swing.JButton plus_minus_btn;
    public javax.swing.JTextField project_input;
    private javax.swing.JButton type_add;
    private javax.swing.JButton type_drop;
    public javax.swing.JTextField type_input;
    // End of variables declaration//GEN-END:variables
}