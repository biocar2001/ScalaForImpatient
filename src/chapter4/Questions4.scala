package chapter4

import scala.beans.BeanProperty

/**
  * Created by carlos on 22/03/17.
  */
object Questions4 {
  // 1. Improve the Counter class in Section 5.1, "Simple Classes and Parameterless
  // Methods," on page 51 so that it doesn't turn negative at Int.MaxValue.
  class Counter {
    private var value = 0
    def increment() { if(value < Int.MaxValue) value += 1 }
    def current = value

    def isLess(other: Counter) = value < other.value // can access private field of other object
  }

  // 2. Write a class BankAccount with methods deposit and withdraw, and a read-only
  // property balance.
  class BankAccount {
    private var _balance = 0

    def balance = _balance

    def deposit(money: Int) = _balance += money
    def withdraw(money: Int) = if(money < _balance) _balance -= money
  }

  // 3. Write a class Time with read-only properties hours and minutes and a method
  // before(other: Time): Boolean that checks whether this time comes before the
  // other. A Time object should be constructed as new Time(hrs, min), where hrs is in
  // military time format (between 0 and 23).

  class Time(val hrs: Int, val min: Int) {
    def before(other: Time) = {
      (hrs < other.hrs) || (hrs == other.hrs && min < other.min)
    }
  }


  // 4. Reimplement the Time class from the preceding exercise so that the internal
  // representation is the number of minutes since midnight (between 0 and
  // 24 * 60 - 1). Do not change the public interface. That is, client code should be
  // unaffected by your change.
  class Time(hrs: Int, min: Int) {
    private val _time = hrs * 60 + min

    def before(other: Time) = _time < other._time
  }

  // 5. Make a class Student with read-write JavaBeans properties name (of type String)
  // and id (of type Long). What methods are generated? (Use javap to check.) Can
  // you call the JavaBeans getters and setters in Scala? Should you?
  class Student (@BeanProperty var name: String, @BeanProperty var id: Long) {
  }
  /*
  What methods are generated? (Use javap to check.)
  //Compiled from "Student.scala"
  public class Student implements scala.ScalaObject {
    public java.lang.String name();
    public void name_$eq(java.lang.String);
    public void setName(java.lang.String);
    public long id();
    public void id_$eq(long);
    public void setId(long);
    public long getId();
    public java.lang.String getName();
    public Student(java.lang.String, long);
  }
  Can you call the JavaBeans getters and setters in Scala? => Yes
  Should you? => No because they are verbose and not as intuitive as scala's methods
  */

  // 6. In the Person class of Section 5.1, "Simple Classes and Parameterless Methods,"
  // on page 51, provide a primary constructor that turns negative ages to 0.
  class Person(var name: String = "", var age: Int = 0) {
    if(age < 0) age = 0
  }


  // 7. Write a class Person with a primary constructor that accepts a string containing
  // a first name, a space, and a last name, such as new Person("Fred Smith"). Supply
  // read-only properties firstName and lastName. Should the primary constructor
  // parameter be a var, a val, or a plain parameter? Why?
  class Person(name: String) {
    private val fnln = name.split(' ')
    val firstName = fnln(0)
    val lastName = fnln(1)
  }
  // Should the primary constructor
  // parameter be a var, a val, or a plain parameter? Why?
  // => It should be a plain parameter as it's not used in any of the methods

  //8. Make a class Car with read-only properties for manufacturer, model name,
  //and model year, and a read-write property for the license plate. Supply four
  //constructors. All require the manufacturer and model name. Optionally,
  //model year and license plate can also be specified in the constructor. If not,
  //the model year is set to -1 and the license plate to the empty string. Which
  //constructor are you choosing as the primary constructor? Why?

  class Car(val manufacturer: String, val modelName: String, val modelYear: Int, var licensePlate: String) {
    def this(manufacturer: String, modelName: String, licensePlate: String) = {
      this(manufacturer, modelName, -1, licensePlate)
    }

    def this(manufacturer: String, modelName: String, modelYear: Int) = {
      this(manufacturer, modelName, modelYear, "")
    }

    def this(manufacturer: String, modelName: String) = {
      this(manufacturer, modelName, -1, "")
    }

    override def toString = {
      "[" + manufacturer + ", " + modelName + ", " + modelYear + ", '" + licensePlate + "']"
    }
  }

  // Using default values for constructor parameters, this class can be simplified to the following

  class Car(val manufacturer: String, val modelName: String, val modelYear: Int = -1, var licensePlate: String = "") {
    def this(manufacturer: String, modelName: String, licensePlate: String) = {
      this(manufacturer, modelName, -1, licensePlate)
    }

    override def toString = {
      "[" + manufacturer + ", " + modelName + ", " + modelYear + ", '" + licensePlate + "']"
    }
  }

  // Which constructor are you choosing as the primary constructor? Why?
  // => The constructor that takes all 4 values was chosen as the primary constructor. It's easy to define the other
  // constructors that simply need to call the primary constructor with some default values

  //9. Reimplement the class of the preceding exercise in Java, C#, or C++ (your
  //choice). How much shorter is the Scala class?
  public class JCar {
    private String manufacturer;
    private String modelName;
    private int modelYear = -1;
    private String licensePlate = "";

    public JCar(String manufacturer, String modelName, int modelYear, String licensePlate) {
      this.manufacturer = manufacturer;
      this.modelName = modelName;
      this.modelYear = modelYear;
      this.licensePlate = licensePlate;
    }

    public JCar(String manufacturer, String modelName, int modelYear) {
      this.manufacturer = manufacturer;
      this.modelName = modelName;
      this.modelYear = modelYear;
    }

    public JCar(String manufacturer, String modelName, String licensePlate) {
      this.manufacturer = manufacturer;
      this.modelName = modelName;
      this.licensePlate = licensePlate;
    }

    public JCar(String manufacturer, String modelName) {
      this.manufacturer = manufacturer;
      this.modelName = modelName;
    }

    public String getLicensePlate() {
      return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
      this.licensePlate = licensePlate;
    }

    public String getManufacturer() {
      return manufacturer;
    }

    public String getModelName() {
      return modelName;
    }

    public int getModelYear() {
      return modelYear;
    }

    @Override
    public String toString() {
      return "[" + manufacturer + ", " + modelName + ", " + modelYear + ", '" + licensePlate + "']";
    }
  }

  //10. Consider the class
  //class Employee(val name: String, var salary: Double) {
  // def this() { this("John Q. Public", 0.0) }
  //}
  //Rewrite it to use explicit fields and a default primary constructor. Which form
  //do you prefer? Why?

  class Employee() {
    private var _name: String = "John Q. Public"
    var salary: Double = 0.0

    def this(n: String, s: Double) {
      this()
      _name = n
      salary = s
    }

    def name = _name
  }
}
