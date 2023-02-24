import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Output {

    int number;
    String name;

    public Output(int number, String name) {
        this.number = number;
        this.name = name;
    }

//    static HashMap<Integer,String> outputs = new HashMap<>();
    static ArrayList<Output> outputs = new ArrayList<>();

    static void printAllOutputs(){
        for (int i = 0; i < outputs.size(); i++) {
            System.out.println("---------------------------");
            System.out.println("Index " + i);
            System.out.println("The number of close restaurant: " + outputs.get(i).number);
            System.out.println("The prefix: " + outputs.get(i).name);
            System.out.println("---------------------------");
        }
    }
}
