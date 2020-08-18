/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;

import Classes.Comment;
import Classes.Friendship;
import Classes.Student;
import Classes.StudentCourse;
import DatabaseConnection.DBConnection;

/**
 *
 * @author Doriela
 */
public class DataWriter {
    DBConnection connection;

    public DataWriter() {
        this.connection = new DBConnection();
    }
    
    /**Method to add a friend to the current user
     *@param f- is the friendship to be added to the database
     * @return boolean to specify whether the operation succeded or not
     */
    public boolean addFriendship(Friendship f){
        return connection.addFriend(f.getStudentID(), f.getFriendID());
    
    }
    
    /**Method to add a course to the current user
     *@param stC- is a StudentCourse object to be added to the database 
     * @return boolean to specify whether the operation succeded or not
     */
    public boolean addStudentCourse(StudentCourse stC){
        return connection.addCourse(stC.getStudentID(), stC.getCourseID());
    }
    
    /**Method to drop a course to the current user
     *@param stC- is a StudentCourse object to be dropped from the database 
     * @return boolean to specify whether the operation succeded or not
     */
    public boolean dropCourse(StudentCourse stC){
        return connection.dropCourse(stC.getStudentID(), stC.getCourseID());
    
    }
    
    /**Method to update the profile of the current user
     *@param st- is a Student object whose profile will be updated 
     *@return boolean to specify whether the operation succeded or not
     */
    public boolean updateProfile(Student st){
        if(connection.updateProfile(st.getID(), st.getName(), st.getSurname(), st.getAge())){
            return true;
        }
        return false;
     
    }
    
    /**Method to add a comment of a current user to a course
     *@param c- is a Comment object to be added to the database 
     *@return boolean to specify whether the operation succeded or not
     */
    public boolean addComment(Comment c){
        if(connection.addComment(c.getStudentID(), c.getCourseID(), c.getText())){
            return true;
        }
        return false;
    
    }
    
    
    /**Method to close the connection with the database
     */
    public void close(){
       connection.close();
    }
}
