package time_log;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Chromaticity;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class ViewProjectFrame extends javax.swing.JFrame {

    HandleTime handle_time=new HandleTime();
    String project_name;
    Timer timer;
    double timer_counter=1;
    int row, column;
    boolean saved=true;
    DefaultTableModel table_model;
    Map <Integer, Map<String,String>> records_map; 
    Time_log time_log_stage;
    final Color opaq_black=new Color(0,0,0,175), font_blue=new Color(0,153,255);
    
    /**
     * Creates new form NewJFrame
     * @param stage
     */
    public ViewProjectFrame(Time_log stage) {
        this.timer=initTimer();
        this.time_log_stage=stage;
        initComponents();
        table_model=(DefaultTableModel) jTable1.getModel();
    }
    
    public void setProjectName(String project_name){
        this.project_name=project_name;
        time_log_stage.dml.setTable(this.project_name);
        total_label.setText(time_log_stage.dml.getTotalTime(project_name));
        records_map=new HashMap();
        records_map=time_log_stage.dml.readProjectRecords();
        pushProjectNames();
        String lower_case_project_name=toCapitalize(this.project_name);
        project_label.setText(lower_case_project_name);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        total_header = new javax.swing.JLabel();
        total_label = new javax.swing.JLabel();
        duration_label = new javax.swing.JLabel();
        end_time_label = new javax.swing.JLabel();
        start_time_label = new javax.swing.JLabel();
        duration_header = new javax.swing.JLabel();
        start_btn = new javax.swing.JButton();
        stop_btn = new javax.swing.JButton();
        close_btn = new javax.swing.JButton();
        project_label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        print_btn = new javax.swing.JButton();
        delete_row_btn = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Project Time Tracker");
        setBackground(new java.awt.Color(102, 153, 255));
        setIconImages(null);
        setSize(new java.awt.Dimension(800, 750));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 800));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        total_header.setBackground(new java.awt.Color(0, 0, 0));
        total_header.setFont(new java.awt.Font("Elephant", 1, 18)); // NOI18N
        total_header.setForeground(new java.awt.Color(0, 153, 255));
        total_header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        total_header.setText("Total Time");
        total_header.setOpaque(true);
        jPanel1.add(total_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 130, 40));

        total_label.setBackground(new java.awt.Color(0, 0, 0));
        total_label.setFont(new java.awt.Font("Elephant", 1, 18)); // NOI18N
        total_label.setForeground(new java.awt.Color(0, 153, 255));
        total_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        total_label.setText("0:0");
        total_label.setOpaque(true);
        total_label.setPreferredSize(new java.awt.Dimension(90, 40));
        jPanel1.add(total_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 90, -1));

        duration_label.setFont(new java.awt.Font("Elephant", 1, 18)); // NOI18N
        duration_label.setForeground(new java.awt.Color(0, 153, 255));
        duration_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        duration_label.setText("0:0");
        duration_label.setPreferredSize(new java.awt.Dimension(90, 40));
        jPanel1.add(duration_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 100, -1));

        end_time_label.setBackground(new java.awt.Color(0, 0, 0));
        end_time_label.setFont(new java.awt.Font("Elephant", 1, 24)); // NOI18N
        end_time_label.setForeground(new java.awt.Color(0, 153, 255));
        end_time_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        end_time_label.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        end_time_label.setOpaque(true);
        end_time_label.setVisible(false);
        jPanel1.add(end_time_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 110, 40));

        start_time_label.setBackground(new java.awt.Color(0, 0, 0));
        start_time_label.setFont(new java.awt.Font("Elephant", 1, 24)); // NOI18N
        start_time_label.setForeground(new java.awt.Color(0, 153, 255));
        start_time_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        start_time_label.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        start_time_label.setOpaque(true);
        start_time_label.setVisible(false);
        jPanel1.add(start_time_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 110, 40));

        duration_header.setFont(new java.awt.Font("Elephant", 1, 18)); // NOI18N
        duration_header.setForeground(new java.awt.Color(0, 153, 255));
        duration_header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        duration_header.setText("Duration");
        duration_header.setPreferredSize(new java.awt.Dimension(70, 40));
        jPanel1.add(duration_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 90, -1));

        start_btn.setBackground(new java.awt.Color(0, 0, 0));
        start_btn.setFont(new java.awt.Font("Elephant", 1, 14)); // NOI18N
        start_btn.setForeground(new java.awt.Color(242, 5, 48));
        start_btn.setText("START");
        start_btn.setBorderPainted(false);
        start_btn.setFocusable(false);
        start_btn.setMaximumSize(new java.awt.Dimension(110, 25));
        start_btn.setPreferredSize(new java.awt.Dimension(110, 40));
        start_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                start_btnActionPerformed(evt);
            }
        });
        jPanel1.add(start_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 90, -1));

        stop_btn.setBackground(new java.awt.Color(0, 0, 0));
        stop_btn.setFont(new java.awt.Font("Elephant", 1, 14)); // NOI18N
        stop_btn.setForeground(new java.awt.Color(242, 5, 48));
        stop_btn.setText("STOP");
        stop_btn.setActionCommand("stopTime");
        stop_btn.setBorderPainted(false);
        stop_btn.setFocusable(false);
        stop_btn.setPreferredSize(new java.awt.Dimension(110, 40));
        stop_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stop_btnActionPerformed(evt);
            }
        });
        jPanel1.add(stop_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 90, -1));

        close_btn.setBackground(new java.awt.Color(0, 0, 0));
        close_btn.setFont(new java.awt.Font("Elephant", 1, 14)); // NOI18N
        close_btn.setForeground(new java.awt.Color(242, 5, 48));
        close_btn.setText("CLOSE");
        close_btn.setBorderPainted(false);
        close_btn.setFocusable(false);
        close_btn.setPreferredSize(new java.awt.Dimension(110, 40));
        close_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_btnActionPerformed(evt);
            }
        });
        jPanel1.add(close_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 90, -1));

        project_label.setBackground(new Color(0,0,0,175));
        project_label.setFont(new java.awt.Font("Elephant", 1, 24)); // NOI18N
        project_label.setForeground(new java.awt.Color(0, 153, 255));
        project_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        project_label.setOpaque(true);
        jPanel1.add(project_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 400, 40));

        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBackground(new java.awt.Color(0, 0, 0));
        jTable1.setFont(new java.awt.Font("Elephant", 0, 16)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 153, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ROW #", "DATE", "START TIME", "END TIME", "DURATION", "TOTAL TIME"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setFocusable(false);
        jTable1.setOpaque(false);
        jTable1.setRowHeight(30);
        jTable1.setSelectionBackground(new java.awt.Color(247, 0, 38));
        jTable1.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setShowGrid(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        ((DefaultTableCellRenderer) jTable1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        int columns=jTable1.getColumnCount();
        jTable1.setBackground(opaq_black);
        jTable1.setForeground(font_blue);
        setTableStyles();
        jTable1.getColumnModel().getColumn(0).setMaxWidth(85);
        jTable1.setOpaque(false);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 157, 760, 450));
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        ((DefaultTableCellRenderer)jTable1.getDefaultRenderer(Object.class)).setOpaque(false);

        print_btn.setBackground(new java.awt.Color(0, 0, 0));
        print_btn.setFont(new java.awt.Font("Elephant", 1, 14)); // NOI18N
        print_btn.setForeground(new java.awt.Color(242, 5, 48));
        print_btn.setText("PRINT");
        print_btn.setBorderPainted(false);
        print_btn.setFocusable(false);
        print_btn.setPreferredSize(new java.awt.Dimension(110, 40));
        print_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_btnActionPerformed(evt);
            }
        });
        jPanel1.add(print_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 620, 160, -1));

        delete_row_btn.setBackground(new java.awt.Color(0, 0, 0));
        delete_row_btn.setFont(new java.awt.Font("Elephant", 1, 14)); // NOI18N
        delete_row_btn.setForeground(new java.awt.Color(242, 5, 48));
        delete_row_btn.setText("DELETE ROW");
        delete_row_btn.setActionCommand("deleteRow");
        delete_row_btn.setBorderPainted(false);
        delete_row_btn.setFocusable(false);
        delete_row_btn.setPreferredSize(new java.awt.Dimension(110, 40));
        delete_row_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_row_btnActionPerformed(evt);
            }
        });
        jPanel1.add(delete_row_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 620, 160, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/time_log/background.jpg"))); // NOI18N
        jPanel1.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 680));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 680));

        setSize(new java.awt.Dimension(814, 716));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void close_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_btnActionPerformed
        if(!saved){
            String error_str="Are you sure you want to close without stopping?";
            ErrorSaveFrame error_stage=new ErrorSaveFrame(error_str, this, time_log_stage);
            error_stage.setVisible(true);
        }
        else{
            setToDefault();
            int row=0;
            for(int i=0;i<time_log_stage.jTable1.getRowCount();i++){
                if(time_log_stage.table_model.getValueAt(i, 0).toString().toLowerCase().compareTo(project_name)==0){
                    row=i;
                    break;
                }
            }
            time_log_stage.table_model.setValueAt(time_log_stage.dml.getTotalTime(project_name), row, 1);
            this.setVisible(false);
            time_log_stage.setVisible(true);
        }
    }//GEN-LAST:event_close_btnActionPerformed

    private void stop_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stop_btnActionPerformed
        buttonClickedColor("stop");
        if(timer.isRunning()){
            handle_time.timeEnd();
            handle_time.timeDuration();
            timer.stop();
            try {
                handle_time.totalTime(time_log_stage.dml);
                table_model.addRow(new Object[]{table_model.getRowCount()+1,handle_time.getDate(), handle_time.getTimeStart(),
                                                handle_time.getTimeEnd(), handle_time.getDuration(),
                                                handle_time.getTotalTime()});
                int added_row=table_model.getRowCount()-1;
                time_log_stage.dml.insertProjectRecords(added_row);
                timer_counter=1;
                total_label.setText(time_log_stage.dml.getTotalTime());
                duration_label.setText("0:0");
                end_time_label.setVisible(true);
                end_time_label.setText(time_log_stage.dml.getTimeEnd());
                saved=true;
            } catch (SQLException ex) {
                showErrorStage(ex.toString());
            }
            
        }
    }//GEN-LAST:event_stop_btnActionPerformed

    private void start_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_start_btnActionPerformed
        if(saved){
            timer.start();
            handle_time.timeStart();
            handle_time.startDate();
            start_time_label.setVisible(true);
            start_time_label.setText(time_log_stage.dml.getTimeStart());
            end_time_label.setVisible(false);
            buttonClickedColor("start");
            saved=false;
        }
    }//GEN-LAST:event_start_btnActionPerformed

    private void delete_row_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_row_btnActionPerformed
        if(table_model.getRowCount()>0){
            String header_str="Are you sure you want to delete the selected project record?";
            String to_do_str="delete_project_data";
            ConfirmFrame delete_project_data=new ConfirmFrame(this, to_do_str, header_str);
            delete_project_data.setVisible(true);
        }
    }//GEN-LAST:event_delete_row_btnActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        Point point=evt.getPoint();
        this.row=jTable1.rowAtPoint(point);
    }//GEN-LAST:event_jTable1MouseClicked

    private void print_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_btnActionPerformed
        try {
            jTable1.setBackground(Color.white);
            jTable1.setForeground(Color.black);
            setTableStyles();
            
            MessageFormat header=new MessageFormat("Cory Gibbs:  "+project_name);
            MessageFormat footer=new MessageFormat("Page Number: {0}");
            PrintRequestAttributeSet a_set=new HashPrintRequestAttributeSet();
            a_set.add(Chromaticity.MONOCHROME);
            jTable1.print(JTable.PrintMode.FIT_WIDTH, header, footer, true, a_set, true);
            
            jTable1.setBackground(opaq_black);
            jTable1.setForeground(font_blue);
            setTableStyles();
        } catch (PrinterException ex) {
            jTable1.setBackground(opaq_black);
            jTable1.setForeground(font_blue);
            setTableStyles();
            showErrorStage(ex.toString());
        }
    }//GEN-LAST:event_print_btnActionPerformed
    
        
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
            java.util.logging.Logger.getLogger(ViewProjectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewProjectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewProjectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewProjectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    
     

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run() {
            }
        });
    }
    
    private Timer initTimer(){
        timer=new Timer(60000, (ActionEvent e) -> {
            String count_str;
            double count_convert=timer_counter/60;
            double fractional_part=count_convert%1;
            int hours=(int)(count_convert-fractional_part);
            int mins=(int)Math.round((count_convert-hours)*60);
            if(mins<10){
                count_str=hours+":0"+mins;
            }
            else{
                count_str=hours+":"+mins;
            }
            
            duration_label.setText(count_str);
            timer_counter++;
        });
        return timer;
    }
    
    public void pushProjectNames(){
        table_model.setNumRows(0);
        for(int i=0; i<records_map.size(); i++){
            int row_int=Integer.parseInt(records_map.get(i).get("row_num"))+1;
            table_model.addRow(new Object[]{String.valueOf(row_int),
                                            records_map.get(i).get("date"),
                                            records_map.get(i).get("start_time"),
                                            records_map.get(i).get("end_time"),
                                            records_map.get(i).get("duration"),
                                            records_map.get(i).get("total_time")});
        }
    }
    
    public void buttonClickedColor(String button){
        start_btn.setBackground(new Color(0, 0, 0));
        stop_btn.setBackground(new Color(0, 0, 0));
        switch(button){
            case "start":
                start_btn.setBackground(new Color(51, 255, 51));
                break;
            case "stop":
                stop_btn.setBackground(new Color(51, 255, 51));
                break;
            default:
                start_btn.setBackground(new Color(0, 0, 0));
                stop_btn.setBackground(new Color(0, 0, 0));
        }
    }
    
    private String toCapitalize(Object object){
        String str=object.toString();
        if(str==null){
            return str;
        }
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }
    
    private void showErrorStage(String error_str){
        DisplayErrorFrame error_stage=new DisplayErrorFrame(error_str);
        error_stage.setVisible(true);
    }
    
    public void setToDefault(){
        timer.stop();
        buttonClickedColor("close");
        timer_counter=1;
        duration_label.setText("0:0");
        start_time_label.setVisible(false);
        end_time_label.setVisible(false);
        saved=true;
    }
    
    public void setTableStyles(){
        for(int i=0; i<jTable1.getColumnCount(); i++){
                DefaultTableCellRenderer render=new DefaultTableCellRenderer();
                render.setHorizontalAlignment(SwingConstants.CENTER);
                jTable1.getColumnModel().getColumn(i).setCellRenderer(render);
//                render.setBackground(background);
//                render.setForeground(foreground);
                jTable1.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(render);
                jTable1.getTableHeader().setPreferredSize(new Dimension(jScrollPane1.getWidth(), 40));
            }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton close_btn;
    private javax.swing.JButton delete_row_btn;
    private javax.swing.JLabel duration_header;
    private javax.swing.JLabel duration_label;
    private javax.swing.JLabel end_time_label;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton print_btn;
    private javax.swing.JLabel project_label;
    private javax.swing.JButton start_btn;
    private javax.swing.JLabel start_time_label;
    private javax.swing.JButton stop_btn;
    private javax.swing.JLabel total_header;
    private javax.swing.JLabel total_label;
    // End of variables declaration//GEN-END:variables
}
