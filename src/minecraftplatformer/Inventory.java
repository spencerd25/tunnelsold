package minecraftplatformer;

import java.awt.*;

public class Inventory {
	public Cell[] invBar = new Cell[Tile.invlength];
	
	public Inventory() {
		for(int i=0;i<invBar.length;i++) {
			invBar[i] = new Cell(new Rectangle((Component.pixel.width / 2) - ((Tile.invlength * (Tile.invCellSize + Tile.invCellSpace))/2) + (i *(Tile.invCellSize + Tile.invCellSpace)), Component.pixel.height - (Tile.invCellSize + Tile.invBorderSpace), Tile.invCellSize, Tile.invCellSize), Tile.air);
	}
}

	public void render(Graphics g) {
			for(int i=0;i<invBar.length;i++) {
				invBar[i].render(g);
			}
		}
	
}
