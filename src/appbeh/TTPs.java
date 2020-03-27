package appbeh;

import java.util.Arrays;
/*
  @author ashrafi
 */
public class TTPs {
    //public String line;
    public static int T1156(String S[],int length){ //T1156-1 & T1156-2 (Persistence)
        //it has three subparts
        //System.err.println(Arrays.toString(S));
        if(length==7){ //line containing "File:" found
            String[] filePathParts = S[4].split("/"); //the 4th index is the filepath
            if(filePathParts.length>=2){ //to address corner case for filepath e.g. NA
                if(S[3].equals("open") && (filePathParts[1].equals("home") || filePathParts[1].equals("root")) && 
                        (filePathParts[filePathParts.length-1].equals(".bash_profile") || filePathParts[filePathParts.length-1].equals(".bashrc"))){
                    return 1; //subpart 1
               }
            }
        }
        if(length==7){ //line containing "File:" found
            String[] filePathParts = S[4].split("/"); //the 4th index is the filepath
            if(filePathParts.length>=2){ //to address corner case for filepath e.g. NA
                if(S[3].equals("dup") && (filePathParts[1].equals("home") || filePathParts[1].equals("root")) && 
                    (filePathParts[filePathParts.length-1].equals(".bash_profile") || filePathParts[filePathParts.length-1].equals(".bashrc"))){
                    return 2; //subpart 2
                }
            }
        }
        if(length==7){ //line containing "File:" found
            String[] filePathParts = S[4].split("/"); //the 4th index is the filepath
            if(filePathParts.length>=2){ //to address corner case for filepath e.g. NA
                if(S[3].equals("write") && (filePathParts[1].equals("home") || filePathParts[1].equals("root")) && 
                    (filePathParts[filePathParts.length-1].equals(".bash_profile") || filePathParts[filePathParts.length-1].equals(".bashrc"))){
                    return 3; //subpart 3
                }
            }
        }
        return 0; //if no hard match found to this TTP
    }
    
     public static int T1148(String S[],int length){
         //it has two subparts
         if(length==7){ //line containing "File:" found
             String[] filePathParts = S[4].split("/"); //the 4th index is the filepath
             
         }
         return 0;
     }
}
