/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerystore;

import java.text.DecimalFormat;

/**
 *
 * @author Thaer
 */
public class Payment {

    private double cashMoney;
    private double customerChange;
    private double totalPrice;

    public Payment(double cashMoney, double totalPrice) {
        if (cashMoney >= totalPrice) {
            this.cashMoney = cashMoney;
            this.totalPrice = totalPrice;           
            this.customerChange = Double.parseDouble(new DecimalFormat("##.##").format(this.cashMoney - this.totalPrice));
        }
    }

    public double getCustomerChange() {
        return customerChange;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getCashMoney() {
        return cashMoney;
    }

    public void setCashMoney(double cashMoney, double totalPrice) {
        if (cashMoney >= totalPrice) {
            this.cashMoney = cashMoney;
            this.totalPrice = totalPrice;
            this.customerChange = this.cashMoney - this.totalPrice;
        } else {
            System.out.println("cash Money must be >= total product price");
        }
    }
}
