import java.io.IOException;
import java.io.SyncFailedException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws IOException {
        Controller controller = new Controller();
        controller.init();
    }
}