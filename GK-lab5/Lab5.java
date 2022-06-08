﻿import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.*;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT; 

/**
 * CPSC 424, Fall 2015, Lab 4:  Some objects in 3D.  The arrow keys
 * can be used to rotate the object.  The number keys 1 through 6
 * select the object.  The space bar toggles the use of anaglyph
 * stereo.
 */
public class Lab5 extends GLJPanel implements GLEventListener, KeyListener{

	/**
	 * A main routine to create and show a window that contains a
	 * panel of type Lab5.  The program ends when the user closes the 
	 * window.
	 */
	public static void main(String[] args) {
		JFrame window = new JFrame("Some Objects in 3D");
		Lab5 panel = new Lab5();
		window.setContentPane(panel);
		window.pack();
		window.setResizable(false);
		window.setLocation(50,50);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

	/**
	 * Constructor for class Lab4.
	 */
	public Lab5() {
		super( new GLCapabilities(null) ); // Makes a panel with default OpenGL "capabilities".
		setPreferredSize( new Dimension(700,700) );
		addGLEventListener(this); // This panel will respond to OpenGL events.
		addKeyListener(this);  // The panel will respond to key events.
	}

	
	//------------------- TODO: Complete this section! ---------------------

	private int objectNumber = 1;        // Which object to draw (1 ,2, 3, 4, 5, or 6)?
	                                     //   (Controlled by number keys.)

	private boolean useAnaglyph = false; // Should anaglyph stereo be used?
	                                     //    (Controlled by space bar.)

	private int rotateX = 0;    // Rotations of the cube about the axes.
	private int rotateY = 0;    //   (Controlled by arrow, PageUp, PageDown keys;
	private int rotateZ = 0;    //    Home key sets all rotations to 0.)

	private GLUT glut = new GLUT(); // An object for drawing GLUT shapes.


	/**
	 * The method that draws the current object, with its modeling transformation.
	 */
	private void draw(GL2 gl2) {

		gl2.glRotatef(rotateZ,0,0,1);   // Apply rotations to complete object.
		gl2.glRotatef(rotateY,0,1,0);
		gl2.glRotatef(rotateX,1,0,0);

		// TODO: Draw the currently selected object, number 1, 2, 3, 4, 5, or 6.
		// (Objects should lie in the cube with x, y, and z coordinates in the
		// range -5 to 5.)
		
		if (objectNumber == 1)
		   {
			
			corkscrew(gl2,2);

		   }
		   else if (objectNumber == 2 )
		   {
			   Added_Poligon(gl2, 1);	// gl2 , size
		    }
		   else if (objectNumber == 3 )
		   {
			   Polygon_and_Triangle(gl2,100,5,7); // gl2 n , r, h
		   }

	}
	public void corkscrew(GL2 gl2, double size)
	{
		gl2.glScaled(size,size,size);
		gl2.glPushMatrix();
		gl2.glPopMatrix();
		gl2.glPushMatrix();
		gl2.glScaled(0.35,1,0.35);
		gl2.glBegin(gl2.GL_LINE_STRIP);
		
		for(double j=0.1,i = 0; i < 300; i++,j+=0.1) 
		 {
		 if (i<=100)
		 gl2.glColor3f(0.0f, 1.0f, 0.0f);//green
		 else if (i<=200)
		 gl2.glColor3f(0.0f, 0.0f, 1.0f);//blue
		 else if (i<=300)
		 gl2.glColor3f(0.47f, 0.3274f, 0.1645f);//brown
		 gl2.glVertex3d(Math.cos(i/10.0),i/50.0,Math.sin(i/10.0));
		 }
		 gl2.glEnd();
		 gl2.glPopMatrix();

	   }
	
	public void Added_Poligon(GL2 gl2, double size)
	{
		gl2.glScaled(size,size,size);
		Podstawa(gl2 , 6 , 5);	
		gl2.glPushMatrix();
		Triangle(gl2,1.0f, 0.0f, 0.0f );
		gl2.glPushMatrix();
		gl2.glRotatef(0, 0, 0, 0);
		gl2.glPopMatrix();
		
		gl2.glPushMatrix();
		gl2.glRotated(60, 0, 1, 0);
		gl2.glTranslated(0,0,0);
		Triangle(gl2,0.0f, 1.0f, 0.0f );
		gl2.glPopMatrix();
		
		gl2.glPushMatrix();
		gl2.glRotated(120, 0, 1, 0);
		gl2.glTranslated(0,0,0);
		Triangle(gl2,1.0f, 0.0f, 0.0f );
		gl2.glPopMatrix();
		
		gl2.glPushMatrix();
		gl2.glRotated(180, 0, 1, 0);
		gl2.glTranslated(0,0,0);
		Triangle(gl2,0.0f, 1.0f, 0.0f );
		gl2.glPopMatrix();
		
		gl2.glPushMatrix();
		gl2.glRotated(-60, 0, 1, 0);
		gl2.glTranslated(0,0,0);
		Triangle(gl2,0.0f, 1.0f, 0.0f );
		gl2.glPopMatrix();
		
		gl2.glPushMatrix();
		gl2.glRotated(-120, 0, 1, 0);
		gl2.glTranslated(0,0,0);
		Triangle(gl2,1.0f, 0.0f, 0.0f );
		gl2.glPopMatrix();
		
	}
	
	public void Triangle (GL2 gl2 , float r , float g ,float b )
	{
		gl2.glColor3f(r,g,b);
		gl2.glBegin(GL2.GL_POLYGON);
		gl2.glVertex3d(5, 0.5, 0);
		gl2.glVertex3d(0, 5, 0);
		gl2.glVertex3d(2.5, 0.5,4.333);
	    gl2.glEnd ();
	}
	
	public void Podstawa (GL2 gl2,int n , int r)
	{
		gl2.glBegin(GL2.GL_POLYGON);
		for (int i=0;i<=n;i++)
		{	
			
			gl2.glColor3f(1.0f, 1.0f, 0.0f); 
			gl2.glVertex3d((double)(r*Math.cos(i*2*Math.PI/n)),0.5,(double)(r*Math.sin(i*2*Math.PI/n)));// gl2.glVertex3d(x , y ,z ) 
			 
		}
		gl2.glEnd();

	}
	public void Polygon_and_Triangle (GL2 gl2,int n , int r, int h)
	{
		Podstawa (gl2 , n , r);
	    for (int i=0;i<=n;i++)
	    {
	    	
	    	gl2.glBegin(GL2.GL_POLYGON);	
	    	gl2.glColor3f(0.0f,0.0f,1.0f);
			gl2.glVertex3d((double)(r*Math.cos(i*2*Math.PI/n)),0.5, (double)(r*Math.sin(i*2*Math.PI/n))); 
			gl2.glColor3f( 1.0f, 1.0f, 1.0f ); 
			gl2.glVertex3d(0, h, 0);
			i++;
			gl2.glColor3f(0.0f, 1.0f, 0.0f);
			gl2.glVertex3d((double)(r*Math.cos(i*2*Math.PI/n)),0.5,(double)(r*Math.sin(i*2*Math.PI/n)));
			i--;
		    gl2.glEnd ();
	    }
	}
	public void cylinder (GL2 gl2,int a, double size_x,double size_y , double size_z ) 
	{
	int n=a*100;
	gl2.glScaled(size_x,size_y,size_z);
	for (int i=0;i<=n;i++)
	{
	gl2.glBegin(gl2.GL_TRIANGLE_FAN);	
	gl2.glVertex3d(0.0, 2, 0.0);
	gl2.glVertex3d((2*Math.cos(i*2*Math.PI/n)), 2, (2*Math.sin(i*2*Math.PI/n)));
	gl2.glVertex3d ((2*Math.cos((i+1)*2*Math.PI/n)), 2, (2*Math.sin((i+1)*2*Math.PI/n)));
	gl2.glVertex3d ((2*Math.cos((i+1)*2*Math.PI/n)), 0.5, (2*Math.sin((i+1)*2*Math.PI/n)));
	gl2.glVertex3d((2*Math.cos(i*2*Math.PI/n)), 0.5, (2*Math.sin(i*2*Math.PI/n)));
	gl2.glVertex3d(0.0, 0.5, 0.0);	
	gl2.glEnd();
	}
	}
//	public void Triangles
	//-------------------- Draw the Scene  -------------------------

	/**
	 * The display method is called when the panel needs to be drawn.
	 * It's called when the window opens and it is called by the keyPressed
	 * method when the user hits a key that modifies the scene.
	 */
	public void display(GLAutoDrawable drawable) {    

		GL2 gl2 = drawable.getGL().getGL2(); // The object that contains all the OpenGL methods.

		if (useAnaglyph) {
			gl2.glDisable(GL2.GL_COLOR_MATERIAL); // in anaglyph mode, everything is drawn in white
			gl2.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, new float[]{1,1,1,1}, 0);
		}
		else { 
			gl2.glEnable(GL2.GL_COLOR_MATERIAL);  // in non-anaglyph mode, glColor* is respected
		}        	
		gl2.glNormal3f(0,0,1); // (Make sure normal vector is correct for object 1.)

		gl2.glClearColor( 0, 0, 0, 1 ); // Background color (black).
		gl2.glClear( GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT );


		if (useAnaglyph == false) {
			gl2.glLoadIdentity(); // Make sure we start with no transformation!
			gl2.glTranslated(0,0,-15);  // Move object away from viewer (at (0,0,0)).
			draw(gl2);
		}
		else {
			gl2.glLoadIdentity(); // Make sure we start with no transformation!
			gl2.glColorMask(true, false, false, true);
			gl2.glRotatef(4,0,1,0);
			gl2.glTranslated(1,0,-15); 
			draw(gl2);  // draw the current object!
			gl2.glColorMask(true, false, false, true);
			gl2.glClear(GL2.GL_DEPTH_BUFFER_BIT);
			gl2.glLoadIdentity();
			gl2.glRotatef(-4,0,1,0);
			gl2.glTranslated(-1,0,-15); 
			gl2.glColorMask(false, true, true, true);
			draw(gl2);
			gl2.glColorMask(true, true, true, true);
		}

	} // end display()

	/** The init method is called once, before the window is opened, to initialize
	 *  OpenGL.  Here, it sets up a projection, turns on some lighting, and enables
	 *  the depth test.
	 */
	public void init(GLAutoDrawable drawable) {
		GL2 gl2 = drawable.getGL().getGL2();
		gl2.glMatrixMode(GL2.GL_PROJECTION);
		gl2.glFrustum(-3.5, 3.5, -3.5, 3.5, 5, 25);
		gl2.glMatrixMode(GL2.GL_MODELVIEW);
		gl2.glEnable(GL2.GL_LIGHTING);  
		gl2.glEnable(GL2.GL_LIGHT0);
		gl2.glLightfv(GL2.GL_LIGHT0,GL2.GL_DIFFUSE,new float[] {0.7f,0.7f,0.7f},0);
		gl2.glLightModeli(GL2.GL_LIGHT_MODEL_TWO_SIDE, 1);
		gl2.glEnable(GL2.GL_DEPTH_TEST);
		gl2.glLineWidth(3);  // make wide lines for the stellated dodecahedron.
	}

	public void dispose(GLAutoDrawable drawable) {
		// called when the panel is being disposed
	}

	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		// called when user resizes the window
	}

	// ----------------  Methods from the KeyListener interface --------------

	/**
	 * Responds to keypressed events.  The four arrow keys control the rotations
	 * about the x- and y-axes.  The PageUp and PageDown keys control the rotation
	 * about the z-axis.  The Home key resets all rotations to zero.  The number
	 * keys 1, 2, 3, 4, 5, and 6 select the current object number.  Pressing the space
	 * bar toggles anaglyph stereo on and off.  The panel is redrawn to reflect the
	 * change.
	 */
	public void keyPressed(KeyEvent evt) {
		int key = evt.getKeyCode();
		boolean repaint = true;
		if ( key == KeyEvent.VK_LEFT )
			rotateY -= 6;
		else if ( key == KeyEvent.VK_RIGHT )
			rotateY += 6;
		else if ( key == KeyEvent.VK_DOWN)
			rotateX += 6;
		else if ( key == KeyEvent.VK_UP )
			rotateX -= 6;
		else if ( key == KeyEvent.VK_PAGE_UP )
			rotateZ += 6;
		else if ( key == KeyEvent.VK_PAGE_DOWN )
			rotateZ -= 6;
		else if ( key == KeyEvent.VK_HOME )
			rotateX = rotateY = rotateZ = 0;
		else if (key == KeyEvent.VK_1)
			objectNumber = 1;
		else if (key == KeyEvent.VK_2)
			objectNumber = 2;
		else if (key == KeyEvent.VK_3)
			objectNumber = 3;
		else if (key == KeyEvent.VK_4)
			objectNumber = 4;
		else if (key == KeyEvent.VK_5)
			objectNumber = 5;
		else if (key == KeyEvent.VK_6)
			objectNumber = 6;
		else if (key == KeyEvent.VK_SPACE)
			useAnaglyph = ! useAnaglyph;
		else
			repaint = false;
		if (repaint)
			repaint();
	}

	public void keyReleased(KeyEvent evt) {
	}

	public void keyTyped(KeyEvent evt) {
	}

} // end class Lab4