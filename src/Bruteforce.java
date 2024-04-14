import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Formatter;

public class Bruteforce {
    public static int BruteForceKey (String path){
        Path tempPath = Path.of("Temp.txt").toAbsolutePath();
        int maxCountOfSpace = 0;
        int tempKey = -1;
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

                    int countOfSpaces = txtFileToString.length() - txtFileToString.replaceAll(" ","").length();
                    if (countOfSpaces > maxCountOfSpace) {
                        maxCountOfSpace =countOfSpaces;
                        tempKey = i;
                    }
                    Files.delete(tempPath);
                    bufferedReader.close();
                } catch (Exception e){
                    e.printStackTrace();
                }
        }
        if (tempKey != -1){
            System.out.println("Файл розшифровано. Ключ для розшифрування: " + tempKey);
            return tempKey;
        } else {
            return -1;
        }
    }
}
