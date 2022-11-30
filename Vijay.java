import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Vijay {

    public static ArrayList<ArrayList<String>> read(File fname) {
        try {
            Scanner sc = new Scanner(fname);
            ArrayList<ArrayList<String>> al = new ArrayList<>();
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                String arr[] = str.split(" ");
                ArrayList<String> k = new ArrayList<>();
                for (String x : arr) {
                    k.add(x);
                }
                al.add(k);
            }
            sc.close();
            return al;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        final String fname = "sol.txt";
        Scanner sc=new Scanner(System.in);
        File file = new File(fname);
        while(true){
            String str = sc.nextLine();
            String arr[] = str.split(" ");

            if(arr[0].equalsIgnoreCase("create")){
                ArrayList<ArrayList<String>> al = read(file);

                try {
                    FileWriter fw = new FileWriter(file);
                    ArrayList<String> k = new ArrayList<>();
                    k.add(arr[1]);k.add(arr[2]);k.add("0");
                    al.add(k);
                    String mystr="";
                    for(int i=0;i<al.size();i++){
                        String temp = "";
                        for(int j=0;j<al.get(i).size();j++){
                            temp+=al.get(i).get(j)+" ";
                        }
                        temp = temp.trim();
                        fw.write(temp+"\n");
                    }
                    fw.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            else if(arr[0].equalsIgnoreCase("deposit")){
                ArrayList<ArrayList<String>> al = read(file);
                for(int i=0;i<al.size();i++){
                    if(al.get(i).get(0).equalsIgnoreCase(arr[1])){
                        String y = al.get(i).get(2);
                        double d = Double.parseDouble(y);
                        d+=Double.parseDouble(arr[2]);
                        al.get(i).remove(y);
                        al.get(i).add(d+"");
                        break;
                    }
                }
                try {
                    FileWriter fw = new FileWriter(file);
                    String mystr="";
                    for(int i=0;i<al.size();i++){
                        String temp = "";
                        for(int j=0;j<al.get(i).size();j++){
                            temp+=al.get(i).get(j)+" ";
                        }
                        temp = temp.trim();
                        fw.write(temp+"\n");
                    }
                    fw.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            else if(arr[0].equalsIgnoreCase("withdraw")){
                ArrayList<ArrayList<String>> al = read(file);
                for(int i=0;i<al.size();i++){
                    if(al.get(i).get(0).equalsIgnoreCase(arr[1])){
                        String y = al.get(i).get(2);
                        double d = Double.parseDouble(y);
                        d-=Double.parseDouble(arr[2]);
                        al.get(i).remove(y);
                        al.get(i).add(d+"");
                        break;
                    }
                }
                try {
                    FileWriter fw = new FileWriter(file);
                    String mystr="";
                    for(int i=0;i<al.size();i++){
                        String temp = "";
                        for(int j=0;j<al.get(i).size();j++){
                            temp+=al.get(i).get(j)+" ";
                        }
                        temp = temp.trim();
                        fw.write(temp+"\n");
                    }
                    fw.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            else{
                ArrayList<ArrayList<String>> al = read(file);
                for(int i=0;i<al.size();i++){
                    if(al.get(i).get(0).equalsIgnoreCase(arr[1])){
                        System.out.println(al.get(i).get(1)+" "+al.get(i).get(2));
                        break;
                    }
                }
            }
        }

    }
}
