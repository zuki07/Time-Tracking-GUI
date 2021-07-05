  



package time_log;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;


public class TableMouseListener extends MouseAdapter{

    private final JTable table;
    private final Time_log time_log_stage;
    private String  project_name;
    private ViewProjectFrame project_stage;
    
    
    public TableMouseListener(JTable table, Time_log stage){
        this.table=table;
        this.time_log_stage=stage;
        this.project_stage=new ViewProjectFrame(time_log_stage, time_log_stage.dml);
    }
    
    @Override
    public void mouseClicked(MouseEvent event){
        Point point=event.getPoint();
        int row=table.rowAtPoint(point);
        int column=table.columnAtPoint(point);
        if(column==1){
            this.project_name=table.getValueAt(row, 0).toString().toLowerCase();
            project_stage.setProjectName(this.project_name);
            time_log_stage.setVisible(false);
            project_stage.setVisible(true);
        }

    }
}
