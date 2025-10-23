import java.util.*;

// Class representing a city location  (M1_Ujali)
class Location {
    String name;
    Location(String name) {
        this.name = name;
    }
}

// Class representing a simple linked list for storing locations (M2_Sithara)
class LocationList {
    LinkedList<String> locations = new LinkedList<>();

    public void add(String name) {
        locations.add(name);
    }

    public void remove(String name) {
        locations.remove(name);
    }

    public void display() {
        if (locations.isEmpty()) {
            System.out.println("No locations added yet.");
            return;
        }
        System.out.println("All Locations:");
        for (String loc : locations) {
            System.out.println(" - " + loc);
        }
    }
}

 // Class representing a graph using adjacency list (M1_Ujali)
class Graph {
    private Map<String, List<String>> adjList = new HashMap<>();

    public void addLocation(String name) {
        adjList.putIfAbsent(name, new ArrayList<>());
    }

    public void removeLocation(String name) {
        if (!adjList.containsKey(name)) {
            System.out.println("Location not found.");
            return;
        }
        adjList.remove(name);
        for (List<String> roads : adjList.values()) {
            roads.remove(name);
        }
    }

    public void addRoad(String from, String to) {
        if (!adjList.containsKey(from) || !adjList.containsKey(to)) {
            System.out.println("One or both locations do not exist!");
            return;
        }
        adjList.get(from).add(to);
        adjList.get(to).add(from);
    }

    public void removeRoad(String from, String to) {
        if (!adjList.containsKey(from) || !adjList.containsKey(to)) {
            System.out.println("Invalid locations!");
            return;
        }
        adjList.get(from).remove(to);
        adjList.get(to).remove(from);
    }

    public void displayConnections() {
        if (adjList.isEmpty()) {
            System.out.println("No connections available.");
            return;
        }
        System.out.println("City Connections:");
        for (var entry : adjList.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }

    // Optional: Breadth-First Traversal ( using Queue) (M3_Ruwanthika )
    public void bfsTraversal(String start) {
        if (!adjList.containsKey(start)) {
            System.out.println("Start location not found!");
            return;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

        System.out.print("BFS Route from " + start + ": ");
        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");

            for (String neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }
}


// Main Class  (M4_pasindu)
public class SmartCityRoutePlanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Graph graph = new Graph();
        LocationList list = new LocationList();

        while (true) {
            System.out.println("\n--- Smart City Route Planner ---");
            System.out.println("1. Add a new location");
            System.out.println("2. Remove a location");
            System.out.println("3. Add a road between locations");
            System.out.println("4. Remove a road");
            System.out.println("5. Display all connections");
            System.out.println("6. Display all locations");
            System.out.println("7. Traverse (BFS)");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter location name: ");
                    String name = sc.nextLine();
                    graph.addLocation(name);
                    list.add(name);
                    System.out.println("Location added successfully.");
                }
                case 2 -> {
                    System.out.print("Enter location name to remove: ");
                    String name = sc.nextLine();
                    graph.removeLocation(name);
                    list.remove(name);
                }
                case 3 -> {
                    System.out.print("Enter first location: ");
                    String from = sc.nextLine();
                    System.out.print("Enter second location: ");
                    String to = sc.nextLine();
                    graph.addRoad(from, to);
                }
                case 4 -> {
                    System.out.print("Enter first location: ");
                    String from = sc.nextLine();
                    System.out.print("Enter second location: ");
                    String to = sc.nextLine();
                    graph.removeRoad(from, to);
                }
                case 5 -> graph.displayConnections();
                case 6 -> list.display();
                case 7 -> {
                    System.out.print("Enter starting location: ");
                    String start = sc.nextLine();
                    graph.bfsTraversal(start);
                }
                case 8 -> {
                    System.out.println("Exiting program...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}