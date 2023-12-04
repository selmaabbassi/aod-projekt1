package file;

import java.awt.Component;
import java.io.File;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class OpenFileSelector
  {
  private List<File> fileList = new LinkedList<File>();
  private File       currentDirectory;
  private String     fileDescription;
  private String     fileExtension;
  private Component parent;

  public OpenFileSelector(Component parent, String fileDescription, String fileExtension)
    {
    this.parent = parent;
    this.fileDescription = fileDescription;
    this.fileExtension = fileExtension;
    }

  public List<File> getFileList()
    {
    try
      {
      JFileChooser chooser = new JFileChooser();
      FileNameExtensionFilter filter = new FileNameExtensionFilter(fileDescription, fileExtension);
      chooser.setFileFilter(filter);
      if(currentDirectory == null)
        currentDirectory = new File(Paths.get("").toAbsolutePath().toString());
      chooser.setCurrentDirectory(currentDirectory);
      chooser.setMultiSelectionEnabled(true);
      int returnVal = chooser.showOpenDialog(parent);
      if (returnVal == JFileChooser.APPROVE_OPTION)
        {
        fileList = new LinkedList<File>();
        File[] files = chooser.getSelectedFiles();
        for (File f : files)
          fileList.add(f);
        currentDirectory = chooser.getCurrentDirectory();
        }
      }
    catch (Exception ex)
      {
      }
    return fileList;
    }
  }
