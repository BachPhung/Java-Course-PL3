public class Circle implements IShapeMetrics {
  double radius = 0.0;

  public Circle(double radius) {
    this.radius = radius;
  }
  
  public String toString(){
    return String.format("Circle with radius: %.2f", this.radius);
  }
  @Override
  public String name(){
    return "circle";
  }
  @Override
  public Double area(){
    return this.radius * Math.pow(PI, 2);
  }
  @Override
  public Double circumference(){
    return this.radius * PI;
  }
}