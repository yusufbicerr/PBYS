import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;
import java.util.List;
public class Main {
    public static void main(String[] args) throws IOException{

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("giris.txt"))) {

            String line = null;

            String specialCharacter = ",";

            //List<String> data = new ArrayList<>();
            Data data = new Data();

            while ((line = bufferedReader.readLine()) != null) {
                line = line.replaceAll(" ","");

                String[] values = line.split(specialCharacter);

                data.VarisZamani = Integer.parseInt(values[0]);
                data.Oncelik = Integer.parseInt(values[1]);
                data.ProcessZamani = Integer.parseInt(values[2]);


            }


        }
    }
}