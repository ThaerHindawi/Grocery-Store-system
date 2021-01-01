/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectedDevices.deviceoutput;

/**
 *
 * @author Thaer
 */
public class MainTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IDrawer drawer = new Drawer();
        drawer.open();
        drawer.close();
        IRecipePrinter printer = new ReciptePrinter();
        printer.printBill("bill printed");
    }
    
}
