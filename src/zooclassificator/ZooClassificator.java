/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zooclassificator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ahmad Naufal Farhan
 */
public class ZooClassificator {
    
    private List<List<String> > data;
    private int numRows;
    private int numAttributes;
    
    public ZooClassificator(String filename) {
        data = new ArrayList<>();
        File file = new File(filename);
        
        try {
            Scanner sc = new Scanner(file);
            
            while (sc.hasNextLine()) {
                String buf = sc.nextLine();
                data.add(Arrays.asList(buf.split(",")));
            }
            
            sc.close();
            
            // set the number of rows and the attributes
            numRows = data.size();
            numAttributes = data.get(0).size();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ZooClassificator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * @return the data
     */
    public List<List<String> > getData() {
        return data;
    }

    /**
     * @return the numRows
     */
    public int getNumRows() {
        return numRows;
    }

    /**
     * @return the numAttributes
     */
    public int getNumAttributes() {
        return numAttributes;
    }
    
    
}
