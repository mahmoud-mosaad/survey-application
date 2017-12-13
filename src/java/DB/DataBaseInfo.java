package DB;

public class DataBaseInfo {
    
    private final String DATABASE_NAME = "ia_project";
    private final String CONNECT_STRING = "com.mysql.jdbc.Driver";
    private final String DATABASE_URL = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
    private final String USERNAME = "root";
    private final String PASSWORD = "";

    public DataBaseInfo() {
    }       

    public String getDATABASE_NAME() {
        return DATABASE_NAME;
    }

    public String getCONNECT_STRING() {
        return CONNECT_STRING;
    }

    public String getDATABASE_URL() {
        return DATABASE_URL;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }
    
    
}
