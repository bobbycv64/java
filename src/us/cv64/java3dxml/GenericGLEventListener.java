package cv64.util;

import java.awt.*;
import java.awt.event.*;
import net.java.games.jogl.*;

public class GenericGLEventListener implements GLEventListener {

  public GenericGLEventListener() {}
  /**
   * Take care of initialization here.
   */
  public void init(GLDrawable drawable) {

  }

  /**
   * Take care of drawing here.
   */
  public void display(GLDrawable drawable) {

  }

  /**
   * Called when the GLDrawable (GLCanvas
   * or GLJPanel) has changed in size. We
   * won't need this, but you may eventually
   * need it -- just not yet.
   */
  public void reshape(
                        GLDrawable drawable,
                        int x,
                        int y,
                        int width,
                        int height
                      ) {}

  /**
   * If the display depth is changed while the
   * program is running this method is called.
   * Nowadays this doesn't happen much, unless
   * a programmer has his program do it.
   */
  public void displayChanged(
                              GLDrawable drawable,
                              boolean modeChanged,
                              boolean deviceChanged
                            ) {}
}
