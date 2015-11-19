/*
 * PAIR USED TO SAVE ATTRIBUTE COLLECTION AND DATA COLLECTION
 */
package zooclassificator.model;

import java.util.ArrayList;
public class Pair {
    ArrayList<Attribute> Attrs;
    ArrayList<Data> DataSet;

    public Pair(ArrayList<Attribute> Attrs, ArrayList<Data> DataSet) {
        this.Attrs = Attrs;
        this.DataSet = DataSet;
    }

    public ArrayList<Attribute> getAttrs() {
        return Attrs;
    }

    public ArrayList<Data> getDataSet() {
        return DataSet;
    }
    
}
