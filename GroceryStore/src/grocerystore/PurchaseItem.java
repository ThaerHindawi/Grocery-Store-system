/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerystore;

import java.text.DecimalFormat;
import java.util.Vector;

/**
 *
 * @author Thaer
 */
public class PurchaseItem {

    private double quantity = 1;
    private Product product;

    public PurchaseItem(Product product, double quantity) {
        this.quantity = quantity;
        this.product = product;
    }

    public double getSubtotal() {
        return Double.parseDouble(new DecimalFormat("##.##").format(product.getPrice() * quantity));
    } 
    
     public Vector allData() {
        Vector v= new Vector();
        v.add(product.getNumber());
        v.add(product.getName());
        v.add(product.getPrice());        
        v.add(quantity);
        v.add(getSubtotal());
        return v;
    }
}
