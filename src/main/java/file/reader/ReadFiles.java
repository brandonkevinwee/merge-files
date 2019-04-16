package file.reader;

import java.io.File;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReadFiles {

  public static List<File> getAllFiles() throws Exception {
    String jarFilePath =
        ReadFiles.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    File jarFile = new File(jarFilePath);
    File[] jarDirectoryFiles =
        new File(URLDecoder.decode(jarFile.getParent(), "UTF-8")).listFiles();
    return Arrays.stream(jarDirectoryFiles)
        .filter(file -> !file.getName().equals(jarFile.getName()))
        .collect(Collectors.toList());
  }
}
