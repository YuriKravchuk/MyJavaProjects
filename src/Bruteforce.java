import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Formatter;

public class Bruteforce {
    public static int BruteForceKey (String path){
        Path tempPath = Path.of("Temp.txt").toAbsolutePath();
        for (int i = 0; i < SymbolsTable.getListOfSymbols().size(); i++) {
                try(FileReader reader = new FileReader(path.toString());
                    FileWriter writer = new FileWriter(tempPath.toString()))
                {
                    while (reader.ready()) {
                        int byteSymbol = reader.read();
                        writer.write(CaesarCode.getEncryptSymbol(3, (char)byteSymbol, i));
                    }
                    writer.flush();
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(tempPath.toString()));

                    String txtFileToString = "";
                    while (bufferedReader.ready()){
                        txtFileToString = txtFileToString + bufferedReader.readLine();
                    }
                    if (txtFileToString.contains(", ")){
                        System.out.println("Файл розшифровано. Ключ для розшифрування: " + i);
                        Files.delete(tempPath);
                        return i;
                    }

                } catch (Exception e){
                    e.printStackTrace();
                }
        }
        return -1;
    }
}
