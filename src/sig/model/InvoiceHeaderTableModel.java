
package sig.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class InvoiceHeaderTableModel extends AbstractTableModel {

    private ArrayList<InvoiceHeader>invoicesArray;

    public InvoiceHeaderTableModel(ArrayList<InvoiceHeader> invoicesArray) {
        this.invoicesArray = invoicesArray;
    }
    
    
    @Override
    public int getRowCount() {
        return invoicesArray.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       InvoiceHeader inv=invoicesArray.get(rowIndex);
       switch(columnIndex)
        {
           case 0:return inv.getNum();
           case 1:return  inv.getDate();
           case 2: return inv.getCustomer();
           case 3: return inv.getInvoiceTotal();
        }
       return "";
    }

    @Override
    public String getColumnName(int column) {
        switch(column)
        {
            case 0:return "Invoice Num";
            case 1:return "Invoice Date";
            case 2:return "Customer Name";

        }
        return "";

        
    }
    
}
