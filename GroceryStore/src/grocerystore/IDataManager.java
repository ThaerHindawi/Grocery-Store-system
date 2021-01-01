/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerystore;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thaer
 */
public interface IDataManager {
    public ArrayList<Product> readData();
    public void writeData(Register register);
}
