package zooclassificator;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import zooclassificator.engine.KNearest;
import zooclassificator.engine.NaiveBayes;
import zooclassificator.model.Data;
import zooclassificator.model.Pair;

public class Main {
   public static void main(String[] args) {
//        try {
//            Pair P = Pair.readDataSet(args[0]);
//            
//            if (args[1].equalsIgnoreCase("naivebayes")) {
//                NaiveBayes nb = new NaiveBayes();
//                if (args[2].equals("fold10"))
//                    nb.ten_fold(P);
//                else
//                    nb.fulltraining(P);
//            } else if (args[1].equalsIgnoreCase("knn")) {
//                int k = Integer.parseInt(args[2]);
//                KNearest knn = new KNearest(k);
//                if (args[3].equals("fold10"))
//                    knn.tenFold(P);
//                else
//                    knn.FullTraining(P);
//            } else {
//                System.err.println("Oops error occurred..");
//            }
//            
//        } catch (IOException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
