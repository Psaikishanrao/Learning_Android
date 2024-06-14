1. **Class Constructor Parameters**:
   - These parameters are part of the primary constructor of the `User` class. They are used to initialize the properties of the class when a new instance is created.

2. **Factory Method Parameters**:
   - The factory method (`create`) is a method within the companion object. It provides a convenient way to create instances of the `User` class.
   - The factory method allows you to set default values and manage the creation process, providing flexibility and additional logic if needed.

### Why Two Sets of Parameters?

1. **Primary Constructor**:
   - Defines what information is needed to create an instance of `User`.
   - Example:
     ```kotlin
     class User(val name: String, val age: Int, val address: String)
     ```

2. **Factory Method**:
   - Provides a convenient way to create instances, with optional parameters and default values.
   - Calls the primary constructor to actually create the instance.
   - Example:
     ```kotlin
     companion object {
         fun create(name: String, age: Int = 21, address: String): User {
             return User(name, age, address)
         }
     }
     ```

### Detailed Explanation with Example

Let's walk through the code step by step:

#### Class Definition

```kotlin
class User(val name: String, val age: Int, val address: String)
```
- The `User` class has three properties: `name`, `age`, and `address`.
- The primary constructor initializes these properties when a new `User` instance is created.

#### Companion Object with Factory Method

```kotlin
companion object {
    fun create(name: String, age: Int = 21, address: String): User {
        return User(name, age, address)
    }
}
```
- The `create` method is a factory method in the companion object.
- It takes three parameters (`name`, `age`, and `address`), with `age` having a default value of `21`.
- It creates a new `User` instance by calling the primary constructor: `User(name, age, address)`.

#### Main Function

```kotlin
fun main() {
    val user1 = User.create(name = "sai", age = 29, address = "Bhubneswar")
    val user2 = User.create(name = "Monu", address = "Rourkela")
    
    println("user1 details: Name=${user1.name}, Age=${user1.age}, Address=${user1.address}")
    println("user2 details: Name=${user2.name}, Age=${user2.age}, Address=${user2.address}")
}
```
- `User.create(name = "sai", age = 29, address = "Bhubneswar")` creates a `User` with the specified `name`, `age`, and `address`.
  - It calls `User(name, 29, "Bhubneswar")`.
- `User.create(name = "Monu", address = "Rourkela")` creates a `User` with the specified `name` and `address`, using the default age of `21`.
  - It calls `User(name, 21, "Rourkela")`.

### Summary

1. **Primary Constructor**:
   - Defines what parameters are needed to instantiate a `User`.

2. **Factory Method**:
   - Provides a convenient way to create `User` instances with optional parameters and default values.
   - Calls the primary constructor to actually create the `User` instance.

### Visualization

Here's a simplified flow:

1. **Calling Factory Method**:
   - `User.create(name, age, address)`

2. **Factory Method Logic**:
   - Checks if default values are needed.
   - Calls the primary constructor: `User(name, age, address)`.

3. **Primary Constructor**:
   - Initializes the `User` instance with the provided values.

### Code

```kotlin
class User(val name: String, val age: Int, val address: String) {
    companion object {
        fun create(name: String, age: Int = 21, address: String): User {
            return User(name, age, address)
        }
    }
}

fun main() {
    val user1 = User.create(name = "sai", age = 29, address = "Bhubneswar")
    val user2 = User.create(name = "Monu", address = "Rourkela")
    
    println("user1 details: Name=${user1.name}, Age=${user1.age}, Address=${user1.address}")
    println("user2 details: Name=${user2.name}, Age=${user2.age}, Address=${user2.address}")
}
```
