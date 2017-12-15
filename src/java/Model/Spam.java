package Model;

import DB.DataBaseInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Spam {
    private String userID;
    private String surveyID;
    private int isSpam;
    private int spamCount;
    
    DataBaseInfo db = new DataBaseInfo();

    private final String CONNECT_STRING = db.getCONNECT_STRING();
    private final String URL = db.getDATABASE_URL();
    private final String USER = db.getUSERNAME();
    private final String PASS = db.getPASSWORD();
    private final String TABLE_NAME = "spam";
    private final String quote = "'";
    private final String comma = ",";

    public Spam() {
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getSurveyID() {
        return surveyID;
    }

    public void setSurveyID(String surveyID) {
        this.surveyID = surveyID;
    }

    public int getIsSpam() {
        return isSpam;
    }

    public void setIsSpam(int isSpam) {
        this.isSpam = isSpam;
    }

    public int getSpamCount() {
        return spamCount;
    }

    public void setSpamCount(int spamCount) {
        this.spamCount = spamCount;
    }
    
    
    
    private String x(String str)
    {
        return "'"+str+"'";
    }
    
    public Boolean spamIt(Spam spam) {
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO " + TABLE_NAME + " VALUES(" + x(spam.getUserID())+comma+x(spam.getSurveyID())+comma+spam.getIsSpam()+")");
            stmt.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in marking survey as spam" + e);
            System.err.println("-------------------------------------");
            return false;
        }
        
    }
    
    public ArrayList getSpamedSurveys() {
        ArrayList<Spam> surveysSpams = new ArrayList<Spam>();
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLE_NAME );
            while (rs.next()) {
                Spam spam = new Spam();
                spam.setUserID(rs.getString("userID"));
                spam.setSurveyID(rs.getString("surveyID"));
                spam.setIsSpam(rs.getInt("spam"));
                surveysSpams.add(spam);
            }
             rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in retrivnig spammed surveys  " + e);
            System.err.println("-------------------------------------");
        }
        return surveysSpams;
    }
    
    public ArrayList getSpamedSurveysByCount() {
        ArrayList<Spam> surveysSpams = new ArrayList<Spam>();
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT surveyID, count(userID) as spamCount FROM " + TABLE_NAME + " group by surveyID");
            while (rs.next()) {
                Spam spam = new Spam();
                spam.setSurveyID(rs.getString("surveyID"));
                spam.setSpamCount(rs.getInt("spamCount"));
                surveysSpams.add(spam);
            }
             rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in retrivnig spam counter surveys  " + e);
            System.err.println("-------------------------------------");
        }
        return surveysSpams;
    }
    
    public Boolean checkIfSpammed(String userID , String surveyID) {
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
    
    
    public Boolean deleteSpam(String surveyID) {
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM " + TABLE_NAME + " WHERE surveyID = " + x(surveyID));
            stmt.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in deleting spam" + e);
            System.err.println("-------------------------------------");
            return false;
        }
    }
    
}
