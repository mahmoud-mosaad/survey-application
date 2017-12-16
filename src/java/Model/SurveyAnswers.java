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

    private String x(String str) {
        return "'" + str + "'";
    }

    public Boolean addAnswer(SurveyAnswers sa) {
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO " + TABLE_NAME + " VALUES(" + x(sa.getUserID()) + comma + x(sa.getSurveyID()) + comma + x(sa.getQuestionID()) + comma + x(sa.getAnswer()) + ")");
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

    public Boolean updateAnswer(SurveyAnswers sa) {
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE " + TABLE_NAME + " SET answer=" + x(sa.getAnswer()) + " WHERE questionID=" + x(sa.getQuestionID()) + " AND userID=" + x(sa.getUserID()));
            stmt.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in updating surevey's answers" + e);
            System.err.println("-------------------------------------");
            return false;
        }
    }
        
        

    public String getAnswer(String userID , String questionID) {
        String answer="";
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT answer FROM " + TABLE_NAME + " where questionID = " + x(questionID) + " AND userID="+x(userID));
            while (rs.next()) {
                answer = rs.getString("answer");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in getting answering " + e);
            System.err.println("-------------------------------------");
        }
        return answer;
    }
    
    
    public ArrayList<String> getCheckBoxes(String userID , String questionID) {
        String answer="";
        ArrayList<String> answers = new ArrayList<String>();
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLE_NAME + " where questionID = " + x(questionID) + " AND userID="+x(userID));
            while (rs.next()) {
                answer = rs.getString("answer");
                answers.add(answer);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in getting answering " + e);
            System.err.println("-------------------------------------");
        }
        System.out.println("*****************************");
        for(int i=0 ; i<answers.size() ; i++)
        {
            System.out.println(answers.get(i));
        }
        System.out.println("*****************************");
        return answers;
    }


}
