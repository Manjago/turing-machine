import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int x = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String start = in.nextLine();
        int n = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < n; i++) {
            String stateActions = in.nextLine();
        }

        System.out.println("answer");
    }
}

class Turing {
    private final Map<String, List<Instruction>> instructions = new HashMap<>();

    private record Instruction(int symbolToWrite, boolean moveLeft, String nextState) {
    }
}