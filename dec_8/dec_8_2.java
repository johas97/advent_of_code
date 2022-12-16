// Advent of code day X
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class dec_8_2 {

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
    ArrayList<ArrayList<Integer>> matrix_trees = new ArrayList<ArrayList<Integer>>();

    // Extract input to matrix
    while (line != null) {
      String[] row = line.split("");
      ArrayList<Integer> row_of_trees = new ArrayList<>();
      for (String a_num : row) {
        row_of_trees.add(Integer.parseInt(a_num));
      }
      matrix_trees.add(row_of_trees);
      line = reader.readLine();
    }
    reader.close();


    // Control if tree is visable

    int tree_height = 0;
    int counter = 0;
    int score = 1;
    int max_score = 0;

    ArrayList<Integer> above = new ArrayList<>();
    ArrayList<Integer> below = new ArrayList<>();

    Boolean[] visable_horiz_vert = { false, false };

    for (int i = 1; i + 1 < matrix_trees.size(); i++) {
      // to right
      for (int j = 1; j + 1 < matrix_trees.get(i).size(); j++) {
        tree_height = matrix_trees.get(i).get(j);
        while (tree_height > matrix_trees.get(i).get(j + counter)) {
          counter++;
          if (counter + j >= matrix_trees.get(i).size()) {
            counter--;
            break;
          }
        }
        score *= counter;

        counter = 1;

        // To left
        while (tree_height > matrix_trees.get(i).get(j - counter)) {
          counter++;
          if (j - counter < 0) {
            counter--;
            break;
          }
        }
        score *= counter;

        counter = 1;

        // Below
        while (tree_height > matrix_trees.get(i + counter).get(j)) {
          counter++;
          if (counter + i >= matrix_trees.size()) {
            counter--;
            break;
          }
        }
        score *= counter;

        counter = 1;

        // Above
        while (tree_height > matrix_trees.get(i - counter).get(j)) {
          counter++;
          if (i - counter < 0) {
            counter--;
            break;
          }
        }
        score *= counter;

        counter = 1;

        if (max_score < score) {
          max_score = score;
        }
        score = 1;
      }
    }
    System.out.println(max_score);
  }
}
