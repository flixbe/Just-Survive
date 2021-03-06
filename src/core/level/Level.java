package core.level;

import core.graphics.Renderer;
import core.level.tile.Tile;

public class Level {

	private static final int GRASS_COLOR  = 0xFF00FF00;
	private static final int FLOWER_COLOR = 0xFF00AA00;
	private static final int ROCK_COLOR   = 0xFFAFAFAF;
	
	protected int width , height;
	protected int[] tiles;
	protected int[] pixelsColors;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		
		generateLevel();
	}
	
	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}
	
	protected void generateLevel() {
		
	}
	
	protected void loadLevel(String path) {
		
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
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, renderer);
			}
	}
	
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height ) return Tile.void_tile;
		if (pixelsColors[x + y * width] == GRASS_COLOR) return Tile.grass;
		if (pixelsColors[x + y * width] == FLOWER_COLOR) return Tile.flower;
		if (pixelsColors[x + y * width] == ROCK_COLOR) return Tile.rock;
		
		return Tile.void_tile;
	}
	
}