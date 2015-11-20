package zooclassificator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import zooclassificator.model.Data;
import zooclassificator.model.Pair;

public class Main {
   public static void main(String[] args) {
        try {
            Pair P = Pair.readDataSet("Test/weather.nominal.arff");
            ArrayList<Data> AttrLib = P.getAttrLib();
            ArrayList<Data> DataSet = P.getDataSet();
            //CHECK IT OUT!!
            System.out.println(AttrLib.get(2).toString());
            System.out.println(DataSet.get(2).getAttributes().size());
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
