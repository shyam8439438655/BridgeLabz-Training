import java.util.Scanner;
public class AreaOfTriangle {
   public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     double base = scanner.nextDouble();
        double height = scanner.nextDouble();

        double areaCm = 0.5 * base * height;
        double areaIn = areaCm / (2.54 * 2.54);

        System.out.println("The Area of the triangle in sq in is " + areaIn +
                           " and sq cm is " + areaCm);
        scanner.close();
   } 
}
