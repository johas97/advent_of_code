// Advent of code day X
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.*;

public class dec_4_p2 {

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

    int number_of_contaied_elfs = 0;
    String[] elf_pair_section_as_text = { "", "" };
    String[] task_section_first_elf = { "", "" };
    String[] task_section_second_elf = { "", "" };
    String[][] elf_pair = { task_section_first_elf, task_section_second_elf };

    Set<Integer> section_set_elf_1 = new HashSet<>();
    Set<Integer> section_set_elf_2 = new HashSet<>();

    while (line != null) {
      // extract the numbers from a line
      elf_pair_section_as_text = line.split(",");
      for (int i = 0; i < 2; i++) {
        elf_pair[i] = elf_pair_section_as_text[i].split("-");
      }

      // Add numbers to set 1 & 2

      for (
        int i = Integer.parseInt(elf_pair[0][0]);
        i <= Integer.parseInt(elf_pair[0][1]);
        i++
      ) {
        section_set_elf_1.add(i);
      }

      for (
        int i = Integer.parseInt(elf_pair[1][0]);
        i <= Integer.parseInt(elf_pair[1][1]);
        i++
      ) {
        section_set_elf_2.add(i);
      }

      // Use sets to find match
      if (
        section_set_elf_1.stream().anyMatch( L -> section_set_elf_2.contains(L) )) {
        number_of_contaied_elfs++;
      }
      
      section_set_elf_1.clear();
      section_set_elf_2.clear();
      line = reader.readLine();
    }
    System.out.println(number_of_contaied_elfs);
    reader.close();
  }
}
