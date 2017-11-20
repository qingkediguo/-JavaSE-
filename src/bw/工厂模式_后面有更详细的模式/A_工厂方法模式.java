package bw.工厂模式_后面有更详细的模式;

//抽象产品角色
interface Moveable {
  void run();
}
//具体产品角色
class Plane implements Moveable {
  @Override
  public void run() {
      System.out.println("plane....");
  }
}

class Broom implements Moveable {
  @Override
  public void run() {
      System.out.println("broom.....");
  }
}

//抽象工厂
abstract class VehicleFactory {
  abstract Moveable create();
}
//具体工厂
class PlaneFactory extends VehicleFactory{
  public Moveable create() {
      return new Plane();
  }
}
class BroomFactory extends VehicleFactory{
  public Moveable create() {
      return new Broom();
  }
}
//测试类
public class A_工厂方法模式 {
  public static void main(String[] args) {
      VehicleFactory factory = new BroomFactory();
      VehicleFactory factory2 = new PlaneFactory();
      Moveable m = factory.create();
      Moveable m1 = factory2.create();
      m.run();
      m1.run();
  }
}