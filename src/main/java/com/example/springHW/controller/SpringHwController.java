package com.example.springHW.controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
public class SpringHwController {

    ArrayList<Team> teams = new ArrayList<>();

    public SpringHwController() {
        teams.add(new Team(1, "Liverpool", "England", "Premier League", 20, 9.0));
        teams.add(new Team(2, "Barcelona", "Spain", "La Liga", 28, 9.3));
        teams.add(new Team(3, "Bayern Munich", "Germany", "Bundesliga", 34, 9.1));
        teams.add(new Team(4, "Real Madrid", "Spain", "La Liga", 36, 9.5));
        teams.add(new Team(5, "Manchester City", "England", "Premier League", 10, 8.9));
    }

    // 1. Welcome
    @GetMapping("/api")
    public Map<String, String> welcome() {
        Map<String, String> response = new HashMap<>();

        response.put("application", "Football Team API");
        response.put("name", "Mohamed Rashad Aljoamee");
        response.put("theme", "Sports - Football");
        response.put("description", "A REST API for football teams");

        return response;
    }

    // 2. Get all teams
    @GetMapping("/teams")
    public ArrayList<Team> getAllTeams() {
        return teams;
    }

    // 3. Get one team
    @GetMapping("/teams/{id}")
    public Object getTeam(@PathVariable int id) {

        for (Team team : teams) {
            if (team.id == id) {
                return team;
            }
        }

        return "Team not found";
    }

    // 4. Search by name
    @GetMapping("/teams/search")
    public ArrayList<Team> searchTeam(@RequestParam String name) {

        ArrayList<Team> results = new ArrayList<>();

        for (Team team : teams) {
            if (team.name.toLowerCase().contains(name.toLowerCase())) {
                results.add(team);
            }
        }

        return results;
    }

    // 5. Filter by league
    @GetMapping("/teams/filter")
    public ArrayList<Team> filterTeams(@RequestParam String league) {

        ArrayList<Team> results = new ArrayList<>();

        for (Team team : teams) {
            if (team.league.equalsIgnoreCase(league)) {
                results.add(team);
            }
        }

        return results;
    }

    // 6. Add a team
    @PostMapping("/teams")
    public Team addTeam(@RequestBody Team team) {

        team.id = teams.size() + 1;

        teams.add(team);

        return team;
    }

    // 7. Update a team
    @PutMapping("/teams/{id}")
    public Object updateTeam(@PathVariable int id, @RequestBody Team updatedTeam) {

        for (Team team : teams) {

            if (team.id == id) {

                team.name = updatedTeam.name;
                team.country = updatedTeam.country;
                team.league = updatedTeam.league;
                team.titles = updatedTeam.titles;
                team.rating = updatedTeam.rating;

                return team;
            }
        }

        return "Team not found";
    }

    // 8. Delete a team
    @DeleteMapping("/teams/{id}")
    public String deleteTeam(@PathVariable int id) {

        for (int i = 0; i < teams.size(); i++) {

            if (teams.get(i).id == id) {

                teams.remove(i);

                return "Team deleted";
            }
        }

        return "Team not found";
    }

    // 9. Statistics
    @GetMapping("/teams/stats")
    public Map<String, Object> stats() {

        Map<String, Object> response = new HashMap<>();

        double totalRating = 0;

        for (Team team : teams) {
            totalRating += team.rating;
        }

        response.put("totalTeams", teams.size());
        response.put("averageRating", totalRating / teams.size());

        return response;
    }

    // 10. Random team
    @GetMapping("/teams/random")
    public Team randomTeam() {

        Random random = new Random();

        int index = random.nextInt(teams.size());

        return teams.get(index);
    }
}

