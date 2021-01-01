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
public class ReciptePrinter implements IRecipePrinter{    
    
    @Override
    public void printBill(String bill) {
        System.out.println(bill);
    }
    
}
