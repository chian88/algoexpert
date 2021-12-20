package ApartmentHunting;

import java.util.*;

class Program {
	public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
		// Write your code here.


		// left to right

		List<Map<String, Integer>> minDists = new ArrayList<>();


		for (int i = 0; i < blocks.size(); i++) {
			Map<String, Boolean> block = blocks.get(i);
			Map<String, Integer> minDist = new HashMap<>();
			for (Map.Entry<String, Boolean> facility : block.entrySet()) {



				if (facility.getValue()) {
					minDist.put(facility.getKey(), 0);
				} else {
					minDist.put(facility.getKey(), Integer.MAX_VALUE);

					if (i - 1 >= 0) {
						Map<String, Integer> prevMinDist = minDists.get(i - 1);

						if (minDist.get(facility.getKey()) > prevMinDist.get(facility.getKey())) {
							minDist.put(facility.getKey(), prevMinDist.get(facility.getKey()) + 1);
						}
					}
				}


			}

			minDists.add(minDist);
		}

		for (int i = blocks.size() - 1; i >= 0; i--) {
			Map<String, Boolean> block = blocks.get(i);
			Map<String, Integer> minDist = minDists.get(i);
			for (Map.Entry<String, Boolean> facility : block.entrySet()) {

				if (facility.getValue()) {
					minDist.put(facility.getKey(), 0);
				} else {
					int existingMinDist = minDist.get(facility.getKey());

					if (i + 1 < blocks.size()) {
						Map<String, Integer> postMinDist = minDists.get(i + 1);

						if (existingMinDist > postMinDist.get(facility.getKey())) {
							minDist.put(facility.getKey(), postMinDist.get(facility.getKey()) + 1);
						}
					}
				}


			}

		}

		int best = 0;
		int overallMin = Integer.MAX_VALUE;

		for (int i = 1; i < minDists.size(); i++) {
			Map<String, Integer> minDist = minDists.get(i);

			int localMaxDist = Integer.MIN_VALUE;

			for (String req : reqs) {
				if (minDist.get(req) > localMaxDist) {
					localMaxDist = minDist.get(req);
				}
			}



			if (localMaxDist < overallMin) {
				overallMin = localMaxDist;
				best = i;
			}
		}




		return best;
	}

	public static void main(String[] args) {
		List<Map<String, Boolean>> blocks = new ArrayList<>();

		blocks.add(Map.of("gym", false, "school", true, "store", false));
		blocks.add(Map.of("gym", true, "school", false, "store", false));
		blocks.add(Map.of("gym", true, "school", true, "store", false));
		blocks.add(Map.of("gym", false, "school", true, "store", false));
		blocks.add(Map.of("gym", false, "school", true, "store", true));

		String[] reqs = new String[]{"gym", "school", "store"};

		apartmentHunting(blocks, reqs);

	}
}
