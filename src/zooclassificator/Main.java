package zooclassificator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import zooclassificator.engine.NaiveBayes;
import zooclassificator.model.Data;
import zooclassificator.model.Pair;

public class Main {
   public static void main(String[] args) {
        try {
            Pair P = Pair.readDataSet(args[0]);
            
            if (args[1].equalsIgnoreCase("naivebayes")) {
                NaiveBayes nb = new NaiveBayes();
                if (args[2].equals("fold10"))
                    nb.ten_fold(P);
                else
                    nb.fulltraining(P);
            } else if (args[2].equalsIgnoreCase("knn")) {
                
            } else {
                System.err.println("Oops error occured..");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
