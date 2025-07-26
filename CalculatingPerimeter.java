public class CalculatingPerimeter
{
  public static void main(String[] args) {
    Distance();
  }
  static void distance()
  {
    float lenth=0.7f;
    float brth=0.5f;
    float perimeter=2*(lenth+brth);
    float wire_required=perimeter*4;
    System.out.println("the wire required for fencing the rectangular field is "+wire_required);
  }
  static void Distance()
  {
    int total_distance=5350;
    int walking_distance=1070;
    int bus_distance=total_distance-walking_distance;
    System.out.println("the distance travelled by bus is "+bus_distance);
  }
}