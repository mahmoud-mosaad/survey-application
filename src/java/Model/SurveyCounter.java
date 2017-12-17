package Model;

import DB.DataBaseInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SurveyCounter {
    private String userID;
    private String surevyID;
    private int submitedSurveyCount;
    
    DataBaseInfo db = new DataBaseInfo();

    private final String CONNECT_STRING = db.getCONNECT_STRING();
    private final String URL = db.getDATABASE_URL();
    private final String USER = db.getUSERNAME();
    private final String PASS = db.getPASSWORD();
    private final String TABLE_NAME = "survey_counter";
    private final String quote = "'";
    private final String comma = ",";

    public SurveyCounter() {
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getSurevyID() {
        return surevyID;
    }

    public void setSurevyID(String surevyID) {
        this.surevyID = surevyID;
    }

    public int getSubmitedSurveyCount() {
        return submitedSurveyCount;
    }

    public void setSubmitedSurveyCount(int submitedSurveyCount) {
        this.submitedSurveyCount = submitedSurveyCount;
    }
    
    
    
     private String x(String str)
    {
        return "'"+str+"'";
    }
    
    public Boolean submitSurvey(SurveyCounter sc) {
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO " + TABLE_NAME + " VALUES(" + x(sc.getUserID())+comma+x(sc.getSurevyID())+")");
            stmt.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in submiting surevy " + e);
            System.err.println("-------------------------------------");
            return false;
        }
        
    }
    
    public ArrayList getSubmitedSurvey() {
        ArrayList<SurveyCounter> surveyCounters = new ArrayList<SurveyCounter>();
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLE_NAME );
            while (rs.next()) {
                SurveyCounter sc = new SurveyCounter();
                sc.setUserID(rs.getString("userID"));
                sc.setSurevyID(rs.getString("surveyID"));
                surveyCounters.add(sc);
            }
             rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in retrivnig submited surveys  " + e);
            System.err.println("-------------------------------------");
        }
        return surveyCounters;
    }
    
    public ArrayList getSubmitedSpamedSurveysByCount(String userID) {
        ArrayList<SurveyCounter> surveysCounters = new ArrayList<SurveyCounter>();
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT surveyID, count(userID) as Count FROM " + TABLE_NAME + " where userID="+x(userID)+ " group by surveyID" );
            while (rs.next()) {
                SurveyCounter sc = new SurveyCounter();
                sc.setSurevyID(rs.getString("surveyID"));
                sc.setSubmitedSurveyCount(rs.getInt("Count"));
                surveysCounters.add(sc);
            }
             rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in retrivnig submited suveys count   " + e);
            System.err.println("-------------------------------------");
        }
        return surveysCounters;
    }
    
    
    public SurveyCounter getSingleSubmitedSurveysCount(String surveyID) {
        SurveyCounter sc = new SurveyCounter();
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT surveyID, count(userID) as Count FROM " + TABLE_NAME + " where surveyID="+x(surveyID)+ " group by surveyID" );
            while (rs.next()) {
                sc.setSurevyID(rs.getString("surveyID"));
                sc.setSubmitedSurveyCount(rs.getInt("Count"));
            }
             rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in retrivnig submited suveys count   " + e);
            System.err.println("-------------------------------------");
        }
        return sc;
    }
    
    public Boolean checkIfSubumittedBefore(String userID , String surveyID) {
        try {
            String ss="";
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT userID FROM " + TABLE_NAME +" where userID="+x(userID)+" AND surveyID="+x(surveyID));
            while (rs.next()) {
                ss = rs.getString("userID");
            }
            rs.close();
            stmt.close();
            conn.close();
            if(ss.equals("") || ss == null){return false;}else{return true;}
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in checking user spam  " + e);
            System.err.println("-------------------------------------"); 
        }
        return false;
    }
    
    public int getAnonymousCount(String surveyID){
        int rr = 0;
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT surveyID, count(userID) as Count FROM " + TABLE_NAME + " where surveyID="+x(surveyID)+ "and userID='anonymous' group by surveyID" );
            while (rs.next()) {
                rr = rs.getInt("Count");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in retrivnig anonymous count   " + e);
            System.err.println("-------------------------------------");
        }
        return rr;
    }
    
    public int getMalesCount(String surveyID){
        int rr = 0;
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT surveyID, count(userID) as Count FROM " + TABLE_NAME + " join user on user.id = survey_counter.userID where surveyID="+x(surveyID)+ " and gender='male' group by surveyID" );
            while (rs.next()) {
                rr = rs.getInt("Count");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in retrivnig anonymous count   " + e);
            System.err.println("-------------------------------------");
        }
        return rr;
    }
    
    public int getFemalesCount(String surveyID){
        int rr = 0;
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT surveyID, count(userID) as Count FROM " + TABLE_NAME + " join user on user.id = survey_counter.userID where surveyID="+x(surveyID)+ " and gender='female' group by surveyID" );
            while (rs.next()) {
                rr = rs.getInt("Count");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in retrivnig anonymous count   " + e);
            System.err.println("-------------------------------------");
        }
        return rr;
    }
    
}
