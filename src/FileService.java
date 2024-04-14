
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileService {
    private Path inputPath;
    private Path outputPath;
    private  boolean done=false;

    public FileService(String inputPath, int command,int key) throws IOException {
        this.inputPath = Path.of(inputPath);
        this.outputPath = Path.of(inputPath.substring(0, inputPath.lastIndexOf('.'))  + selectCommand(command) + ".txt");
        this.done = fileCreator(command, key);
    }

    public boolean isDone() {
        return done;
    }

    private String selectCommand (int command){
        switch (command){
            case 1: return "[ENCRYPT]";
            case 2: return "[DECRYPT]";
            case 3: return "[BRUTEFORCE_DECRYPT]";
            case 4: return "[STATISTIC_DECRYPT]";
            default: return "";
        }
    }

    public boolean fileCreator(int command, int key) throws IOException {
        try(FileReader reader = new FileReader(inputPath.toString());
            FileWriter writer = new FileWriter(outputPath.toString()))
        {
            while (reader.ready()) {
                int byteSymbol = reader.read();
                writer.write(CaesarCode.getEncryptSymbol(command, (char)byteSymbol, key));
            }
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
