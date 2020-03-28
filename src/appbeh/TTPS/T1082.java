package TTPs;

import java.util.ArrayList;

public class T1082 extends TTP {

	public void signatureScore(ArrayList<ArrayList<String>> targetFile) {
		int score = 0;
		for (int i = 0; i < targetFile.size(); i++) {
			score += signatureMatching(targetFile.get(i));
		}
		System.out.println("T1082:   " + score);
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

			if (oneLine.get(3).equals("open") && ((filePathParts[1].equals("/proc/modules")))) {
				return 1;
			} else if (oneLine.get(3).equals("read") && ((filePathParts[1].equals("/proc/modules")))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/proc/cmdline"))) {
				return 1;
			} else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/proc/cmdline"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/sys/module"))) {
				return 1;
			} else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/sys/module"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/sys/class/dmi/id/bios_version"))) {
				return 1;
			} else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/sys/class/dmi/id/bios_version"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/sys/class/dmi/id/chassis_vendor"))) {
				return 1;
			} else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/sys/class/dmi/id/chassis_vendor"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/sys/class/dmi/id/product_name"))) {
				return 1;
			} else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/sys/class/dmi/id/product_name"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/sys/firmware/dmi/tables"))) {
				return 1;
			} else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/sys/firmware/dmi/tables/"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/proc/scsi/scsi"))) {
				return 1;
			} else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/proc/scsi/scsi"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/sys/bus/pci/devices"))) {
				return 1;
			} else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/sys/bus/pci/devices"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/sys/bus/pci/slots"))) {
				return 1;
			} else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/sys/bus/pci/slots"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/usr/share/misc"))) {
				return 1;
			} else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/usr/share/misc"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/sys/devices/system/node"))) {
				return 1;
			} else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/sys/devices/system/node"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/sys/devices/system/cpu"))) {
				return 1;
			} else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/sys/devices/system/cpu"))) {
				return 1;
			} else if (oneLine.get(3).equals("open") && (oneLine.get(4).contains("/proc/cpuinfo"))) {
				return 1;
			} else if (oneLine.get(3).equals("read") && (oneLine.get(4).contains("/proc/cpuinfo"))) {
				return 1;
			}
		}
		return 0;
	}

}
