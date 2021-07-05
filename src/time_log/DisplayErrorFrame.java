
package time_log;


public class DisplayErrorFrame extends javax.swing.JFrame {

    String error_str;
    /**
     * Creates new form Error_stage
     * @param error_str
     */
    public DisplayErrorFrame(String error_str) {
        initComponents();
        if(error_str.compareTo("Connection Good")==0){
            background.setBackground(new java.awt.Color(51,255,51));
            ok_btn.setBackground(new java.awt.Color(0,102,0));
        }
        this.error_str="<HTML>"+error_str+"</HTML>";
        error_txt.setText(this.error_str);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ok_btn = new javax.swing.JButton();
        error_txt = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ERROR");
        setAlwaysOnTop(true);
        setLocation(new java.awt.Point(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ok_btn.setBackground(new java.awt.Color(51, 255, 51));
        ok_btn.setFont(new java.awt.Font("Elephant", 1, 16)); // NOI18N
        ok_btn.setText("OK");
        ok_btn.setBorderPainted(false);
        ok_btn.setFocusPainted(false);
        ok_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ok_btnActionPerformed(evt);
            }
        });
        getContentPane().add(ok_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 100, 40));

        error_txt.setBackground(new java.awt.Color(255, 51, 0));
        error_txt.setFont(new java.awt.Font("Elephant", 1, 24)); // NOI18N
        error_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(error_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 590, 130));

        background.setBackground(new java.awt.Color(255, 51, 0));
        background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        background.setOpaque(true);
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 210));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ok_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ok_btnActionPerformed
        this.dispose();
    }//GEN-LAST:event_ok_btnActionPerformed

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
            java.util.logging.Logger.getLogger(DisplayErrorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DisplayErrorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DisplayErrorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DisplayErrorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel error_txt;
    private javax.swing.JButton ok_btn;
    // End of variables declaration//GEN-END:variables
}
