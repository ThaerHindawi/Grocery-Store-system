/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerystore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thaer
 */
public class FileManger implements IDataManager {

    // public static String filePath;
    private ArrayList<Product> listProduct = new ArrayList<>();
    private final String path = "FilesData\\products.txt";

    @Override
    public ArrayList<Product> readData() {
        File file = new File(path);

        BufferedReader br;
        String data = "";
        try {
            br = new BufferedReader(new FileReader(file));
            while ((data = br.readLine()) != null) {

                String[] arrStr = data.trim().split("\\s+");
                if (arrStr[0].toLowerCase().contains("name")
                        && arrStr[2].toLowerCase().contains("number")
                        && (arrStr[4].toLowerCase().contains("count")
                        || arrStr[4].toLowerCase().contains("wight")
                        || arrStr[4].toLowerCase().contains("weight"))
                        && arrStr[6].toLowerCase().contains("price")) {
                    Product p;
                    if (arrStr[4].toLowerCase().contains("count")) {
                        p = new Product(arrStr[1], Integer.parseInt(arrStr[3]),
                                Double.parseDouble(arrStr[7]),
                                Double.parseDouble(arrStr[5]), ProductType.Counted);
                    } else {
                        p = new Product(arrStr[1], Integer.parseInt(arrStr[3]),
                                Double.parseDouble(arrStr[7]),
                                Double.parseDouble(arrStr[5]), ProductType.Weighted);
                    }
                    listProduct.add(p);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManger.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileManger.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listProduct;
    }

    @Override
    public void writeData(Register register) {
        if (!register.getCart().getItems().isEmpty()) {
            BufferedWriter writer = null;
            Formatter formatter = new Formatter();
            try {
                writer = new BufferedWriter(new FileWriter("FilesData\\log.txt", true));
                writer.append(String.format("Store Name: %s \r\nAddress: %s \r\n", register.getStore().getName(), register.getStore().getAddress()));
                writer.append("Bill ID: " + register.getID() + "\r\n");
                writer.append("StartSaleTime: " + register.getStartSaleTime() + "\r\n");                
                writer.append(String.format("Date End: %s \r\nTime End: %s \r\n", register.getDate(), register.getTime()));
                writer.append("Totle price: " + register.getCart().getTotal() + "\r\n");
                writer.append("Payment Cash Money: " + register.getCart().getPayment().getCashMoney() + "\r\n");
                writer.append("Customer Change: " + register.getCart().getPayment().getCustomerChange() + "\r\n");
                writer.append("_______________________\r\n \r\n");
                writer.append(formatter.format("%20s %20s %20s %20s %20s", "Number", "Name", "Price", "Count/Weight", "Sub Total").toString());
                writer.append("\r\n");
                for (PurchaseItem item : register.getCart().getItems()) {
                    formatter = new Formatter();
                    Vector<Product> vProdcut = item.allData();
                    writer.append(formatter.format("%20s %20s %20s %20s %20s", vProdcut.elementAt(0),
                            vProdcut.elementAt(1), vProdcut.elementAt(2),
                            vProdcut.elementAt(3), vProdcut.elementAt(4)).toString());
                    writer.append("\r\n____________________\r\n");
                }
                for (int i = 0; i < 10; i++) {
                    writer.append("########################");
                    if (i == 4) {
                        writer.append("\r\n");
                    }
                    if (i == 9) {
                        writer.append("\r\n");
                    }
                }
                writer.append("\r\n");
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(FileManger.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    writer.close();
                } catch (IOException ex) {
                    Logger.getLogger(FileManger.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
