import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Sam Bigham
 *         converts to different texts
 */

public class BrailleASCIITables {

    BitTree BTB = new BitTree(7);
    BitTree BTA = new BitTree(5);
    BitTree BTU = new BitTree(5);

    BrailleASCIITables() {
        try {
            BufferedReader myObj = new BufferedReader(new FileReader("ASCII.txt"));
            BufferedReader BrailleReader = new BufferedReader(new FileReader("BrailleToASCII.txt"));
            BufferedReader BrailleToUnicodeReader = new BufferedReader(new FileReader("BrailleToUnicode.txt"));
            BTB.load(myObj);
            BTA.load(BrailleReader);
            BTU.load(BrailleToUnicodeReader);
        } catch (Exception e) {
            System.err.println("error while creating BrailleASCIITables");
            e.printStackTrace();
        }

    }

    public String toBraille(char letter) {
        int ascval = (int) letter;
        String str = Integer.toBinaryString(ascval);
        StringBuilder sb = new StringBuilder(str);
        String binary = sb.insert(0, 0).toString();

        try {
            str = BTB.get(binary);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return str;
    }

    public String toASCII(String bits) {
        String str = "";
        try {
            str = BTA.get(bits);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return str;
    }

    public String toUnicode(String bits) {
        String str = "";
        try {
            str = BTU.get(bits);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return str;
    }
}
