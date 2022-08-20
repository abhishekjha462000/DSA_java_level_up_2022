import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		BigInteger n = scn.nextBigInteger();
		
		BigInteger two = BigInteger.valueOf(2);
		BigInteger smallAns = n.divide(two) ;

		if(n.remainder(two).equals(BigInteger.valueOf(0))) {
			System.out.println(smallAns);
		}else {
			smallAns = smallAns.multiply(BigInteger.valueOf(-1)).add(BigInteger.valueOf(-1));
			System.out.println(smallAns);
		}
		
		scn.close();
		
	}
	
	private static void initializeIO(){
        try 
        {
        	Path currentRelativePath = Paths.get("");
        	String myPath = currentRelativePath.toAbsolutePath().toString();
            System.setIn(new FileInputStream(myPath + "\\src\\input.txt"));
            System.setOut(new PrintStream(new FileOutputStream(myPath + "\\src\\output.txt")));
            System.setErr(new PrintStream(new FileOutputStream(myPath + "\\src\\error.txt")));
        }
        catch (Exception e) 
        {
            System.err.println(e.getMessage());
        }
    }

}
