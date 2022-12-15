// Advent of code day X
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class dec_6 {

  /**
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    // Enter data using BufferReader

    File file = new File("dec_6/input.txt");

    BufferedReader reader = new BufferedReader(new FileReader(file));
    // Reading data using readLine
    String line;

    line = reader.readLine();

    ArrayList<Character> lagging_letters = new ArrayList<>();

    for (int letter_index = 0; letter_index < line.length(); letter_index++) {
    lagging_letters.add(line.charAt(letter_index));

    Set<Character> unique_letters = new HashSet<>(lagging_letters);
    if(unique_letters.size() == 14){
        System.out.println(unique_letters);
        System.out.println(letter_index + 1);
        break;

    }

      if (lagging_letters.size() > 13) {
        lagging_letters.remove(0);
      }
    }


    reader.close();
  }
}
