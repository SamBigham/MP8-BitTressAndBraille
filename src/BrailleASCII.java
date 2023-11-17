import java.io.PrintWriter;

public class BrailleASCII {
    public static void main(String[] args) {
        PrintWriter pen = new PrintWriter(System.out, true);
        BitTree BT = new BitTree(2);
        
        // try {
        //     //BT.set("", "");
        //     //BT.set("1010", "moasdivkpld");
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
             
    
        try {
            BT.set("0", "2");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
       BT.dump(pen);
    }
}
