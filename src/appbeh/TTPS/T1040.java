package TTPs;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T1040 extends TTP {

	public void signatureScore(ArrayList<ArrayList<String>> targetFile) {
		int score = 0;
		for (int i = 0; i < targetFile.size(); i++) {
			score += signatureMatching(targetFile.get(i));
		}
		System.out.println("T1040:   " + score);
	}

	@Override
	public int signatureMatching(ArrayList<String> oneLine) {
		if (oneLine.get(0).equals("Network:")) {
	
			if ((oneLine.get(2).equals("netlink")) && (oneLine.get(3).equals("sendto")||oneLine.get(3).equals("recvfrom")))
				return 1;
		}

		return 0;
	}

}
