package TTPs;

import java.util.ArrayList;

public class T1033 extends TTP {

	public void signatureScore(ArrayList<ArrayList<String>> targetFile) {
		int score = 0;
		for (int i = 0; i < targetFile.size(); i++) {
			score += signatureMatching(targetFile.get(i));
		}
		System.out.println("T1033:   " + score);
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

			if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/var/run/utmp"))) {
				return 1;
			} else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/var/run/utmp"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/proc/filesystems"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/proc/filesystems"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/sys/devices/system/cpu/online"))) {
				return 1;
			} else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/sys/devices/system/cpu/online"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/etc/nsswitch.conf"))) {
				return 1;
			} else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/etc/nsswitch.conf"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/proc"))) {
				if (filePathParts.length < 3)
					return 0;
				if (Character.isDigit(filePathParts[2].charAt(0)))
					return 1;
				return 0;
			} else if (oneLine.get(3).equals("write") && (oneLine.get(4).contains("/proc"))) {
				if (filePathParts.length < 3)
					return 0;
				if (Character.isDigit(filePathParts[2].charAt(0)))
					return 1;
				return 0;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/proc/loadavg"))) {
				return 1;
			} else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/proc/loadavg"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/etc/passwd"))) {
				return 1;
			} else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/etc/passwd"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/etc/localtime"))) {
				return 1;
			} else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/etc/localtime"))) {
				return 1;
			}
		}

		return 0;
	}

}
