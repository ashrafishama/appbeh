package TTPs;

import java.util.ArrayList;

public class T1158 extends TTP {
	public void signatureScore(ArrayList<ArrayList<String>> targetFile) {
		int score = 0;
		for (int i = 0; i < targetFile.size(); i++) {
			score+= signatureMatching(targetFile.get(i));
		}
		System.out.println("T1158:   "+score);
	}

	@Override
	public int signatureMatching(ArrayList<String> oneLine) {
		if (oneLine.get(0).equals("File:")) { 
			
			//special case
			if (oneLine.get(4).equals("NA"))
				return 0;
			String[] filePathParts = oneLine.get(4).split("/");
            
			//special case
			if (filePathParts.length == 1) return 0;
			
			if (oneLine.get(3).equals("write") && ((filePathParts[filePathParts.length - 1].charAt(0)== ('.'))
							|| (filePathParts[filePathParts.length - 2].charAt(0)== ('.')))) {
				return 1;
			}
		}
		return 0;
	}
}
