package file;

import java.io.File;
import java.util.List;

import file.edit.ModifyFiles;
import file.reader.ReadFiles;

public class Launcher {

  public static void main(String[] args) throws Exception {
    List<File> files = ReadFiles.getAllFiles();
    ModifyFiles modifyFiles = new ModifyFiles(files);
    int linesToSkip = args.length == 0 ? 0 : Integer.valueOf(args[0]);
    modifyFiles.mergeFiles(linesToSkip);
  }
}
