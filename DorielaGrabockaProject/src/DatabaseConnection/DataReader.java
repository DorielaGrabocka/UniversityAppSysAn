/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;

import Classes.Comment;
import Classes.Course;
import Classes.Friendship;
import Classes.Student;
import Classes.StudentCourse;
import DatabaseConnection.DBConnection;
import java.util.ArrayList;

/**
 *
 * @author Doriela Grabocka
 */
public class DataReader {
    private DBConnection connection;
    //public static Student currentUser;
    public DataReader() {
        connection = new DBConnection();
    }
    
    /**Method used to return a student given an ID 
    * @param id - is the ID that the user has inputted
    * @return Student- will return the student found or null if not found
    */
    public Student getStudent(int id){
        Student st=connection.getStudent(id);
        return st;
        
    }
    
    
    /** Method to return all courses from the database
     * @return - return the array list of all courses read from the database
     *
     */
    public ArrayList getCourses(){
        ArrayList<Course> coursesList=new ArrayList<>();
        connection.getCourses(coursesList);
        return coursesList;
    
    }
    
    /** Method to return the course specified by the id
     * @param id- the id of the course to get
     * @return - returns the course 
     *
     */
    public Course getCourse(int id){
        Course course=connection.getCourse(id);
        return course;
    
    }
    
    
    /** Method to return all friendships from the database
     * @return - return the array list of all courses read from the database
     *
     */
    public ArrayList getFriendships(){
        ArrayList<Friendship> friendshipList=new ArrayList<>();
        connection.getFriendships(friendshipList);
        return friendshipList;
    
    }
    
    /** Method to return all friends of current user from the database
     * @param id- the id of the current user
     * @return - return the array list of all courses read from the database
     *
     */
    public ArrayList getFriendsOfStudent(int id){
        ArrayList<Student> friendsList=new ArrayList<>();
        connection.getFriendsOfStudent(id,friendsList);
        return friendsList;
    
    }
    
    /** Method to return all students from the database or the students specified by name
     * if name is null then all students will be returned, else only the students with 
     * the specified name will be returned
     * @param studentName- is the name of the students that we want to query
     * @return - return the array list of all students read from the database
     *
     */
    public ArrayList getStudents(String studentName){
        ArrayList<Student> studentsList=new ArrayList<>();
        if(studentName==null){
            connection.getStudents(studentsList, null);//as an object studentsList is passed by reference
        }
        else{
            connection.getStudents(studentsList, studentName);//pass even the student name
        }
        
        return studentsList;
    
    }
    
    
    /** Method to return all comments from the database
     * @return - return the array list of all courses read from the database
     *
     */
    public ArrayList getComments(){
        ArrayList<Comment> commentList=new ArrayList<>();
        connection.getComments(commentList);
        return commentList;
    
    }
    
    /** Method to return all comments from the database
     * @param id- id of the course
     * @return - return the array list of all comments read from the database
     *
     */
    public ArrayList getCommentsAboutCourse(int id){
        ArrayList<Comment> commentList=new ArrayList<>();
        connection.getCommentsAboutCourse(id,commentList);
        System.out.println(commentList.size());
        return commentList;
    
    }
    
    /** Method to return all studentsCourse objects from the database
     * @return - return the array list of all students of a course read from the database
     *
     */
    public ArrayList getStudentCourses(){
        ArrayList<StudentCourse> studentCourseList=new ArrayList<>();
        connection.getStudentCourses(studentCourseList);
        System.out.println(studentCourseList.size());
        return studentCourseList;
    }
    
    /** Method to return all courses of a student from the database
     * @param id- the id of the student
     * @return - return the array list of all courses of student read from the database
     *
     */
    public ArrayList getCoursesOfStudent(int id){
       ArrayList<Course> courseList=new ArrayList<>();
        connection.getCoursesOfStudent(id,courseList);
        return courseList;
    }
    
    
    
    /** Method to return all students of a course from the database
     * @param id- id of the course
     * @return - return the array list of all students of a course read from the database
     */
    public ArrayList getStudentsOfCourse(int id){
        ArrayList<Student> studentCourseList=new ArrayList<>();
        connection.getStudentsOfCourse(id,studentCourseList);
        return studentCourseList;
    }
    
    /**Method to close the connection with the database
     */
    public void close(){
       connection.close();
    }
    
}
