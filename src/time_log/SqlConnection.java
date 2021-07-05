



package time_log;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SqlConnection {
    private Map<String,String> data_values=new HashMap();
    private String url, database_name=null,
            user_name=null,
            password=null,
            host=null,
            port=null;
    Connection con=null;
    
    
    public String getDatabase(){
        return database_name;
    }
    
    public Connection startConnection(boolean first_connection) throws SQLException{
        if(!first_connection){
            this.url="jdbc:mysql://"+host+":"+port+"/"+database_name;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection(url, user_name, password);
            }
            catch(ClassNotFoundException e){
                con.close();
                showErrorStage(e.toString());
            }
        }
        else{
            readData();
            setValues();
            this.url="jdbc:mysql://"+host+":"+port+"/"+database_name;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection(url, user_name, password);
                showErrorStage("Connection Good");
            }
            catch(ClassNotFoundException e){
                con.close();
                showErrorStage(e.toString());
            }
        }
        return con;
    }
    
    public void closeConnection(){
        try {
            con.close();
            this.url=null;
        } catch (SQLException ex) {
            showErrorStage(ex.toString());
        }
    }
    
    public void testConnection(Map values_map) throws SQLException{
        String str_url="jdbc:mysql://"+values_map.get("host")+":"+
                values_map.get("port")+"/"+values_map.get("database");
        List test_conn_list=new ArrayList();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(str_url, values_map.get("username").toString(), values_map.get("password").toString());
            Statement stmt=con.createStatement();
            ResultSet project_names=stmt.executeQuery("SELECT * FROM types");
            while(project_names.next()){
                test_conn_list.add(project_names.getString(1));
            }
            test_conn_list.clear();
            stmt.close();
            closeConnection();
            showErrorStage("Connection Good");
        }
        catch(ClassNotFoundException e){
            con.close();
            showErrorStage(e.toString());
        }
    }
    
    public void setValues(Map values_map){
        this.data_values.putAll(values_map);
        this.database_name=values_map.get("database").toString();
        this.user_name=values_map.get("username").toString();
        this.password=values_map.get("password").toString();
        this.host=values_map.get("host").toString();
        this.port=values_map.get("port").toString();
    }
    
    public void replaceValuesMap(Map <String,String> values_map){
        this.data_values.forEach((key,value)->{
            this.data_values.replace(key, values_map.get(key));
        });
        this.database_name=values_map.get("database");
        this.user_name=values_map.get("username");
        this.password=values_map.get("password");
        this.host=values_map.get("host");
        this.port=values_map.get("port");
    }
    
    private void setValues(){
        this.database_name=this.data_values.get("database");
        this.user_name=this.data_values.get("username");
        this.password=this.data_values.get("password");
        this.host=this.data_values.get("host");
        this.port=this.data_values.get("port");
    }
    
    private void readData(){
        String str;
        try {
            FileInputStream fstream=new FileInputStream("server_data.dat");
            DataInputStream input_file = new DataInputStream(fstream);
            while(input_file.available()>0){
                str=input_file.readUTF();
                String[] token=str.split("=");
                this.data_values.put(token[0], token[1]);
            }
        } 
        catch (IOException ex) {
            showErrorStage(ex.toString());
        }
    }
     
    private void showErrorStage(String error_str){
       DisplayErrorFrame error_stage=new DisplayErrorFrame(error_str);
       error_stage.setTitle("Good Connection");
       error_stage.setVisible(true);
   }

}
