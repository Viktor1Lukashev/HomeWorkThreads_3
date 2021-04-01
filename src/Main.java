import java.io.File;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Введите путь к дирректории которую необходимо скопировать содержимое");
        Scanner sc = new Scanner(System.in);
        String pathToIn = sc.nextLine();
        System.out.println("Введите путь к дирректории в которую необходимо скопировать содержимое");
        String pathToOut = sc.nextLine();
        File f1 = new File(pathToIn);
        File f2 = new File(pathToOut);
        ThreadForDirectory tr = new ThreadForDirectory(f1,f2);
        Thread t = new Thread(tr);
        t.start();
        System.out.println("Идет копирование файлов!");
        
    }
}
