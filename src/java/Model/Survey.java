package Model;

import DB.DataBaseInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Survey {

    private String id;
    private String name;
    private String desc;
    private String userID;
    private int suspend;

    ArrayList<Question> mcqQuestions;
    ArrayList<Question> checkboxQuestions;
    ArrayList<Question> freeanswerQuestions;

    DataBaseInfo db = new DataBaseInfo();

    private final String CONNECT_STRING = db.getCONNECT_STRING();
    private final String URL = db.getDATABASE_URL();
    private final String USER = db.getUSERNAME();
    private final String PASS = db.getPASSWORD();
    private final String TABLE_NAME = "survey";
    private final String quote = "'";
    private final String comma = ",";

    public Survey() {
    }

    public Survey(String id, String name, String desc, String userID) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.userID = userID;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public ArrayList<Question> getMcqQuestions() {
        return mcqQuestions;
    }

    public void setMcqQuestions(ArrayList<Question> mcqQuestions) {
        this.mcqQuestions = mcqQuestions;
    }

    public ArrayList<Question> getCheckboxQuestions() {
        return checkboxQuestions;
    }

    public void setCheckboxQuestions(ArrayList<Question> checkboxQuestions) {
        this.checkboxQuestions = checkboxQuestions;
    }

    public ArrayList<Question> getFreeanswerQuestions() {
        return freeanswerQuestions;
    }

    public void setFreeanswerQuestions(ArrayList<Question> freeanswerQuestions) {
        this.freeanswerQuestions = freeanswerQuestions;
    }
    
    public int getSuspend() {
        return suspend;
    }

    public void setSuspend(int suspend) {
        this.suspend = suspend;
    }
    
    
    private String x(String str)
    {
        return "'"+str+"'";
    }

    public void addSurvey(Survey survey) {
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO " + TABLE_NAME + " VALUES(" + x(survey.getId())+ comma +
                                x(survey.getName()) + comma + x(survey.getDesc()) +comma+ x(survey.getUserID())+comma+x(String.valueOf(survey.getSuspend()))+ ")");
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in adding survey" + e);
            System.err.println("-------------------------------------");
        }
    }
    
    public ArrayList getSurveys() {
        ArrayList<Survey> surveys = new ArrayList<Survey>();
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLE_NAME );
            while (rs.next()) {
                Survey survey = new Survey();
                survey.setId(rs.getString("id"));
                survey.setName(rs.getString("name"));
                survey.setDesc(rs.getString("description"));
                survey.setUserID(rs.getString("userID"));
                survey.setSuspend(rs.getInt("suspend"));
                surveys.add(survey);
            }
             rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in retriving servays" + e);
            System.err.println("-------------------------------------");
        }
        return surveys;
    }
    
    
    public Survey getSurvey(String id) {
        Survey survey = new Survey();
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name,description,userID,suspend FROM " + TABLE_NAME + " where id = " + quote + id + quote);
            while (rs.next()) {
                survey.setName(rs.getString("name"));
                survey.setUserID(rs.getString("userID"));
                survey.setDesc(rs.getString("description"));
                survey.setSuspend(rs.getInt("suspend"));
            }
             rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in getting single survey" + e);
            System.err.println("-------------------------------------");
        }
        return survey;
    }
    
    public Boolean suspend(String surveyID)
    {
        
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE " + TABLE_NAME + " SET suspend='1'" +" where id = " + quote + surveyID + quote);
            stmt.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in suspend the survey " + e);
            System.err.println("-------------------------------------");
            return true;
        }
        
    }
    
    public Boolean deleteSurvey(String surveyID) {
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM " + TABLE_NAME + " WHERE id = " + x(surveyID));
            stmt.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in deleting survey" + e);
            System.err.println("-------------------------------------");
            return false;
        }
    }

}
