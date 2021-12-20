package LaptopRental;

import java.util.*;

class Program {

	public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
		// Write your code here.
		PriorityQueue<Integer> endTimes = new PriorityQueue<>();

		Collections.sort(times, (a, b) -> {
			int startTimeCmp = Integer.compare(a.get(0), b.get(0));
			if (startTimeCmp != 0) {
				return startTimeCmp;
			}

			return Integer.compare(a.get(1), b.get(1));
		});
		int maxLaptop = 0;
		for (ArrayList<Integer> time : times) {
			if (endTimes.isEmpty()) {
				maxLaptop = Math.max(maxLaptop, 1);
				endTimes.add(time.get(1));
			} else {

				while (!endTimes.isEmpty() && endTimes.peek() <= time.get(0)) {
					endTimes.poll();
				}

				endTimes.add(time.get(1));
				maxLaptop = Math.max(maxLaptop, endTimes.size());

			}
		}

		return maxLaptop;
	}
}
