/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerystore;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Thaer
 */
public class Cart {

    private List<PurchaseItem> Items = new ArrayList();
   // private Date date = new Date();// check this
   // private boolean isComplete = false;
    private Payment payment;
//    private Calendar calendar = Calendar.getInstance(); // check this

//    public void becomeComplete() {
//        isComplete = true;
//    }
///////////////////////////////////

//    public boolean isComplete() {
//        return isComplete;
//    }
//////////////////////////////////////////////

    public Vector addItem(Product item, double quantity) {
        PurchaseItem pur = new PurchaseItem(item, quantity);
        synchronized (Items) {
            Items.add(pur);
        }
        return pur.allData();
    }
//////////////////////////////////////////

    public double getTotal() {
        double total = 0;
        synchronized (Items) {
            for (PurchaseItem lineltem : Items) {
                total += lineltem.getSubtotal();
            }
            return Double.parseDouble(new DecimalFormat("##.##").format(total));
        }
    }
/////////////////////////////////////////

    public void removeItem(int index) {
        synchronized (Items) {
            Items.remove(index);
        }
    }
/////////////////////////////////////////

    public void makePayment(double cash) {
        if (cash >= getTotal()) {
            payment = new Payment(cash, getTotal());
        } else {
            System.out.println("cash Money must be >= total product price");
        }
    }

    /////////////////////////////////////
//    public Calendar getCalendar() {
//        return calendar;
//    }
//
//    public void setCalendar(Calendar calendar) {
//        this.calendar = calendar;
//    }

    ////////////////////////////////////////
    public List<PurchaseItem> getItems() {
        return Items;
    }

    ///////////////////////////////////////
    public Payment getPayment() {
        return payment;
    }

}
