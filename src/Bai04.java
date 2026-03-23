import java.util.*;

public class Bai04 {
    static List<Integer> numbers = new ArrayList<>();
    static List<Integer> subsequence = new ArrayList<>();
    static List<Integer> bestSubsequence = new ArrayList<>();
    static void findMaxSubsequence(int currentSum, int currentIndex) {
        if (currentSum == 0) {
            if (subsequence.size() > bestSubsequence.size()) {
                bestSubsequence = new ArrayList<>(subsequence);
            }
            return;
        }
        for (int idx = currentIndex; idx < numbers.size(); idx++) {
            int currentNumber = numbers.get(idx);
            if (currentSum - currentNumber < 0) {
                continue;
            }
            subsequence.add(currentNumber);
            findMaxSubsequence(currentSum - currentNumber, idx + 1);
            subsequence.remove(subsequence.size() - 1);
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            if (!sc.hasNextInt()) return;
            int n = sc.nextInt();
            int k = sc.nextInt();
            for (int i = 0; i < n; i++) {
                numbers.add(sc.nextInt());
            }
            findMaxSubsequence(k, 0);
            for (int i = 0; i < bestSubsequence.size(); i++) {
                System.out.print(bestSubsequence.get(i) + (i == bestSubsequence.size() - 1 ? "" : ","));
            }
            System.out.println();
        }
    }
}