import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

  public static void main(String[] args) {
    File gamesDir = new File("C:\\Games");
    StringBuilder log = new StringBuilder("Протокол");
    File srcDir = new File(gamesDir.getAbsolutePath() + "\\src");
    if (srcDir.mkdir())
      log.append("\nСоздан каталог src");
    File mainDir = new File(srcDir.getAbsolutePath() + "\\main");
    if (mainDir.mkdir())
      log.append("\nСоздан каталог main");
    File mainFile = new File(mainDir, "Main.java");
    try {
      if (mainFile.createNewFile())
        log.append("\nСоздан файл " + mainFile.getName());
    } catch (IOException e) {
      log.append(e.toString());
    }
    File utilsFile = new File(mainDir, "Utils.java");
    try {
      if (utilsFile.createNewFile())
        log.append("\nСоздан файл " + utilsFile.getName());
    } catch (IOException e) {
      log.append(e.toString());
    }
    File testDir = new File(srcDir.getAbsolutePath() + "\\test");
    if (testDir.mkdir())
      log.append("\nСоздан каталог test");
    File resDir = new File(gamesDir.getAbsolutePath() + "\\res");
    if (resDir.mkdir())
      log.append("\nСоздан каталог res");
    File drawablesDir = new File(resDir.getAbsolutePath() + "\\drawables");
    if (drawablesDir.mkdir())
      log.append("\nСоздан каталог drawables");
    File vectorsDir = new File(resDir.getAbsolutePath() + "\\vectors");
    if (vectorsDir.mkdir())
      log.append("\nСоздан каталог vectors");
    File iconsDir = new File(resDir.getAbsolutePath() + "\\icons");
    if (iconsDir.mkdir())
      log.append("\nСоздан каталог icons");
    File savegamesDir = new File(gamesDir.getAbsolutePath() + "\\savegames");
    if (savegamesDir.mkdir())
      log.append("\nСоздан каталог savegames");
    File tempDir = new File(gamesDir.getAbsolutePath() + "\\temp");
    if (tempDir.mkdir()) {
      log.append("\nСоздан каталог temp");
    }
    File tempFile = new File(tempDir, "temp.txt");
    try {
      if (tempFile.createNewFile())
        log.append("\nСоздан файл " + tempFile.getName());
    } catch (IOException e) {
      e.printStackTrace();
    }
    try (FileWriter writer = new FileWriter(tempFile);) {
      writer.write(log.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("Протокол работы в файле " + tempFile.getName());
  }
}
