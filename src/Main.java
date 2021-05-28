import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file = new File("abc.csv");
        try {
            if (!file.exists()){
                file.createNewFile();
            }
            System.out.println("done");
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader("abc.csv"));
            while ((line = br.readLine()) != null){
                System.out.println(parseCsvLine(line));
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (br != null){
                    br.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public static List<String> parseCsvLine(String csvLine){
        List<String> list = new ArrayList<>();

        if (csvLine != null){
            String[] strings = csvLine.split(",");
            for (int i = 0; i < strings.length; i++) {
                list.add(strings[i]);
            }
        }
        return list;
    }

}
