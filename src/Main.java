import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

  public static void main(String[] args) {
    File gamesDir = new File("C:\\Games");
    StringBuilder log = new StringBuilder("Протокол");
    File srcDir = createFile(gamesDir.getAbsolutePath() + "\\src", log);
    File mainDir = createFile(srcDir.getAbsolutePath() + "\\main", log);
    createFile(mainDir, "Main.java", log);
    createFile(mainDir, "Utils.java", log);
    createFile(srcDir.getAbsolutePath() + "\\test", log);
    File resDir = createFile(gamesDir.getAbsolutePath() + "\\res", log);
    createFile(resDir.getAbsolutePath() + "\\drawables", log);
    createFile(resDir.getAbsolutePath() + "\\vectors", log);
    createFile(resDir.getAbsolutePath() + "\\icons", log);
    createFile(gamesDir.getAbsolutePath() + "\\savegames", log);
    File tempDir = createFile(gamesDir.getAbsolutePath() + "\\temp", log);
    File tempFile = createFile(tempDir, "temp.txt", log);
    try (FileWriter writer = new FileWriter(tempFile)) {
      writer.write(log.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("Протокол работы в файле " + tempFile.getName());
  }

  public static File createFile(String pathname, StringBuilder log) {
    File dir = new File(pathname);
    if (dir.mkdir())
      log.append("\nСоздан каталог " + dir.getName());
    return dir;
  }

  public static File createFile(File parent, String child, StringBuilder log) {
    File file = new File(parent, child);
    try {
      if (file.createNewFile())
        log.append("\nСоздан файл " + file.getName());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return file;
  }
}
