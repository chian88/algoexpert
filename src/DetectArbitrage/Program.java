package DetectArbitrage;

import java.util.*;

class Program {

	public static boolean detectArbitrage(ArrayList<ArrayList<Double>> exchangeRates) {
		// Write your code here.
		ArrayList<ArrayList<Double>> logExchanges = convertToLogMatrix(exchangeRates);

		return foundNegativeWeightCycle(logExchanges, 0);
	}

	private static boolean foundNegativeWeightCycle(ArrayList<ArrayList<Double>> graph, int start) {
		double[] distancesFromStart = new double[graph.size()];
		Arrays.fill(distancesFromStart, Double.MAX_VALUE);
		distancesFromStart[start] = 0;

		for (int unused = 0; unused < graph.size(); unused++) {
			if (!relaxEdgesAndUpdateDistances(graph, distancesFromStart)) {
				return false;
			}
		}

		return relaxEdgesAndUpdateDistances(graph, distancesFromStart);
	}

	private static boolean relaxEdgesAndUpdateDistances(ArrayList<ArrayList<Double>> graph, double[] distances) {
		boolean updated = false;
		for (int sourceIdx = 0; sourceIdx < graph.size() ; sourceIdx++) {
			ArrayList<Double> edges = graph.get(sourceIdx);
			for (int destinationIdx = 0; destinationIdx < edges.size(); destinationIdx++) {
				double edgeWeight = edges.get(destinationIdx);
				double newDistanceToDestination = distances[sourceIdx] + edgeWeight;
				if (newDistanceToDestination < distances[destinationIdx]) {
					updated = true;
					distances[destinationIdx] = newDistanceToDestination;
				}
			}
		}

		return updated;
	}

	private static ArrayList<ArrayList<Double>> convertToLogMatrix(ArrayList<ArrayList<Double>> matrix) {

		ArrayList<ArrayList<Double>> newMatrix = new ArrayList<>();

		for (int row = 0; row < matrix.size(); row++) {
			ArrayList<Double> rates = matrix.get(row);
			newMatrix.add(new ArrayList<>());
			for (Double rate : rates) {
				newMatrix.get(row).add(-Math.log10(rate));
			}
		}

		return newMatrix;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Double>> exchangeRates = new ArrayList<>();
		exchangeRates.add(new ArrayList<Double>(Arrays.asList(1.0, 0.8631, 0.5903)));
		exchangeRates.add(new ArrayList<Double>(Arrays.asList(1.1586, 1.0, 0.6849)));
		exchangeRates.add(new ArrayList<Double>(Arrays.asList(1.6939, 1.46, 1.0)));
		detectArbitrage(exchangeRates);
	}
}
