package appbeh;

import java.util.*;
/*
  @author ashrafi
 */
public class TTPs {
    //public String line;
    //variables for aid in 'pattern checking'
    public static int[] TTP1083 = new int[6];
    public static int[] TTP1030 = new int[2];
    
    TTPs(){
        Arrays.fill(TTP1083,1);
        Arrays.fill(TTP1030,1);
    }
    
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
     
     public static int T1083(String S[],int length){
        //it has six subparts
        //first subpart
        if(length==7 && TTP1083[0]==1){ //line containing "File:" found
             String[] filePathParts = S[4].split("/"); //the 4th index is the filepath
             if(filePathParts.length>=2){//1st subpart check
                if(S[3].equals("read") && ((filePathParts[1].equals("proc") || filePathParts[1].equals("lib") || 
                        filePathParts[1].equals("usr")))){ //proc -> lib -> usr sequence not important, but if all of them read, then fishy
                    TTP1083[0] = 0;
                    return 1;
                }
             }
        }
        //second subpart
        if(length==7 && TTP1083[1]==1){ //line containing "File:" found
             String[] filePathParts = S[4].split("/"); //the 4th index is the filepath
             if(filePathParts.length>=2){//1st subpart check
                if(S[3].equals("read") && ((filePathParts[1].equals("proc") || filePathParts[1].equals("lib") || 
                        filePathParts[1].equals("usr")))){ //proc -> lib -> usr sequence not important, but if all of them read, then fishy
                    TTP1083[1] = 0;
                    return 2;
                }
             }
        }
        //third subpart
        if(length==7 && TTP1083[2]==1){ //line containing "File:" found
             String[] filePathParts = S[4].split("/"); //the 4th index is the filepath
             if(filePathParts.length>=2){//1st subpart check
                if(S[3].equals("read") && ((filePathParts[1].equals("proc") || filePathParts[1].equals("lib") || 
                        filePathParts[1].equals("usr")))){ //proc -> lib -> usr sequence not important, but if all of them read, then fishy
                    TTP1083[2] = 0;
                    return 3;
                }
             }
        }
        //fourth subpart
        if(length==7 && TTP1083[3]==1){ //line containing "File:" found
             String[] filePathParts = S[4].split("/"); //the 4th index is the filepath
             if(filePathParts.length>=2){//1st subpart check
                if(S[3].equals("write") && filePathParts[1].equals("tmp")){ //write in any file under '/tmp' folder
                    TTP1083[3] = 0;
                    return 4;
                }
             }
        }
        //fifth subpart
        if(length==7 && TTP1083[4]==1){ //line containing "File:" found
             String[] filePathParts = S[4].split("/"); //the 4th index is the filepath
             if(filePathParts.length>=2){//1st subpart check
                if(S[3].equals("read") && ((filePathParts[1].equals("proc") || filePathParts[1].equals("lib")))){
                    //proc -> lib sequence is not important, but if all of them read, then fishy
                    TTP1083[4] = 0;
                    return 5;
                }
             }
        }
        //sixth subpart
        if(length==7 && TTP1083[5]==1){ //line containing "File:" found
             String[] filePathParts = S[4].split("/"); //the 4th index is the filepath
             if(filePathParts.length>=2){//1st subpart check
                if(S[3].equals("read") && ((filePathParts[1].equals("proc") || filePathParts[1].equals("lib")))){
                    //proc -> lib sequence is not important, but if all of them read, then fishy
                    Arrays.fill(TTP1083,1); //again set all to 1
                    return 6;
                }
             }
        }
        return 0;
     }
     
     public static int T1030(String S[],int length){
         //four subparts
         //first subpart
         if(length==7 && S[0].equals("File:")){
             String[] filePathParts = S[4].split("/");
             if(S[3].equals("read") && filePathParts[1].equals("proc") && filePathParts[2].equals("filesystems")){
                 return 1;
             }

         }
         //second subpart
         if(length==7 && S[0].equals("Network:")){
             if(S[3].equals("unix") && S[4].equals("connect")){
                 return 2;
             }
         }
         //third subpart
         if(length==7 && TTP1030[0]==1 && S[0].equals("File:")){
             String[] filePathParts = S[4].split("/");
             if(S[3].equals("dup") && filePathParts[1].equals("tmp")){
                 TTP1030[0] = 0;
                 return 3;
             }
         }
         //fourth subpart
         if(length==7 && TTP1030[1]==1 && S[0].equals("File:")){
             String[] filePathParts = S[4].split("/");
             if(S[3].equals("dup") && filePathParts[1].equals("tmp")){
                 Arrays.fill(TTP1030,1);
                 return 4;
             }
         }
         
         return 0;
     }
}
