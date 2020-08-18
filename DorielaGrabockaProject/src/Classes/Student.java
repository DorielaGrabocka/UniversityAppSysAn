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
public class Student {
    private int ID;//this ID is used to enter and identify in the system
    private String name;
    private String surname;
    private int age;
    private String major;
    private String minor;
    private String password;//this will not be accessible
    private ArrayList<Course> courseList;
    private ArrayList<Student> friendList;
    private static Student currentUser;//this will gold the currnet user of the system
    public Student(int ID, String name, String surname, int age, String major, String minor, String password) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.major = major;
        this.minor = minor;
        this.password = password;//this will be initialized here and nowhere else will be accessed or changed
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>17){//since students will be greater >17
            this.age = age;
        }
    }

    public int getID() {
        return ID;
    }

    public String getMajor() {
        return major;
    }

    public String getMinor() {
        return minor;
    }

    public String getPassword() {
        return password;
    }

    /**Method to populate the courseList of the student
     *@param id-specifies the student id 
     *@return-the arrayList containing all courses of the student
     */
    public ArrayList getCourseList(int id){
        courseList= new ArrayList<>();
        DataReader dr= new DataReader();
        courseList=dr.getCoursesOfStudent(id);
        dr.close();
        return courseList;
    }
    

    /**Method to get the courses of a student that are part of his major
     *minor or are eligible to be taken by all
     *@return an arraylist of possible courses
     */
    public ArrayList getPossibleCoursesList(){
        ArrayList<Course> coursesList= new ArrayList<Course>();
        ArrayList<Course> possibleCoursesList= new ArrayList<>();
        DataReader dr= new DataReader();
        coursesList=dr.getCourses();
        dr.close();
        for (Course course : coursesList) {
            if(isEligibleToTake(course)){
                possibleCoursesList.add(course);//remove all courses that the student cannot take
            }
        }
        return possibleCoursesList;
    }
    
    /**Method to populate the friendList of the student/user 
     *@return-the arrayList containing all friends of the student
     */
    public ArrayList getFriendsList(){
        friendList= new ArrayList<>();
        DataReader dr= new DataReader();
        friendList=dr.getFriendsOfStudent(this.getID());
        dr.close();
        return friendList;
    }
    
    /**Method to check if a student is a friend of the current student
     *@param friendId-specifies the friend's student id 
     *@return-a boolean to mark the friendship
     */
    public boolean isFriendWith(int friendId){
        if(friendList==null){
            getFriendsList();//fill the friendsList if it is not filled yet
        }
        for (Student friend : friendList) {
            if(friend.getID()==friendId){
                return true;
            }
        }
        return false;//if we reachhere no frfiends were found
    
    }
    /**Method to return the current user
     *@return a student object containing the current user 
     */
    public static Student getCurrentUser(){
        return currentUser;
    
    }
    
    
    /**Method to update the age,name and surname of the current user
     * @param newAge- is the new age set up by the user
     * @param newName- is the new name of the user
     * @param newSurname - is the new surname supplied by the user
     * @return boolean to check whether the operation succeded or not
     */
    public boolean updateProfile(int newAge, String newName, String newSurname){
        this.setAge(newAge);
        this.setName(newName);
        this.setSurname(newSurname);
        DataWriter dw=new DataWriter();
        if(dw.updateProfile(this)){
            dw.close();
            return true;
        }
        dw.close();
        return false;
    
    }
    
    /**Method to return a student with the inputted ID
     * @param  id- is the student ID we are searching for
     * @return theStudent if found or null
     */
    public static Student getStudent(int id){
        DataReader dr=new DataReader();
        Student theStudent=dr.getStudent(id);
        dr.close();
        return theStudent;
    
    }
    
    /**Method to return all students from the database
     *@return the list of all students
     */
    public static ArrayList getAllStudents(){
        DataReader dr=new DataReader();
        ArrayList<Student> allStudentsList= dr.getStudents(null);
        dr.close();
        return allStudentsList;
    }
    /**Method to return all students with a certain name from the database
     *@param name- is the name of the student we will query
     * @return the list of all students
     */
    public static ArrayList getAllStudentsWithName(String name){
        DataReader dr=new DataReader();
        ArrayList<Student> requiredStudentList= dr.getStudents(name);
        dr.close();
        return requiredStudentList;
    }
    
    /**Method to add a friend to the friend list of current student
     *@param friend- the student to add in the friends list
     *@return if the friendship was succesfully added or not
     */
    public boolean addFriendshipWith(Student friend){
        
        Friendship newFriendship= new Friendship(this.ID, friend.getID());
        DataWriter dw= new DataWriter();
        boolean isAdded=dw.addFriendship(newFriendship);//here we send the data to the datawriter
        dw.close();
        return isAdded;
    }
    
    
    /**Method to add a course for the current user
     *@param course -the course to be added to the course list
     *@return boolean to indicate whether the operation succeded
     */
    public boolean addCourse(Course course){
        boolean added=false;
        if(course!=null){
        
            //add the course if the student is elgible to take and does not have the course
            if(isEligibleToTake(course) && !hasCourse(course.getID())){
                StudentCourse stC= new StudentCourse(this.ID, course.getID());
                DataWriter dw= new DataWriter();
                added=dw.addStudentCourse(stC);
                dw.close();
                updateCourseList();//update the courselist each time we add a course
            }
        }
        return added;
    
    }
    
    
    /**Method to find if a student is eligible to take the course or not,
     * by this we mean that the course is either in the students' major or minor
     * or is eligible to be taken by all
     *@param c- is a course object
     *@return is a boolean to specify whether the student is eligible to take a course or not
     */
    private boolean isEligibleToTake(Course c){
        boolean isEligibilityAll= c.getEligibility().equals("All");
        boolean isMajorEligible= c.getDepartment().equals(this.major);
        boolean isMinorEligible= c.getDepartment().equals(this.minor);
        
        return (isEligibilityAll || isMajorEligible || isMinorEligible);
        
    
    }
    
    /**Method to drop a course for the current user
     *@param course -the course to be dropped from the course list
     *@return boolean to indicate whether the operation succeded
     */
    public boolean dropCourse(Course course){
        boolean dropped=false;
        if(hasCourse(course.getID())){//if the student has the course
            StudentCourse stC= new StudentCourse(this.ID, course.getID());
            DataWriter dw= new DataWriter();
            dropped=dw.dropCourse(stC);
            dw.close();
            updateCourseList();//update the courselist each time we add a course
        }
        return dropped;
    
    }
    
    /**Method to find if a user has a course in his/her list or not
     *@param courseID- the courseID to search for
     *@return boolean- whether the course is present or not
     */
    public boolean hasCourse(int courseID){
        for (Course course : courseList) {
            if(course.getID()==courseID)
                return true;
        }
        return false;
    }
    
    /**Method to update the course list of the student*/
    private void updateCourseList(){
        getCourseList(this.getID());//update the course list
    
    }
    
    /**Static Method(since nothing is still read from the database) 
     * to authenticate user that is trying to enter the system
     * @param  id- is the id inputted by the user
     * @param password - is  the password inputted by the user
     * @return boolean-indicates whether authentication passed or failed
     */
    public static boolean isUserAuthenticated(int id,String password){
        DataReader dr = new DataReader();
        currentUser=dr.getStudent(id);//here we get the student with the corresponding ID
        dr.close();
        return (currentUser!=null && currentUser.getPassword().equals(password));
    
    }
    
    public boolean addComment(int courseID, String message){
        System.out.println(message);
        DataWriter dw= new DataWriter();
        Comment c= new Comment(this.getID(), courseID, this.getName(), this.getSurname(), message);
        boolean isAdded=dw.addComment(c);
        return isAdded;
    }

}
