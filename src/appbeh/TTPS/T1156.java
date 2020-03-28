package TTPs;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T1156 extends TTP {

	public void signatureScore(ArrayList<ArrayList<String>> targetFile) {
		int score = 0;
		for (int i = 0; i < targetFile.size(); i++) {
			score += signatureMatching(targetFile.get(i));
		}
		System.out.println("T1156:   " + score);
	}

	@Override
	public int signatureMatching(ArrayList<String> oneLine) {
		
		//special case
		if (oneLine.get(4).equals("NA"))
			return 0;
		
		String[] filePathParts = oneLine.get(4).split("/");
		//special case
		if (filePathParts.length < 2) return 0;
		
		String dirname="";
		String basename= filePathParts[filePathParts.length-1];
		for(int i=0;i<filePathParts.length-1;i++) {
		if(i!=0) dirname = dirname.concat("/");
		dirname = dirname.concat(filePathParts[i]);
		if(i==filePathParts.length-2) dirname = dirname.concat("/");
		}
		
		String pattern1 = "(/root/|/home/).*";
		Pattern p1 = Pattern.compile(pattern1);  
		Matcher m1 = p1.matcher(dirname);  
		
		String pattern2 =  "(.*rc|.*sh_profile)";
		Pattern p2 = Pattern.compile(pattern2);  
		Matcher m2 = p2.matcher(basename);  
		
		if((oneLine.get(3).equals("open")||oneLine.get(3).equals("dup")||oneLine.get(3).equals("write"))
				&& m1.matches() && m2.matches()) return 1;
		return 0;
	}

}