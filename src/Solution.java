import java.util.*;
import java.io.*;
import java.math.*;
import java.util.stream.Collectors;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        final Turing solver = new Turing();

        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        solver.tape = new int[t];
        int x = in.nextInt();
        solver.pos = x;
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String start = in.nextLine();
        solver.state = start;
        int n = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < n; i++) {
            String stateActions = in.nextLine();
            final String[] byDv = stateActions.split(":");
            final ArrayList<Turing.Instruction> instructionArrayList = new ArrayList<>();
            solver.instructions.put(byDv[0], instructionArrayList);
            final String[] bySemicolon = byDv[1].split(";");
            Arrays.stream(bySemicolon).sequential().forEach(it -> {
                final String[] tokens = it.split(" ");
                instructionArrayList.add(new Turing.Instruction(Integer.parseInt(tokens[0]), "L".equals(tokens[1]), tokens[2]));
            });
        }

        solver.run();
        System.out.println(solver.counter);
        System.out.println(solver.pos);
        System.out.println(Arrays.stream(solver.tape)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("")));
    }
}

class Turing {
    final Map<String, List<Instruction>> instructions = new HashMap<>();
    String state;
    int[] tape;
    int pos;
    int counter = 0;

    record Instruction(int symbolToWrite, boolean moveLeft, String nextState) {
    }

    void run() {


        while(true) {
            ++counter;
            int currSymbol = tape[pos];
            Instruction instruction = instructions.get(state).get(currSymbol);
            tape[pos] = instruction.symbolToWrite;
            int newPos = pos;
            if (instruction.moveLeft) {
                --newPos;
            } else {
                ++newPos;
            }
            if (newPos < 0 || newPos >= tape.length) {
                return;
            }
            pos = newPos;

            if (instruction.nextState.equals("HALT")) {
                return;
            }

            state = instruction.nextState;
        }

    }
}