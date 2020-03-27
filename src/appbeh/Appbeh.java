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
       TTPmatcher.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3))); //3 subparts for TTP T1156, index 0
       TTPmatcher.add(new ArrayList<Integer>(Arrays.asList(1, 2))); //3 subparts for TTP T1485-5, index 1       
       String filename = "chrome.txt";
       //String filename = "test.txt";
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
            String[] parts = temp.split("\\s+"); //number of parts in each line
            //the following 9 lines will be repeated for each TTP
            int prev_match_1 = 0;
            int match_1 = ttps.T1156(parts,parts.length); //have to call this function for each TTP, against each line, returns a #
            if(match_1!=0 && match_1>prev_match_1){//if the found sequence is logically after the previous matches
                matchUpdater(TTPmatcher, 1, match_1); //1 for T1156
                if(allPartsMatched(TTPmatcher,1)){ //checking if all subparts of T1156 are found
                    ttpFrequency[0]+=1; //updating T1156 frequency
                }
            }
            prev_match_1 = match_1;
        }
        
        return;
    }
    
    public static void matchUpdater(ArrayList<ArrayList<Integer>> ttpMatcher,int TTPNo,int part){
        ttpMatcher.get(TTPNo-1).set(part-1,0); //make the matched part 0
    }
    
    public static boolean allPartsMatched(ArrayList<ArrayList<Integer>> ttpMatcher,int TTPNo){
        if(TTPNo==1){
            if (Collections.frequency(ttpMatcher.get(TTPNo-1), 0) == ttpMatcher.get(TTPNo-1).size()){ //TTPNo-1 is the index in the AL
                ttpMatcher.get(0).set(0,1);
                ttpMatcher.get(0).set(1,2);
                ttpMatcher.get(0).set(2,3);
                return true; //all subparts matched for some TTP, for TTPNo == 1, T1156 it is
            }        
        }
        return false;
    }
}
