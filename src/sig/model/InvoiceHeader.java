 
package sig.model;

import java.util.ArrayList;
import java.util.Date;


public class InvoiceHeader {
    private int num;
    private String customer;
    private Date date;
    private ArrayList<InvoiceLine>lines;

    public InvoiceHeader(int num, Date date, String customer) {
        this.num = num;
        this.customer = customer;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public ArrayList<InvoiceLine> getLines() {
        if(lines==null)
        {
            lines=new ArrayList<>();
        }
        return lines;
    }

    public void setLines(ArrayList<InvoiceLine> lines) {
        this.lines = lines;
    }
    public double getInvoiceTotal()
    {
        double total =0.0;
        for(int i=0;i<lines.size();i++)
        {
            
        }
        return total;
    }

    @Override
    public String toString() {
        return "InvoiceHeader{" + "num=" + num + ", customer=" + customer + ", date=" + date + '}';
    }
    
}
