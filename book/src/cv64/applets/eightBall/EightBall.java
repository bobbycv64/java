package cv64.applets.eightBall;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.util.Hashtable;
import java.net.MalformedURLException;
import java.net.URL;

import java.applet.AudioClip;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *  class EightBall
 *
 *  This class is an imitation of the Eight Ball game.
 *
 *  @author     Robert Estey
 *  @version    20020907RE - initial
 */

public class EightBall extends JApplet implements ActionListener {

  private AudioClip sound_;
  private Button button_ = new Button("Get Answer");
  private Hashtable images_, sounds_;
  private ImageIcon imageIcon_ = null;

  public EightBall() {}

  public void init() {

    setImages();
    setSounds();

    getContentPane().add(button_, BorderLayout.CENTER);
    button_.addActionListener(this);
  }

  public void start() {}

  public void actionPerformed(ActionEvent actionEvent) {

    Response response = new Response();
    ResponseMessage responseMessage = response.getResponseMessage();

    imageIcon_ = (ImageIcon)images_.get(responseMessage.getResponseType());
    JOptionPane.showMessageDialog(this,
                                  responseMessage.getResponse(),
                                  responseMessage.getResponseType(),
                                  JOptionPane.PLAIN_MESSAGE,
                                  imageIcon_);

    sound_= (AudioClip)sounds_.get(responseMessage.getResponseType());
    sound_.play();
  }

  /** Loads images into a hashtable */
  private void setImages() {

    images_ = new Hashtable();
    URL url;
    String imagesPath = getCodeBase().toString() + "images/";

    System.out.println("Images Path: " + imagesPath);
    try {
      url = new URL(imagesPath);
    }
    catch (MalformedURLException exception) {
      System.out.println(exception.getMessage());
      return;
    }

    images_.put("Positive", new ImageIcon( getImage(url, "Positive.gif")));
    images_.put("Neutral ", new ImageIcon( getImage(url, "Neutral.gif")));
    images_.put("Negative", new ImageIcon( getImage(url, "Negative.gif")));
  }

/** Load sounds into a hashtable */
  private void setSounds() {

    sounds_ = new Hashtable();
    URL url;
    String soundsPath = getCodeBase().toString() + "sounds/";

    System.out.println("Sounds Path: " + soundsPath );
    try {
      url = new URL(soundsPath);
    }
    catch(MalformedURLException ex) {
      System.out.println(ex.getMessage());
      return;
    }

    sounds_.put("Positive", getAudioClip(url, "Positive.wav"));
    sounds_.put("Neutral ", getAudioClip(url, "Neutral.wav"));
    sounds_.put("Negative", getAudioClip(url, "Negative.au"));
  }

  public static void main(String[] args) {

    JFrame frame = new JFrame("EightBall");
    EightBall eightBall = new EightBall();

    frame.getContentPane().add(eightBall);
    frame.setSize(160, 20);
    frame.validate();
    frame.pack();
    frame.setVisible(true);
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent windowEvent) { System.exit(0); }
    });
    frame.setFont(new Font("Arial", Font.PLAIN, 24));

    eightBall.init();
    eightBall.start();
  }
}


