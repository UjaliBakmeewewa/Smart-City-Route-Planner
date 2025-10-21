/*Represents roads between locations (Adjacency List recommended) */

import java.util.*;

class Graph {
    private Map<String, List<String>> adjList = new HashMap<>();

    public void addLocation(String name) {
        adjList.putIfAbsent(name, new ArrayList<>());
    }

    public void removeLocation(String name) {
        adjList.remove(name);
        for (List<String> roads : adjList.values()) {
            roads.remove(name);
        }
    }

    public void addRoad(String from, String to) {
        if (adjList.containsKey(from) && adjList.containsKey(to)) {
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }
    }

    public void removeRoad(String from, String to) {
        adjList.get(from).remove(to);
        adjList.get(to).remove(from);
    }

    public void displayConnections() {
        for (var entry : adjList.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }

    public Set<String> getLocations() {
        return adjList.keySet();
    }
}

