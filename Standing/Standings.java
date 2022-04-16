package Standing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Standings {
  private ArrayList<Team> teams = new ArrayList<>();

  public Standings() {};

  public Standings(String filename) throws IOException {
    this.readMatchData(filename);
  }

  public void calcRule(String teamNameA, int goalsA, int goalsB, String teamNameB) {
    List<Team> teamFilterA = teams.stream().filter(team -> team.name.equalsIgnoreCase(teamNameA))
        .collect(Collectors.toList());
    List<Team> teamFilterB = teams.stream().filter(team -> team.name.equalsIgnoreCase(teamNameB))
        .collect(Collectors.toList());
    Team teamA;
    Team teamB;
    if (teamFilterA.isEmpty()) {
      teamA = new Team(teamNameA);
    }
    else {
      teamA = teamFilterA.get(0);
    }
    if (teamFilterB.isEmpty()) {
      teamB = new Team(teamNameB);
    }
    else {
      teamB = teamFilterB.get(0);
    }
    if (goalsA > goalsB) {
      teamA.win++;
      teamA.point += 3;
      teamB.loss++;

    } else if (goalsA < goalsB) {
      teamB.win++;
      teamB.point += 3;
      teamA.loss++;
    } else {
      teamA.tie++;
      teamA.point += 1;
      teamB.tie++;
      teamB.point += 1;
    }
    teamA.score += goalsA;
    teamA.allowed += goalsB;
    teamB.score += goalsB;
    teamB.allowed += goalsA;
    if(teamFilterA.isEmpty()){
      this.teams.add(teamA);
    }
    if(teamFilterB.isEmpty()){
      this.teams.add(teamB);
    }
  }

  public void readMatchData(String filename) throws IOException {
    try (var input = new BufferedReader(new FileReader(filename))) {
      String line = null;
      while ((line = input.readLine()) != null) {
        String[] matchInfo = line.split("\\t");
        String[] goals = matchInfo[1].split("-");
        String teamA = matchInfo[0];
        String teamB = matchInfo[2];
        int goalsA = Integer.parseInt(goals[0]);
        int goalsB = Integer.parseInt(goals[1]);
        this.calcRule(teamA, goalsA, goalsB, teamB);
      }
    }
  }

  public void addMatchResult(String teamNameA, int goalsA, int goalsB, String teamNameB) {
    this.calcRule(teamNameA, goalsA, goalsB, teamNameB);
  }

  public List<Team> getTeams() {
    return this.teams;
  }

  public void printStandings() {
    List<Team> teamsReturned = this.getTeams();
    teamsReturned.sort((a,b)->(a.point<b.point) ? 1 : (a.point > b.point ? -1 
    : ((a.score - a.allowed < b.score - b.allowed)? 1 
    : ((a.score - a.allowed > b.score - b.allowed) ? -1 
    : (b.name.compareToIgnoreCase(a.name))))));
    for (int i = 0; i < teamsReturned.size();i++) {
      Team a = this.teams.get(i);
      System.out.printf("%-19s   %2d   %2d   %2d   %2d   %2d-%-2d   %2d%n", a.name, a.win + a.loss + a.tie,
          a.win, a.tie, a.loss, a.score, a.allowed, a.point);
    }
  }

  public static class Team {
    private String name = null;
    private int win = 0;
    private int tie = 0;
    private int loss = 0;
    private int score = 0;
    private int allowed = 0;
    private int point = 0;

    Team() {
    }

    Team(String name) {
      this.name = name;
    }

    String getName() {
      return this.name;
    }

    int getWins() {
      return this.win;
    }

    int getTies() {
      return this.tie;
    }

    int getLosses() {
      return this.loss;
    }

    int getScored() {
      return this.score;
    }

    int getAllowed() {
      return this.allowed;
    }

    int getPoints() {
      return this.point;
    }

  }

}
