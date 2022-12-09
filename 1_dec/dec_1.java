

// Advent of code day 1 
import java.io.*;
import java.util.Arrays;



public class dec_1 {
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
        int currentNum;
        int[] currentMaxNum = {0, 0, 0};
        int currentKulmativ = 0;

        line = reader.readLine();
        do  {

            if (!line.equals("")) {
                currentNum = Integer.parseInt(line);
                currentKulmativ = currentKulmativ + currentNum;
            }
            else{
                
                for(int i = 0; i < 3 ; i++) {
                    if(currentKulmativ > currentMaxNum[i]){
                        if(i == 0){ 
                            //save val
                            int a, b;
                            a = currentMaxNum[i];
                            b = currentMaxNum[i+1];

                            //insert val
                            currentMaxNum[i] = currentKulmativ;
                            currentMaxNum[i+1] = a;
                            currentMaxNum[i+2] = b;
                         }
                        
                        if(i == 1){
                             //save val
                             int a;
                             a = currentMaxNum[i];

                             //insert val
                             currentMaxNum[i] = currentKulmativ;
                             currentMaxNum[i+1] = a;
                        }

                        if(i == 2){
                          currentMaxNum[i] = currentKulmativ;
                       }


                        currentMaxNum[i] = currentKulmativ;
                        currentKulmativ = 0;
                        break;
                    }

                }
                currentKulmativ = 0;

            }
            
            line = reader.readLine();
        }while (line != null);
        
        int total = 0;
        for(int i = 0; i < 3 ; i++) {
         total = total + currentMaxNum[i]; 
         
         System.out.println(currentMaxNum[i]);

        }
        System.out.println(total);
    
    }
}