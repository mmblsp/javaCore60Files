import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String rootPath = "D://Games";

        StringBuilder sb = new StringBuilder();
        List<File> folderList = Arrays.asList(
                new File(rootPath),
                new File(rootPath + "//temp"),
                new File(rootPath + "//src"),
                new File(rootPath + "//res"),
                new File(rootPath + "//savegames"),
                new File(rootPath + "//src//main"),
                new File(rootPath + "//src//test"),
                new File(rootPath + "//res//drawables"),
                new File(rootPath + "//res//vectors"),
                new File(rootPath + "//res//icons")
        );
        List<File> fileList = Arrays.asList(
                new File(rootPath + "//src//main//Main.java"),
                new File(rootPath + "//src//main//Utils.java"),
                new File(rootPath + "//temp//temp.txt")
        );
        folderList.stream().forEach(folder -> {
            if (folder.mkdir()) sb.append(folder + ": done\n");
            else sb.append(folder + ": done\n");
        });
        fileList.stream().forEach(file -> {
            try {
                if (file.createNewFile()) sb.append(file + ": done\n");
                else sb.append(file + ": done\n");
            } catch (IOException ex) {
                sb.append(ex.getMessage() + '\n');
            }
        });
        try (FileWriter log = new FileWriter(rootPath + "//temp//temp.txt", false)) {
            log.write(sb.toString());
            log.flush();
        } catch (IOException ex) {
            sb.append(ex.getMessage() + '\n');
        }
        try (BufferedReader br = new BufferedReader(new FileReader(rootPath + "//temp//temp.txt"))) {
            String s;
            while ((s = br.readLine()) != null) System.out.println(s);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
