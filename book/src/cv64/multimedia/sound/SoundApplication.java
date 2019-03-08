package cv64.multimedia.sound;

import java.applet.Applet;
import java.applet.AudioClip;
import javax.swing.JPanel;
import java.net.URL;
import java.net.MalformedURLException;

public class SoundApplication extends JPanel {

  private AudioClip audioClip = null;
  private URL url = null;

  private String path = "file:\\C:\\estey\\bob\\html\\uob\\computing\\java" +
                        "\\book\\src\\cv64\\multimedia\\sound\\";

  private String file = "sample.au";

  public SoundApplication() {
    try {
        url = new URL(path + file);
        audioClip = Applet.newAudioClip(url);
        audioClip.play();
    } catch (MalformedURLException exception) {
        System.err.println("Sound Application Error");
    }
  }

  public static void main(String[] args) {
    new SoundApplication();
  }
}
