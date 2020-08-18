/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Doriela
 */
public class HelpWindow extends javax.swing.JFrame {

    /**
     * Creates new form HelpWindow
     */
    public HelpWindow() {
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

        jDesktopPane2 = new javax.swing.JDesktopPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaHelp = new javax.swing.JTextArea();

        setTitle("Help & Support");

        jDesktopPane2.setBackground(new java.awt.Color(255, 255, 255));

        txtAreaHelp.setColumns(20);
        txtAreaHelp.setRows(5);
        txtAreaHelp.setText("Help Menu\nUniversity App  -  May 2020 -Designed to make students' life easier and performance better...\n\nDear User,\n       This system is intended for academic use.Its main goal is to help students be\n  more organized.\n        Functionalities:\n    1.Search Available Courses - this button will redirect you to a new window tha will\n       contain the table of courses that you can take based your major and minor, \n       and the table of your actual courses. By clicking in the desired row of a table \n       or by manually entering the course ID into the textfield you can add or drop the\n       course that you want.\n\n   2.Check Course Details - this button will redirect you to the window of all courses.\n       There are two tables.The first one lists all courses offered in the current semester,\n       while the second one lists all the participants of the course. You can either  click  the \n       course in the table or enter its ID manually to see the details.\n         \n  3.See All Students - this window will give you the possibility to see all students of the\n     university. You can click on the table to select a student and then press the Add Friend\n     button to that student to your friends list. You can search for students by entering their\n     name and then pressing the Search button. If you want to see all students simply press\n     Display All button.\n\n  4.See My Friends - this button will redirect you to a window that will show all your friends.\n     By clicking a friend in the Friends Table you are going to check the friends' course list.\n\n  5.Update Profile- this window will allow you to change your name, your surname and age.\n     After th emodifications press Update button.\n\n  6.Log out- this will sign you out and close the application.\n\n  7.Go to Course - this button will redirect you to the course age where you can check the\n     the course details, read the comments of  students and add comments if you want. You \n     go to courses that are in your course list only. You can select the course from the table \n     and then click the button.\n\n If there are any issues, please e-mail at dorielag18@gmail.com or dorielagrabocka@unyt.edu.al.\n    \n We hope you enjoy your experience here!\n BEST WISHES!");
        jScrollPane2.setViewportView(txtAreaHelp);

        jDesktopPane2.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 807, Short.MAX_VALUE)
            .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 574, Short.MAX_VALUE)
            .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main() {
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
            java.util.logging.Logger.getLogger(HelpWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HelpWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HelpWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HelpWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HelpWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtAreaHelp;
    // End of variables declaration//GEN-END:variables
}