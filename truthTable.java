import java.util.Scanner;
public class truthTable {
    private static int[] nums;

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("How many propositions do you have: ");
        int propositions = keyboard.nextInt();
        keyboard.close();
        boolean[] truthValues = new boolean[propositions];
        nums = new int[propositions];
        generateTruthTable(truthValues, propositions, 0);
    }

    private static void generateTruthTable(boolean[] truthValues, int propositions, int current) {
        if (current == propositions) {
            for (int i = 0; i < propositions; i++) {
                nums[i]++;
                System.out.printf("%d: %-5s\t", nums[i], truthValues[i]);
            }
            System.out.println();
        } else {
            truthValues[current] = true;
            generateTruthTable(truthValues, propositions, current + 1);
            truthValues[current] = false;
            generateTruthTable(truthValues, propositions, current + 1);
        }
    }
}