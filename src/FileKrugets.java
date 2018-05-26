import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
public class FileKrugets {
    Boolean state;
    String csvFile;
    public FileKrugets(String csvFile){
        this.csvFile = csvFile;
    }

    public void fileread() {

        try(CSVReader reader = new CSVReader(new FileReader(csvFile))) {

            String[] line;
            while ((line = reader.readNext()) != null) {

                if (line[1].equals("true")) {
                    state = true;
                }
                else
                    state = false;

                Test.location.get(0).build(line[0], state, line[2], line[3]);
            }
        }
     catch(IOException e) {
         System.out.println(e);
     }
    }
}


