package Model;

import DB.DataBaseInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Answer {
    private String id;
    private String value;
    private String type;
    private String quetionID;

    DataBaseInfo db = new DataBaseInfo();

    private final String CONNECT_STRING = db.getCONNECT_STRING();
    private final String URL = db.getDATABASE_URL();
    private final String USER = db.getUSERNAME();
    private final String PASS = db.getPASSWORD();
    private final String TABLE_NAME = "answer";
    private final String quote = "'";
    private final String comma = ",";
    
    public Answer() {
    }

    public Answer(String id, String value, String type, String quetionID) {
        this.id = id;
        this.value = value;
        this.type = type;
        this.quetionID = quetionID;
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

    public String getQuetionID() {
        return quetionID;
    }

    public void setQuetionID(String quetionID) {
        this.quetionID = quetionID;
    }
    
     private String x(String str)
    {
        return "'"+str+"'";
    }

    public void addAnswer(Answer answer) {
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO " + TABLE_NAME + " VALUES(" + x(answer.getId())+ comma +
                                x(answer.getValue()) + comma + x(answer.getType()) +comma+ x(answer.getQuetionID())+ ")");
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in adding answer" + e);
            System.err.println("-------------------------------------");
        }
    }
    
    public ArrayList getAnswer(String questionID) {
        ArrayList<Answer> answers = new ArrayList<Answer>();
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLE_NAME + " where questionID="+ x(questionID) );
            while (rs.next()) {
                Answer answer = new Answer();
                answer.setId(rs.getString("id"));
                answer.setValue(rs.getString("value"));
                answer.setType(rs.getString("type"));
                answer.setQuetionID(rs.getString("questionID"));
                answers.add(answer);
            }
             rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in retriving answers" + e);
            System.err.println("-------------------------------------");
        }
        return answers;
    }
    
    public void deleteAnswer(String answerID) {
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM " + TABLE_NAME + " WHERE id = " + x(answerID));
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in deleting answer" + e);
            System.err.println("-------------------------------------");
        }
    }

}
