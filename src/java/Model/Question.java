package Model;

import DB.DataBaseInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Question {
    
    private String id;
    private String value;
    private String type;
    private String surveyID;
    private ArrayList<Answer> mcqAnswers;
    private ArrayList<Answer> checkboxAnswers;

    DataBaseInfo db = new DataBaseInfo();

    private final String CONNECT_STRING = db.getCONNECT_STRING();
    private final String URL = db.getDATABASE_URL();
    private final String USER = db.getUSERNAME();
    private final String PASS = db.getPASSWORD();
    private final String TABLE_NAME = "question";
    private final String quote = "'";
    private final String comma = ",";
    
    public Question() {
    }

    public Question(String id, String value, String type, String surveyID) {
        this.id = id;
        this.value = value;
        this.type = type;
        this.surveyID = surveyID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSurveyID() {
        return surveyID;
    }

    public void setSurveyID(String surveyID) {
        this.surveyID = surveyID;
    }

    public ArrayList<Answer> getMcqAnswers() {
        return mcqAnswers;
    }

    public void setMcqAnswers(ArrayList<Answer> mcqAnswers) {
        this.mcqAnswers = mcqAnswers;
    }

    public ArrayList<Answer> getCheckboxAnswers() {
        return checkboxAnswers;
    }

    public void setCheckboxAnswers(ArrayList<Answer> checkboxAnswers) {
        this.checkboxAnswers = checkboxAnswers;
    }

    
    
    private String x(String str)
    {
        return "'"+str+"'";
    }
    
    
    public void addQuestion(Question question) {
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO " + TABLE_NAME + " VALUES(" + x(question.getId())+ comma +
                                x(question.getValue()) + comma + x(question.getType()) +comma+ x(question.getSurveyID())+ ")");
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in adding question" + e);
            System.err.println("-------------------------------------");
        }
    }
    
    
     public ArrayList getQuestions(String surveyID) {
        ArrayList<Question> questions = new ArrayList<Question>();
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLE_NAME + " where surveyID="+ x(surveyID) );
            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getString("id"));
                question.setValue(rs.getString("value"));
                question.setType(rs.getString("type"));
                question.setSurveyID(rs.getString("surveyID"));
                questions.add(question);
            }
             rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in retriving questions" + e);
            System.err.println("-------------------------------------");
        }
        return questions;
    }
     
     
     public ArrayList getQuestions(String surveyID , String type) {
        ArrayList<Question> questions = new ArrayList<Question>();
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLE_NAME + " where surveyID="+ x(surveyID) +"AND type="+x(type));
            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getString("id"));
                question.setValue(rs.getString("value"));
                question.setType(rs.getString("type"));
                question.setSurveyID(rs.getString("surveyID"));
                questions.add(question);
            }
             rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in retriving questions" + e);
            System.err.println("-------------------------------------");
        }
        return questions;
    }
    
    public void deleteQuestion(String questionID) {
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM " + TABLE_NAME + " WHERE id = " + x(questionID));
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in deleting question" + e);
            System.err.println("-------------------------------------");
        }
    }
    
}
