import java.io.File;
import java.util.Scanner;

public class MarkovChains {
    public static void main(String[] args) {
        System.out.println("Hello! Welcome to a weird MarkovChine Thingy");
        System.out.println();
        Scanner s = new Scanner(System.in);
        System.out.print("Give a File Name (no .txt): ");
        File fileInput = new File(s.nextLine() + ".txt");
        Scanner sc = new Scanner(fileInput);
        ArrayDictionary dictionary = new ArrayDictionary();
        boolean done = false;

        String allText = "";
        while (!done){
            String line = sc.nextLine();
            if (line == null){
                done = true;
            } else if (line != ""){
                allText.concat(line);
                allText.concat(" ");
            } else{
                int thing = 12345;
            }
        }

        int numWords = 0;
        done = false;
        String allText2 = allText;
        while (!done){
            if ()
            if (allText2.contains(" ")){
                numWords++;
                allText2.substring(allText2.indexOf(' ')+1);
            }
        }
    }
}
