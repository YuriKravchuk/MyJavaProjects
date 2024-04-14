import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class StatisticAnalysis {
    public static int StatisticKey (String path) {
        Path tempPath = Path.of("Temp.txt").toAbsolutePath();
        for (int i = 0; i < SymbolsTable.getListOfSymbols().size(); i++) {
            try(FileReader reader = new FileReader(path.toString());
                FileWriter writer = new FileWriter(tempPath.toString()))
            {
                while (reader.ready()) {
                    int byteSymbol = reader.read();
                    writer.write(CaesarCode.getEncryptSymbol(4, (char)byteSymbol, i));
                }
                writer.flush();
                BufferedReader bufferedReader = new BufferedReader(new FileReader(tempPath.toString()));

                String txtFileToString = "";
                while (bufferedReader.ready()){
                    txtFileToString = txtFileToString + bufferedReader.readLine();
                }
                if (isFindStatisticKey(txtFileToString)){
                    System.out.println("Файл розшифровано. Ключ для розшифрування: " + i);
                    Files.delete(tempPath);
                    return i;
                }
                bufferedReader.close();

            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return -1;
    }

    private static boolean isFindStatisticKey(String txt){
        int txtLength = txt.length();
        String [] lowOnePercentLetters = new String[] {"щ", "ф", "є", "ї", "ґ", "ц", "ж"};
        String [] higherFourPercentLetters = new String[] {"а", "в", "и", "о", "н"};
        boolean isLettersInRangeOfStatistic = false;
        String lettersStatistic = "";
        for (String letter:lowOnePercentLetters){
            int letterCountInTxt = txtLength - txt.toLowerCase().replace(letter, "").length();
            Double percentOfLetterInTxt = 100.0*letterCountInTxt/txtLength;
            if (percentOfLetterInTxt < 1) {
                isLettersInRangeOfStatistic = true;
                lettersStatistic = lettersStatistic + letter + " - " + String.format("%.2f", percentOfLetterInTxt) + "%; ";
            } else {
                return false;
            }
        }

        for (String letter:higherFourPercentLetters){
            int letterCountInTxt = txtLength - txt.toLowerCase().replace(letter, "").length();
            Double percentOfLetterInTxt = 100.0*letterCountInTxt/txtLength;
            if (percentOfLetterInTxt > 4) {
                isLettersInRangeOfStatistic = true;
                lettersStatistic = lettersStatistic + letter + " - " + String.format("%.2f", percentOfLetterInTxt) + "%; ";
            } else {
                return false;
            }
        }
        if (isLettersInRangeOfStatistic){
            System.out.println(lettersStatistic);
        }
        return isLettersInRangeOfStatistic;
    }
}