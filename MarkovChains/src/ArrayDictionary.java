// Roan Silver      Created: December 7, 2023        Last Edits: December 7, 2023
import java.util.ArrayList;
import java.util.Collection;

public class ArrayDictionary<T> {

    // Instance Data

    private ArrayList<T> keys;
    private ArrayList<ArrayList<String>> values;
    private int size;

    // Constructors

    public ArrayDictionary(){
        keys = new ArrayList<>();
        values = new ArrayList<>();
        size = 0;
    }

    // Methods

    public void put(T key, String value){
        if (keys.contains(key)){
            values.get(keys.indexOf(key)).add(value);
        } else{
            keys.add(key);
            ArrayList<String> a = new ArrayList<>();
            a.add(value);
            values.add(a);
            size++;
        }
    }

    public ArrayList<String> get(T key){
        int place = keys.indexOf(key);
        if (place == -1){
            return null;
        } return values.get(place);
    }

    public ArrayList<String> remove(T key){
        int place = keys.indexOf(key);
        keys.remove(place);
        ArrayList<String> value = values.get(place);
        values.remove(place);
        size--;
        return value;
    }

    public boolean contains(T key){
        return keys.contains(key);
    }

    public boolean isEmpty(){
        if (size == 0)
            return true;
        return false;
    }

    public int size(){
        return size;
    }
}
