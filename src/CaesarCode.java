import java.util.ArrayList;

public class CaesarCode {

    public static char getEncryptSymbol(int command, char charSymbol, int key){
        SymbolsTable listOfSymbols = new SymbolsTable();
        ArrayList<Character> symbols = listOfSymbols.getListOfSymbols();
        int newCharIndex = symbols.indexOf(charSymbol);
        if (key > symbols.size()){
            key = key%symbols.size();
        }
        if (symbols.contains(charSymbol)){
            switch (command){
                case 1: // ENCRYPT
                    newCharIndex = newCharIndex + key;
                    if ((newCharIndex + 1) > symbols.size()) {
                        newCharIndex = newCharIndex - symbols.size();
                    }
                    return symbols.get(newCharIndex);
                case 2, 3: // DECRYPT
                        newCharIndex = newCharIndex - key;
                        if (newCharIndex < 0) {
                            newCharIndex = symbols.size() + newCharIndex;
                        }
                        return symbols.get(newCharIndex);
                default:
                    return charSymbol;
            }
        } else {
            return charSymbol;
        }
    }
}
