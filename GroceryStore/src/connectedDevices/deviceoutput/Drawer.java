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
public class Drawer implements IDrawer{

    @Override
    public void open() {
        System.out.println("Drawer Open");
    }

    @Override
    public void close() {
        System.out.println("Drawer Close");
    }  
    
}
