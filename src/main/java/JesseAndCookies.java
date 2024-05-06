package src.main.java;

import java.io.*;
import java.util.*;

class Result {
    public static int cookies(int k, List<Integer> A) {
        // edge case: all items already >= k

        // sort list in desc order
        // check if last item <= k and return count, else:
        // pop first two items and apply formula
        // append result into separate list to avoid resorting
        // increment count
        // if set only has one item, and the item < k return -1
        // this separate list, is a queue :)

        int count = 0;
        Queue<Integer> B = new LinkedList<>();

        A.sort(Collections.reverseOrder());

        while (!A.isEmpty() || !B.isEmpty()) {
            int leastSweetCookie = getMinimum(A, B);

            if (leastSweetCookie >= k) break;

            if (A.size() + B.size() == 0 && leastSweetCookie < k) return -1;

            int secondLeastSweetCookie = getMinimum(A, B);
            int newCookie = leastSweetCookie + (2 * secondLeastSweetCookie);
            B.add(newCookie);
            count++;
        }

        return count;
    }

    private static int getMinimum(List<Integer> A, Queue<Integer> B) {
        int listASize = A.size();
        int listBSize = B.size();
        int min = 0;
        if (listASize > 0) {
            if(listBSize > 0) {
                int minA = A.get(listASize - 1);
                long minB = B.peek();
                if (minA <= minB) min = A.remove(listASize - 1); else min = B.remove();
            } else {
                min = A.remove(listASize - 1);
            }
        } else min = B.remove();
        return min;
    }
}

public class JesseAndCookies {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int k = input.nextInt();

        List<Integer> A = new ArrayList<>(size);
        while (A.size() < size) {
            A.add(input.nextInt());
        }

        System.out.println(Result.cookies(k, A));
    }
}