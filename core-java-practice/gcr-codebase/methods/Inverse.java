import java.util.Scanner;

public class Inverse {

    // Input matrix
    static int[][] inputMatrix(Scanner sc, int n) {
        int[][] m = new int[n][n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                m[i][j] = sc.nextInt();
        return m;
    }

    // Display matrix
    static void print(int[][] m) {
        for (int[] row : m) {
            for (int val : row) System.out.print(val + "\t");
            System.out.println();
        }
    }
    static void print(double[][] m) {
        for (double[] row : m) {
            for (double val : row) System.out.print(val + "\t");
            System.out.println();
        }
    }

    // Transpose
    static int[][] transpose(int[][] m) {
        int n = m.length;
        int[][] t = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                t[j][i] = m[i][j];
        return t;
    }

    // Determinant 2x2
    static int det2(int[][] m) {
        return m[0][0]*m[1][1] - m[0][1]*m[1][0];
    }

    // Determinant 3x3
    static int det3(int[][] m) {
        return m[0][0]*(m[1][1]*m[2][2]-m[1][2]*m[2][1])
             - m[0][1]*(m[1][0]*m[2][2]-m[1][2]*m[2][0])
             + m[0][2]*(m[1][0]*m[2][1]-m[1][1]*m[2][0]);
    }

    // Inverse 2x2
    static double[][] inv2(int[][] m) {
        double d = det2(m);
        if (d==0) return null;
        return new double[][]{
            { m[1][1]/d, -m[0][1]/d },
            { -m[1][0]/d, m[0][0]/d }
        };
    }

    // Inverse 3x3 (adjoint/det)
    static double[][] inv3(int[][] m) {
        double d = det3(m);
        if (d==0) return null;
        double[][] cof = {
            { (m[1][1]*m[2][2]-m[1][2]*m[2][1]), -(m[1][0]*m[2][2]-m[1][2]*m[2][0]), (m[1][0]*m[2][1]-m[1][1]*m[2][0]) },
            { -(m[0][1]*m[2][2]-m[0][2]*m[2][1]), (m[0][0]*m[2][2]-m[0][2]*m[2][0]), -(m[0][0]*m[2][1]-m[0][1]*m[2][0]) },
            { (m[0][1]*m[1][2]-m[0][2]*m[1][1]), -(m[0][0]*m[1][2]-m[0][2]*m[1][0]), (m[0][0]*m[1][1]-m[0][1]*m[1][0]) }
        };
        double[][] adj = new double[3][3];
        for(int i=0;i<3;i++) for(int j=0;j<3;j++) adj[i][j]=cof[j][i];
        for(int i=0;i<3;i++) for(int j=0;j<3;j++) adj[i][j]/=d;
        return adj;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size (2 or 3): ");
        int n = sc.nextInt();
        int[][] m = inputMatrix(sc,n);

        System.out.println("Original:");
        print(m);

        System.out.println("Transpose:");
        print(transpose(m));

        if(n==2){
            int d = det2(m);
            System.out.println("Determinant = " + d);
            double[][] inv = inv2(m);
            if(inv!=null){ System.out.println("Inverse:"); print(inv); }
            else System.out.println("Inverse not possible");
        }
        else if(n==3){
            int d = det3(m);
            System.out.println("Determinant = " + d);
            double[][] inv = inv3(m);
            if(inv!=null){ System.out.println("Inverse:"); print(inv); }
            else System.out.println("Inverse not possible");
        }
    }
}