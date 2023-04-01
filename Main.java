import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        List<File> folderList = Arrays.asList(
                new File("D://Games"),
                new File("D://Games//src"),
                new File("D://Games//res"),
                new File("D://Games//temp"),
                new File("D://Games//savegames"),
                new File("D://Games//src//main"),
                new File("D://Games//src//test"),
                new File("D://Games//res//drawables"),
                new File("D://Games//res//vectors"),
                new File("D://Games//res//icons")
        );
        List<File> fileList = Arrays.asList(
                new File("D://Games//src//main//Main.java"),
                new File("D://Games//src//main//Utils.java"),
                new File("D://Games//temp//temp.txt")
        );
        folderList.stream().forEach(folder -> {
            if (folder.mkdir())
                text.append("Каталог " + folder + " создан" + '\n');
            else
                text.append("Каталог " + folder + " не создан" + '\n');
        });

        fileList.stream().forEach(file -> {
            try {
                if (file.createNewFile())
                    text.append("Файл " + file + " создан" + '\n');
                else
                    text.append("Файл " + file + " не создан" + '\n');
            } catch (IOException ex) {
                text.append(ex.getMessage()+ '\n');
            }
        });

        try (FileWriter writer = new FileWriter("D://Games//temp//temp.txt", false)) {
            writer.write(text.toString());
            writer.append('\n');
            writer.flush();
        } catch (IOException ex) {
            text.append(ex.getMessage()+ '\n');
        }

        try (BufferedReader br = new BufferedReader(new FileReader("D://Games//temp//temp.txt"))) {
            String s;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage()+ '\n');
        }
    }
}