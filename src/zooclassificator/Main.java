package zooclassificator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import zooclassificator.model.Attribute;
import zooclassificator.model.Data;
import zooclassificator.model.Pair;

public class Main {
    static public Attribute makeAttr(String codex) {
    //Mengambil elemen nama dan anggota attribute dengan regex
        Pattern ptr = Pattern.compile("([a-z])\\w+");
        Matcher mtc = ptr.matcher(codex);
        ArrayList<String> elmts = new ArrayList<>(); 
        mtc.find(); mtc.find();
        String name = mtc.group();
        while(mtc.find())
            elmts.add(mtc.group());
        Attribute atr = new Attribute(name,elmts);
        return atr;
    }
    static Pair readDataSet(String url) throws FileNotFoundException, IOException {
    //Mengambil Attribute Collection dan Data Collection dengan regex
        String line; Pattern ptr; Matcher mtc;
        ArrayList<Attribute> AttrLib = new ArrayList<>(); 
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
                    ptr = Pattern.compile("([a-z])\\w+");
                    mtc = ptr.matcher(line);
                    String find = "";
                    ArrayList<String> L = new ArrayList<>();
                    while(mtc.find())
                        L.add(mtc.group());
                    id += 1;
                    Data dt = new Data(L);
                    DataSet.add(dt);
                }
            }	
	}
        return new Pair(AttrLib,DataSet);
    } 
    
    public static void main(String[] args) {
        try {
            Pair P = readDataSet("Test/weather.nominal.arff");
            ArrayList<Attribute> AttrLib = P.getAttrs();
            ArrayList<Data> DataSet = P.getDataSet();
            //CHECK IT OUT!!
            System.out.println(AttrLib.get(0).toString());
            System.out.println(DataSet.get(0).toString());
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
