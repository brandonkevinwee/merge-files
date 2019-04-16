package file.edit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class ModifyFiles {
  List<File> files;

  public ModifyFiles(List<File> files) {
    this.files = files;
  }

  public void mergeFiles(int linesToSkipInEachFile) throws Exception {
    File mergedFile = new File("merged_file.txt");
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(mergedFile));
    for (File file : files) {
      BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
      int lineCount = 0;
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        lineCount++;
        if (linesToSkipInEachFile >= lineCount) continue;
        bufferedWriter.write(line);
        bufferedWriter.newLine();
      }
      bufferedReader.close();
    }
    bufferedWriter.close();
  }
}
