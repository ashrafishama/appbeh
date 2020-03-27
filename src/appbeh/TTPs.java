package appbeh;

import com.sun.javafx.font.FontResource;
import java.util.Arrays;
/*
  @author ashrafi
 */
public class TTPs {
    //public String line;
    public static int T1156(String S[],int length){ //T1156-1 & T1156-2 (Persistence)
        //it has three subparts
        //System.err.println(Arrays.toString(S));
        //first subpart check
        if(length==7){ //line containing "File:" found
            String[] filePathParts = S[4].split("/"); //the 4th index is the filepath
            if(filePathParts.length>=2){ //to address corner case for filepath e.g. NA
                if(S[3].equals("open") && (filePathParts[1].equals("home") || filePathParts[1].equals("root")) && 
                        (filePathParts[filePathParts.length-1].equals(".bash_profile") || filePathParts[filePathParts.length-1].equals(".bashrc"))){
                    return 1; //subpart 1
               }
            }
        }
        //second subpart check
        if(length==7){ //line containing "File:" found
            String[] filePathParts = S[4].split("/"); //the 4th index is the filepath
            if(filePathParts.length>=2){ //to address corner case for filepath e.g. NA
                if(S[3].equals("dup") && (filePathParts[1].equals("home") || filePathParts[1].equals("root")) && 
                    (filePathParts[filePathParts.length-1].equals(".bash_profile") || filePathParts[filePathParts.length-1].equals(".bashrc"))){
                    return 2; //subpart 2
                }
            }
        }
        //third subpart check
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
         //first subpart check
         if(length==7){ //line containing "File:" found
             String[] filePathParts = S[4].split("/"); //the 4th index is the filepath
             String[] time = S[6].split(":");
             int freq = Integer.parseInt(time[1]);
             if(filePathParts.length>=2){//1st subpart check
                if(S[3].equals("read") && filePathParts[1].equals("dev") && freq>=5){ //threshold of 5 times read from /dev/*
                    return 1;
                }
             }
         }
         //second subpart check
         if(length==7){ //line containing "File:" found
             String[] filePathParts = S[4].split("/"); //the 4th index is the filepath
             String[] time = S[6].split(":");
             int freq = Integer.parseInt(time[1]);
             if(filePathParts.length>=1){//1st subpart check
                if(S[3].equals("write") && filePathParts[filePathParts.length-1].equals("syslog") && 
                      filePathParts[filePathParts.length-2].equals("log") && filePathParts[filePathParts.length-3].equals("var")
                       && freq>=5){ //threshold of 5 times write to /var/log/syslog
                    return 2;
                }
             }
         }
         return 0;
     }
}
