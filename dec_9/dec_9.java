import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class dec_9 {

  public static void main(String[] args) {
    // Initialize the head and tail positions to the starting position (0, 0)
    int headX = 0;
    int headY = 0;
    int tailX = 0;
    int tailY = 0;

    // Read the series of motions from the input file
    String motions = "";
    try (
      BufferedReader reader = new BufferedReader(new FileReader("kort_input.txt"))
    ) {
      String line;
      while ((line = reader.readLine()) != null) {
        line = line.replaceAll(" ", "");
        motions += line + ",";
      }
    } catch (IOException e) {
      System.out.println("Error reading input file: " + e.getMessage());
      return;
    }
    // Split the motions into individual commands
    String[] commands = motions.split(",");

    // Loop through the commands and update the head and tail positions
    for (int i = 0; i < commands.length; i++) {
      // Get the current command
      String command = commands[i];
      // Get the number of steps for this command
      int steps = Integer.parseInt(command.substring(1));

      // Update the head position based on the command
      if (command.startsWith("R")) {
        headX += steps;
      } else if (command.startsWith("U")) {
        headY += steps;
      } else if (command.startsWith("L")) {
        headX -= steps;
      } else if (command.startsWith("D")) {
        headY -= steps;
      }

      // Update the tail position based on the head position
      if (Math.abs(headX - tailX) <= 1 && Math.abs(headY - tailY) <= 1) {
        // If the head and tail are touching, do nothing
      } else if (headX == tailX) {
        // If the head and tail are in the same column, update the tail's y-position
        if (headY > tailY) {
          tailY++;
        } else {
          tailY--;
        }
      } else if (headY == tailY) {
        // If the head and tail are in the same row, update the tail's x-position
        if (headX > tailX) {
          tailX++;
        } else {
          tailX--;
        }
      } else {
        // If the head and tail are not touching and not in the same row or column, update the tail's position diagonally
        if (headX > tailX) {
          tailX++;
        } else {
          tailX--;
        }
        if (headY > tailY) {
          tailY++;
        } else {
          tailY--;
        }
      }
    }

    // Print the final positions of the head and tail
    System.out.println("Head position: (" + headX + ", " + headY + ")");
    System.out.println("Tail position: (" + tailX + ", " + tailY + ")");
  }
}
