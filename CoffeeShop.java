import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public static void main(String[] args) {
    int pricePerCoffee = 250;
    int numCoffeeSold = 100;
    int totalCostOfBeans = 15000;


    int otherExpenses = readExpensesFromFile("expenses.txt");

    double profit = calculateProfit(pricePerCoffee, numCoffeeSold, totalCostOfBeans, otherExpenses);
    System.out.println(STR."Profit: \{profit} Laris");
}

public static double calculateProfit(int pricePerCoffee, int numCoffeeSold, int totalCostOfBeans, int otherExpenses) {
    double totalRevenue = pricePerCoffee * numCoffeeSold / 100.0;
    double totalCost = totalCostOfBeans / 100.0 + otherExpenses / 100.0;
    return totalRevenue - totalCost;
}

public static int readExpensesFromFile(String filename) {
    int totalExpenses = 0;
    try {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {

            String[] parts = line.split(" - ");
            if (parts.length == 2) {

                if (parts[1].contains("lari")) {
                    totalExpenses += Integer.parseInt(parts[1].replace(" lari", "").trim());
                } else if (parts[1].contains("tetri")) {
                    totalExpenses += Integer.parseInt(parts[1].replace(" tetri", "").trim()) / 100;
                }
            }
        }
        reader.close();
    } catch (IOException e) {
        System.err.println(STR."Error reading expenses file: \{e.getMessage()}");
    }
    return totalExpenses;
}

