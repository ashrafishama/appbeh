package appbeh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramSocketImplFactory;
import java.util.ArrayList;
/*
  @author ashrafi
 */
public class Appbeh extends TTPs {
    public static void main(String[] args) throws IOException {
       int[] TTPcounter = new int[39]; //each index for distinct TTP appearance count
       /*TTPs ttps = new TTPs();
       String s = "Hello";
       ttps.T1156(s);*/
       String filename = "chrome.txt";
       ArrayList content = fileRead(filename);
       System.err.println("Size of file is " + content.size());
       parser(content);
    }
    public static ArrayList fileRead(String filename) throws IOException{
        BufferedReader bufReader = new BufferedReader(new FileReader(filename));
        ArrayList<String> listOfLines = new ArrayList<>();
        String line = bufReader.readLine();
        while(line != null){
            listOfLines.add(line);
            line = bufReader.readLine(); 
        }
        bufReader.close();
        return listOfLines;
    }
    
    public static void parser(ArrayList data){
        for(int i=0;i<data.size();i++){
            String temp = (String) data.get(i);
            String[] parts = temp.split("\\s+");
            /*if(parts[0].equals("File:")){
                System.err.println("found");
            }*/
        }
        return;
    }
}
