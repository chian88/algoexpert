package TournamentWinner;

import java.util.*;

class Program {

    public String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        // Write your code here.
        HashMap<String, Integer> score = new HashMap<>();
        for ( int i = 0 ; i < competitions.size(); i ++) {
            ArrayList<String> competition = competitions.get(i);
            String home = competition.get(0);
            String away = competition.get(1);
            // competition[0] is hometeam, competition[1] is awayteam.
            Integer result = results.get(i);

            if (result == 1) {
                /// home wins.
                if (score.containsKey(home)) {
                    int temp = score.get(home);
                    score.put(home, temp + 1);
                } else {
                    score.put(home, 1);
                }
            } else {
                // away wins
                /// home wins.
                if (score.containsKey(away)) {
                    int temp = score.get(away);
                    score.put(away, temp + 1);
                } else {
                    score.put(away, 1);
                }
            }
        }

        Iterator it = score.entrySet().iterator();
        int maxScore = Integer.MIN_VALUE;
        String winner = "";

        while(it.hasNext()) {
            Map.Entry<String, Integer> entry = (Map.Entry) it.next();
            if (entry.getValue() > maxScore) {
                maxScore = entry.getValue();
                winner = entry.getKey();
            }
        }

        return winner;
    }
}
