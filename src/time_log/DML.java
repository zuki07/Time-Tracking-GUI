



package time_log;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DML extends HandleTime{
    private Statement stmt;
    String table_name, types_str;
    boolean first_connection;
    Map<Integer,Map<String,String>> records_row;
    
    
    public void insertProjectNamesValues(String table_name){
        try {
            first_connection=false;
            con=startConnection(first_connection);
            stmt=con.createStatement();
            String query=String.format("INSERT INTO project_names VALUES ('%s', '%s')", types_str, table_name);
            stmt.executeUpdate(query);
            stmt.close();
            closeConnection();
        } catch (SQLException ex) {
            showErrorStage(ex.toString());
        }
    }
    
    public void insertType(String type){
        try {
            first_connection=false;
            con=startConnection(first_connection);
            stmt=con.createStatement();
            String query="INSERT INTO types VALUES ('"+type+"')";
            stmt.executeUpdate(query);
            stmt.close();
            closeConnection();
        } catch (SQLException ex) {
            showErrorStage(ex.toString());
        }
    }
    
    public void deleteType(String type){
        try {
            
            List list=getProjectsRecords(type);
            for(int i=0;i<list.size();i++){
                deleteProjectName(list.get(i).toString());
            }
            first_connection=false;
            con=startConnection(first_connection);
            stmt=con.createStatement();
            String query="DELETE FROM types WHERE project_types = '"+type+"'";
            stmt.executeUpdate(query);
            stmt.close();
            closeConnection();
        } catch (SQLException ex) {
            showErrorStage(ex.toString());
        }
    }
    public void setTable(String table){
        this.table_name=table;
    }
    
    public void deleteProjectName(String table_name){
        try {
            first_connection=false;
            con=startConnection(first_connection);
            stmt=con.createStatement();
            String query="DELETE FROM projects_data where project_name = '"+table_name+"'";
            stmt.executeUpdate(query);
            query="DELETE FROM project_names where project_names = '"+table_name+"'";
            stmt.executeUpdate(query);
            stmt.close();
            closeConnection();
        } catch (SQLException ex) {
            showErrorStage(ex.toString());
        }
    }
    
    public void insertProjectRecords(){
        try {
            first_connection=false;
            con=startConnection(first_connection);
            stmt=con.createStatement();
            String query=String.format("INSERT INTO projects_data (project_name, date, start_time, end_time, duration, total_time) "+
                    "VALUES ('%s','%s', '%s', '%s', '%s', '%s')",table_name,start_date,start_str,end_str,duration_str,total_str);
            stmt.executeUpdate(query);
            stmt.close();
            closeConnection();
        } catch (SQLException ex) {
            showErrorStage(ex.toString());
        }
    }
    
    public Map readProjectRecords(){
        try {
            String query2="SELECT date, start_time, end_time, duration, total_time " +
                            "from projects_data where project_name = '"+table_name+"'";
            first_connection=false;
            con=startConnection(first_connection);
            stmt=con.prepareStatement(query2);
            ResultSet rs=stmt.executeQuery(query2);
            int index=0;
            records_row=new HashMap();
            while(rs.next()){
                Map<String,String> records_map=new HashMap();
                records_map.put("date", rs.getString("date"));
                records_map.put("start_time", rs.getString("start_time"));
                records_map.put("end_time", rs.getString("end_time"));
                records_map.put("duration", rs.getString("duration"));
                records_map.put("total_time", rs.getString("total_time"));
                records_row.put(index, records_map);
                index++;
            }
            stmt.close();
            rs.close();
            closeConnection();
        } catch (SQLException ex) {
            showErrorStage(ex.toString());
        }
        return records_row;
    }
    
    public List getProjectsRecords(String type_table){
        List project_list=new ArrayList();
        try {
            first_connection=false;
            con=startConnection(first_connection);
            stmt=con.createStatement();
            ResultSet project_names=stmt.executeQuery("SELECT project_names FROM types join project_names on types.project_types = project_names.project_types "
                                        + "WHERE project_names.project_types = '"+type_table+"'");
            while(project_names.next()){
                project_list.add(project_names.getString(1));
            }
            project_names.close();
            stmt.close();
            closeConnection();
        } catch (SQLException ex) {
            showErrorStage(ex.toString());
        }
        return project_list;
    }
    
    public void setTotalTime(String total_string){
        total_str=total_string;
    }
    
    @Override
    public String getTotalTime(){
        try {
            first_connection=false;
            con=startConnection(first_connection);
            stmt=con.createStatement();
            ResultSet rs_total=stmt.executeQuery("Select total_time from projects_data where project_name = '"+table_name+"' order by total_time desc limit 1");
            total_str="";
            while(rs_total.next()){
                total_str=rs_total.getString("total_time");
            }
            rs_total.close();
            stmt.close();
            closeConnection();
        } catch (SQLException ex) {
            showErrorStage(ex.toString());
        }
        return total_str;
    }
    
    public List getAllProjects(){
        List all_projects_list=new ArrayList();
        first_connection=false;
        try {
            con=startConnection(first_connection);
            stmt=con.createStatement();
            ResultSet all_projects=stmt.executeQuery("SELECT project_names from project_names");
            while(all_projects.next()){
                all_projects_list.add(all_projects.getString(1));
            }
            all_projects.close();
            stmt.close();
            closeConnection();
        } catch (SQLException ex) {
            showErrorStage(ex.toString());
        }
        return all_projects_list;
    }
    
    public String getTypeFromProject(String project_name){
        String type="";
        first_connection=false;
        try {
            con=startConnection(first_connection);
            stmt=con.createStatement();
            ResultSet all_projects=stmt.executeQuery("SELECT project_types from project_names where project_names = '"+project_name+"'");
            while(all_projects.next()){
                type=all_projects.getString(1);
            }
            all_projects.close();
            stmt.close();
            closeConnection();
        } catch (SQLException ex) {
            showErrorStage(ex.toString());
        }
        return type;
    }
    
    public List getProjectTypes(boolean first_connection){
        List types_list=new ArrayList();
        try {
            con=startConnection(first_connection);
            stmt=con.createStatement();
            try {
                ResultSet project_types=stmt.executeQuery("SELECT * FROM types");
                while(project_types.next()){
                    types_list.add(project_types.getString(1));
                }
                project_types.close();
            }
            catch (SQLException ex) {
                showErrorStage("Database Structure error.  Please see README-2.TXT for instructions on setting up the structure of the database.");
            }
            stmt.close();
            closeConnection();
        } catch (SQLException ex) {
            types_list=null;
            showErrorStage(ex.toString());
        }
        return types_list;
    }
    
    public String getDatabaseSize(){
        String database_size="";
        try {
            first_connection=false;
            con=startConnection(first_connection);
            stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT ROUND(SUM(data_length + index_length) / 1024 / 1024, 2) AS 'Size (MB)' " +
                                            "FROM information_schema.TABLES WHERE table_schema = '"+this.getDatabase()+"'");
            while(rs.next()){
                database_size=rs.getString("Size (MB)");
            }
            rs.close();
            stmt.close();
            closeConnection();
        } catch (SQLException ex) {
            showErrorStage(ex.toString());
        }
        return database_size;
    }
    
    private void showErrorStage(String error_str){
        DisplayErrorFrame error_stage=new DisplayErrorFrame(error_str);
        error_stage.setVisible(true);
    }

}
