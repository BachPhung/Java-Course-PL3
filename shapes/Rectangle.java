public class Rectangle implements IShapeMetrics {
  double height = 0.0;
  double width = 0.0;
  Rectangle(double height, double width){
    this.height = height;
    this.width = width;
  }
  public String toString(){
    return String.format("Rectangle with height %.2f and width %.2f", this.height, this.width);
  }
  @Override
  public String name(){
    return "rectangle";
  }
  @Override
  public Double area(){
    return this.height * this.width;
  }
  @Override
  public Double circumference(){
    return 2 * (this.height + this.width);
  }
}
