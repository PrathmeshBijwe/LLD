
// Incorrect approach

//class Vehicle {
//    public void startEngine() {
//        System.out.println("Engine started");
//    }
//}
//
//class Bicycle extends Vehicle {
//    @Override
//    public void startEngine() {
//        throw new UnsupportedOperationException("Bicycles don't have engines!");
//    }
//}

//correct approach

interface Vehicle {
    void move();
}

interface MotorVehicle extends Vehicle {
    void startEngine();
}

class Car implements MotorVehicle {
    public void startEngine() { System.out.println("Car engine started"); }
    public void move() { System.out.println("Car moving"); }
}

class Bicycle implements Vehicle {
    public void move() { System.out.println("Bicycle moving"); }
}
