import java.util.*;
import java.time.*;

public class GlobalShipmentManifestValidator {

    static boolean validCode(String code){
        if(!code.matches("SHIP-[1-9][0-9]{5}")) return false;

        String num = code.substring(5);
        int count = 1;

        for(int i=1;i<num.length();i++){
            if(num.charAt(i)==num.charAt(i-1)){
                count++;
                if(count>3) return false;
            }else count=1;
        }
        return true;
    }

    static boolean validDate(String date){
        try{
            LocalDate d = LocalDate.parse(date);
            int y = d.getYear();
            return y>=2000 && y<=2099;
        }catch(Exception e){
            return false;
        }
    }

    static boolean validMode(String mode){
        return mode.matches("AIR|SEA|ROAD|RAIL|EXPRESS|FREIGHT");
    }

    static boolean validWeight(String w){
        if(!w.matches("(0|[1-9][0-9]{0,5})(\\.[0-9]{1,2})?")) return false;
        double val = Double.parseDouble(w);
        return val<=999999.99;
    }

    static boolean validStatus(String s){
        return s.matches("DELIVERED|CANCELLED|IN_TRANSIT");
    }

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++){

            String rec=sc.nextLine();
            String[] p=rec.split("\\|");

            if(p.length!=5 ||
               !validCode(p[0]) ||
               !validDate(p[1]) ||
               !validMode(p[2]) ||
               !validWeight(p[3]) ||
               !validStatus(p[4])){

                System.out.println("NON-COMPLIANT RECORD");
            }
            else{
                System.out.println("COMPLIANT RECORD");
            }
        }
    }
}