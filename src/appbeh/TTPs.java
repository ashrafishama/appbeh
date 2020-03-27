package appbeh;

import java.util.Arrays;
/*
 * @author ashrafi
 */
public class TTPs {
    //public String line;
    public static int T1156(String S[],int length){ //T1156-1 & T1156-2
        //System.err.println(Arrays.toString(S));
        
        if(length==5){ //line containing "File:" found
            String[] filePathParts = S[3].split("/");
            if(filePathParts[0].equals("open") && (filePathParts[1].equals("home") || filePathParts[1].equals("root")) && 
                    (filePathParts[length-1].equals(".bash_profile") || filePathParts[length-1].equals(".bashrc"))){
                return 1; //subpart 1
            }
        }
        if(length==5){ //line containing "File:" found
            String[] filePathParts = S[3].split("/");
            if(filePathParts[0].equals("dup") && (filePathParts[1].equals("home") || filePathParts[1].equals("root")) && 
                    (filePathParts[length-1].equals(".bash_profile") || filePathParts[length-1].equals(".bashrc"))){
                return 2; //subpart 2
            }
        }
        if(length==5){ //line containing "File:" found
            String[] filePathParts = S[3].split("/");
            if(filePathParts[0].equals("write") && (filePathParts[1].equals("home") || filePathParts[1].equals("root")) && 
                    (filePathParts[length-1].equals(".bash_profile") || filePathParts[length-1].equals(".bashrc"))){
                return 3; //subpart 3
            }
        }
        return 0; //if no hard match found to this TTP
    }
}
