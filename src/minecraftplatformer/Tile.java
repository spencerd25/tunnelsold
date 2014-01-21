package minecraftplatformer;

import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class Tile {
	public static int tileSize = 31;
	public static int invCellSize = 25;
	public static int invlength = 8;
	public static int invCellSpace = 4;
	public static int invBorderSpace = 4;
	
	public static int[] air = {-1, -1};
	public static int[] earth = {0, 0};
	public static int[] grass = {1, 0};
	public static int[] sand = {2, 0};
	
	public static int[] character = {0, 18};
	
	public static BufferedImage tileset_terrain;
	
	public Tile() {
		try {
		Tile.tileset_terrain = ImageIO.read(new File("res/tileset_terrain.png"));
		} catch(Exception e) { }
	}
}
