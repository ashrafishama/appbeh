package appbeh;
import java.util.*; 
import java.io.*;
/*
  @author ashrafi
 */
public class Appbeh extends TTPs {
    public static void main(String[] args) throws IOException {
       int[] TTPfrequency = new int[39]; //each index for distinct TTP appearance count
       Arrays.fill(TTPfrequency, 0); //initial frequency '0'
       TTPs ttps = new TTPs();
       ArrayList<ArrayList<Integer>> TTPmatcher = new ArrayList<ArrayList<Integer>>(); //39 entries for 39 TTPs for matching parts
       TTPmatcher.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3))); //3 subpart for TTP T1156
       
       //String filename = "chrome.txt";
       String filename = "test.txt";
       ArrayList content = fileRead(filename);
       System.out.println("Initial Frequency " + TTPfrequency[0]); //of T1156, that is why index is '0'
       parser(content,ttps,TTPfrequency,TTPmatcher);
       System.out.println("Final Frequency " + TTPfrequency[0]); //of T1156, that is why index is '1'
       
    }
    
    //file reader
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
    
    //line parser (with delemeter)
    public static void parser(ArrayList data,TTPs ttps,int[] ttpFrequency,ArrayList<ArrayList<Integer>> TTPmatcher){
        for(int i=0;i<data.size();i++){
            String temp = (String) data.get(i);
            String[] parts = temp.split("\\s+");
            int match = ttps.T1156(parts,parts.length); //have to call this function for each TTP, against each line, returns a #
            //System.err.println("Matched " + match); // working now
            matchUpdater(TTPmatcher, 1, match);
            if(allPartsMatched(TTPmatcher,1)){
                ttpFrequency[0]+=1;
            }
        }
        
        return;
    }
    
    public static void matchUpdater(ArrayList<ArrayList<Integer>> ttpMatcher,int TTPNo,int part){
        ttpMatcher.get(TTPNo-1).set(part-1,0); //make the matched part 0
    }
    
    public static boolean allPartsMatched(ArrayList<ArrayList<Integer>> ttpMatcher,int TTPNo){
        if (Collections.frequency(ttpMatcher.get(TTPNo-1), 0) == ttpMatcher.get(TTPNo-1).size()){ //TTPNo-1 is the index in the AL
            ttpMatcher.get(0).set(0,1);
            ttpMatcher.get(0).set(1,2);
            ttpMatcher.get(0).set(2,3);
            return true;
        }        
        return false;
    }
}
