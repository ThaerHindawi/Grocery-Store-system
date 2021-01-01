/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerystore;

import connectedDevices.deviceinput.IScale;
import connectedDevices.deviceoutput.ReciptePrinter;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Thaer
 */
public class Register {

    private static int ID;
    private final Cart cart;
    private static ArrayList<Product> listProduct;
    public final IDataManager fileManger;
    private String time;
    private String date;
    private Store store;
    private String startSaleTime;
    private final ReciptePrinter printer;

    public Register() {
        // define cart
        cart = new Cart();
        // define printer
        printer = new ReciptePrinter();
        ////////////////////////////////////////////////
        fileManger = new FileManger(); // Read and Write on txt file
        listProduct = fileManger.readData(); // read data from file
        //////////////////////////////////////////////////////  
        //////////////////////////////////////////////////////
        //////////////////////////////////////////////////////
        store = new Store();
        store.setName("Grocery Store");
        store.setAddress("JUST");
        ID++;

    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

//    public Vector addProduct(int productNumber, double qu) {
//        for (Product product : listProduct) {
//            if (product.getNumber() == productNumber) {
//                if (product.getType() == ProductType.Counted) {
//                    Vector v = cart.addItem(product, (int)qu);
//                    return v;
//                } else {
//                    Vector v = cart.addItem(product, qu);
//                    return v;
//                }
//            }
//        }
//        return null;
//    }
    public Vector addProductCounted(int productNumber, int qu) {
        for (Product product : listProduct) {
            if (product.getNumber() == productNumber) {
                if (product.getType() == ProductType.Counted) {
                    Vector v = cart.addItem(product, qu);
                    return v;
                }
            }
        }
        return null;
    }

    public Vector addProductWeighted(int productNumber, double qu) {
        for (Product product : listProduct) {
            if (product.getNumber() == productNumber) {
                if (product.getType() == ProductType.Weighted) {
                    Vector v = cart.addItem(product, qu);
                    return v;
                }
            }
        }
        return null;
    }

    public void WriteData(String date, String time) {
        this.date = date;
        this.time = time;
        fileManger.writeData(this);
    }

    public void printBill() {
        String bill = String.format("Store Name: %s \r\nAddress: %s \r\n", getStore().getName(), getStore().getAddress());
        bill += "Bill ID: " + ID + "\n";
        bill += String.format("Date: %s \r\nTime: %s \r\n", getDate(), getTime());
        bill += "Totle price: " + getCart().getTotal() + "\r\n";//
        bill += "Payment Cash Money: " + getCart().getPayment().getCashMoney() + "\r\n";
        bill += "Customer Change: " + getCart().getPayment().getCustomerChange() + "\r\n";
        bill += "____________________\r\n";
        bill += String.format("%20s %20s %20s %20s %20s", "Number", "Name", "Price", "Count/Weight", "Sub Total");
        bill += "\r\n";
        for (PurchaseItem item : getCart().getItems()) {
            Vector<Product> vProdcut = item.allData();
            bill += String.format("%20s %20s %20s %20s %20s", vProdcut.elementAt(0), vProdcut.elementAt(1), vProdcut.elementAt(2),
                    vProdcut.elementAt(3), vProdcut.elementAt(4));
            bill += "\r\n____________________\r\n";
        }
        bill += "########################################################################";
        printer.printBill(bill);
    }

    public Cart getCart() {
        return cart;
    }

    public boolean makePayment(double money) {
        if (money >= cart.getTotal()) {
            cart.makePayment(money);
            return true;
        }
        return false;
    }

    public int getID() {
        return ID;
    }

    public String getStartSaleTime() {
        return startSaleTime;
    }

    public void setStartSaleTime(String startSaleTime) {
        this.startSaleTime = startSaleTime;
    }
    
    

}
