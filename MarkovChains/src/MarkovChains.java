// Roan Silver      Created: February 26, 2024        Last Edits: February 29, 2024
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MarkovChains {
    public static void main(String[] args) throws FileNotFoundException {

        // Setting up Everything

        System.out.println("Hello! Welcome to a weird MarkovChain Thingy");
        System.out.println();
        Scanner s = new Scanner(System.in);
        System.out.print("Give a File Name (no .txt): ");
        File fileInput = new File(s.nextLine() + ".txt");
        Scanner sc = new Scanner(fileInput);
        ArrayDictionary dictionary = new ArrayDictionary();
        ArrayList<String> keys = new ArrayList<>();
        Random r = new Random();
        boolean done = false;


        // Adding things to Dictionary

        while (!done){
            boolean subDone = false;
            String line = sc.nextLine();
            if (sc.hasNextLine() == false){
                done = true;
            } else if (line != ""){
                /**
                line.replaceAll(",", "");
                line.replaceAll(java.util.regex.Matcher.quoteReplacement("/"), "");
                line.replaceAll(":", "");
                line.replaceAll(";", "");
                line.replaceAll(java.util.regex.Matcher.quoteReplacement("("), "");
                line.replaceAll(java.util.regex.Matcher.quoteReplacement(")"), "");
                line.replaceAll("—", " ");
                 **/
                line.toLowerCase();
                String restLine = line;
                while (!subDone){
                    if (!restLine.contains(" ")){
                        subDone = true;
                    } else{
                        String word = restLine.substring(0, restLine.indexOf(" "));
                        restLine = restLine.substring(restLine.indexOf(" ")+1);
                        if (!restLine.contains(" ")){
                            keys.add(word);
                            dictionary.put(word, restLine);
                        } else{
                            keys.add(word);
                            dictionary.put(word, restLine.substring(0, restLine.indexOf(" ")));
                        }
                    }
                }
            }
        }

        // Making Sentences

        System.out.print("How many lines would you like to generate?: ");
        int numWords = s.nextInt();
        String output = "";
        String current;
        boolean start = true;
        for (int i = 0; i < numWords; i++){
            if (start){
                current = keys.get(r.nextInt(keys.size()));
                output = output.concat(current + " ");
            } else{
                String randomKey = keys.get(r.nextInt(0, keys.size()));
                ArrayList<String> options = dictionary.get(randomKey);
                String randomValue = options.get(r.nextInt(0, options.size()));
                current = randomValue;
                output = output.concat(current + " ");
            }
        } output = output.concat(".");
        System.out.println("Your finished result is below:");
        System.out.println(output);
    }
}
