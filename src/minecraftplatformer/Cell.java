package minecraftplatformer;

import java.awt.*;

public class Cell extends Rectangle {
	private static final long serialVersionUID = 1L;
	
	public int[] id = {0, 0};
	
	public Cell(Rectangle size, int[] id) {
		setBounds(size);
		this.id = id;
		
	}
	
	public void render(Graphics g) {
		g.setColor(new Color(255,100,100));
		g.fillRect(x, y, width, height);
	}
}
