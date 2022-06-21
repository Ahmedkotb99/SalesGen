
package sig.controller;

import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import sig.model.InvoiceHeader;
import sig.model.InvoiceLine;
import sig.model.InvoiceLineModel;
import sig.view.invoiceFrame;

public class InvoiceSelectionListner implements ListSelectionListener{
    
    private invoiceFrame frame;

    public InvoiceSelectionListner(invoiceFrame frame) {
        this.frame = frame;
    }
    
    
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedIndex=frame.getHeaderTable().getSelectedRow();
        System.out.println("Invoice selected"+frame.getHeaderTable().getSelectedRow());
        InvoiceHeader selectedINV= frame.getInvoicesArray().get(selectedIndex);
        ArrayList<InvoiceLine>lines=selectedINV.getLines();
        InvoiceLineModel invoiceLineModel=new InvoiceLineModel(lines);
        frame.getHeaderTable().setModel(invoiceLineModel); 
        frame.getCustomerlabel().setText(selectedINV.getCustomer());
        frame.getNumVarLabel().setText(""+selectedINV.getNum());
        frame.getTotalVarLabel().setText(""+selectedINV.getInvoiceTotal());
        frame.getDateLabel().setText(selectedINV.getDate().toString());
        
    }
    
}
