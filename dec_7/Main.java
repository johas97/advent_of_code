// Advent of code day X

import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

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
    line = reader.readLine();
    FolderClass root_folder = new FolderClass("root", null);
    FolderClass current_folder = root_folder;

    //Create file structure

    while (line != null) {
      if (line.charAt(0) == 'd') {
        String folder_name = line.substring(4);
        current_folder.addFolder(folder_name);
      } else if (line.charAt(0) == '$' && line.charAt(2) == 'c') {
        String cd_command = line.substring(5);
        if (cd_command.equals("..")) {
          if (current_folder.getParent() != null) {
            current_folder = current_folder.getParent();
          }
        } else if (!cd_command.equals("/")) {
          current_folder = current_folder.getFolder(cd_command);
        }
      } else if (Character.isDigit(line.charAt(0))) {
        String[] file_to_add = line.split(" ");
        current_folder.addFile(
          file_to_add[1],
          Integer.parseInt(file_to_add[0])
        );
      }

      line = reader.readLine();
    }

    reader.close();
    int size_all_files = root_folder.getCullmativeSize();
    int free_space = 70000000 - size_all_files;
    int space_needed = 30000000;


    //traverse file strucutre and sum or use hashmap to keep val updated
    System.out.println(root_folder.bfs(space_needed - free_space));
  }
}
