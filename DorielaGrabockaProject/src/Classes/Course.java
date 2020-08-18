/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import DatabaseConnection.DataReader;
import java.util.ArrayList;

/**
 *
 * @author Doriela
 */
public class Course {
    private int ID;
    private String title;
    private String instructor;
    private String day;
    private String time;
    private String location;
    private int credits;
    private String department;
    private String faculty;
    private String eligibility; //who can select this course ("All" or "-" possible values)
    private ArrayList<Student> listOfStudent;
    public Course(int ID, String title, String instructor, String day, String time, String location, int credits, String department, String faculty, String eligibility) {
        this.ID = ID;
        this.title = title;
        this.instructor = instructor;
        this.day = day;
        this.time = time;
        this.location = location;
        this.credits = credits;
        this.department = department;
        this.faculty = faculty;
        this.eligibility = eligibility;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public int getCredits() {
        return credits;
    }

    public String getDepartment() {
        return department;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getEligibility() {
        return eligibility;
    }
    
    /**Static method to return a course when supplied with a course ID
     *@param id- is the course ID that we want to find
     * @return - the Course after found or null if not found
     */
    
    public static Course getCourse(int id){
        DataReader dr=new DataReader();
        Course course=dr.getCourse(id);//setting the global variables
        dr.close();//closing the connection
        return course;
    }
    
    /**method to get all courses from the database
     *@return the list of all courses
     */
    public static ArrayList getAllCourses(){
        DataReader dr= new DataReader();
        ArrayList<Course> courses= dr.getCourses();
        dr.close();
        return courses;
    }
    
    /**Method to get all students in a course
     * @return the array list of students in this course
     */
    public ArrayList getStudentsOfCourse(){
        listOfStudent=new ArrayList<>();
        DataReader dr=new DataReader();
        listOfStudent=dr.getStudentsOfCourse(this.getID());
        dr.close();
        return listOfStudent; 
    }
    
    
    /**Method to check if a course list contains an element or not
     *@param list- the lists where to search
     *@param c- the course to be searched
     */
    public static boolean contains(ArrayList<Course> list, Course c){
        for (Course course : list) {
            if(course.getID()==c.getID())
                return true;
        }
        return false;
    }
      
    
}
