/* Author: Ruohan Dang */

import java.io.FileReader;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;


public class WordCounter {
    public Hashtable count_words(String contents){
        Hashtable count = new Hashtable();
        String[] words = contents.split("\\W+");

        for (int i =0; i < words.length;i++){
            String word = words[i].toLowerCase();
            Integer number = (Integer) count.get(word);
            if (number == null){
                count.put(word,1);
            } else {
                count.put(word,number+1);
            }
        }
        return count;
    }
    public static void main(String args[]){
        try{
            String contents = "";

            Scanner in =  new Scanner(new FileReader("src/Fear.txt"));
            while(in.hasNextLine())
            {
                contents +=   in.nextLine() +  "\n";

            }

            WordCounter wc   =  new WordCounter();
            Hashtable count = wc.count_words(contents);
            System.out.println(count);

        }  catch (Exception e){
            System.err.println("Error " +  e.getMessage());
        }
    }

}
