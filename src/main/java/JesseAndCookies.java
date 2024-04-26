class Result {
    public static int cookies(int k, List<Integer> A) {
        // edge case: all items already >= k
        // edge case: sequence of 0s

        // sort list in asc order
        // check if first item <= k, else return
        // pop first two items and apply formula
        // append result, and increment count
        // Now consider using a DS that auto sorts on insertion and deletion
        int count = 0;
        while (true) {
            A.sort(null);
            int firstCookie = A.remove(0);
            if (firstCookie >= k) return count;
            int secondCookie = A.remove(1);
            if (firstCookie == secondCookie && firstCookie < k) return -1;
            int result = firstCookie + (2 * secondCookie);
            A.add(result);
            count++;
        }
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