package Model;

import DB.DataBaseInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SuspendedUserResponse {
    private String adminID;
    private String userID;
    private String msg;

    DataBaseInfo db = new DataBaseInfo();

    private final String CONNECT_STRING = db.getCONNECT_STRING();
    private final String URL = db.getDATABASE_URL();
    private final String USER = db.getUSERNAME();
    private final String PASS = db.getPASSWORD();
    private final String TABLE_NAME = "suspended_user_msg";
    private final String quote = "'";
    private final String comma = ",";

    public SuspendedUserResponse() {
    }
    
    

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    private String x(String str)
    {
        return "'"+str+"'";
    }
    
    public Boolean addMsg(SuspendedUserResponse msg) {
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO " + TABLE_NAME + " VALUES(" +
                                x(msg.getUserID()) + comma + x(msg.getMsg())+ ")");
            stmt.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in adding suspended user msg" + e);
            System.err.println("-------------------------------------");
            return false;
        }
    }
    
    public ArrayList getAdminMsgs() {
        ArrayList<SuspendedUserResponse> msgs = new ArrayList<SuspendedUserResponse>();
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLE_NAME );
            while (rs.next()) {
                SuspendedUserResponse msg = new SuspendedUserResponse();
                msg.setUserID(rs.getString("userID"));
                msg.setMsg(rs.getString("msg"));
                msgs.add(msg);
            }
             rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in retriving resonse msgs" + e);
            System.err.println("-------------------------------------");
        }
        return msgs;
    }
    
    
    public Boolean deleteResponse(String userID) {
        try {
            Class.forName(CONNECT_STRING);
            Connection conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM " + TABLE_NAME + " WHERE userID = " + x(userID));
            stmt.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("-------------------------------------");
            System.err.println("error in deleting suspende user response " + e);
            System.err.println("-------------------------------------");
            return false;
        }
    }
    
}
