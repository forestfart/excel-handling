package pl.edu.agh.mwo.java2;

public final class Rectangle {
    private final double height;
    private final double width;
    
    public Rectangle(double height, double width) {
    	if (height < 0.0 || height < 0.0) 
    		throw new IllegalArgumentException();
    	this.height = height;
    	this.width = width;
    	
    }

	public double getHeight() {
		return height;
	}

	public double getWidth() {
		return width;
	}
    
    
}
