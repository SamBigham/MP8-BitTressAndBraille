import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class BrailleASCII {
    public static void main(String[] args) throws IOException {
        PrintWriter pen = new PrintWriter(System.out, true);

        BitTree BT = new BitTree(3); 
    
        try {
            BT.set("0110", "8");
        } catch (Exception e) {
            
            System.err.println("****ERROR in set**** : " + e);
        }  
        
        try {
            BT.set("0010", "7");
        } catch (Exception e) {
            System.err.println("****ERROR in set**** : " + e);
        }
        try {
            
            String str1 = BT.get("0110");
            String str2 = BT.get("0010");
           System.out.println(str1);
           System.out.println(str2);
        
        } catch (Exception e) {
            System.err.println("****ERROR in get**** : " + e);
        }
       BT.dump(pen);
       pen.println("_________");
    try {
        BufferedReader myObj = new BufferedReader(new FileReader("test.txt"));
         BT.load(myObj);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    BT.dump(pen);
    pen.println("_________");
    //BT.dump(pen);

    // BrailleASCIITables BA = new BrailleASCIITables();
    // BA.toBraille('s');

    BitTree BTT = new BitTree(5);
    try {
        BufferedReader myObj = new BufferedReader(new FileReader("ASCII.txt"));
        BTT.load(myObj);
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    BTT.dump(pen);
    }//main
}//BrailleASCII
