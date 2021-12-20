package ValidStartingCity;

import java.util.*;

class Program {

	public int validStartingCity(int[] distances, int[] fuel, int mpg) {
		// Write your code here.
		int[] distancesBefore = new int[distances.length];

		distancesBefore[0] = 0;
		int minDist = 0;
		int minCity = 0;

		for (int i = 1; i < distances.length; i++) {
			int distance = distances[i - 1];
			int milesAdded = fuel[i - 1] * mpg;
			distancesBefore[i] = milesAdded - distance + distancesBefore[i - 1];

			if ( distancesBefore[i] < minDist ) {
				minDist = distancesBefore[i];
				minCity = i ;
			}

		}

		return minCity;
	}
}
