import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Number Of Element");
        int n = input.nextInt();

        System.out.println("Enter Number");
        int [] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }

        System.out.println("Read Element To Search");
        int key = input.nextInt();

        for(int i = 0; i < n; i++){
            if(arr[i] == key){
                System.out.println("Found At Index " + i);
                return;
            }
        }

        System.out.println("Not Founded");
    }    
}
