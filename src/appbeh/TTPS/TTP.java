package TTPs;

import java.util.ArrayList;

abstract public class TTP {

	public abstract void signatureScore(ArrayList<ArrayList<String>> targetFile);
	public abstract int signatureMatching(ArrayList<String> oneLine);
}
