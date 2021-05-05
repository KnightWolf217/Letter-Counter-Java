import java.io.*;
import java.util.TreeMap;

public class ApplicationRunner {

    static String file = System.getProperty("user.dir") + File.separator + "play.txt";

    //main method
    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String content;
            int totalchar = 0;
            TreeMap<Character, Integer> counts = new TreeMap<>();
            for (char i = 'a'; i <= 'z'; i++) {
                counts.put(i, 0);
            }
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
                                Integer count = counts.get(character);
                                counts.replace(character, count + 1);
                                break; //breaking the loop when the character count is incremented
                            }
                        }
                    }
                }
            }
            System.out.println("Total letters = " + totalchar);
            for (char i = 'a'; i <= 'z'; i++) {
                System.out.println(i + " --> " + counts.get(i));
            }

        } catch (IOException ex) {
            System.out.println("File not found error");
        }

    }
}
