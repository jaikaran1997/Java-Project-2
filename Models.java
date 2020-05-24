import java.io.*;
import java.text.*;
import java.util.*;
import java.nio.charset.StandardCharsets;

public class Models
{
    public Models()
    {
        Methods M= new Methods();
        Bigrams B= new Bigrams();
        //Initialising variable
        System.out.print("\u000c"); //Clearing screen
        System.out.println("INITIALISATION!");
        String[] fileIn={"English.txt","French.txt","German.txt","Italian.txt","Spanish.txt"};
        String[] fileOut={"EnglishModel.txt","FrenchModel.txt","GermanModel.txt","ItalianModel.txt","SpanishModel.txt"};
        Locale SPANISH= new Locale("es","ES");
        Locale[] locale={Locale.ENGLISH,Locale.FRENCH,Locale.GERMAN,Locale.ITALIAN,Locale.GERMAN,SPANISH};

        try
        {
            for(int i=0; i< 5;i++)
            {
                String filePath="Learning\\"+fileIn[i];
                modelGeneration(filePath,fileOut[i],locale[i]);
                System.out.println(fileOut[i]+" created");
            }
        }
        catch (Exception e)
        {
            System.out.println("Error! While creating Models");
        }
        System.out.println("INITIALISATION DONE!");
    }

    public static void modelGeneration(String fileIn, String fileOut, Locale locale)
    {
        Methods M= new Methods();
        Bigrams B= new Bigrams();
        ArrayList bigramList= new ArrayList();
        String bigramProbFile="";
        bigramList=B.generateBigram(M.extractWords(M.readFile(fileIn),locale));
        Collections.sort(bigramList);
        bigramProbFile=B.calculateProbFile(bigramList);
        M.writeModelsToFile(fileOut,bigramProbFile);
    }

}
