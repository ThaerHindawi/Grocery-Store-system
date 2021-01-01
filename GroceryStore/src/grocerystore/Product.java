/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerystore;


/**
 *
 * @author Thaer
 */
public class Product {
    
    ProductType Type;
    private String name;
    private int number;
    private double price;
    private double quantity;
    public Product(String name, int number, double price, double quantity) {
        this.name = name;
        this.number = number;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(String name, int number, double price, double quantity, ProductType Type) {
        this.Type = Type;
        this.name = name;
        this.number = number;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price * quantity;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }   

    public ProductType getType() {
        return Type;
    }

    public void setType(ProductType Type) {
        this.Type = Type;
    }
    
    
}
