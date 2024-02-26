// Roan Silver      Created: December 7, 2023        Last Edits: December 7, 2023
import java.util.ArrayList;
import java.util.Collection;

public class ArrayDictionary<T> {

    // Instance Data

    private ArrayList<T> keys;
    private ArrayList<T> values;
    private int size;

    // Constructors

    public ArrayDictionary(){
        keys = new ArrayList<>();
        values = new ArrayList<>();
        size = 0;
    }

    // Methods

    public void put(T key, T value){
        keys.add(key);
        values.add(value);
        size++;
    }

    public T get(T key){
        int place = keys.indexOf(key);
        return values.get(place);
    }

    public T remove(T key){
        int place = keys.indexOf(key);
        keys.remove(place);
        T value = values.get(place);
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

    public Collection<T> keys(){
        Collection<T> c = new ArrayList();
        for (int i = 0; i < size; i++){
            c.add(keys.get(i));
        } return c;
    }

    public Collection<T> values(){
        Collection<T> c = new ArrayList();
        for (int i = 0; i < size; i++){
            c.add(values.get(i));
        } return c;
    }
}
