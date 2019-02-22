/** ====================================================================
 * cv64 Software License, Version 0.13
 *
 * Copyright (c) 2000-2004 cv64.  All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution,
 *    if any, must include the following acknowledgment:
 *    "This product includes software developed by cv64 (http://cv64.us/)."
 *    Alternately, this acknowledgment may appear in the software itself,
 *    if and wherever such third-party acknowledgments normally appear.
 *
 * 4. The name "cv64" must not be used to endorse or promote products
 *    derived from this software without prior written permission.
 *    For written permission, please contact information@cv64.us.
 *
 * 5. Products derived from this software may not be called "cv64",
 *    nor may "cv64" appear in their name, without prior written
 *    permission of cv64.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL cv64 OR ITS CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT
 * OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR
 * BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of cv64.  For more information on cv64,
 * please see http://cv64.us
 *
 * Portions of this software are based upon public domain software.
 */
package us.cv64.java3dxml;

import net.java.games.jogl.*;

/**
 * <p>Title:  J3XGLEventListener</p>
 * <p>Description: Java application that reads, writes and renders 3D scenes using XML</p>
 * <p>Copyright:  Copyright (c) 2000 - 2004</p>
 * <p>Company:  cv64</p>
 * @author Robert Estey - 2004 August 13
 * @version 0.13
 */
public class J3XGLEventListener implements GLEventListener {

  /**
   * @param height viewport height
   */
  private int height = 300;

  /**
   * @param width viewport width
   */
  private int width = 500;

  /**
   * @param x lower left pixel position on the X axis.
   */
  private int x = 0;

  /**
   * @param y lower left pixel position on the Y axis.
   */
  private int y = 0;

  public J3XGLEventListener(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.height = height - 100;
    this.width = width - 100;

    System.out.println("J3XGLEventListener X: " + x + " Y: " + y);
    System.out.println("J3XGLEventListener Width: " + width + " Height: " + height);
  }

  public J3XGLEventListener() {
    this(0, 0, 300, 500);
  }

  /**
   * method called for setting up the GLDrawable.
   * @param gld GLDrawable
   */
  public void init(GLDrawable gld) {

    GL gl = gld.getGL();
    GLU glu = gld.getGLU();
    gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    gl.glViewport(x, y, width, height);
    gl.glMatrixMode(GL.GL_PROJECTION);
    gl.glLoadIdentity();
    //glu.gluOrtho2D(Double.longBitsToDouble(x), Double.longBitsToDouble(width),
    //               Double.longBitsToDouble(y), Double.longBitsToDouble(height));
    glu.gluOrtho2D(0.0, 500.0, 0.0, 300.0);
  }

  /**
   * method called to render the scene
   * @param drawable GLDrawable
   */
  public void display(GLDrawable drawable) {

    float red = 0.0f;
    float green = 0.0f;
    float blue = 0.0f;

    GL gl = drawable.getGL();

    gl.glClear(GL.GL_COLOR_BUFFER_BIT);

    gl.glPointSize(5.0f);

    for (int i=0; i<50; i++) {

      red -= .09f;
      green -= .12f;
      blue -= .15f;

      if (red < 0.15) red = 1.0f;
      if (green < 0.15) green = 1.0f;
      if (blue < 0.15) blue = 1.0f;

      gl.glColor3f(red, green, blue);

      gl.glBegin(GL.GL_POINTS);
          gl.glVertex2i((i*10), 150);
      gl.glEnd();

    }
  }

  /**
   * method is called when display depth has changed
   * @param drawable GLDrawable
   * @param modeChanged boolean
   * @param deviceChanged boolean
   */
  public void displayChanged(GLDrawable drawable, boolean modeChanged, boolean deviceChanged) {}

  /**
   * method is called when the GLDrawable size has changed, e.g. GLCanvas, GLJPanel
   * @param drawable GLDrawable
   * @param x int
   * @param y int
   * @param width int
   * @param height int
   */
  public void reshape(GLDrawable drawable, int x, int y, int width, int height) {}
}
