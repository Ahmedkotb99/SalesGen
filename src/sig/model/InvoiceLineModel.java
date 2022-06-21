
package sig.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class InvoiceLineModel extends AbstractTableModel{

    private ArrayList<InvoiceLine>linesarray;
    private String[]coulmns={"Item Name","Price","Count","Line Total"};

    public InvoiceLineModel(ArrayList<InvoiceLine> linesarray) {
        this.linesarray = linesarray;
    }
    
    @Override
    public int getRowCount() {
        return linesarray.size();
    }

    @Override
    public int getColumnCount() {
        return coulmns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceLine line=linesarray.get(rowIndex);
         switch(columnIndex){
            case 0:return line.getitem();
            case 1:return line.getPrice();
            case 2:return line.getCount();
            case 3:return line.getLineTotal();
            default: return "";
         }
                
    
   }

    @Override
    public String getColumnName(int column) {
        return coulmns[column];
    }
    
    
}
