package SunsetViews;

import java.lang.reflect.Array;
import java.util.*;

class Program {

	public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
		// Write your code here.
		ArrayList<Integer> res = new ArrayList<>();
		if (buildings.length == 0) return res;
		if (direction.equals("EAST")) {
			int max = buildings[buildings.length - 1];
			res.add(buildings.length - 1);
			for (int i = buildings.length - 2; i >= 0; i--) {
				if (buildings[i] > max) {
					res.add(0,i);
					max = buildings[i];
				}
			}
		} else if (direction.equals("WEST")) {
			int max = buildings[0];
			res.add(0);
			for (int i = 1; i < buildings.length; i++) {
				if (buildings[i] > max) {
					res.add(i);
					max = buildings[i];
				}
			}
		}


		return res;
	}
}
