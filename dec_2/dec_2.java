
// Advent of code day 2 
import java.io.*;
import java.util.Arrays;

public class dec_2 {
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

        //char my_move = line.charAt(2);
        //char opponent_move = line.charAt(0);
        int points = 0;
        while (line != null) {

            switch (line) {
                case "A X":
                    points += 0 + 3;

                    break;

                case "A Y":
                    points += 3 + 1;

                    break;
                case "A Z":
                    points += 6 + 2;

                    break;
                case "B X":
                    points += 0 + 1;

                    break;
                case "B Y":
                    points += 3 + 2;

                    break;
                case "B Z":
                    points += 6 + 3;

                    break;
                case "C X":
                    points += 0 + 2;

                    break;
                case "C Y":
                    points += 3 + 3;

                    break;
                case "C Z":
                    points += 6 + 1;

                    break;
            }
            line = reader.readLine();
        }
        System.out.println(points);
        reader.close();
    }
}