
public class InvertedShape implements Shape{
	private Shape s;
	
	public InvertedShape(Shape s) {
		this.s = s;
	}
	
	@Override
	public boolean continePunct(int x, int y) {
		return !s.continePunct(x, y);
	}
}
