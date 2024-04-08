import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
    private static Scanner scanner = new Scanner(System.in);
    public void sayHello(){
        System.out.println("Привіт, мандрівник!");
        System.out.println("Мене звати робот Діді. Я вмію шифрувати файли.");
    }
    public int printMenu() {
            System.out.println("Обери команду:");
            System.out.println("1 - Зашифрувати файл");
            System.out.println("2 - Розшифрувати файл");
            System.out.println("3 - Спробувати розкодувати за допомогою Bruteforce");
            System.out.println("4 - Вийти з програми");
            if (scanner.hasNextInt()){
                return scanner.nextInt();
            } else {
                scanner.next();
                return 0;
            }

    }

    public String enterPath(){
        System.out.println("Введи шлях до файлу:");
        String optionalFilePath = scanner.next();
        while (Files.exists(Path.of(optionalFilePath))==false){
            System.out.println("Error ... Спробуй ще");
            optionalFilePath = scanner.next();
        }
        System.out.println("OK ... Вихідний файл: " + Path.of(optionalFilePath).getFileName());
        return optionalFilePath;
    }

    public int enterKey(){
        System.out.println("Введи ключ шифрування (будь-яке число):");
        return scanner.nextInt();
    }

    public void printResult(boolean flag){
        if (flag==true){
            System.out.println("Виконано...");
        }else {
            System.out.println("Щось пішло не так.");
        }
    }

    public boolean printCommandResult (int command){
        switch (command){
            case 1:
                System.out.println("OK ... Буду шифрувати файл.");
                return true;
            case  2, 3:
                System.out.println("OK ... Буду розшифровувати файл.");
                return true;
            case 4:
                System.out.println("Бувай!");
                System.exit(0);
            default:
                System.out.println("Error ... Обери пункт меню.");
                return false;
        }
    }


}
