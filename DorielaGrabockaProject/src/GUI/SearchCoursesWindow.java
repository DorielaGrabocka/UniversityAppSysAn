/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Classes.Course;
import Classes.Student;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import sun.net.www.protocol.http.HttpURLConnection;

/**
 *
 * @author Doriela
 */
public class SearchCoursesWindow extends javax.swing.JFrame {
    Student user=Student.getCurrentUser();
    /** Creates new form SearchCoursesWindow */
    public SearchCoursesWindow() {
        initComponents();
        lblErrorAdd.setVisible(false);
        lblErrorDrop.setVisible(false);
        populateCoursesTable(user.getPossibleCoursesList(), tblAllCourses);//fill courses table
        populateCoursesTable(user.getCourseList(user.getID()), tblUserCourses1);//fill user courses table
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAllCourses = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblUserCourses1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtCourseIDDrop = new javax.swing.JTextField();
        btnDropCourse = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtCourseIDAdd = new javax.swing.JTextField();
        btnAddCourse = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblErrorAdd = new javax.swing.JLabel();
        lblErrorDrop = new javax.swing.JLabel();

        setTitle("Search Courses");

        jDesktopPane1.setBackground(new java.awt.Color(204, 204, 204));

        tblAllCourses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course ID", "Title", "Instructor", "Day", "Time", "Location", "Credits", "Department", "Faculty", "Eligibility"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAllCourses.setRowHeight(26);
        tblAllCourses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAllCoursesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblAllCourses);
        if (tblAllCourses.getColumnModel().getColumnCount() > 0) {
            tblAllCourses.getColumnModel().getColumn(0).setMaxWidth(80);
            tblAllCourses.getColumnModel().getColumn(5).setMaxWidth(80);
            tblAllCourses.getColumnModel().getColumn(6).setMaxWidth(80);
            tblAllCourses.getColumnModel().getColumn(9).setMaxWidth(60);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Course List");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("My Course List");

        tblUserCourses1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course ID", "Title", "Instructor", "Day", "Time", "Location", "Credits", "Department", "Faculty", "Eligibility"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUserCourses1.setRowHeight(26);
        tblUserCourses1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserCourses1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblUserCourses1);
        if (tblUserCourses1.getColumnModel().getColumnCount() > 0) {
            tblUserCourses1.getColumnModel().getColumn(0).setMaxWidth(80);
            tblUserCourses1.getColumnModel().getColumn(5).setMaxWidth(80);
            tblUserCourses1.getColumnModel().getColumn(6).setMaxWidth(80);
            tblUserCourses1.getColumnModel().getColumn(9).setMaxWidth(60);
        }

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Enter Course ID:");

        txtCourseIDDrop.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        btnDropCourse.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDropCourse.setText("Drop Course");
        btnDropCourse.setToolTipText("Go to Course");
        btnDropCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDropCourseActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Enter Course ID:");

        txtCourseIDAdd.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        btnAddCourse.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddCourse.setText("Add Course");
        btnAddCourse.setToolTipText("Go to Course");
        btnAddCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCourseActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("(only courses in your major and minor)");

        lblErrorAdd.setForeground(new java.awt.Color(255, 255, 255));
        lblErrorAdd.setText("Wrong Input! Must be numeric!");

        lblErrorDrop.setForeground(new java.awt.Color(255, 255, 255));
        lblErrorDrop.setText("Wrong Input! Must be numeric!");

        jDesktopPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtCourseIDDrop, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnDropCourse, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtCourseIDAdd, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnAddCourse, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lblErrorAdd, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lblErrorDrop, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1042, Short.MAX_VALUE)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCourseIDDrop, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btnDropCourse)
                        .addGap(36, 36, 36)
                        .addComponent(lblErrorDrop, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCourseIDAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btnAddCourse)
                        .addGap(59, 59, 59)
                        .addComponent(lblErrorAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCourseIDAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrorAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCourseIDDrop, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDropCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrorDrop, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jDesktopPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1115, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCourseActionPerformed
        // TODO add your handling code here:
        String courseIDStr=txtCourseIDAdd.getText();
        try{
            int courseId=Integer.parseInt(courseIDStr);
            Course course= Course.getCourse(courseId);//here we find the course
            if(course!=null){
                if(user.addCourse(course)){
                    lblErrorAdd.setText("Course added successfully! Check table below or refresh table in main window!");
                    populateCoursesTable(user.getCourseList(user.getID()), tblUserCourses1);//update user courses table
                }
                else{
                    lblErrorAdd.setText("You have this course already or you are not eligible to take it!");
                    
                }
            
            }
            else{
                //course does not exist
                lblErrorAdd.setText("This course does not exist! Enter again!");
                
            
            }
        
        }
        catch(NumberFormatException e){
            //course id must be number
            lblErrorAdd.setText("Wrong course ID! Must be numeric!");
            
        }
        txtCourseIDAdd.setText("");
        lblErrorAdd.setForeground(Color.WHITE);
        lblErrorAdd.setVisible(true);
        
    }//GEN-LAST:event_btnAddCourseActionPerformed

    private void btnDropCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDropCourseActionPerformed
        // TODO add your handling code here:
        String courseIDStr=txtCourseIDDrop.getText();
        try{
            int courseId=Integer.parseInt(courseIDStr);
            Course course= Course.getCourse(courseId);//here we find the course
            if(course!=null){
                if(user.dropCourse(course)){
                    //course in course list
                    lblErrorDrop.setText("Course dropped from your course list! See \"My Course List\" table.");
                    populateCoursesTable(user.getCourseList(user.getID()), tblUserCourses1);//update user courses table
                    
                }
                else{
                    //course not in course list
                    lblErrorDrop.setText("You do not have this course on your course list!");
                    
                }
            
            }
            else{
                //course does not exist
                lblErrorDrop.setText("This course does not exist! Enter again!");
                
            
            }
        
        }
        catch(NumberFormatException e){
            //course id must be number
            lblErrorDrop.setText("Wrong course ID! Must be numeric!");
            
        }
        txtCourseIDDrop.setText("");
        lblErrorDrop.setForeground(Color.WHITE);
        lblErrorDrop.setVisible(true);
    }//GEN-LAST:event_btnDropCourseActionPerformed

    private void tblAllCoursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAllCoursesMouseClicked
        // TODO add your handling code here:
        int index=tblAllCourses.getSelectedRow();
        TableModel model=tblAllCourses.getModel();
        int courseID=Integer.parseInt(model.getValueAt(index, 0).toString());//get the ID of the selected row
        txtCourseIDAdd.setText(new Integer (courseID).toString());
                                           
    }//GEN-LAST:event_tblAllCoursesMouseClicked

    private void tblUserCourses1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserCourses1MouseClicked
        // TODO add your handling code here:
        int index=tblUserCourses1.getSelectedRow();
        TableModel model=tblUserCourses1.getModel();
        int courseID=Integer.parseInt(model.getValueAt(index, 0).toString());//get the ID of the selected row
        txtCourseIDDrop.setText(new Integer (courseID).toString());
    }//GEN-LAST:event_tblUserCourses1MouseClicked

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
            java.util.logging.Logger.getLogger(SearchCoursesWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchCoursesWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchCoursesWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchCoursesWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchCoursesWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCourse;
    private javax.swing.JButton btnDropCourse;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblErrorAdd;
    private javax.swing.JLabel lblErrorDrop;
    private javax.swing.JTable tblAllCourses;
    private javax.swing.JTable tblUserCourses1;
    private javax.swing.JTextField txtCourseIDAdd;
    private javax.swing.JTextField txtCourseIDDrop;
    // End of variables declaration//GEN-END:variables

    private void populateCoursesTable(ArrayList<Course> list, JTable table) {
        DefaultTableModel modelofThistable=(DefaultTableModel) table.getModel();
        modelofThistable.setRowCount(0);//clear all table contents
        Object[] rowInfo= new Object[10];
        
        //adding all the course of the current user tothe table
        for(Course thisCourse: list){
            
            rowInfo[0]=thisCourse.getID();
            rowInfo[1]=thisCourse.getTitle();
            rowInfo[2]=thisCourse.getInstructor();
            rowInfo[3]=thisCourse.getDay();
            rowInfo[4]=thisCourse.getTime();
            rowInfo[5]=thisCourse.getLocation();
            rowInfo[6]=thisCourse.getCredits();
            rowInfo[7]=thisCourse.getDepartment();
            rowInfo[8]=thisCourse.getFaculty();
            rowInfo[9]=thisCourse.getEligibility();
            modelofThistable.addRow(rowInfo);
            
        }
        
        tblAllCourses.setFillsViewportHeight(true);
    }



}
