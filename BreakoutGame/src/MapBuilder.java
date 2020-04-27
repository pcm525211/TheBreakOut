

public class MapBuilder {
	Shape c;
	MapGenerator map;
	public MapBuilder(MapGenerator map, Shape c) {
		this.c = c;
		this.map = map;
																	
	}
	public void stage1() {
		for (int y = 0; y < map.map.length; y++) {
			for (int x = 0; x < 10 ; x++) {
				if (c.continePunct(x, x)) {
					map.setBrickValue(1, x, y);
				}
			}
		}

	}

}
