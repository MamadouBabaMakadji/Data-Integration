package data.integration.extractor;

import data.integration.request.Request;

import java.sql.*;
import java.util.ArrayList;

public class Source2ExtractorImpl implements IExtractor {

    public int extractResultR1(){
        ArrayList<String> result = executeRequest(Request.S2_R1);

        return result.size();
    }

    public ArrayList<String> extractResultR2(){
        ArrayList<String> result = executeRequest(Request.S2_R2);

        return result;
    }

    public ArrayList<String> extractResultR3(){
        ArrayList<String> result = executeRequest(Request.S2_R3);

        return result;
    }

    private ArrayList<String> executeRequest(String requete){
        {
            ArrayList<String> result = new ArrayList<String>();
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost/source2_db";
            String login = "root";
            String mdp = "root";
            Connection connection = null;
            Statement statement = null;
            ResultSet rs = null;
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, login, mdp);
                statement = connection.createStatement();
                rs = statement.executeQuery(requete);
                while(rs.next()){
                    result.add(rs.getString("result"));
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            return result;
        }
    }
}
