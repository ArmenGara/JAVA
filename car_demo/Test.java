public class Test{
    public static  void main(String args[]){
        //INSTANTIATE A CAR
        Car default Car = new Car();

        Car armenCar = new Car(4,4, "white", "v4", true);

        armenCar.drive(5).drive(5).drive(5);

    }
}