 1. Function Overloading:
//  ○ Define two overloaded functions named calculateArea that calculate the area
//  of a rectangle and a circle. The first function should take two parameters (length
//  and breadth) and return the area of a rectangle. The second function should take
//  one parameter (radius) and return the area of a circle.

class Overload{
   fun calculateArea (len:Int, bread:Int):Double{
       var ans=len * bread
       return ans.toDouble()
   }
   fun calculateArea ( rad:Int):Double{
       var ans=  3.14 * rad * rad
       return ans.toDouble()
   }
   fun main() {
       println(calculateArea(15,20))
       println(calculateArea(20))
   }
    
}
fun main(){
    var overload=Overload()
    overload.main()
}
//output 300.0 1256.0

2. Higher-Order Functions:
//  ○ Write a higher-order function named operation that takes two integers and a
//  function as parameters. The function should apply the given function to the two
//  integers and return the result

class Higherorder{
    companion object {
        fun create():Higherorder=Higherorder()  
        }
    
    fun operation ( a:Int, b:Int,func:(Int,Int)->Int):Int{
      	return func(a,b)
    }
    fun add(x:Int,y:Int):Int{
        return x+y
    }
     fun sub(x:Int,y:Int):Int{
        return x-y
    }
      fun mul(x:Int,y:Int):Int{
        return x*y
    }
       fun div(x:Int,y:Int):Int{
        return x/y
    }
    
}
fun main(){
    val instance=Higherorder.create()
	println(instance.operation(3,4,instance::add))
    println(instance.operation(3,4,instance::sub))
    println(instance.operation(3,4,instance::mul))
    println(instance.operation(5,5,instance::div))
}
// output 7
// -1
// 12
// 1

3. Extension Functions:
//  ○ Create an extension function for the String class named isPalindrome that
//  returns true if the string is a palindrome, and false otherwise

fun String.isPalindrome(): Boolean {
    val cleanedString = this
    
    val length = cleanedString.length
    var reversedString = ""
    for (i in length - 1 downTo 0) {
        reversedString += cleanedString[i]
    }
    
    return cleanedString == reversedString
}

fun main() {
    val str1 = "racecar"
    val str2 = "madam"
    val str3="palindrome"
    
    println("\"$str1\" is palindrome: ${str1.isPalindrome()}")
    println("\"$str2\" is palindrome: ${str2.isPalindrome()}")
    println("\"$str3\" is palindrome: ${str3.isPalindrome()}")
}

Advanced Programming Questions on Classes
//  1. Inheritance and Polymorphism:
//  ○ Create an abstract class Shape with an abstract method area. Create two
//  subclasses Rectangle and Circle that implement the area method. Add
//  another method perimeter in both subclasses and demonstrate polymorphism

abstract class shape{
    abstract fun area():Double
    
}

class Rectangle(val length:Int,val breadth:Int):shape() {
    override fun area():Double{
        val ans=length * breadth
        return  ans.toDouble()
    }
}
class Circle(val radius:Int):shape(){
    override fun area():Double{
        val ans:=3.14* radius*radius
        return ans.toDouble()
    }
}
fun main(){
    val circle=Circle(10)
    val rectangle=Rectangle(10,20)
    val circ=circle.area()
    val rect=rectangle.area()
    println("area of circle is $circ")
        println("area of rectangle is $rect")
}
// output:-area of circle is 314.0
// area of rectangle is 200.0

// 2. Data Classes and Copy Function:
// ○ Define a data class Person with properties name, age, and address. Create an
// instance of Person and use the copy function to create a new instance with a
// different age and address.
data class Person(val name:String,val age:Int,val address:String)

fun main(){
    val person1=Person("Sai",20,"Bhubneswar")
    val person2=person1.copy(age=21,address="Rourkela")
    println(person1)
    println(person2)
}
// ouput:-
// Person(name=Sai, age=20, address=Bhubneswar)
// Person(name=Sai, age=21, address=Rourkela)

//  3. Companion Objects and Factory Methods:
//  ○ Create a class User with a companion object that has a factory method to create
//  a user with a default age. Extend the factory method to allow creation of a user
//  with optional parameters for name and age

class User(val name:String,val age:Int,val address:String){ //Primary Constructor: Defines how to initialize a User object.
    companion object{
        fun create(name:String,age:Int=21,address:String):User{ //Factory Method: Provides an easy way to create a User with optional parameters.
            return User(name,age,address)
        }
    }
}
fun main(){
    val user1=User.create(name="sai",age=29,address="Bhubneswar")
    val user2=User.create(name="Monu",address="Rourkela")
    println("user1 details: Name=${user1.name},Age=${user1.age},Address=${user1.address}")
    println("user2 details: Name=${user2.name},Age=${user2.age},Address=${user2.address}")
}
//Arguments: Passed to both the create method and the User constructor to ensure flexibility
// and encapsulation of object creation logic.
// output:-
// user1 details: Name=sai,Age=29,Address=Bhubneswar
// user2 details: Name=Monu,Age=21,Address=Rourkela

//  4. Interface Implementation:
//  ○ Create an interface Drawable with a method draw. Implement this interface in
//  two classes Square and Triangle. Extend the interface to include a method
//  resize and demonstrate its usage in both classes.

interface Drawable {
    fun draw()
}
class Square():Drawable{
    override fun draw(){
        println("drawing square")
    }
}
class Triangle():Drawable{
    override fun draw(){
        println("Drawing triangle")
    }
}
fun main(){
 val square=Square()
  val triangle=Triangle()
  square.draw()
  triangle.draw()
}
// output:-
// drawing square
// Drawing triangle

5. Singleton Pattern:
//  ○ Implement the Singleton pattern using Kotlin's object declaration. Create a class
//  DatabaseConnection that ensures only one instance of the connection exists
//  throughout the application

object DatabaseConnection {
    fun connect() {
        println("Connecting to the database")
    }

    fun disconnect() {
        println("Disconnecting from the database")
    }
}

fun main() {
    DatabaseConnection.connect()
    DatabaseConnection.disconnect()
    val dbConnection1 = DatabaseConnection
    val dbConnection2 = DatabaseConnection
    println(dbConnection1 === dbConnection2)
}
// output
// Connecting to the database
// Disconnecting from the database
// true