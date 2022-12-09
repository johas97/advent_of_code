import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class dec_5 {

  /**
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    // Enter data using BufferReader

    File file = new File("input.txt");

    BufferedReader reader = new BufferedReader(new FileReader(file));
    // Reading data using readLine
    String line;

    line = reader.readLine();
    // array of stacks
    final int ant_stack = 9;
    final int space_next_stack = 4;
    ArrayList<Stack<Character>> all_stacks = new ArrayList<>(ant_stack);

    int letter_pos = 1;

    for (int i = 0; i < ant_stack; i++) {
      all_stacks.add(new Stack<>());
    }

    while (!line.contains("1")) {
      // Per read line, place via charAt() in appropriate stack

      for (int i = 0; i < ant_stack; i++) {
        if (line.charAt(letter_pos) != ' ') {
          all_stacks.get(i).add(line.charAt(letter_pos));
        }
        letter_pos += space_next_stack;
      }
      letter_pos = 1;
      line = reader.readLine();
    }

    // reverse stacks

    for (int i = 0; i < ant_stack; i++) {
      reverse(all_stacks.get(i));
    }

    // read and preform operation on stacks
    line = reader.readLine();
    line = reader.readLine();

    int moves = 0;
    int to_stack = 0;
    int from_stack = 0;
    while (line != null) {
      line = line.replaceAll("[^0-9]", " ");
      line = line.replaceAll(" +", " ");

      // Dubble didgit moves, if space for 0 in 10, 1 didgit move
      if (line.charAt(2) != ' ') {
        moves = Integer.parseInt(line.substring(1, 3));
        from_stack = Integer.parseInt(line.substring(4, 5));
        to_stack = Integer.parseInt(line.substring(6, 7));
      } else {
        moves = Integer.parseInt(line.substring(1, 2));
        from_stack = Integer.parseInt(line.substring(3, 4));
        to_stack = Integer.parseInt(line.substring(5, 6));
      }

      ArrayList<Character> moving_chars = new ArrayList<>();
      for (int i = 0; i < moves; i++) {
        moving_chars.add(all_stacks.get(from_stack - 1).pop());
      }

      for (int i = moves - 1;  i >= 0 ; i--) {
        all_stacks.get(to_stack - 1).add(moving_chars.get(i));
      }

      line = reader.readLine();
    }
    reader.close();

    for (int i = 0; i < 9; i++) {
      System.out.print(all_stacks.get(i).pop());
    }
  }

  // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
  public static void reverse(Stack<Character> thy_stack) {
    if (thy_stack.isEmpty()) {
      return;
    }

    Character temp_char = thy_stack.pop();
    reverse(thy_stack);

    insertAtLast(thy_stack, temp_char);
  }

  public static void insertAtLast(Stack<Character> stack, Character elem) {
    if (stack.isEmpty()) {
      stack.push(elem);
      return;
    }

    Character topElem = stack.pop();
    insertAtLast(stack, elem);

    stack.push(topElem);
  }
}
