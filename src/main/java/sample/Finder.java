package sample;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Finder {
    private File pathDirectory;
    private String text;
    private String extendFile;

    public Finder(File pathDirectory, String text, String extendFile) {
        this.pathDirectory = pathDirectory;
        this.text = text;
        this.extendFile = extendFile;
    }

    public File findingText() {
//        File[] list = pathDirectory.listFiles();
//        File test = null;
//
//        for (int i = 0; i < (list != null ? list.length : 0); i++) {
//             test = list[i];
//            System.out.println(test);
//        }

        try (Stream<Path> walk = Files.walk(Paths.get("C:\\Users\\Кирилл\\Desktop\\LogMap"))) {
//            List<String> result = walk.filter(Files::isRegularFile)
//                    .map(Path::toString).collect(Collectors.toList());

            List<String> result = walk
                    .map(x -> x.toString())
                    .filter(f -> f.endsWith(".txt"))
                    .filter(f -> f.contains("Log"))
                    .collect(Collectors.toList());

            result.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
