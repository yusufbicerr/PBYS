import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.LinkedList;
import java.io.IOException;
import java.util.List;
import java.util.Queue;


public class Main {
    public static int sure=0;
    public static int idver=0;

    public static void main(String[] args) throws IOException{

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("giris.txt"))) {

            String line = null;

            Queue<Process> processQueue = new LinkedList<> ();


            String specialCharacter = ",";

            //List<String> data = new ArrayList<>();
            Data data = new Data();

            while ((line = bufferedReader.readLine()) != null) {
                line = line.replaceAll(" ","");

                String[] values = line.split(specialCharacter);
                data.id=idver;
                idver++;
                data.VarisZamani = Integer.parseInt(values[0]);
                data.Oncelik = Integer.parseInt(values[1]);
                data.ProcessZamani = Integer.parseInt(values[2]);

                Process process = new Process(data.id,data.VarisZamani,data.Oncelik,data.ProcessZamani, 0);
                sure = process.getProcessZamani() +sure;
                processQueue.add(process);

            }

            Dispatcher dispatcher = new Dispatcher();
            dispatcher.OncelikliKuyrugaTasi(processQueue,sure);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}