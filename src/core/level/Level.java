package core.level;

import core.graphics.Renderer;
import core.level.tile.Tile;

public class Level {

	protected int width , height;
	protected int[] tiles;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		
		generateLevel();
	}
	
	public Level(String path) {
		loadLevel(path);
	}
	
	protected void generateLevel() {
		
	}
	
	private void loadLevel(String path) {
		
	}
	
	public void update() {
		
	}
	
	private void time() {
		
	}
	
	public void render(int xScroll, int yScroll, Renderer renderer) {
		renderer.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + renderer.getWidth() + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + renderer.getHeight() + 16) >> 4;
		
		for (int y = y0; y < y1; y++)
			for (int x = x0; x < x1; x++)
				getTile(x, y).render(x, y, renderer);
	}
	
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.void_tile;
		if (tiles[x + y * width] == 0) return Tile.grass;
		
		return Tile.void_tile;
	}
	
}