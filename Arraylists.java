package WorkingOut;

import java.lang.reflect.Array;
import java.util.ArrayList;
public class Arraylists {

    void method(String name, int age) {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        Arraylists ob = new Arraylists();
        ArrayList<Arraylists> obList = new ArrayList<>();
        obList.add(ob);
        ob.method("Ragul", 21);
        System.out.println("Size of the ObjectList: " + obList.size());
        ArrayList<String> names = new ArrayList<>();
        names.add("Ragul");
        names.add("Raguraman");
        System.out.println("Size of the List : " + names.size());
        names.remove(0);
        System.out.println("Size after removal : " + names.size());
        names.set(0, "Ragul Raguraman");
        System.out.println("Accessing the elements : " + names.get(0));
        System.out.println("Retreiving the index value : " + names.indexOf("Ragul Raguraman"));
        System.out.println("Checking if 'names' contains a specific element : " + names.contains("Ragul Raguraman"));
        names.clear();
        System.out.println("Size of the list after clearing all the elements : " + names.size());
    }
}