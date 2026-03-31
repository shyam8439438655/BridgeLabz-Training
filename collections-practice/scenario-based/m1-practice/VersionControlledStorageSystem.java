import java.util.*;

class FileVersion{
    String version;
    int size;

    FileVersion(String v,int s){
        version=v;
        size=s;
    }
}

public class VersionControlledStorageSystem {

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();

        Map<String,List<FileVersion>> map=new HashMap<>();

        for(int i=0;i<n;i++){

            String line=sc.nextLine();
            String[] p=line.split(" ");

            if(p[0].equals("UPLOAD")){

                String name=p[1];
                String ver=p[2];
                int size=Integer.parseInt(p[3]);

                map.putIfAbsent(name,new ArrayList<>());

                boolean exists=false;

                for(FileVersion f:map.get(name))
                    if(f.version.equals(ver)) exists=true;

                if(!exists)
                    map.get(name).add(new FileVersion(ver,size));
            }

            else if(p[0].equals("FETCH")){

                String name=p[1];

                if(!map.containsKey(name)){
                    System.out.println("File Not Found");
                    continue;
                }

                List<FileVersion> list=map.get(name);

                list.sort((a,b)->{
                    if(a.size==b.size)
                        return a.version.compareTo(b.version);
                    return a.size-b.size;
                });

                for(FileVersion f:list)
                    System.out.println(name+" "+f.version+" "+f.size);
            }

            else if(p[0].equals("LATEST")){

                String name=p[1];

                if(!map.containsKey(name)){
                    System.out.println("File Not Found");
                    continue;
                }

                List<FileVersion> list=map.get(name);
                FileVersion f=list.get(list.size()-1);

                System.out.println(name+" "+f.version+" "+f.size);
            }

            else if(p[0].equals("TOTAL_STORAGE")){

                String name=p[1];

                if(!map.containsKey(name)){
                    System.out.println("File Not Found");
                    continue;
                }

                int sum=0;

                for(FileVersion f:map.get(name))
                    sum+=f.size;

                System.out.println(name+" "+sum);
            }
        }
    }
}