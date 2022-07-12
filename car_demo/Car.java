public class Car{
    //Member Variables
    private int wheels;
    private int doors;
    private String colors;
    private String engine;
    private boolean convertible;
    private int miles;

    // Constructor Methods
    // Empty Constructor
    public Car(){
        this.wheels = 4;
        this.doors = 4l
        this.colors = "Black";
        this.engine = "V4"
        this.convertible = false;
        this.miles = 0
    }
    // Full Constructor
    public Car( int wheels, int doors, String color, String enginem, boolean convertiable){
        this.wheels = wheels;
        this.doors = doors;
        this.colors = colors;
        this.engine = engine;
        this.convertiable = convertiable;
        this.miles = miles;
    }
    // Other Methods
    //drive
    public Car drive(int distance){
        this.miles += distance;
        System.out.println(this.miles);
        //Return this to the test java.
        return this;
    }
    //honk
    ///
    // Getters/ Setters 
    public in getWheels(){
        return this.wheels;
    }

    public void setWheels(int newWheels){
        this.wheels = this.newWheels;
    }


}