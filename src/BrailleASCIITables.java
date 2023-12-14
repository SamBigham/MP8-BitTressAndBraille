import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BrailleASCIITables {
    
    public String toBraille(char letter){
        String str = Character.toString(letter);

        BitTree BTB = new BitTree(7); 
        try {
            BufferedReader myObj = new BufferedReader(new FileReader("ASCII.txt"));
                BTB.load(myObj);

                str = BTB.get(str);
                System.out.println(str);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return str;
        }

    public String toASCII(String bits){
        return "strASC";
    }
    public String toUnicode(String bits){
        return "strUni";
    }
}
