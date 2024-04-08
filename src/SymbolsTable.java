import java.util.ArrayList;

public class SymbolsTable {
    private static ArrayList<Character> listOfSymbols;

    public static ArrayList<Character> getListOfSymbols() {
        new SymbolsTable();
        return listOfSymbols;
    }

    private ArrayList<Character> fromCharToListSymbols() {
        String symbols = "АаБбВвГгҐґДдЕеЄєЖжЗзИиІіЇїЙйКкЛлМмНнОоПпРрСсТтУуФфХхЦцЧчШшЩщьЮюЯяAaBbCcDdEeFfGgHhJjKkLlMmNnOoPpQqRrTtUuVvWwXxYyZz!?., :;#$%*()_-=+/'1234567890@\\\"";
        char[] symbolsCharArrayArray = symbols.toCharArray();
        ArrayList<Character> tempArrayList = new ArrayList<>();
        for (int i = 0; i < symbolsCharArrayArray.length; i++) {
            tempArrayList.add(i,symbolsCharArrayArray[i]);
        }
        return tempArrayList;
    }

    public SymbolsTable() {
        this.listOfSymbols = fromCharToListSymbols();
    }
}
