package Model;

import DB.DataBaseInfo;
import java.sql.*;
import java.util.ArrayList;

public class User{

    private String id;
    private String name;
    private String email;
    private String password;
    private String gender;
    private int age;
    private String suspendMsg;
    private int type;
    private int suspended;
    private int state;
    private ArrayList<Survey> surveys;
    
    DataBaseInfo db = new DataBaseInfo();

    private final String CONNECT_STRING = db.getCONNECT_STRING();
    private final String URL = db.getDATABASE_URL();
    private final String USER = db.getUSERNAME();
    private final String PASS = db.getPASSWORD();
    private final String TABLE_NAME = "user";
    private final String quote = "'";
    private final String comma = ",";

    public User() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getsuspendMsg() {
        return suspendMsg;
    }

    public void setsuspendMsg(String img) {
        this.suspendMsg = img;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int isSuspended() {
        return suspended;
    }

    public void setSuspended(int suspended) {
        this.suspended = suspended;
    }
    
    
    public ArrayList<Survey> getSurveys() {
        return surveys;
    }

    public void setSurveys(ArrayList<Survey> surveys) {
        this.surveys = surveys;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    
    private String x(String str)
    {
        return "'"+str+"'";
    }
    

    public Boolean addUser(User user) {
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO " + TABLE_NAME + " VALUES('" + user.getId() + quote + comma 
                                + quote + user.getName() + quote + comma + quote + user.getEmail()+ quote 
                                + comma + quote + user.getPassword()+ quote + comma + quote +user.getGender()
                                + quote + comma + quote +user.getAge() + quote + comma + quote + user.getsuspendMsg()
                                + quote + comma + quote +user.getType()+ quote + comma + quote +user.isSuspended()+quote+comma+user.getState()+")");
             
            stmt.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in adding user" + e);
            System.err.println("-------------------------------------");
            return false;
        }
        
    }

    public Boolean checkUserName(String name) {
        Boolean found = false;
        String n = "";
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name FROM " + TABLE_NAME + " where name = " + quote + name + quote);
            while (rs.next()) {
                n = rs.getString("name");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in finding user Name" + e);
            System.err.println("-------------------------------------");
        }

        if (n != null && !n.equals("")) {
            found = true;
        }

        return found;
    }

    public Boolean checkUserEmail(String Email) {
        Boolean found = false;
        String n = "";
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT email FROM " + TABLE_NAME + " where email = " + quote + Email + quote);
            while (rs.next()) {
                n = rs.getString("email");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in finding user Name" + e);
            System.err.println("-------------------------------------");
        }

        if (n != null && !n.equals("")) {
            found = true;
        }

        return found;
    }

    public User getUser(String email) {
        User user = new User();
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id,name,email,password,gender,age,suspendMsg,type,suspended,state FROM " + TABLE_NAME + " where email = " + quote + email + quote);
            while (rs.next()) {
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setGender(rs.getString("gender"));
                user.setAge(rs.getInt("age"));
                user.setsuspendMsg(rs.getString("suspendMsg"));
                user.setType(rs.getInt("type"));
                user.setSuspended(rs.getInt("suspended"));
                user.setState(rs.getInt("state"));
            }
             rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in getting user" + e);
            System.err.println("-------------------------------------");
        }
        return user;
    }
    
    
    public User getUserByID(String id) {
        User user = new User();
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id,name,email,password,gender,age,suspendMsg,type,suspended,state FROM " + TABLE_NAME + " where id = " + quote + id + quote);
            while (rs.next()) {
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setGender(rs.getString("gender"));
                user.setAge(rs.getInt("age"));
                user.setsuspendMsg(rs.getString("suspendMsg"));
                user.setType(rs.getInt("type"));
                user.setSuspended(rs.getInt("suspended"));
                user.setState(rs.getInt("state"));
            }
             rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in getting user by id" + e);
            System.err.println("-------------------------------------");
        }
        return user;
    }
    
    
    public ArrayList getUsers() {
        ArrayList<User> users = new ArrayList<User>();
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLE_NAME );
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setGender(rs.getString("gender"));
                user.setAge(rs.getInt("age"));
                user.setsuspendMsg("suspendMsg");
                user.setType(rs.getInt("type"));
                user.setSuspended(rs.getInt("suspended"));
                user.setState(rs.getInt("state"));
                users.add(user);
            }
             rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in retriving servays" + e);
            System.err.println("-------------------------------------");
        }
        return users;
    }
    
    
    public Boolean makeAdmin(String email , int type)
    {
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE " + TABLE_NAME + " SET type=" +type +" where email = " + quote + email + quote);
            stmt.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in changing type of user " + e);
            System.err.println("-------------------------------------");
            return false;
        }
    }
    
    
    public Boolean sendSuspendMsg(String email , String msg)
    {
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE " + TABLE_NAME + " SET suspendMsg=" +x(msg) +",suspended=1 where email = " + quote + email + quote);
            stmt.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in sending suspend msg to user " + e);
            System.err.println("-------------------------------------");
            return false;
        }
    }
    
    
    public Boolean suspendUser(String email)
    {
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE " + TABLE_NAME + " SET suspended='1'" +" where email = " + quote + email + quote);
            stmt.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in suspend the user " + e);
            System.err.println("-------------------------------------");
            return false;
        }
    }
    
    public Boolean unSuspendUser(String email)
    {
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE " + TABLE_NAME + " SET suspended='0',suspendMsg=''" +" where email = " + quote + email + quote);
            stmt.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in unsuspend the user " + e);
            System.err.println("-------------------------------------");
            return false;
        }
    }
    
    public Boolean changePassword(String email , String newPassword)
    {
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE " + TABLE_NAME + " SET password='"+newPassword+"'" +" where email = " + quote + email + quote);
            stmt.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in changing password " + e);
            System.err.println("-------------------------------------");
            return false;
        }
    }
    
    
    public Boolean changeState(String email , int state)
    {
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE " + TABLE_NAME + " SET state='"+state+"'" +" where email = " + quote + email + quote);
            stmt.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in changing state" + e);
            System.err.println("-------------------------------------");
            return false;
        }
    }

            
    public void deleteUser(String email) {
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM " + TABLE_NAME + " WHERE email = " + quote+email+quote);
            
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in deleting user" + e);
            System.err.println("-------------------------------------");
        }
    }
}
