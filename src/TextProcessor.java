import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

public class TextProcessor {

    public void process(InputStream is, OutputStream os) throws IOException {

        Scanner in = new Scanner(is);

        while (in.hasNextLine()) {
            String line = in.nextLine();
            line = line.toLowerCase();
            Map<Character, Integer> map = new HashMap<>();
            int maxOccurring = 0;
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);

                if (ch == ' ') continue;

                if (map.containsKey(ch) && Character.isLetter(ch)) {
                    map.put(ch, map.get(ch) + 1);
                } else {
                    map.put(ch, 1);
                }

                if (map.get(ch) > maxOccurring) {
                    maxOccurring = map.get(ch);
                }
            }

            System.out.println(maxOccurring);

        }
    }

}

