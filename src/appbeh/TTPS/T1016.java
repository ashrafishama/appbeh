package TTPs;

import java.util.ArrayList;

public class T1016 extends TTP {

	public void signatureScore(ArrayList<ArrayList<String>> targetFile) {
		int score = 0;
		for (int i = 0; i < targetFile.size(); i++) {
			score += signatureMatching(targetFile.get(i));
		}
		System.out.println("T1016:   " + score);
	}

	@Override
	public int signatureMatching(ArrayList<String> oneLine) {
		if (oneLine.get(0).equals("File:")) {

			if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/proc/net/arp"))) {
				return 1;
			}else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/proc/net/arp"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/etc/nsswitch.conf"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/etc/nsswitch.conf"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/etc/resolv.conf"))) {
				return 1;
			} else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/etc/resolv.conf"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/etc/host.conf"))) {
				return 1;
			} else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/etc/host.conf"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/etc/hosts"))) {
				return 1;
			} else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/etc/hosts"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/proc/net/tcp"))) {
				return 1;
			} else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/proc/net/tcp"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/proc/net/tcp6"))) {
				return 1;
			} else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/proc/net/tcp6"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/proc/net/dev"))) {
				return 1;
			} else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/proc/net/dev"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/proc/net/if_inet6"))) {
				return 1;
			} else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/proc/net/if_inet6"))) {
				return 1;
			} 
		}

		return 0;
	}

}
