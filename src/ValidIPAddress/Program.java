package ValidIPAddress;

import java.util.*;

class Program {

    public static ArrayList<String> validIPAddresses(String string) {
        // Write your code here.

		ArrayList<String> res = new ArrayList<>();

		for (int i = 1; (i < string.length() && i < 4); i ++) {
			String first = string.substring(0,i);
			if (!isValidIPAddress(first)) continue;
			for (int j = i+1 ; (j < string.length() && j < i+4 ); j++) {
				String second = string.substring(i, j);
				if (!isValidIPAddress(second)) continue;

				for (int k = j + 1; (k < string.length() && k < j + 4); k++ ) {
					String third = string.substring(j, k);
					String fourth = string.substring(k);

					if (!isValidIPAddress(third)) continue;
					if (!isValidIPAddress(fourth)) continue;

					res.add(first + "." + second + "." + third + "." + fourth);

				}
			}
		}

        return res;
    }

    private static boolean isValidIPAddress(String ip) {
    	if (ip.startsWith("0") && ip.length() > 1) {
    		return false;
		} else {
    		int ipInt = Integer.parseInt(ip);
    		return (ipInt >= 0 && ipInt <= 255);
		}
	}

	public static void main(String[] args) {
		validIPAddresses("9743");
	}
}
