package cv64.multimedia.sound;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;

public class SoundApplet extends Applet {

  private AudioClip audioClip = null;

  public void init() {
    audioClip = getAudioClip(getDocumentBase(), "sample.au");
  }

  public void paint(Graphics graphics) {
    graphics.drawString("Sound Example 2", 25, 25);
  }

  public void start() { audioClip.loop(); }
  public void stop() { audioClip.stop(); }
}
