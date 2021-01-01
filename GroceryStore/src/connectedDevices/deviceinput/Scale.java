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
public class Scale implements IScale {

    private double weight;

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void MeasureWeight(double weight) {
        this.weight = weight;
    }

}
