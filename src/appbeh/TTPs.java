package appbeh;

import sun.security.util.Length;

/*
 * @author ashrafi
 */
public class TTPs {
    //public String line;
    public static boolean T1156(String S[],int length){ //T1156-1 & T1156-2
        if(length==5){ //line containing "File:" found
            String[] filePathParts = S[3].split("/");
            if(filePathParts[2].equals("write") && (filePathParts[0].equals("home") || filePathParts[0].equals("root")) && 
                    (filePathParts[length-1].equals(".bash_profile") || filePathParts[length-1].equals(".bashrc"))){
                return true;
            }
        }
        return false; //if no hard match found to this TTP
    }
}
