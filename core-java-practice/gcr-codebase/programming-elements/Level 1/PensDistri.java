

public class PensDistri {
    public static void main(String[] args) {
     int pens = 14;
        int students = 3;
        int remainingpens = pens % students;
        int pensdist = (pens-remainingpens)/students;
        System.out.println("The Pen Per Student is "+pensdist+" and the remaining pen not distributed is "+remainingpens);  

    }
}
