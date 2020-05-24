import java.io.*;
import java.text.*;
import java.util.*;
import java.nio.charset.StandardCharsets;

public class Methods
{

    public Methods(){}

    public static String readFile(String filePath) 
    {
        StringBuilder fileContent = new StringBuilder();

        try 
        {
            Reader reader = new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String s;
            while ((s = bufferedReader.readLine()) != null)
            {    
                fileContent.append(s + "\n");
            }
            bufferedReader.close();
            reader.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        return fileContent.toString();

    }

    public static ArrayList extractWords(String inputText, Locale currentLocale) 
    {      
        ArrayList wordList = new ArrayList();      
        BreakIterator wordIterator = BreakIterator.getWordInstance(currentLocale);       
        wordIterator.setText(inputText);  
        int start = wordIterator.first();  
        int end = wordIterator.next();  
        while (end != BreakIterator.DONE) 
        {        
            String word = inputText.substring(start, end);
            word = word.toLowerCase();
            if (Character.isLetter(word.charAt(0)) && word.length() > 1) 
            {          
                wordList.add(word);
            }  
            start = end;  
            end = wordIterator.next();      
        }  
        return wordList;    
    }

    public static void outputFile(String filePath, ArrayList wordList) 
    { 
        try 
        {
            Writer writer = new OutputStreamWriter(  new FileOutputStream(filePath), StandardCharsets.UTF_16);
            PrintWriter printWriter = new PrintWriter(writer);
            for(int i=0; i<wordList.size();i++)
            {
                printWriter.println(wordList.get(i));
            }
            writer.close();
            printWriter.close();
        }
        catch(Exception e)
        {
            e.printStackTrace(); 
        }

    }

    public static void writeModelsToFile(String fileName, String content) 
    {
        fileName="Models\\"+fileName;
        try 
        { 
            Writer writer = new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8);
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.println(content);
            writer.close();           
            printWriter.close();       
        } 
        catch (Exception e)
        {            
            e.printStackTrace();
        }    
    }

}
