import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;

/**
 * @author Sam Bigham
 *         Main code
 */

public class BrailleASCII {
    public static void main(String[] args) throws IOException {

        PrintWriter pen = new PrintWriter(System.out, true);
        BrailleASCIITables BAT = new BrailleASCIITables();

        if (args.length != 2) {
            pen.println("not enough arguments in command line");
            return;
        }
        if (args[0].equals("braille")) {
            for (int i = 0; i < args[1].length(); i++) {
                pen.print(BAT.toBraille(args[1].charAt(i)));
            }
            pen.println();
        } else if (args[0].equals("ascii")) {
            // reads 7 numbers and then converts from ascii to text
            pen.println("ascii");
            char[] chArr = new char[6];
            int n = 0;
            for (int i = 0; i < args[1].length(); i++) {
                if (i % 6 == 0) {
                    String str = new String(chArr);
                    pen.print(BAT.toASCII(str));
                    n = 0;
                }
                chArr[n] = args[1].charAt(i);
                // System.out.println("i is : " + i + " n is : " + n);
                n++;
                // pen.print(args[1].charAt(i));
            }
            String str = new String(chArr);
            pen.print(BAT.toASCII(str));
            pen.println();
        } else if (args[0].equals("unicode")) {
            for (int i = 0; i < args[1].length(); i++) {
                // pen.print(i);
                String str = BAT.toBraille(args[1].charAt(i));
                str = BAT.toUnicode(str);
                String unicode;

                StringBuilder sb = new StringBuilder(str);
                unicode = sb.insert(0, '\\').toString();
                unicode = sb.insert(1, 'u').toString();
            
                pen.print(unicode);
                
        

            }
            pen.println();
        } // else if

    }// main
}// BrailleASCII
