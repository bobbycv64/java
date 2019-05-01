package general.ascii;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

public class Ascii2Text {

    private static final String FILENAME = "src/ascii/ascii.txt";
    private static final int LINEFEED = 10;
    private static List<Ascii> arrayList = null;

    public Ascii2Text() {
        arrayList = AsciiArrayList.buildArrayList();
        decipher();
    }

    // decipher ascii to text
    private void decipher() {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILENAME))) {

            String record = "";
            String token = "";
            String character = "";

            while ((record = bufferedReader.readLine()) != null) {
                System.out.println("ASCII Record: " + record + "\n");
                StringTokenizer stringTokenizer = new StringTokenizer(record, ",");

                while (stringTokenizer.hasMoreTokens()) {
                    token = stringTokenizer.nextToken().trim();
                    int asciiKey = Integer.parseInt(token);
                    character = arrayList.get(asciiKey).getCharacter();

                    if (asciiKey == LINEFEED) {
                        System.out.println(character);
                    } else {
                        System.out.print(character);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        System.out.println("********** Start Ascii2Text **********\n");
        new Ascii2Text();
        System.out.println("\n\n********** End   Ascii2Text **********\n");
    }
}
