
package TablaModel;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class RendererTablaUsuario extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        if(column == 0){
            setHorizontalAlignment(SwingConstants.CENTER);
        }else{
            setHorizontalAlignment(CENTER);
        }
    
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
    }
    
}
