/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerystore;

import java.util.Vector;
import javax.swing.JTextArea;

/**
 *
 * @author Thaer
 */
public class Controller {

    private static Register register = new Register();
//    public Controller() {
//        register = new Register();
//    }
//    private static Object lock = new Object();
//    private static Controller instance; 
//    
//    public static Controller getInstance() {
//        if(instance == null) {
//            synchronized(lock) {
//                if(instance == null) {
//                    instance = new Controller();
//                }
//            }
//        }
//        return instance;
//    }

    public static void makeNewRegister() {
        register = new Register();        
    }

    public static double getTotal() {
        return register.getCart().getTotal();
    }

    public static void printBill() {
        register.printBill();
    }

    public static void WriteData(String date, String time) {
        register.WriteData(date, time);
    }

    public static Cart getCart() {
        return register.getCart();
    }

    public static double getCustomerChange() {
        return register.getCart().getPayment().getCustomerChange();
    }

    public static boolean makePayment(double money) {
        return register.makePayment(money);
    }

    public static boolean isCartEmpty() {
        return register.getCart().getItems().isEmpty();
    }

    public static void removeItem(int index) {
        register.getCart().removeItem(index);
    }

    public static Vector addProductWeighted(int productNumber, double qu) {
        return register.addProductWeighted(productNumber, qu);
    }

    public static Vector addProductCounted(int productNumber, int qu) {
        return register.addProductCounted(productNumber, qu);
    }

    public static String getStoreName() {
        return register.getStore().getName();
    }

    public static String getStoreAddress() {
        return register.getStore().getAddress();
    }
    
    public static void startSaleTime(String time) {
        register.setStartSaleTime(time);
    }
}
