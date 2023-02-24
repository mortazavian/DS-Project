import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



//        Restaurant restaurant1 = new Restaurant("javad",23);
//        Restaurant restaurant2 = new Restaurant("sajad",23);
//        Restaurant restaurant3 = new Restaurant("navid",23);
//        Restaurant restaurant4 = new Restaurant("mehdi",23);
//        Restaurant restaurant5 = new Restaurant("taha",23);
//
//        Stack stack = new Stack(10);
//
//        stack.push(restaurant1);
//        stack.push(restaurant2);
//        stack.push(restaurant3);
//        stack.push(restaurant4);
//        stack.push(restaurant5);
//
//        stack.printStack();





        Trie trie = new Trie();


        // Get the number of inputs
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();
        scanner.nextLine();

        // Loop to get inputs from user
        for (int i = 0; i < userInput; i++) {
            String information = scanner.nextLine();
            String[] split = information.split("\\s+");
            Restaurant restaurant = new Restaurant(split[0], Integer.parseInt(split[1]));
            Restaurant.restaurants.add(restaurant);
        }

        MinHeap minHeap = new MinHeap(userInput);
//        MaxHeap maxHeap = new MaxHeap(userInput);
        Stack stack = new Stack(userInput);
        for (int i = 0; i < Restaurant.restaurants.size(); i++) {
            minHeap.insert(Restaurant.restaurants.get(i));
        }
//        minHeap.print();


        // Get number of outputs
        int numberOfOutputs = scanner.nextInt();
        scanner.nextLine();

        // Loop to get outputs from user
        for (int i = 0; i < numberOfOutputs; i++) {
            String input = scanner.nextLine();
            String[] split = input.split("\\s+");
            Output output = new Output(Integer.parseInt(split[0]), split[1]);
            Output.outputs.add(output);
        }

        // Answering to each output
//        ArrayList<Restaurant> maxHeap = new ArrayList<>();
        for (int i = 0; i < Output.outputs.size(); i++) {
            Output output = new Output(Output.outputs.get(i).number, Output.outputs.get(i).name);


            if (stack.getSize() < output.number) {
                int size = stack.getSize();
                for (int j = 0; j < output.number - size; j++) {
                    if (minHeap.size() != 0) {
                        Restaurant restaurant = minHeap.remove();
                        stack.push(restaurant);
                        trie.insert(restaurant.name);
                    }
                }
            } else {
                int size = stack.getSize();
                for (int j = 0; j < size - output.number; j++) {
                    if (stack.getSize() != 0) {
                        Restaurant restaurant = stack.pop();
                        minHeap.insert(restaurant);
                        trie.removeTrie(Trie.trieroot, restaurant.name, 0);
                    }
                }
            }


            // Define Trie

            // Put all the close restaurant in trie

            trie.searchTrie(output.name);

        }

//        System.out.println(maxHeap);

//        for (int i = 0; i < maxHeap.size(); i++) {
//            System.out.println("Name: " + maxHeap.get(i).name);
//            System.out.println("Distance: " + maxHeap.get(i).distance);
//        }

    }
}