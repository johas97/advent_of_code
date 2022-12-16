// Advent of code day X
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class dec_8 {

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
    
    int no_visable_trees = ((matrix_trees.size() + matrix_trees.get(0).size()) * 2) - 4;

    // Control if tree is visable
    
    int tree_height = 0;
    int max_height_to_left = 0;
    int max_height_to_right = 0;

    ArrayList<Integer> above = new ArrayList<>();
    ArrayList<Integer> below = new ArrayList<>();

    Boolean[] visable_horiz_vert = { false, false };
    // ArrayList<ArrayList<Boolean[]>> visability_matrix = new ArrayList<ArrayList<Boolean[]>>();

    for (int i = 1; i + 1 < matrix_trees.size(); i++) {
      ArrayList<Integer> current_row = matrix_trees.get(i);
      max_height_to_right =
        Collections.max(current_row.subList(2, current_row.size()));

      for (int j = 1; j + 1 < current_row.size(); j++) {
        tree_height = current_row.get(j);

        above.clear();
        below.clear();

        if (max_height_to_left < current_row.get(j - 1)) {
          max_height_to_left = current_row.get(j - 1);
        }
        //System.out.println(matrix_trees.get(i).get(j+1));
        if (max_height_to_right == current_row.get(j)) {
          max_height_to_right =
            Collections.max(current_row.subList(j + 1, current_row.size()));
          // System.out.println(current_row.subList(j + 1, current_row.size()));
        }

        /*  System.out.println(max_height_to_left);
        System.out.println(max_height_to_right);
        System.out.println(tree_height);
        System.out.println("  "); 
        
        */
        if (
          current_row.get(j) > max_height_to_left ||
          current_row.get(j) > max_height_to_right
        ) {
          no_visable_trees += 1;
          continue;
        }

        for (int k = 0; k < matrix_trees.size(); k++) {
          if (k < i) {
            above.add(matrix_trees.get(k).get(j));
          } else if (k > i) {
            below.add(matrix_trees.get(k).get(j));
          }
        }

        if (
          tree_height > Collections.max(above) ||
          tree_height > Collections.max(below)
        ) {
          no_visable_trees += 1;
        }
      }

      max_height_to_left = 0;
      max_height_to_right = 0;
    }

    System.out.println(no_visable_trees);
  }
}
