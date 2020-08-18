/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import DatabaseConnection.DataReader;
import DatabaseConnection.DataWriter;
import java.util.ArrayList;

/**
 *
 * @author Doriela
 */
public class Comment {
    private int studentID;
    private String studentName;
    private String studentSurname;
    private int courseID;
    private String text;//what the comment will contain

    public Comment(int studentID, int courseID, String stName, String stSurname, String text) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.studentName=stName;
        this.studentSurname=stSurname;
        this.text = text;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public boolean addComment(){
        DataWriter dw = new DataWriter();
        boolean added=dw.addComment(this);
        dw.close();
        return added;
    }
    
    
    /**Method to get all comments about a course
     *@param courseID - is the ID of the course whose comments we are getting
     *@return arraylist -the list of all comments about the course
     */
    public static ArrayList getCommentsAboutCourse(int courseID){
        ArrayList<Comment> commentsList= new ArrayList<>();
        DataReader dr= new DataReader();
        commentsList= dr.getCommentsAboutCourse(courseID);
        dr.close();
        return commentsList;
    }
    
    
}
