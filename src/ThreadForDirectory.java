import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

public class ThreadForDirectory implements Runnable {
    File oldDir;
    List<File> ls;
    File newDir;
    public ThreadForDirectory(File pathOld, File pathNew){
        oldDir = pathOld;
        newDir = pathNew;
        ls = new LinkedList<File>();
    }
    @Override
    public void run() {
        if (isFile() && oldDir!=null) {
            {
                for (File f : oldDir.listFiles()) {
                    ls.add(f);
                }
                try {
                    copyFiles();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private boolean copyFiles() throws IOException {
        if(ls.isEmpty()){
            System.out.println("в дирректории "+ oldDir.getName()+ " не найдено файлов");
            return false;
        }
        newDir.mkdir();
        String f3 = newDir.getAbsolutePath()+"/";
            for (int i = 0;i<ls.size();i++){
                Files.copy(ls.get(i).toPath(),new File(f3+ls.get(i).getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        return true;

    }
    private boolean isFile() {
        if(oldDir.isDirectory())
        return true;
        else{
            System.out.println("Указанная директория не является файлом! введите другой путь");
            return false;
        }
    }
}
