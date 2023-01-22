// Advent of code day X
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class dec_10 {

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
    int crt_drawing_pix = 0;
    int loop_num = 0;
    int x_reg = 1;

    while (line != null) {
      // sortera in i de två fallen

      if (line.charAt(0) == 'a') {
        String string_num = line.substring(5);
        int add_num = Integer.parseInt(string_num);
        for (int i = 0; i < 2; i++) {
          if (loop_num == 40) {
            loop_num = 0;
            System.out.println("");
          }
          print_crt(loop_num, x_reg);
          if (i == 1) {
            x_reg = x_reg + add_num;
          }
          loop_num++;
        }
      } else {
        if (loop_num == 40) {
          loop_num = 0;
          System.out.println("");
        }
        print_crt(loop_num, x_reg);
        loop_num++;
      }
      // New row

      line = reader.readLine();
    }

    reader.close();
  }

  static void print_crt(int loop_num, int x_reg) {
    if (loop_num - 1 == x_reg || loop_num == x_reg || loop_num + 1 == x_reg) {
      System.out.print("#");
    } else {
      System.out.print(".");
    }
    // System.out.print(loop_num);
    // System.out.print("@@");
    // System.out.println(x_reg);
  }
}
