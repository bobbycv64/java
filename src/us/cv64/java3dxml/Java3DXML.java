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

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JPanel;

import net.java.games.jogl.GLCanvas;
import net.java.games.jogl.GLCapabilities;
import net.java.games.jogl.GLDrawableFactory;

import cv64.java3dxml.mvc.J3XModel;
import cv64.java3dxml.processor.XMLProcessor;
import cv64.java3dxml.processor.XMLReader;

import cv64.util.Constraint;
/**
 * <p>Title:  Java3DXML</p>
 * <p>Description: Java application that reads, writes and renders 3D scenes using XML</p>
 * <p>Copyright:  Copyright (c) 2000 - 2004</p>
 * <p>Company:  cv64</p>
 * @author Robert Estey - 2004 August 10
 * @version 0.13
 */
public class Java3DXML extends JPanel {

  /**
   * @param height JFrame height
   */
  private int height = 0;

  /**
   * @param width JFrame width
   */
  private int width = 0;

  /**
   * @param height JFrame height
   */
  private int canvasHeight = 0;

  /**
   * @param width JFrame width
   */
  private int canvasWidth = 0;

  /**
   * @param x X-Axis Lower Left Position
   */
  private int x = 0;

  /**
   * @param y Y-Axis Lower Left Position
   */
  private int y = 0;

  /**
   * @param filenameProperties Java3DXML properties file
   */
  private String filenameProperties = "C:\\java3dxml.properties";

  /**
   * GLCapabilities, graphics capabilties that are supported, e.g. color depth,
   * configuration routines, etc.
   */
  private GLCapabilities glCaps = null;

  /**
   *
   * GLDrawable is the top interface for GLCanvas (AWT) and GLJPanel (Swing).
   * GLCanvas and GLJpanel are the widgets to render 3D objects.  Another way
   * to look at a GLDrawable is the Graphics Context.
   */
  private GLCanvas glCanvas = null;

  /**
   * Java3DXML Constructor
   */
  public Java3DXML(String fileName) {
    getProperties();
    buildRenderer();
    XMLProcessor xmlProcessor = new XMLProcessor();
    add(new J3XModel(glCanvas));
  }

  /**
   * initialization method reads the Java3DXML properties file in preparation of starting the application
   */
  private void getProperties() {

    Properties properties = new Properties();

    try {
        properties.load(new FileInputStream(filenameProperties));
        this.height = Integer.parseInt(properties.getProperty("screenHeight"));
        this.width = Integer.parseInt(properties.getProperty("screenWidth"));
        this.canvasHeight = Integer.parseInt(properties.getProperty("canvasHeight"));
        this.canvasWidth = Integer.parseInt(properties.getProperty("canvasWidth"));
        int x = Integer.parseInt(properties.getProperty("x"));
        int y = Integer.parseInt(properties.getProperty("y"));

        System.out.println("Java3DXML JFrame X: " + x + " Y: " + y);
        System.out.println("Java3DXML JFrame Width: " + this.width + " Height: " + this.height);

    } catch (IOException exception) {
        System.err.println("Failed to Load Property File: " + filenameProperties );
    }
  }

  public void buildRenderer() {

    glCaps = new GLCapabilities();
    glCanvas = GLDrawableFactory.getFactory().createGLCanvas(glCaps);

    // GLEventListener is the actual computations that produce the 3D scene.
    glCanvas.addGLEventListener(new J3XGLEventListener(this.x, this.y, this.canvasWidth, this.canvasHeight));

    glCanvas.setSize(this.canvasWidth, this.canvasHeight);
  }

  /**
   * usage method shows how to properly execute Java3DXML
   *
   * @throws Exception
   */
  public static void usage() throws Exception {
    throw new Exception("Improper Runtime Syntax Usage:  java -jar J3XMain xmlFile");
  }

  /**
   * main method for Java3DXML application
   * @param args String[] command line arguments
   */
  public static void main(String[] args) {

    /**
     * @param panel the main JPanel for this application
     */
    try {
      if (args.length != 1) usage();

      final Java3DXML panel = new Java3DXML(args[0]); // create JPanel
      // Create JFrame and add the GLCanvas (rendering area) and the JPanel (navigation aids).
      JFrame frame = new JFrame("Java 3D XML (java3dxml)");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // close window if exit button pressed
      frame.getContentPane().add("Center", panel);  // add JPanel to JFrame
      frame.setSize(new Dimension(panel.width, panel.height));
      frame.pack();
      frame.setVisible(true);

    } catch (Exception exception) {
        exception.printStackTrace();
    }
  }
}
