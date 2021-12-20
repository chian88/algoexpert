package AmbigousMeasurements;

import java.util.*;

class Program {

	public boolean ambiguousMeasurements(int[][] measuringCups, int low, int high) {
		// Write your code here.
		return ambiguousMeasurementsHelper(measuringCups, low, high, new HashMap<>() );
	}

	public boolean ambiguousMeasurementsHelper(int[][] measuringCups, int low, int high, Map<String, Boolean> memo) {
		// Write your code here.

		if (low < 0 && high < 0) {
			memo.put(low + ":" + high, false);
			return false;
		}

		if (memo.containsKey(low + ":" + high)) return false;

		for (int i = 0; i < measuringCups.length; i++) {
			int[] cup = measuringCups[i];


			if (low <= cup[0] && high >= cup[1]) return true;

			if (ambiguousMeasurementsHelper(measuringCups, low - cup[0], high - cup[1], memo)) return true;
		}
		memo.put(low + ":" + high, false);

		return false;
	}


}
