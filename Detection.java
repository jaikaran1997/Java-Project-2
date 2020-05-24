import java.io.*;
import java.text.*;
import java.util.*;

public class Detection
{

    public Detection()
    {
        Models M=new Models();
        Score S=new Score();
        //Initialising variable
        String[] testFileName={"Unknown1.txt","Unknown2.txt","Unknown3.txt","Unknown4.txt","Unknown5.txt","Unknown6.txt","Unknown7.txt","Unknown8.txt"};
        String[] fileIn={"EnglishModel.txt","FrenchModel.txt","GermanModel.txt","ItalianModel.txt","SpanishModel.txt"};
        String[] detectedLanguage={"ENGLISH","FRENCH","GERMAN","ITALIAN","SPANISH"};

        Locale SPANISH= new Locale("es","ES");//Locale builder for Spanish
        Locale[] locale={Locale.ENGLISH,Locale.FRENCH,Locale.GERMAN,Locale.ITALIAN,Locale.GERMAN,SPANISH};

        ArrayList unknownBigramList= new ArrayList();

        for(int i=0;i< testFileName.length;i++)
        {
            ArrayList scoreList=new ArrayList();
            //Prints out the file name, read file, generate bigrams
            System.out.println("\n Detection File Name: "+testFileName[i]);
            unknownBigramList= detectionBigramGenerator(testFileName[i]);
            //sorting the generated bigram
            Collections.sort(unknownBigramList);

            for(int j=0;j<fileIn.length;j++)
            {
                //adding scores from 5 tested models to an arraylist
                scoreList.add(S.scoreCalculate("Models\\"+fileIn[j],unknownBigramList));
            }
            //finding the maximum score
            Comparable max= Collections.max(scoreList);
            //finding the index of the maximum score to print out detected language
            int index= scoreList.indexOf(max);
            System.out.println(detectedLanguage[index]+" Detected!");

        }
       
    }

    public static ArrayList detectionBigramGenerator(String fileIn)
    {
        Methods M= new Methods();
        Bigrams B= new Bigrams();
        //Initialising variable
        fileIn="Testing\\"+fileIn;
        String content="";
        ArrayList bigramList= new ArrayList();

        content=M.readFile(fileIn);
        System.out.println(" File Contents: "+content);
        bigramList=B.generateBigram(M.extractWords(content,Locale.getDefault()));
        return bigramList;
    }

}
