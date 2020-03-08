
public class ShapeUnion implements Shape{
	private Shape s1;
	private Shape s2;
	
	public ShapeUnion(Shape s1, Shape s2) {
		this.s1 = s1;
		this.s2 = s2;
	}
	@Override
	public boolean continePunct(int x, int y) {
		return s1.continePunct(x, y) || s2.continePunct(x, y);
	}

}
