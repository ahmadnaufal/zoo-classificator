/*
 * PAIR USED TO SAVE ATTRIBUTE COLLECTION AND DATA COLLECTION
 */
package zooclassificator.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pair {
    ArrayList<Data> AttrLib;
    ArrayList<Data> DataSet;

    public Pair(ArrayList<Data> AttrLib, ArrayList<Data> DataSet) {
        this.AttrLib = AttrLib;
        this.DataSet = DataSet;
    }   

    public ArrayList<Data> getAttrLib() {
        return AttrLib;
    }    

    public ArrayList<Data> getDataSet() {
        return DataSet;
    }
    
    static public Data makeAttr(String codex) {
    //Mengambil elemen nama dan anggota attribute dengan regex
        Pattern ptr = Pattern.compile("\\w+");
        Matcher mtc = ptr.matcher(codex);
        ArrayList<String> elmts = new ArrayList<>(); 
        mtc.find(); mtc.find();
        String name = mtc.group();
        while(mtc.find())
            elmts.add(mtc.group());
        Data data = new Data(name,elmts);
        return data;
    }
    
    static public Pair readDataSet(String url) throws FileNotFoundException, IOException {
    //Mengambil Data Collection dan Data Collection dengan regex
        String line; Pattern ptr; Matcher mtc;
        ArrayList<Data> AttrLib = new ArrayList<>(); 
        ArrayList<Data> DataSet = new ArrayList<>();
        boolean attrFlag = true; 
        int id=0;
        try (BufferedReader br = new BufferedReader(new FileReader(url))) {
            while((line = br.readLine()) != null) {
                if(line.equals("@data")) 
                    attrFlag = false;
                else if(attrFlag) {
                    ptr = Pattern.compile("@attr");
                    mtc = ptr.matcher(line);
                    if(mtc.find())
                        AttrLib.add(makeAttr(line));
                } else {
                    ptr = Pattern.compile("\\w+");
                    mtc = ptr.matcher(line);
                    String find = "";
                    ArrayList<String> L = new ArrayList<>();
                    while(mtc.find())
                        L.add(mtc.group());
                    id += 1;
                    String sid = "data" + id;
                    Data dt = new Data(sid,L);
                    DataSet.add(dt);
                }
            }	
	   }
        return new Pair(AttrLib,DataSet);
    } 
    
}
