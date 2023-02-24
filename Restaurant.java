import java.util.ArrayList;
import java.util.HashMap;

public class Restaurant {
    String name;
    int distance;

    public Restaurant(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

//    static HashMap<String, Integer> restaurants = new HashMap<String, Integer>();

    static ArrayList<Restaurant> restaurants = new ArrayList<>();


    static void printAllRestaurant() {
        for (int i = 0; i < restaurants.size(); i++) {
            System.out.println("---------------------------");
            System.out.println("Index " + i);
            System.out.println("The name: " + restaurants.get(i).name);
            System.out.println("The distance: " + restaurants.get(i).distance);
            System.out.println("---------------------------");
        }
    }

}

