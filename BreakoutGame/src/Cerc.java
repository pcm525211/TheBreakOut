

public class Cerc implements Shape {

	double raza;
	int x;
	int y;
	
	
	public Cerc(int x, int y, double raza)		{
		this.raza = raza;
		this.x = x;
		this.y = y;
			
	}
	
	@Override
	public boolean continePunct(int i, int j) {
		return (i-y) * (i-y) + (j-x) * (j-x) <= raza*raza;
	}
	
}
