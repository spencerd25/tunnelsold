package minecraftplatformer;

import java.awt.event.*;

public class Listening implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		switch(key) {
		case KeyEvent.VK_D:
			Component.isMoving = true;
			Component.dir = Component.character.movementSpeed;
			break;
		case KeyEvent.VK_A:
			Component.isMoving = true;
			Component.dir = -Component.character.movementSpeed;
			break;
		case KeyEvent.VK_W:
			Component.isJumping = true;
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		switch(key) {
		case KeyEvent.VK_D:
			if(Component.dir == Component.character.movementSpeed) {
				Component.isMoving = false;
			}
			break;
		case KeyEvent.VK_A:
			if(Component.dir == -Component.character.movementSpeed) {
				
			}
				Component.isMoving = false;
			break;
		case KeyEvent.VK_W:
			if (Component.isJumping = false) {
			break;
			}
		}
	}
		
	public void keyTyped(KeyEvent e)
	{

	}

	
	public void mouseWheelMoved(MouseWheelEvent e) {
		
	}

	
	public void mouseDragged(MouseEvent e) {
	Component.mse.setLocation(e.getX(),e.getY());
	}

	
	public void mouseMoved(MouseEvent e) {
	Component.mse.setLocation(e.getX(),e.getY());
	}


	public void mouseClicked(MouseEvent e) {
		
	}

	
	public void mouseEntered(MouseEvent e) {
		
	}

	
	public void mouseExited(MouseEvent e) {
		
	}

	
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			Component.isMouseLeft = true;
			
		} else if(e.getButton() == MouseEvent.BUTTON3) {
			Component.isMouseRight = true;
		}
	}

	
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			Component.isMouseLeft = false;
			
		} else if(e.getButton() == MouseEvent.BUTTON3) {
			Component.isMouseRight = false;
		}
	}
	
}
