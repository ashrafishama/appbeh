package TTPs;

import java.util.ArrayList;

public class T1083 extends TTP {

	public void signatureScore(ArrayList<ArrayList<String>> targetFile) {
		int score = 0;
		for (int i = 0; i < targetFile.size(); i++) {
			score += signatureMatching(targetFile.get(i));
		}
		System.out.println("T1083:   " + score);
	}

	@Override
	public int signatureMatching(ArrayList<String> oneLine) {
		if (oneLine.get(0).equals("File:")) {

			if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/etc/magic"))) {
				return 1;
			}else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/etc/magic"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/usr/share/misc/magic.mgc"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/usr/lib/locale/locale-archive"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/proc/filesystems"))) {
				return 1;
			} else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/proc/filesystems"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/etc/nsswitch.conf"))) {
				return 1;
			} else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/etc/nsswitch.conf"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/var/lib/mlocate/mlocate.db"))) {
				return 1;
			} else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/var/lib/mlocate/mlocate.db"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/usr/bin/which"))) {
				return 1;
			} else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/usr/bin/which"))) {
				return 1;
			} 
		}


		return 0;
	}

}
