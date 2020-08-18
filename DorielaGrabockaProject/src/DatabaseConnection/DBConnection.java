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
import java.sql.*;
import java.util.List;
/**
 *
 * @author Doriela
 */
public class DBConnection {
    
    private Connection con;
    private Statement st; //used for queries
    private ResultSet rs;//used for returning the result of our queries
    public static boolean isConnected=false;//connection at the beginning
    
    public DBConnection(){
       try{
           Class.forName("com.mysql.jdbc.Driver");
           //here we create the connection
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/univerisityapp?zeroDateTimeBehavior=convertToNull","root","");
           st=con.createStatement();
           isConnected=true;
       }
       catch(Exception e){
           System.out.println("Loaded Unsuccesfully!");
           isConnected=false;
       }
    }
    
    /**Method used to close the database connection
     *called from a DataReader object
     */
    public void close(){
       try{
          if(rs!=null){
              rs.close();//close the result set
          }
          if(st!=null){
              st.close();//close the statement to hold the queries
          }
          if(con!=null){
              con.close();//close the connection to the database
          }
          
       }
       catch(SQLException e){
          System.out.println("Cannot close connection");
       }
    }
    
    
    
    //*******GET QUERIES FROM DATABASE START HERE******************************//
    
    /**Method to return the list of all students in the database
     *@param list- this list will hold all the students, it is passed by reference 
     *             so no need to return anything by the function
     *@param studentName - is the name that the students we want to get should have
     */
    public void getStudents(List list, String studentName){
       try{
          String query;
          if(studentName==null){
              query="select * from student";
          }
          else{
              query="SELECT * FROM student WHERE name='"+studentName+"'";
          }
          
          rs=st.executeQuery(query);
          while(rs.next()){
             int id=rs.getInt("ID");
             String name=rs.getString("Name");
             String surname=rs.getString("Surname");
             int age=rs.getInt("Age");
             String major=rs.getString("Major");
             String minor=rs.getString("Minor");
             String password=rs.getString("Password");
             Student student=new Student(id, name, surname, age, major, minor, password);
             list.add(student);
          }//end of while
       }
       catch(Exception e){
          System.out.println("Data cannot be loaded!");
       }
    }
    
    
    
    /**Method to return the list of all courses in the database
     *@param list- this list will hold all the courses, it is passed by reference 
     *             so no need to return anything by the function
     */
    public void getCourses(List list){
       try{
          String query="select * from course";
          rs=st.executeQuery(query);
          while(rs.next()){
             int id=rs.getInt("ID");
             String title=rs.getString("Title");
             String instructor=rs.getString("Instructor");
             int credits=rs.getInt("Credits");
             String day=rs.getString("Day");
             String time=rs.getString("Time");
             String location=rs.getString("Class");
             String department=rs.getString("Department");
             String faculty=rs.getString("Faculty");
             String eligibility=rs.getString("Eligibility");
             Course course=new Course(id, title, instructor, day, time, location,credits, department, faculty, eligibility);
             list.add(course);
          }//end of while
       }
       catch(Exception e){
          System.out.println("Data cannot be loaded!");
       }
    }
    
    
    /**Method to return a single course
     *The same as the method getCourse but this will return a single course instead
     *@param  id- the id of the course
     *@return -will return a single course
     */
    public Course getCourse(int id){
       try{
          String query="select * from course where id="+id;//get the course with that ID
          rs=st.executeQuery(query);
          if(rs.next()){
             int courseId=rs.getInt("ID");
             String title=rs.getString("Title");
             String instructor=rs.getString("Instructor");
             int credits=rs.getInt("Credits");
             String day=rs.getString("Day");
             String time=rs.getString("Time");
             String location=rs.getString("Class");
             String department=rs.getString("Department");
             String faculty=rs.getString("Faculty");
             String eligibility=rs.getString("Eligibility");
             Course course=new Course(courseId, title, instructor, day, time, location,credits, department, faculty, eligibility);
             return course;//here we have recreated the course and return it
             
          
          }
          else{
              System.out.println("This course cannot be found!");
              return null;//student cannot be found
          }
       }
       catch(Exception e){
          System.out.println("Data cannot be loaded!");
          return null;//data could not be loaded
       }
    }
    
    
    /**Method to get friendship data from the database
     *@param list- this list will hold all friendships
     */
    public void getFriendships(List list){
       try{
          String query="select * from friendship";
          rs=st.executeQuery(query);
          while(rs.next()){
             int studentId=rs.getInt("StudentID");
             int friendId=rs.getInt("FriendID");
             Friendship friendship=new Friendship(studentId,friendId);
             list.add(friendship);
             
          }//end of while
       }
       catch(Exception e){
          System.out.println("Data cannot be loaded!");
       }
    }
    
    /**Method to get friends of a student from the database
     *@param id-id of current user/student
     *@param list- this list will hold all friends of current student
     */
    public void getFriendsOfStudent(int id,List list){
    
        try{
          String query="select s2.ID, s2.Name, s2.Surname, s2.Age, s2.Major, s2.Minor "
                     + "from student s1 join friendship f on s1.ID=f.StudentID "
                     + "join student s2 on s2.ID=f.FriendID where s1.ID="+id;
          rs=st.executeQuery(query);
          while(rs.next()){
             int studentId=rs.getInt("ID");
             String name=rs.getString("Name");
             String surname=rs.getString("Surname");
             int age=rs.getInt("Age");
             String major=rs.getString("Major");
             String minor=rs.getString("Minor");
             Student student=new Student(studentId,name,surname,age,major,minor,null);
             list.add(student);
             
          }//end of while
       }
       catch(Exception e){
          System.out.println("Data cannot be loaded!");
       }
    
    
    }
    
    /**Method to get comments from the database
     *@param list- this list will hold all comments
     */
    public void getComments(List list){
       try{
          String query="select * from comment";
          rs=st.executeQuery(query);
          while(rs.next()){
             int studentId=rs.getInt("StudentID");
             int courseID=rs.getInt("CourseID");
             String name=rs.getString("Name");
             String surname=rs.getString("Surname");
             String text=rs.getString("Text");
             Comment comment= new Comment(studentId, courseID, name, surname,text);
             list.add(comment);
             
          }//end of while
       }
       catch(Exception e){
          System.out.println("Data cannot be loaded!");
       }
    }
    
   /**Method to get comments in a certain course from the database
    *@param courseId- this will be the id of the course whose  comments we will get 
    *@param list- this list will hold all comments
    */
    public void getCommentsAboutCourse(int courseId, List list){
       try{
          String query="SELECT c.CourseID,c.StudentID,c.Text,s.Name,s.Surname "
                     + "FROM comment c join student s on c.StudentID=s.ID "
                     + "where c.CourseID="+courseId;
          rs=st.executeQuery(query);
          while(rs.next()){
             int studentId=rs.getInt("StudentID");
             int courseID=rs.getInt("CourseID");
             String name=rs.getString("Name");
             String surname=rs.getString("Surname");
             String text=rs.getString("Text");
             Comment comment= new Comment(studentId, courseID, name, surname,text);
             list.add(comment);
             
          }//end of while
       }
       catch(Exception e){
          System.out.println("Data cannot be loaded!");
       }
    }
    
    
    /**Method to get student-course objects from the database
    *@param list- this list will hold all comments
    */
    public void getStudentCourses(List list){
       try{
          String query="SELECT * FROM studentcourse";
          rs=st.executeQuery(query);
          while(rs.next()){
             int studentId=rs.getInt("StudentID");
             int courseIDfromDB=rs.getInt("CourseID");//this is from the database
             StudentCourse stdcr=new StudentCourse(studentId, courseIDfromDB);
             list.add(stdcr);
             
          }//end of while
       }
       catch(Exception e){
          System.out.println("Data cannot be loaded!");
       }
    }
    
    /**Method to get student-course objects from the database
     * @param id- the student id
     *@param list- this list will hold all comments
     */
    public void getCoursesOfStudent(int id,List list){
       try{
          String query="select c.ID, c.Title, c.Instructor, c.Day, c.Time, c.Class, "
                  + "c.Credits, c.Department, c.Faculty, c.Eligibility "
                  + "from student s join studentcourse sc on s.ID=sc.StudentID "
                  + "join course c on c.ID=sc.CourseID where s.ID="+id;
          rs=st.executeQuery(query);
          while(rs.next()){
             int courseId=rs.getInt("ID");
             String title=rs.getString("Title");
             String instructor=rs.getString("Instructor");
             int credits=rs.getInt("Credits");
             String day=rs.getString("Day");
             String time=rs.getString("Time");
             String location=rs.getString("Class");
             String department=rs.getString("Department");
             String faculty=rs.getString("Faculty");
             String eligibility=rs.getString("Eligibility");
             Course course=new Course(courseId, title, instructor, day, time, location,credits, department, faculty, eligibility);
             list.add(course);
             
          }//end of while
       }
       catch(Exception e){
          System.out.println("Data cannot be loaded!");
       }
    }
    
    /**Method to get student objects in a certain course from the database
    *@param courseId- this will be the id of the course whose  comments we will get 
    *@param list- this list will hold all comments
    */
    public void getStudentsOfCourse(int courseId, List list){
       try{
          String query="select s.Name,s.Surname,s.Major,s.Minor "
                  + "from student s join studentcourse sc on s.ID=sc.StudentID "
                  + "join course c on c.ID=sc.CourseID where c.ID="+courseId;
          rs=st.executeQuery(query);
          while(rs.next()){
             String name=rs.getString("Name");
             String surname=rs.getString("Surname");//this is from the database
             String major= rs.getString("Major");
             String minor= rs.getString("Minor");
             //since we do not need id,age and password we do not get them from the database
             Student std=new Student(-1,name,surname,-1,major,minor,null);
             list.add(std);
             
          }//end of while
       }
       catch(Exception e){
          System.out.println("Data cannot be loaded!");
       }
    }
    
    
    
    /**Method to return a single student in database
     *@param  id- the id of a student
     * @return -will return the student corresonding to that ID
     */
    public Student getStudent(int id){
       try{
          String query="select * from student where id="+id;//get the student with that ID
          rs=st.executeQuery(query);;
          if(rs.next()){
             int ID=rs.getInt("ID");
             String name=rs.getString("Name");
             String surname=rs.getString("Surname");
             int age=rs.getInt("Age");
             String major=rs.getString("Major");
             String minor=rs.getString("Minor");
             String password=rs.getString("Password");
             Student student=new Student(ID, name, surname, age, major, minor, password);
             return student;//here we have recreated the student and return it
             
          }
          else{
              System.out.println("This student cannot be found!");
              return null;//student cannot be found
          }
       }
       catch(Exception e){
          System.out.println("Data cannot be loaded!");
          return null;//data could not be loaded
       }
    }
    

    
    
    
    //*******UPDATE QUERIES OF DATABASE START HERE*****************************//
    
    /**Method used to update the profile of the user
     * @param id- id of the student whose data has changed
     * @param name- new name
     * @param surname- new surname
     * @param age- new age
     *@return - boolean to indicate whether the operation succeded or not
     */
    public boolean updateProfile(int id,String name , String surname, int age){
        boolean operationDone=false;
        
        String query="update student set age=?, name=?, surname=? where id=?";
        
        try{
            PreparedStatement stm= con.prepareStatement(query);
            stm.setInt(1, age);
            stm.setString(2, name);
            stm.setString(3, surname);
            stm.setInt(4, id);
            stm.executeUpdate();
            operationDone=true;
        }
        catch(Exception e){
            System.out.println("Cannot update database");
            operationDone=false;
        }
        return operationDone;
    
    }
    
    
    
    
    
    //*******ADD QUERIES OF DATABASE START HERE********************************//
    
    /**Method to add a friendship relation in the database
     *@param studentID - is the ID of the student adding the friendship
     *@param friendID- is the ID of the new friend added
     *@return boolean to specify if the operation succeded
     */
    public boolean addFriend(int studentID,int friendID){
        String query="INSERT INTO `friendship` (`StudentID`, `FriendID`) VALUES (?, ?)";
        boolean operationDone=false;
        try{
            PreparedStatement st=con.prepareStatement(query);
            st.setInt(1,studentID);
            st.setInt(2,friendID);
            st.execute();
            operationDone=true;
        }
        catch(Exception e){
            System.out.println("Cannot insert in database!");
            operationDone=false;
        
        }
        
    
        return operationDone;
    }
    
    /**Method to add a friendship relation in the database
     *@param studentID - is the ID of the student adding the course
     *@param courseID- is the ID of the course added
     *@return boolean to specify if the operation succeded
     */
    public boolean addCourse(int studentID,int courseID){
        boolean operationDone=false;
        String query="INSERT INTO `studentcourse` (`StudentID`, `CourseID`) VALUES (?, ?)";
        
        try{
            PreparedStatement st=con.prepareStatement(query);
            st.setInt(1,studentID);
            st.setInt(2,courseID);
            st.execute();
            operationDone=true;
        }
        catch(Exception e){
            System.out.println("Cannot insert in database!");
            operationDone=false;
        
        }
        return operationDone;
    }
    
    
    /**Method to add a friendship relation in the database
     *@param studentID - is the ID of the student dropping the course
     *@param courseID- is the ID of the course to be dropped
     *@return boolean to specify if the operation succeded
     */
    public boolean dropCourse(int studentID, int courseID){
        boolean operationDone=false;
        
        String query="DELETE FROM `studentcourse` "
                + "WHERE StudentID = ? AND CourseID = ?";
        
        try{
            PreparedStatement st=con.prepareStatement(query);
            st.setInt(1,studentID);
            st.setInt(2,courseID);
            st.execute();
            operationDone=true;
        }
        catch(Exception e){
            System.out.println("Cannot insert in database!");
            operationDone=false;
        
        }
        return operationDone;
    
    }
    
    
    
    /**Method to add a comment to of a student to a course in the database
     *@param studentID - the ID of the student entering the comment
     *@param courseID -  the ID of the course where the comment is added
     *@param text - the comment that was written
     *@return boolean to specify if the operation succeded or not
     */
    public boolean addComment(int studentID, int courseID, String text){
        boolean operationDone=false;
        String query="INSERT INTO `comment` (`StudentID`, `CourseID`, `Text`) VALUES (?, ?, ?)";
        try{
            PreparedStatement st= con.prepareStatement(query);
            st.setInt(1,studentID);
            st.setInt(2,courseID);
            st.setString(3,text);
            st.execute();
            operationDone=true;
        }catch(SQLException e){
            operationDone=false;
            //System.out.println("Cannot upload to database!");
            e.printStackTrace();
        }
        return operationDone;
    }

}
