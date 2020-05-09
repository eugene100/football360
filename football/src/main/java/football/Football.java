package football;

/**
 Football application calculate final scores of teams.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Team {

    int score = 0;
    String name;

    Team(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        return name + " " + score;
    }

}


class Match {
    Team[] teams;
    int[] goalsTeams;
    int result = 0; // 1 - Left[0] team winner, 0 - tie, -1 - Right[1] team winner
                    // ToDo: Change to Enum

    public Match(final String bulkMatch) {
        teams = new Team[2];
        goalsTeams = new int[2];
        final String[] m = bulkMatch.trim().split(",");         // Eg bulkMatch: Tarantulas 3, Snakes 1
        int i = 0;
        for (String part: m) {
            String[] teamBulk = part.trim().split("\\s+", -1);  // Eg teamBulk: Tarantulas 3
            teams[i] = new Team(teamBulk[0]);
            goalsTeams[i] = Integer.parseInt(teamBulk[1]);
            i += 1;
        }
        if (goalsTeams[0] > goalsTeams[1]) {
            result = 1;
        } else if (goalsTeams[0] < goalsTeams[1]) {
            result = -1;
        }
    }
}


class Competition {
    ArrayList<Match> matches;
    Map<String, Team> teams;

    public Competition() {
        matches = new ArrayList<Match>();
        teams = new HashMap<String, Team>();
    }

    void addMatch(final String bulkMatch) {
        Match match = new Match(bulkMatch);
        addTeams(match);
        updateScores(match);
        matches.add(match);
    }

    private void addTeams(Match match) {
        for (Team t: match.teams) {
            if (teams.containsKey(t.name)) {
                t = teams.get(t.name);
            } else {
                teams.put(t.name, t);
            }
        }
    }

    private void updateScores(Match match) {
        Team team;
        switch (match.result) {
            case -1:
                team = teams.get(match.teams[1].name);
                team.score += 2;
                break;
            case 0:
                team = teams.get(match.teams[0].name);
                team.score += 1;
                team = teams.get(match.teams[1].name);
                team.score += 1;
                break;
            case 1:
                team = teams.get(match.teams[0].name);
                team.score += 2;
                break;
        }
    }

    @Override
    public String toString() {
        String report = "";

        return report;
    }
}


public class Football {

    private static void printHelp() {
        System.out.println("\nFootball application calculate final scores of teams.");
        System.out.println("\nUsage:");
        System.out.println("java -cp football/target/classes football.Football <CSV file>\n");
    }

    private static String getPathFromArgs(String[] args) {
        if (args.length == 0) {
            printHelp();
            System.exit(1);
        }
        return args[0];
    }

    public static void main(final String[] args) throws Exception {

        final String pathToCsv = getPathFromArgs(args);

        System.out.println("Processing file: " + pathToCsv);

        final BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));

        final Competition competition = new Competition();

        String row;
        while ((row = csvReader.readLine()) != null) {
            // System.out.println(row);
            competition.addMatch(row);
        }
        csvReader.close();

        System.out.println(competition);

    }
}