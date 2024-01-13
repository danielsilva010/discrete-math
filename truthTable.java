import java.util.Scanner;

public class truthTable {

    // Array to hold the counters for each proposition
    private static int[] nums;

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("How many propositions do you have: ");
        int propositions = keyboard.nextInt();
        keyboard.close();

        // Initialize an array to hold the truth values for each proposition
        boolean[] truthValues = new boolean[propositions];

        // Initialize the nums array with the same size as the number of propositions
        nums = new int[propositions];

        // Generate the truth table
        generateTruthTable(truthValues, propositions, 0);
    }

    // Recursive method to generate the truth table
    private static void generateTruthTable(boolean[] truthValues, int propositions, int current) {
        if (current == propositions) {
            // If we've assigned a truth value to each proposition, print the current combination
            for (int i = 0; i < propositions; i++) {
                nums[i]++;
                System.out.printf("%d: %-5s\t", nums[i], truthValues[i]);
            }
            System.out.println();
        } else {
            // Otherwise, try both true and false for the current proposition
            truthValues[current] = true;
            generateTruthTable(truthValues, propositions, current + 1);
            truthValues[current] = false;
            generateTruthTable(truthValues, propositions, current + 1);
        }
    }
}