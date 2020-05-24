import java.io.*;
import java.text.*;
import java.util.*;

public class Score
{

    public Score(){}

    public static double scoreCalculate(String fileIn, ArrayList testList)
    {
        Methods M= new Methods();
        //Initialising variable
        String content="";
        String[] splitData=null;
        ArrayList scoreList= new ArrayList();
        ArrayList bigramList= new ArrayList();
        ArrayList<Double> probabilityList= new ArrayList<Double>();
        double score=1;
        content=M.readFile(fileIn);
        //splits the read file which had bigrams and probabilities
        String[] splitLine = content.split("\n"); 
        //splits and store bigrams to an arraylist and probabilities to another
        for(int i=0;i<splitLine.length;i++)
        {
            splitData=splitLine[i].split("\\s+");
            for(int j=0;j<splitData.length;j=+2)
            {
                bigramList.add(splitData[j]);
                probabilityList.add(Double.parseDouble(splitData[j+1]));
            }

        }

        for (int i=0;i<testList.size();i++)
        { 
            //returns a searching index value of the unknown bigram from the testing model 
            int index = Collections.binarySearch(bigramList,testList.get(i));
            //index is used to calucate score
            if(index>=0)
            {
                double prob= probabilityList.get(index);
                score=score*prob;
            }
            else
            {
                score=score*0;

            }
        }
        return score;
    }
}
