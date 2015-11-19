package zooclassificator.model;

import java.util.ArrayList;
public class Attribute {
    String name;
    ArrayList<String> elmts;
    public Attribute(String name, ArrayList<String> elmts) {
        this.name = name;
        this.elmts = elmts;
    }

    @Override
    public String toString() {
        return "Attribute{" + "name=" + name + ", elmts=" + elmts + '}';
    }
    
}
