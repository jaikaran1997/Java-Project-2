import java.io.*;
import java.text.*;
import java.util.*;

public class Bigrams
{

    public Bigrams(){}

    public static String calculateProbFile(ArrayList<String> bigrams)
    {
        //Initialising variable
        String curr= bigrams.get(0);
        String result="";
        int counter=0;
        double prob=0;
        double total=bigrams.size();
        for(String first : bigrams) 
        { 
            if (first.equals(curr))
            { 
                counter++;
            }      
            else 
            { 
                result+= curr+" "+Double.toString(prob)+System.getProperty("line.separator");
                counter=1;
                curr = first;
            } 
            prob=counter/total;
        }   
        return result;
    }

    public static ArrayList generateBigram(ArrayList<String> wordList)
    {
        ArrayList bigram= new ArrayList();
        for (int i = 0; i < wordList.size(); i++) 
        {  
            String word=wordList.get(i);
            for(int j=0;j<word.length()-1;j++)
            {
                bigram.add(word.substring(j,j+2));
            }
        }
        return bigram;  
    }

}
