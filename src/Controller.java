import java.io.IOException;
import java.lang.reflect.AccessFlag;

public class Controller {
    private FileService service;
    private View view = new View();

    public void init() throws IOException {
        view.sayHello();
            while (true) {
                int command = view.printMenu();
                if (view.printCommandResult(command)) {
                    String path = view.enterPath();
                    int key = (command != 3 && command != 4) ? view.enterKey() : ((command == 3) ? Bruteforce.BruteForceKey(path) : StatisticAnalysis.StatisticKey(path));
                    if (key != -1) {
                        service = new FileService(path, command, key);
                        view.printResult(service.isDone());
                    } else{
                        view.printResult(false);
                    }
                    System.out.println("=====================================================");
                }
            }
    }
}