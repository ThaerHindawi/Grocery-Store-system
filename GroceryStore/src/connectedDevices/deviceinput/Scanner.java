/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectedDevices.deviceinput;

/**
 *
 * @author Discovery
 */
public class Scanner implements IScanner{

    private int number;
    @Override
    public void scan(int number) {
        this.number = number;
    }

    @Override
    public int getNumber() {
        return number;
    }
    
}
