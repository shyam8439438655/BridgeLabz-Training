import java.util.*;
import java.util.regex.*;

public class DynamicTemplateProcessor {

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();

        Pattern p=Pattern.compile("\\$\\{(\\w+):(.*?)\\}");

        for(int i=0;i<n;i++){

            String line=sc.nextLine();
            Matcher m=p.matcher(line);

            StringBuffer sb=new StringBuffer();

            while(m.find()){

                String type=m.group(1);
                String val=m.group(2);
                String res="INVALID";

                try{

                    if(type.equals("UPPER"))
                        res=val.toUpperCase();

                    else if(type.equals("LOWER"))
                        res=val.toLowerCase();

                    else if(type.equals("DATE")){
                        String[] d=val.split("-");
                        int day=Integer.parseInt(d[0]);
                        int mon=Integer.parseInt(d[1]);
                        int yr=Integer.parseInt(d[2]);

                        if(day<=31 && mon<=12)
                            res=yr+"/"+String.format("%02d",mon)+"/"+String.format("%02d",day);
                    }

                    else if(type.equals("REPEAT")){
                        String[] r=val.split(",");
                        String w=r[0];
                        int c=Integer.parseInt(r[1]);

                        StringBuilder t=new StringBuilder();
                        for(int j=0;j<c;j++) t.append(w);
                        res=t.toString();
                    }

                }catch(Exception e){}

                m.appendReplacement(sb,res);
            }

            m.appendTail(sb);

            System.out.println(sb.toString());
        }
    }
}