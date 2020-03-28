package TTPs;

import java.util.ArrayList;

public class T1139 extends TTP {

	public void signatureScore(ArrayList<ArrayList<String>> targetFile) {
		int score = 0;
		for (int i = 0; i < targetFile.size(); i++) {
			score += signatureMatching(targetFile.get(i));
		}
		System.out.println("T1139:   " + score);
	}

	@Override
	public int signatureMatching(ArrayList<String> oneLine) {
		if (oneLine.get(0).equals("File:")) {

			// special case
			if (oneLine.get(4).equals("NA"))
				return 0;
			String[] filePathParts = oneLine.get(4).split("/");

			// special case
			if (filePathParts.length == 1)
				return 0;

			if (oneLine.get(3).equals("open")
					&& (filePathParts[1].equals("root") || filePathParts[1].equals("etc")
							|| filePathParts[1].equals("usr"))
					&& (filePathParts[filePathParts.length - 1].equals("ld.so.cache")
							|| filePathParts[filePathParts.length - 1].equals("locale.alias")
							|| filePathParts[filePathParts.length - 1].equals(".bash_history"))) {
				return 1;
			}

			else if (oneLine.get(3).equals("read")
					&& (filePathParts[1].equals("root") || filePathParts[1].equals("etc")
							|| filePathParts[1].equals("usr"))
					&& (filePathParts[filePathParts.length - 1].equals("ld.so.cache")
							|| filePathParts[filePathParts.length - 1].equals("locale.alias")
							|| filePathParts[filePathParts.length - 1].equals(".bash_history"))) {
				return 1;
			}

		}
		return 0;
	}

}
