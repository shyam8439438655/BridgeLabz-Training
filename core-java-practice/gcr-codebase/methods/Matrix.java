import java.util.Scanner;

public class Matrix {

    // Method to input a matrix
    public static int[][] inputMatrix(Scanner sc, int rows, int cols, String name) {
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter elements of Matrix " + name + ":");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(name + "[" + i + "][" + j + "] = ");
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    // Method to print a matrix
    public static void printMatrix(int[][] matrix, String name) {
        System.out.println("Matrix " + name + ":");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    // Method to add two matrices
    public static int[][] addMatrices(int[][] A, int[][] B) {
        int rows = A.length, cols = A[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[i][j] = A[i][j] + B[i][j];
        return result;
    }

    // Method to subtract two matrices
    public static int[][] subtractMatrices(int[][] A, int[][] B) {
        int rows = A.length, cols = A[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[i][j] = A[i][j] - B[i][j];
        return result;
    }

    // Method to multiply two matrices
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rowsA = A.length, colsA = A[0].length;
        int colsB = B[0].length; // only need colsB, rowsB not required
        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++)
            for (int j = 0; j < colsB; j++)
                for (int k = 0; k < colsA; k++)
                    result[i][j] += A[i][k] * B[k][j];
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input dimensions
        System.out.print("Enter rows and columns for Matrix A: ");
        int rowsA = sc.nextInt(), colsA = sc.nextInt();

        System.out.print("Enter rows and columns for Matrix B: ");
        int rowsB = sc.nextInt(), colsB = sc.nextInt();

        // Input matrices
        int[][] A = inputMatrix(sc, rowsA, colsA, "A");
        int[][] B = inputMatrix(sc, rowsB, colsB, "B");

        printMatrix(A, "A");
        printMatrix(B, "B");

        // Addition and subtraction
        if (rowsA == rowsB && colsA == colsB) {
            printMatrix(addMatrices(A, B), "A + B");
            printMatrix(subtractMatrices(A, B), "A - B");
        } else {
            System.out.println("Addition/Subtraction not possible due to dimension mismatch.");
        }

        // Multiplication
        if (colsA == rowsB) {
            printMatrix(multiplyMatrices(A, B), "A x B");
        } else {
            System.out.println("Multiplication not possible due to dimension mismatch.");
        }

        sc.close();
    }
}