// Main Class  
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
