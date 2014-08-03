//I found this source in searching google with next words "ida* java code RubikCube"











//=============================================================================
//
//// Rubik's Cube Java Applet
////
//// Version 1.3 -- May 2 1999
////
//// Copyright 2000 Michael Schubart (michael at schubart dot net)
//// http://www.schubart.net/
////
//// The applet plus additional information can be found at
//// http://www.schubart.net/rc/
////
////===========================================================================
/**
 *
 * Modified by Uday Bondhugula <bondhugula.1@osu.edu> for an IDA*
 * solver.
 *
 */
import java.applet.Applet;
import java.awt.*;
import java.awt.image.*;
import java.net.MalformedURLException;
import javax.swing.*;
import java.awt.event.*;



//=============================================================================
// The RubiksCubeApplet class implements a simulation of Rubik's Cube.
//=============================================================================
public class RubiksCubeApplet extends Applet implements ActionListener{
	// names for the shapes (the different looks cubelet faces can have)
	public final static int SHAPE_XF = 0;	// on FACE_X, fully visible
	public final static int SHAPE_XP = 1;	// on FACE_X, partialy visible
	public final static int SHAPE_YF = 2;	// and so on
	public final static int SHAPE_YP = 3;
	public final static int SHAPE_ZF = 4;
	public final static int SHAPE_ZP = 5;

	// can be used to translate the graphics within the applet
	public final static int CUBEXOFFSET = 100;
	public final static int CUBEYOFFSET = 75;

	// describes where and how each face gets drawn
	// 6 cube faces, each with 3*3 cubelet faces -> 52 visible cubelet faces
	public final static CubeDisplayEntry[] displayTable = new CubeDisplayEntry[54];



	// the background image
	static Image background;
	// images of the shapes (6 shapes in 6 colors)
	static Image[][] shape = new Image[6][6];

	// the cube itself
	Cube cube = new Cube();
	// where did the user start dragging with the mouse?
	CubeSolver solver;
	CubeSurfacePoint dragStart;
	// did they press the Ctrl key then?
	boolean dragCtrlKey;

	// the components
	JButton solve = new JButton("Solve");
	JButton stop = new JButton("Stop");
	JButton reset = new JButton("Reset");
	JButton pause = new JButton("Pause");
	JButton previous, next;
	JButton test = new JButton("Test");
	JButton specify = new JButton("Specify");


	TextArea logBox;
	JLabel l;

	public void init() {
		// initializes the heuristic table to be used by heuristic function
		Heuristics.initpos();
		Heuristics.faceinit();
		CubeSolver.initialize();

		Panel buttonPanel = new Panel()	{
			public Insets getInsets(){
				return new Insets(10, 10, 20, 10);
			}
		};
		Panel top = new Panel();

		// create a CubeSurfacePoint object - makes sure the class has been
		// loaded when the user starts making moves
		new CubeSurfacePoint(0,0,0,0);

		setLayout(new BorderLayout());
		add("North", top);

		top.setLayout(new GridLayout(3,1));
		top.add(new JLabel("Solving Rubik's Cube using an IDA* Algo"));
		top.add(new JLabel("B Uday Kumar Reddy"));
		top.add(new JLabel("M Prasanth"));

		Panel display = new Panel();
		display.setLayout(new BorderLayout());
		logBox = new TextArea(6, 30);
		logBox.setEditable(false);
		logBox.setBackground(Color.white);
		display.add("North", new JLabel("Progress of the IDA* algo: "));
		display.add("Center", logBox);
		add("South", display);

		// on the right side, add the control buttons
		buttonPanel.setLayout(new GridLayout(9,1));
		buttonPanel.add(solve);
		buttonPanel.add(stop);
		buttonPanel.add(reset);
		buttonPanel.add(pause);
		stop.setEnabled(false);
		pause.setEnabled(false);
		solve.addActionListener(this);
		stop.addActionListener(this);
		reset.addActionListener(this);
		pause.addActionListener(this);
		test.addActionListener(this);
		previous = new JButton("Previous");
		next = new JButton("Next");
		previous.setEnabled(false);
		next.setEnabled(false);
		previous.addActionListener(this);
		next.addActionListener(this);
		buttonPanel.add(l = new JLabel("Click for Solution"));
		l.setEnabled(false);
		buttonPanel.add(previous);
		buttonPanel.add(next);
		buttonPanel.add(specify);
		specify.addActionListener(this);
		buttonPanel.add(test);

		add(buttonPanel, BorderLayout.EAST);


		// have the images been loaded by another instance
		if (background == null) {
			MediaTracker tracker = new MediaTracker(this);
			Image shapes;

			showStatus("Loading images, please wait...");
			background = getImage(getCodeBase(), "rc_back.gif");
			tracker.addImage(background, 0);
			shapes = getImage(getCodeBase(), "rc_shapes.gif");

			for (int colorNo = 0; colorNo < 6; colorNo++) {
				for (int shapeNo = 0; shapeNo < 6; shapeNo++) {
					// for each shape/color combination: crop a small image
					// out of the image with all shapes. avoids loading
					// 54 GIFs through the net.
					ImageFilter crop = new CropImageFilter(colorNo * 50,
								shapeNo * 42,
								50, 42);
					shape[colorNo][shapeNo] = createImage
					(new FilteredImageSource(shapes.getSource(), crop));
					tracker.addImage(shape[colorNo][shapeNo], 0);
				}
			}

			// wait for all images
			try {
				tracker.waitForAll();
			} catch (InterruptedException e) {}
		}
	}


	public void stop()	{
		if (solver != null)	solver.stop = true;
		solver = null;
	}


	//=========================================================================
	// Gets called when the applet needs to be redrawn.
	//=========================================================================
	public void paint(Graphics g) {
		// workaround for bug in some versions of Java (like 1.0.2 on Win32)
		g = getGraphics();

		// first the background...
		g.drawImage(background, CUBEXOFFSET, CUBEYOFFSET, this);

		// ...then the cubelet faces
		for (int faceNo = 0; faceNo < displayTable.length; faceNo++) {
			drawFace(g, faceNo);
		}
	}

	//=========================================================================
	// Draws one face of one cubelet.
	// faceNo:  the number of the display table entry that describes which
	//		  cubelet face gets drawn where
	//=========================================================================
	public void drawFace(Graphics g, int faceNo) {
	// get the shape
	int shapeNo = displayTable[faceNo].shape;

	// get the color
	int colorNo = cube.getColor(displayTable[faceNo].xSource,
					displayTable[faceNo].ySource,
					displayTable[faceNo].zSource,
					displayTable[faceNo].faceSource);

	// then draw it
	g.drawImage(shape[colorNo][shapeNo],
			displayTable[faceNo].xOffset + CUBEXOFFSET,
			displayTable[faceNo].yOffset + CUBEYOFFSET,
			this);
	}

	//=========================================================================
	// Gets called when the user clicks with the mouse. We start observing
	// what the mouse does.
	//=========================================================================
	public boolean mouseDown(Event event, int x, int y) {
		// are we for some reason already observing the mouse?
		if (dragStart != null) {
			// then ignore the click
			return true;
		}

		// where did the user click?
		dragStart = new CubeSurfacePoint(x, y, CUBEXOFFSET, CUBEYOFFSET);
		// was the Ctrl key pressed?
		dragCtrlKey = (event.modifiers & java.awt.Event.CTRL_MASK) != 0;

		// is it a point on the cube?
		if (!dragStart.isOnCube()) {
			// no -> forget that point, don't observe the mouse
			dragStart = null;
		}

		return true;
	}

	//=========================================================================
	// Gets called when the user releases the mouse button. We compute a
	// vector from the 2 points where the mouse button was clicked and
	// released. If it's a legal command, we twist the cube accordingly.
	//=========================================================================
	public boolean mouseUp(Event event, int x, int y) {
		// are we observing the mouse?
		if (dragStart == null) {
			// no -> ignore the event
				return true;
		}

			// what colors are displayed where?
		int[] cache = new int[displayTable.length];
		CubeSurfacePoint dragStop = new CubeSurfacePoint
			(x, y, CUBEXOFFSET, CUBEYOFFSET, dragStart.face);

		// how are the 2 points relative to each other?
		int deltaX = mysign(dragStop.cubeX - dragStart.cubeX);
		int deltaY = mysign(dragStop.cubeY - dragStart.cubeY);
		int deltaZ = mysign(dragStop.cubeZ - dragStart.cubeZ);

		// did we twist the cube?
		boolean rotation = false;

			// get all the old color values
		for (int faceNo = 0; faceNo < displayTable.length; faceNo++) {
				cache[faceNo] = cube.getColor(displayTable[faceNo].xSource,
					      	displayTable[faceNo].ySource,
						displayTable[faceNo].zSource,
					  displayTable[faceNo].faceSource);
		}


		// twist the cube according to the 2 points
		switch (dragStart.face) {
		case Cubelet.FACE_XV:
			if (deltaY == 0 && deltaZ != 0) {
			cube.rotate(Cubelet.AXIS_Y, -deltaZ,
					dragStart.cubeY, dragCtrlKey);
			rotation = true;

				} else if (deltaY != 0 && deltaZ == 0) {
			cube.rotate(Cubelet.AXIS_Z, deltaY,
					dragStart.cubeZ, dragCtrlKey);
			rotation=true;
			}
			break;

		case Cubelet.FACE_YV:
			if (deltaX == 0 && deltaZ != 0) {
			cube.rotate(Cubelet.AXIS_X, deltaZ,
					dragStart.cubeX, dragCtrlKey);
			rotation = true;

			} else if (deltaX != 0 && deltaZ == 0) {
			cube.rotate(Cubelet.AXIS_Z, -deltaX,
				dragStart.cubeZ, dragCtrlKey);
				rotation = true;
			}
			break;

		case Cubelet.FACE_ZV:
			if (deltaX == 0 && deltaY != 0) {
				cube.rotate(Cubelet.AXIS_X, -deltaY,
					dragStart.cubeX, dragCtrlKey);
				rotation = true;

			} else if (deltaX != 0 && deltaY == 0) {
				cube.rotate(Cubelet.AXIS_Y, deltaX,
					dragStart.cubeY, dragCtrlKey);
				rotation = true;
			}
			break;
		}

		// stop observing the mouse
		dragStart = null;

		// did we twist it?
		if (rotation) {
			Graphics g = getGraphics();

			// draw only those faces that have a different color now
			for (int faceNo = 0;faceNo < displayTable.length; faceNo++) {
				int cacheColor = cache[faceNo];
				int color = cube.getColor(displayTable[faceNo].xSource,
					  displayTable[faceNo].ySource,
						      	displayTable[faceNo].zSource,
						displayTable[faceNo].faceSource);

				if (color != cacheColor) {
					drawFace(g,faceNo);
				}
			}
		}

		return true;
	}

	//=========================================================================
	// return value:   1 if val > 0
	//				 0 if val = 0
	//				-1 if val < 0
	//=========================================================================
	int mysign(int val) {
		return (val == 0) ? 0 : ((val > 0) ? 1 : -1);
	}

	//=========================================================================
	// Gets called when the user pressed one of the buttons.
	//=========================================================================


	int count;
	Cube [] solution;
	int length;
	public void actionPerformed(ActionEvent ae)	{
		// the "solve" button?
		if (ae.getActionCommand().equals("Solve")) {
			solution = null;
			solver = new CubeSolver(cube, this);
			solve.setEnabled(false);
			l.setEnabled(false);
			stop.setEnabled(true);
			pause.setEnabled(true);
			showStatus("Solving the cube...");
		}

		if (ae.getActionCommand().equals("Pause"))	{
			pause.setText("Wake up");
			try{
				solver.sleep(50000);
			}catch (InterruptedException e)	{
				log("Cube solver thread woken up");
			}
		}
		else if (ae.getActionCommand().equals("Wake Up"))	{
			pause.setText("Pause");
			solver.interrupt();
		}
		else if (ae.getActionCommand().equals("Reset"))	{
			// give a fresh cube to work with
			if (solver != null)	{
				solver.stop = true;
				solver = null;
			}
			System.runFinalization();
			cube = new Cube();
			solve.setEnabled(true);
			stop.setEnabled(false);
			pause.setEnabled(false);
			previous.setEnabled(false);
			next.setEnabled(false);
			repaint();
		}
		else if (ae.getActionCommand().equals("Stop"))	{

			// stop button has been clicked
			stop.setEnabled(false);
			log("Search stopped, total nodes in open: " + solver.OPEN.size());
			log("No. of nodes in closed: " + solver.CLOSED.size());
			log("Total no. of nodes generated so far: " + (solver.OPEN.size()+solver.CLOSED.size()));
			solver.stop = true;
			solver.OPEN = null;
			solver.CLOSED = null;
			solver = null;
		}
		else if (ae.getActionCommand().equals("Previous"))	{
			count--;
			if (count == length - 2)	next.setEnabled(true);
			if (count == 0)	previous.setEnabled(false);
			cube = solution[count];
			repaint();
		}

		else if (ae.getActionCommand().equals("Next"))	{
			count++;
			if (count == 1)	previous.setEnabled(true);
			if (count == length - 1)	next.setEnabled(false);
			cube = solution[count];
			repaint();
		}
		else if (ae.getActionCommand().equals("Test"))	{
			System.out.println(Heuristics.heur(cube));
			System.runFinalization();
		}
		else if (ae.getActionCommand().equals("Specify"))	{
			specify.setText("OK");
			logBox.setText("Specify your own cube to be solved, click OK after specifying\n\n");
			logBox.append("Rules:\n============");
			logBox.append("Please specify the faces of the cube in the following order:\n");
			logBox.append("FRONT, RIGHT, BACK, LEFT, TOP, BOTTOM\n\n");
			logBox.append("Each color is to be represented by a number:\n");
			logBox.append("BLUE - 0, WHITE - 1, DARK-YELLOW - 2, RED - 3, YELLOW - 4, GREEN - 5\n\n");
			logBox.append("Each face has to be specified as a sequence of nine colors\n");
			logBox.append("The whole cube should be therefore be specified as a sequence of 54 numbers. (Please note that the program doesn't check whether the specified string represents a valid cube or whether it can be solved.)\n Start typing in this text area: \n");
			logBox.setEditable(true);
		}
		else if (ae.getActionCommand().equals("OK"))	{
			try	{
			specify.setText("Specify");
			String input = logBox.getText();
			String cubeString = input.substring(input.lastIndexOf(':'), input.length());
			Cube cube = makeCube(cubeString);
			this.cube = cube;
			logBox.setText("Accepted");
			repaint();
			}catch (NumberFormatException e)	{
				logBox.setText("Invalid specification");
			}
			logBox.setEditable(false);
		}
   	}

	public Cube makeCube(String cubeString)	throws NumberFormatException {
		if (cubeString.length() != 54)	throw new NumberFormatException();
		else{
			Cube cube = new Cube();
			for (int x = 0; x < 3;  x++)
			for (int y = 0; y < 3; y++)
			for (int z = 0; z < 3; z++)	{
				cube.cubelet[x][y][z].colors[Cubelet.FACE_XV]=(byte)cubeString.charAt(3*z+y);
				cube.cubelet[x][y][z].colors[Cubelet.FACE_ZH]=(byte)cubeString.charAt(9+3*z+y);
				cube.cubelet[x][y][z].colors[Cubelet.FACE_XH]=(byte)cubeString.charAt(8+3*z+y);
				cube.cubelet[x][y][z].colors[Cubelet.FACE_ZV]=(byte)cubeString.charAt(27+3*z+y);
				cube.cubelet[x][y][z].colors[Cubelet.FACE_YV]=(byte)cubeString.charAt(36+3*z+y);
				cube.cubelet[x][y][z].colors[Cubelet.FACE_YH]=(byte)cubeString.charAt(45+3*z+y);
			}
		}
		return cube;
	}


	// draws a given cube, this is mainly for debugging purposes
	public void drawCube(Cube cube)	{
		this.cube = cube;
		repaint();
		try{
			Thread.currentThread().sleep(3000);
		} catch (InterruptedException e)	{}
	}


	// writes a string into the text area of the applet
	public void log(String s)	{
		logBox.append(s + "\n");
	}


	// shows the solution given by the IDA* algo
	public void displaySolution(Cube [] solution)	{
		solve.setEnabled(true);
		pause.setEnabled(false);
		stop.setEnabled(false);
		if (solution.length != 1)	{
			next.setEnabled(true);
			l.setEnabled(true);
			count = 0;
			this.length = solution.length;
			this.solution = solution;
		}
	}



	//=========================================================================
	// This unnamed static function initializes the display table.
	//=========================================================================
	static {
	int i=0;

	for (int y = 0; y < 3; y++) {
		for (int z = 0; z < 3; z++) {
		displayTable[i++] = new CubeDisplayEntry
			(2, y, z, Cubelet.FACE_XV,
			 211 - 28 * z,
			 153 - 32 * y + 14 * z,
			 SHAPE_XF);

		displayTable[i++] = new CubeDisplayEntry
			(0, y, z, Cubelet.FACE_XH,
			 58 - 28 * z,
			 67 - 32 * y + 14 * z,
			 (y==0 && z==0) ? SHAPE_XP : SHAPE_XF);
		}
	}

	for (int x = 0; x < 3; x++) {
		for (int z = 0; z < 3; z++) {
		displayTable[i++] = new CubeDisplayEntry
			(x, 2, z, Cubelet.FACE_YV,
			 129 + 28 * x - 28 * z,
			 46 + 14 * x + 14 * z,
			 SHAPE_YF);

		displayTable[i++] = new CubeDisplayEntry
			(x, 0, z, Cubelet.FACE_YH,
			 129 + 28 * x - 28 * z,
			 210 + 14 * x + 14 * z,
			 (x==0 && z==0) ? SHAPE_YP : SHAPE_YF);
		}
	}

	for (int x = 0; x < 3; x++) {
		for (int y = 0; y < 3; y++) {
		displayTable[i++] = new CubeDisplayEntry
			(x, y, 2, Cubelet.FACE_ZV,
			 71 + 28 * x,
			 153 - 32 * y + 14 * x,
			 SHAPE_ZF);

		displayTable[i++] = new CubeDisplayEntry
			(x ,y, 0, Cubelet.FACE_ZH,
			 224 + 28 * x,
			 67 - 32 * y + 14 * x,
			 (x==0 && y==0) ? SHAPE_ZP : SHAPE_ZF);
		}
	}
   }

}
