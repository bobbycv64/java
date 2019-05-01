package swing.java3dxml.processor;

public class XMLProcessor {

  protected String fileName = "";

  public XMLProcessor(String fileName) {
    fileName = fileName;
  }

  public XMLProcessor() {}

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    fileName = fileName;
  }
}
