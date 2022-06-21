package sig.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import sig.model.InvoiceHeader;
import sig.model.InvoiceHeaderTableModel;
import sig.model.InvoiceLine;
import sig.view.invoiceFrame;


public class ActionHandler implements ActionListener {
    private invoiceFrame frame;
    private SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
    public ActionHandler(invoiceFrame frame){
      this.frame=frame;
   }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "new invoice":
                System.out.println("invoice added");
                createinv();
                break;
            case "delete invoice":
                System.out.println("invoice deleted");
                Deleteinv();
                break;
            case "new item":
                System.out.println("item added");
                createItem();
                break;
            case "Delete item":
                System.out.println("item deleted");
                Deleteitem();
                break;
            case "load file":
                System.out.println("file loaded");
                    loadfile();
                break;
            case "save file":
                System.out.println("file saved");
                savefile();
                break;
        }
    }

    private void createinv() {
    }

    private void Deleteinv() {
    }

    private void createItem() {
    }

    private void Deleteitem() {
    }

    private void loadfile() 
    {
        JFileChooser fileChooser=new JFileChooser();
        int result= fileChooser.showOpenDialog(frame);
        if(result==JFileChooser.APPROVE_OPTION)
           {
            try {
                File headerfile= fileChooser.getSelectedFile();
                Path headerPath= Paths.get(headerfile.getAbsolutePath());
                List<String>headerLines=Files.readAllLines(headerPath);
                ArrayList<InvoiceHeader>invoiceheaders=new ArrayList<>();
                for(String headerLine:headerLines)
                  {
                      String []arr=headerLine.split(",");
                      String str1=arr[0];
                      String str2=arr[1];    
                      String str3=arr[2];
                      int code=Integer.parseInt(str1);
                      Date invoicedate= dateFormat.parse(str2);
                      InvoiceHeader header=new InvoiceHeader(code, invoicedate, str3);
                      invoiceheaders.add(header);
                  }
                  frame.setInvoicesArray(invoiceheaders);
                  result= fileChooser.showOpenDialog(frame);
                   if(result==JFileChooser.APPROVE_OPTION)
                    {
                        File lineFile= fileChooser.getSelectedFile();
                        Path linePath= Paths.get(headerfile.getAbsolutePath());
                        List<String>lineLines=Files.readAllLines(linePath);
                        ArrayList<InvoiceLine>invoiceLines=new ArrayList<>();
                        for(String LineLine:lineLines)
                        {
                            String []arr=LineLine.split(",");
                            String str1=arr[0];
                            String str2=arr[1];    
                            String str3=arr[2];
                            String str4=arr[3];
                            int invCode=Integer.parseInt(str1);
                            double price=Double.parseDouble(str3);
                            int count=Integer.parseInt(str4);
                            InvoiceHeader inv= frame.getInvObj(invCode);
                            InvoiceLine line=new InvoiceLine(inv, str2, price, count);
                            inv.getLines().add(line);
                        }
                    }
                   InvoiceHeaderTableModel headerTableModel=new InvoiceHeaderTableModel(invoiceheaders);
                   frame.getHeaderTable().setModel(headerTableModel);
                   frame.getLineTable().setModel(headerTableModel);
                
            } catch (IOException | ParseException ex) {                
                JOptionPane.showMessageDialog(frame, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
           }
    }

private void savefile() {
        
    }
    
}
