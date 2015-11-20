/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zooclassificator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import zooclassificator.model.Data;
import zooclassificator.model.Pair;


/**
 * Main app class for zoo classificator
 * @author Ahmad Naufal Farhan
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Pair P = Pair.readDataSet("Test/weather.nominal.arff");
            ArrayList<Data> AttrLib = P.getData();
            ArrayList<Data> DataSet = P.getDataSet();
            //CHECK IT OUT!!
            System.out.println(AttrLib.get(2).toString());
            System.out.println(DataSet.get(2).toString());
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
