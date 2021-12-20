package LowestCommonManager;
import java.util.*;

class Program {
	public static OrgChart getLowestCommonManager(
			OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
		// Write your code here.
		int branchOneIdx = -1;
		int branchTwoIdx = -1;

		for (int i = 0; i  < topManager.directReports.size(); i++) {
			OrgChart candidate = topManager.directReports.get(i);
			if (findThisBranch(candidate, reportOne)) branchOneIdx = i;
			if (findThisBranch(candidate, reportTwo)) branchTwoIdx = i;

		}

		if (branchOneIdx == branchTwoIdx) {
			return getLowestCommonManager(topManager.directReports.get(branchOneIdx), reportOne, reportTwo);
		} else {
			return topManager;
		}

	}

	public static boolean findThisBranch(
			OrgChart root, OrgChart target) {
		if (root.name == target.name) return true;

		for (OrgChart possible : root.directReports) {
			if (findThisBranch(possible, target)) return true;
		}
		return false;
	}

	static class OrgChart {
		public char name;
		public List<OrgChart> directReports;

		OrgChart(char name) {
			this.name = name;
			this.directReports = new ArrayList<OrgChart>();
		}

		// This method is for testing only.
		public void addDirectReports(OrgChart[] directReports) {
			for (OrgChart directReport : directReports) {
				this.directReports.add(directReport);
			}
		}
	}

	public static void main(String[] args) {
		OrgChart A = new OrgChart('A');
		OrgChart B = new OrgChart('B');
		OrgChart C = new OrgChart('C');
		OrgChart D = new OrgChart('D');
		OrgChart E = new OrgChart('E');
		OrgChart F = new OrgChart('F');
		OrgChart G = new OrgChart('G');
		OrgChart H = new OrgChart('H');
		OrgChart I = new OrgChart('H');
		OrgChart J = new OrgChart('J');

		A.addDirectReports(new OrgChart[] {B, C, J});
		B.addDirectReports(new OrgChart[] {D, E});
		C.addDirectReports(new OrgChart[] {F, G});
		D.addDirectReports(new OrgChart[] {H, I});

		getLowestCommonManager(A, H , E);
	}
}
