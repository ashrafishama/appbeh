package TTPs;

import java.util.ArrayList;

public class T1201 extends TTP {

	public void signatureScore(ArrayList<ArrayList<String>> targetFile) {
		int score = 0;
		for (int i = 0; i < targetFile.size(); i++) {
			score += signatureMatching(targetFile.get(i));
		}
		System.out.println("T1201:   " + score);
	}

	@Override
	public int signatureMatching(ArrayList<String> oneLine) {
		if (oneLine.get(0).equals("File:")) {

			if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/etc/pam.d/common-password"))) {
				return 1;
			}else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/etc/pam.d/common-password "))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/etc/login.defs"))) {
				return 1;
			} else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/etc/login.defs"))) {
				return 1;
			}
		}
		return 0;
	}

}
