// Advent of code day 3
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class dec_3 {

  /**
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    // Enter data using BufferReader

    File file = new File("input.txt");

    BufferedReader reader = new BufferedReader(new FileReader(file));
    int ascii_temp = 0;
    // Reading data using readLine
    String line_1;
    String line_2;
    String line_3;

    String overlapping_items = "";
    String overlapping_items_final = "";

    ArrayList<Integer> overlapping_items_priority = new ArrayList<Integer>();

    line_1 = reader.readLine();
    line_2 = reader.readLine();
    line_3 = reader.readLine();
    while (line_1 != null) {
     

      // Hitta de överlappande först två
      for (int i = 0; i < line_2.length(); i++) {
        if (-1 != line_1.indexOf(line_2.charAt(i))) {
          overlapping_items = overlapping_items + line_2.charAt(i);
        }
      }
      // Of theese find final overlap 
      for (int i = 0; i < line_3.length(); i++) {
        if (-1 != overlapping_items.indexOf(line_3.charAt(i))) {
          overlapping_items_final = overlapping_items_final + line_3.charAt(i);
          break;
        }
      }

      overlapping_items = "";

      line_1 = reader.readLine();
      line_2 = reader.readLine();
      line_3 = reader.readLine();
    }

    System.out.println(overlapping_items_final);

    //Konvertera via assci till siffervärden
    for (int i = 0; i < overlapping_items_final.length(); i++) {
      ascii_temp = ((int) overlapping_items_final.charAt(i)); // Trick to cast from char to asci num

      if (ascii_temp < 123 && ascii_temp > 96) {
        ascii_temp -= 96;
      } else if (ascii_temp < 91 && ascii_temp > 64) {
        ascii_temp -= 38;
      }

      overlapping_items_priority.add(ascii_temp);
    }

    int tot_priority = 0;
    for (int i = 0; i < overlapping_items_priority.size(); i++) {
      tot_priority += overlapping_items_priority.get(i);
    }

    System.out.println(tot_priority);
    reader.close();
  }
}
