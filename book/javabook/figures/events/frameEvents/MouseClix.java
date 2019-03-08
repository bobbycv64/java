import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class MouseClix extends FrameEvents implements MouseListener {

  public MouseClix() {
    JPanel panel = new JPanel();
    panel.addMouseListener(this);
    getContentPane().add(panel);
    validate();
  }

  public void mouseClicked(MouseEvent mEvent) {
    int x=mEvent.getX();
    int y=mEvent.getY();
    System.out.println("The mouse clicked on point: " + 
      mEvent.getPoint());
  }

  public void mouseEntered(MouseEvent mouseEvent) {}
  public void mouseExited(MouseEvent mouseEvent) {}
  public void mousePressed(MouseEvent mouseEvent) {}
  public void mouseReleased(MouseEvent mouseEvent) {}

  public static void main(String[] args) {
    new MouseClix();
  }

  private int x;
  private int y; 
}