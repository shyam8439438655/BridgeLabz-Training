public class ShortTallAndMeanHeight {
    // Method to generate array of random heights between 150 and 250 cm
    public static int[] generateRandomHeights(int size) {
        int[] heights = new int[size];

        for (int i = 0; i < size; i++) {
            heights[i] = (int)(Math.random() * 101) + 150; // generates 150–250
        }

        return heights;
    }
    // Method to find the sum of all heights
    public static int findSum(int[] heights) {
        int sum = 0;
        for (int height : heights) {
            sum += height;
        }
        return sum;
    }
    // Method to find the mean height
    public static double findMean(int[] heights) {
        int sum = findSum(heights);
        return (double) sum / heights.length;
    }
    // Method to find the shortest height
    public static int findShortest(int[] heights) {
        int min = heights[0];
        for (int height : heights) {
            min = Math.min(min, height);
        }
        return min;
    }
    // Method to find the tallest height
    public static int findTallest(int[] heights) {
        int max = heights[0];
        for (int height : heights) {
            max = Math.max(max, height);
        }
        return max;
    }
    public static void main(String[] args) {

        // Generate random heights for 11 players
        int[] playerHeights = generateRandomHeights(11);

        System.out.println("Player Heights (in cm):");
        for (int height : playerHeights) {
            System.out.println(height);
        }
        // Calculate and display results
        double meanHeight = findMean(playerHeights);
        int shortestHeight = findShortest(playerHeights);
        int tallestHeight = findTallest(playerHeights);

        System.out.println("\nMean Height: " + meanHeight + " cm");
        System.out.println("Shortest Height: " + shortestHeight + " cm");
        System.out.println("Tallest Height: " + tallestHeight + " cm");
    }
}