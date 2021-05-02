
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ApplicationRunner {

    static String file = System.getProperty("user.dir") + File.separator + "play.txt";

    //frequency counter method for each letter
    public static int charCounter(char x) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String content;
            int frequency = 0;
            while ((content = reader.readLine()) != null) {
                content = content.toLowerCase();
                int length = content.length();
                char character;
                {
                    for (int j = 0; j < length; j++) {
                        character = content.charAt(j);
                        if (character == x) {
                            frequency++;
                        }
                    }
                }
            }
            return frequency;
        } catch (IOException ex) {
            System.out.println("File not found error");
        }
        return x;
    }

    //main method
    public static void main(String[] args) {
        
        //counting total number of letters
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String content;
            int totalchar = 0;
            while ((content = reader.readLine()) != null) {
                content = content.toLowerCase();
                int length = content.length();
                char character;
                {
                    for (int j = 0; j < length; j++) {
                        character = content.charAt(j);
                        for (char i = 'a'; i <= 'z'; i++) {
                            if (character == i) {
                                totalchar++;
                            }
                        }
                    }
                }
            }
            //printing total character count to console
            System.out.println("Total number of letters = " + totalchar);


        } catch (IOException ex) {
            System.out.println("File not found error");
        }

        //array of letter frequency values
        int[] charValues = new int[26];
        
        //adding letters counts to array
        int index = 0;
        for (char i = 'a'; i <= 'z'; i++) {
            charValues[index] = charCounter(i);
            index++;
        }
        
        
        //array of letters 
        String[] chars = new String[26];
        
        //adding letter names to array
        int index2 = 0;
        for (char i = 'a'; i <= 'z'; i++) {
            chars[index2] = Character.toString(i);
            index2++;
        }
        
        final List<String> stringList = Arrays.asList(chars);
        List<String> sortedChars = new ArrayList<>(stringList);
        //sorting the letter array list in relation to how the frequencies will be sorted 
        Collections.sort(sortedChars, (String left, String right) -> charValues[stringList.indexOf(left)] - charValues[stringList.indexOf(right)]);

        //sorting array in ascending order
        Arrays.sort(charValues);

        //mirroring the frequencies array to make it descending order
        for (int i = 0; i < charValues.length / 2; ++i) {
            int temp = charValues[i];
            charValues[i] = charValues[charValues.length - i - 1];
            charValues[charValues.length - i - 1] = temp;
        }

        //converting the character array list back to array after it was sorted in relation to frequencies earlier
        String[] item = sortedChars.toArray(new String[sortedChars.size()]);

        //reversing the character arraylist to make it descending order
        List<String> finalCharArray = Arrays.asList(item);
        Collections.reverse(finalCharArray);
        String[] reversed = finalCharArray.toArray(item);

        //printing letter frequencies to output
        for (int i = 0; i < charValues.length; i++) {
            System.out.println(reversed[i] + " --> " + charValues[i]);
        }
    }
}
