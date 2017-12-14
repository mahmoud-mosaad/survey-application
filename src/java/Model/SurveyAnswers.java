package Model;

import DB.DataBaseInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SurveyAnswers {
    private String userID;
    private String surveyID;
    private String questionID;
    private String answer;
    private int count;
    
     DataBaseInfo db = new DataBaseInfo();

    private final String CONNECT_STRING = db.getCONNECT_STRING();
    private final String URL = db.getDATABASE_URL();
    private final String USER = db.getUSERNAME();
    private final String PASS = db.getPASSWORD();
    private final String TABLE_NAME = "user_answers";
    private final String quote = "'";
    private final String comma = ",";

    public SurveyAnswers() {
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

    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    
    
    private String x(String str)
    {
        return "'"+str+"'";
    }
    
    public Boolean addAnswer(SurveyAnswers sa) {
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO " + TABLE_NAME + " VALUES(" + x(sa.getUserID())+comma+x(sa.getSurveyID())+comma+x(sa.getQuestionID())+comma+x(sa.getAnswer())+")");
            stmt.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in adding surevey's answers" + e);
            System.err.println("-------------------------------------");
            return false;
        }
        
    }
    
    
    public ArrayList getAnsweredSurveysByCount() {
        ArrayList<SurveyAnswers> surveysAnsered = new ArrayList<SurveyAnswers>();
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(DISTINCT surveyID) as count,surveyID,userID FROM user_answers GROUP BY surveyID");
            while (rs.next()) {
                SurveyAnswers ss = new SurveyAnswers();
                ss.setUserID(rs.getString("userID"));
                ss.setSurveyID(rs.getString("surveyID"));
                ss.setCount(rs.getInt("count"));
                surveysAnsered.add(ss);
            }
             rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in retrivnig spam counter surveys ansered  " + e);
            System.err.println("-------------------------------------");
        }
        return surveysAnsered;
    }
    
}
