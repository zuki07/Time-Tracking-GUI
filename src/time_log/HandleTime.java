



package time_log;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.Timer;


public class HandleTime extends SqlConnection{
    static String start_date, end_date, start_str, end_str, duration_str, total_str;
    private LocalTime time_start, time_end, time_duration;
    private int duration_hr, duration_min; 
    Timer timer_array[]=new Timer[5];
    int count=0;
    boolean timer_running=false;
    
    public void startDate(){
        LocalDate date_now=LocalDate.now();
        DateTimeFormatter formater=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        start_date=formater.format(date_now);
    }
    
    public String getDate(){
        return start_date;
    }
    
    public void endDate(){
        LocalDate date_now=LocalDate.now();
        DateTimeFormatter formater=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        end_date=formater.format(date_now);
    }
    
    public void timeStart(){
        this.time_start=LocalTime.now();
        int start_hr=time_start.getHour();
        int start_min=time_start.getMinute();
        if(start_min<10){
            start_str=start_hr+":0"+start_min;
        }
        else{
            start_str=start_hr+":"+start_min;
        }
    }
    
    public String getTimeStart(){
        return start_str;
    }
    
    public void timeEnd(){
        this.time_end=LocalTime.now();
        int end_hr=time_end.getHour();
        int end_min=time_end.getMinute();
        if(end_min<10){
            end_str=end_hr+":0"+end_min;
        }
        else{
            end_str=end_hr+":"+end_min;
        }
    }
    
    public String getTimeEnd(){
        return end_str;
    }
    
    public void timeDuration(){
        this.time_duration=time_end.minusHours(time_start.getHour()).minusMinutes(time_start.getMinute());
        duration_hr=time_duration.getHour();
        duration_min=time_duration.getMinute();
        duration_str=duration_hr+":"+duration_min;
    }
    
    public String getDuration(){
        return duration_str;
    }
    
    public void totalTime(DML dml) throws SQLException{
        String total_time=dml.getTotalTime();
        if(total_time.compareTo("")!=0){
            String [] tokens=total_time.split(":");
            int total_hr=duration_hr+Integer.parseInt(tokens[0]);
            int total_min=duration_min+Integer.parseInt(tokens[1]);
            if(total_min>=60){
                total_hr++;
                total_min=total_min-60;
            }
            total_str=String.format("%s:%s",total_hr,total_min);
        }
        else{
            total_str=String.format("%s:%s",this.duration_hr,this.duration_min);
        }
        dml.setTotalTime(total_str);
    }
    
    public String getTotalTime(){
        return total_str;
    }
}
