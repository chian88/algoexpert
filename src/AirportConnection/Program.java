package AirportConnection;
import java.util.*;

class Program {
	public static int airportConnections(
			List<String> airports, List<List<String>> routes, String startingAirport) {
		// Write your code here.
		Map<String, List<String>> airportRoutes = buildRoute(airports, routes);

		Set<String> unreachableAirports = new HashSet<>();

		for (String airport : airports) {
			unreachableAirports.add(airport);
		}

		removeReachableAirport(startingAirport, airportRoutes, new HashSet<>(), unreachableAirports);
		Map<String, Integer> airportScores = new HashMap<>();
		calculateAirportScores(airportScores, unreachableAirports, airportRoutes);

		int count = 0;
		while (!unreachableAirports.isEmpty()) {
			String toAirport = findHighestScoreAirport(airportScores);

			List<String> toRoute = airportRoutes.get(startingAirport);
			toRoute.add(toAirport);

			removeReachableAirport(startingAirport, airportRoutes, new HashSet<>(), unreachableAirports);
			removeReachableAirportScores(airportScores, unreachableAirports);
			count++;
		}


		return count;
	}

	public static void removeReachableAirportScores(Map<String, Integer> airportScores, Set<String> unreachableAirports) {
		List<String> toRemoves = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : airportScores.entrySet()) {
			if (!unreachableAirports.contains(entry.getKey())) {
				toRemoves.add(entry.getKey());
			}
		}

		for (String airport : toRemoves) {
			airportScores.remove(airport);
		}

	}

	public static String findHighestScoreAirport (Map<String, Integer> airportScores) {
		int max = Integer.MIN_VALUE;
		String maxAirport = "";
		for (Map.Entry<String, Integer> entry : airportScores.entrySet()) {
			if (entry.getValue() > max) {
				max = entry.getValue();
				maxAirport = entry.getKey();
			}
		}

		return maxAirport;
	}

	public static void calculateAirportScores(Map<String, Integer> airportScores,
											  Set<String> unreachableAirports,
											  Map<String, List<String>> airportRoutes) {
		for (String unreachableAirport : unreachableAirports) {
			int score = dfs(unreachableAirport, unreachableAirports, airportRoutes, new HashSet<>());

			airportScores.put(unreachableAirport, score);
		}
	}

	public static int dfs(String unreachableAirport,
						  Set<String> unreachableAirports,
						  Map<String, List<String>> airportRoutes,
						  Set<String> visited) {
		Deque<String> stack = new ArrayDeque<>();

		int score = 0;

		stack.addFirst(unreachableAirport);

		while (!stack.isEmpty()) {
			String curr = stack.pollFirst();
			visited.add(curr);
			score++;

			for (String neighbors : airportRoutes.get(curr)) {
				if (unreachableAirports.contains(neighbors) &&
				    !visited.contains(neighbors)) {
					stack.addFirst(neighbors);
				}
			}

		}

		return score;
	}

	public static void removeReachableAirport(String startingAirport,
											  Map<String, List<String>> airportRoutes,
											  Set<String> visited,
											  Set<String> unreachableAirports) {
		Deque<String> stack = new ArrayDeque<>();

		stack.addFirst(startingAirport);

		while (!stack.isEmpty()) {
			String curr = stack.pollFirst();
			visited.add(curr);
			unreachableAirports.remove(curr);

			for (String neighbours : airportRoutes.get(curr)) {
				if (!visited.contains(neighbours)) {
					stack.addFirst(neighbours);
				}
			}
		}

	}


	public static Map<String, List<String>> buildRoute(List<String> airports, List<List<String>> routes) {
		Map<String, List<String>> result = new HashMap<>();

		for (String airport : airports) {
			List<String> toAirport = new ArrayList<>();


			for (List<String> route : routes) {
				if (route.get(0).equals(airport)) {
					toAirport.add(route.get(1));
				}
			}

			result.put(airport, toAirport);
		}
		return result;
	}

	public static void main(String[] args) {
		List<String> airports = Arrays.asList("BGI", "CDG", "DEL", "DOH", "DSM", "EWR", "EYW", "HND", "ICN", "JFK", "LGA", "LHR", "ORD", "SAN", "SFO", "SIN", "TLV", "BUD");
		List<List<String>> routes = new ArrayList<>();

		routes.add(Arrays.asList("DSM", "ORD"));
		routes.add(Arrays.asList("ORD", "BGI"));
		routes.add(Arrays.asList("BGI", "LGA"));
		routes.add(Arrays.asList("SIN", "CDG"));
		routes.add(Arrays.asList("CDG", "SIN"));
		routes.add(Arrays.asList("CDG", "BUD"));
		routes.add(Arrays.asList("DEL", "DOH"));
		routes.add(Arrays.asList("DEL", "CDG"));
		routes.add(Arrays.asList("TLV", "DEL"));
		routes.add(Arrays.asList("EWR", "HND"));
		routes.add(Arrays.asList("HND", "ICN"));
		routes.add(Arrays.asList("HND", "JFK"));
		routes.add(Arrays.asList("ICN", "JFK"));
		routes.add(Arrays.asList("JFK", "LGA"));
		routes.add(Arrays.asList("EYW", "LHR"));
		routes.add(Arrays.asList("LHR", "SFO"));
		routes.add(Arrays.asList("SFO", "SAN"));
		routes.add(Arrays.asList("SFO", "DSM"));
		routes.add(Arrays.asList("SAN", "EYW"));

		airportConnections(airports, routes, "LGA");
	}
}

