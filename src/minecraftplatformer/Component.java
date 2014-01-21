package minecraftplatformer;

import java.applet.*;
import javax.swing.*;
import java.awt.*;

public class Component extends Applet implements Runnable{
	private static final long serialVersionUID = 1L;
	
	static int pixelSize = 2;
	
	public static int moveFromBorder = 0;
	public static double sX = moveFromBorder, sY = moveFromBorder;
	public static double dir = 0;
	
	public static Dimension size = new Dimension(700, 550);
	public static Dimension pixel = new Dimension(size.width / pixelSize, size.height / pixelSize);
	
	public static Point mse = new Point(0, 0);
	
	public static String name = "Tunnels";
	
	public static boolean isRunning = false;
	public static boolean isMoving = false;
	public static boolean isJumping = false;
	public static boolean isMouseLeft = false;
	public static boolean isMouseRight = false;
	
	private Image screen;
	
	public static Level level;
	public static Character character;
	public static Inventory Inventory;

	public Component() {
		setPreferredSize(size);
		
		addKeyListener(new Listening());
		addMouseListener(new Listening());
		addMouseMotionListener(new Listening());
		addMouseWheelListener(new Listening());
	}
	
	public void start() {
		//Defining objects etc.
		new Tile(); //Loading images.
		level = new Level();
		character = new Character(Tile.tileSize, Tile.tileSize*2);
		Inventory = new Inventory();
		
		//starting game loop.
		isRunning = true;
		new Thread(this).start();
	}
	
	public void stop() {
		isRunning = false;
	}
	
	public static void main(String args[]) {
		Component component = new Component();
		
		JFrame frame = new JFrame();
		frame.add(component);
		frame.pack();
		frame.setTitle(name);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		component.start();
		}
	public void tick() {
		character.tick();
		level.tick((int) sX, (int) sY, (pixel.width / Tile.tileSize) + 2, (pixel.height / Tile.tileSize) + 2);
	}
	
	public void render() {
		Graphics g = screen.getGraphics();
		
		//Drawing things
		g.setColor(new Color(100 ,100, 255));
		g.fillRect(0, 0, pixel.width, pixel.height);
		
		level.render(g, (int) sX, (int) sY, (pixel.width / Tile.tileSize) + 2, (pixel.height / Tile.tileSize) + 2);
		character.render(g);
		Inventory.render(g);
		
		g = getGraphics();
		
		g.drawImage(screen, 0, 0, size.width, size.height, 0, 0, pixel.width, pixel.height, null);
		g.dispose();
	}
		
	public void run()  {
		screen = createVolatileImage(pixel.width, pixel.height);
		
		while(isRunning) {
			tick();
			render();
			
			
			try {
				Thread.sleep(5);
			} catch(Exception e) { }
		}
	}
}

