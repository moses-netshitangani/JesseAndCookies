package src.main.java;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {
    public static int cookies(int k, List<Integer> A) {
        // edge case: all items already >= k
        // edge case: sequence of 0s

        // sort list in asc order
        // check if first item <= k, else return
        // pop first two items and apply formula
        // append result, and increment count
        // Now consider using a DS that auto sorts on insertion and deletion - TreeMap

        // if set is empty while list isn't, add to set.
        // if set only has one item, and the item < k return -1
        // sort the set, and remove the first two items from both
        // apply formula, and add the result to both
        // increment

        // consider storing new values in a new list instead of resorting the old one every time
        // do a check to see if the minimum exists in that list too
        // while loop should check that both lists not empty

        int count = 0;
        List<Integer> B = new ArrayList<>();
        A.sort(Collections.reverseOrder());

        while (!A.isEmpty() || !B.isEmpty()) {
            int listSize = A.size();
            if (A.get(listSize - 1) >= k) break;

            if (A.size() == 1 && A.get(0) < k) return -1;

            int leastSweetCookie = A.remove(listSize - 1);
            int secondLeastSweetCookie = A.remove(listSize - 2);

            int newCookie = leastSweetCookie + (2 * secondLeastSweetCookie);

            B.add(newCookie);

            count++;
        }

        return count;
    }
}

public class JesseAndCookies {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}