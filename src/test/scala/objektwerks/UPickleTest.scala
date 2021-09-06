package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class UPickleTest extends AnyFunSuite with Matchers {
  test("upickle") {
    import UPickleCodecs._
    import upickle.default._

    val employee = Employee(1, "James Bond")
    val employeeJson = write(employee)
    employee shouldBe read[Employee](employeeJson)

    println(s"upickle employee: $employee")
    println(s"upickle employee json: $employeeJson")

    val person = employee.asInstanceOf[Person]
    val personJson = write(person)
    person shouldBe read[Person](personJson)

    println(s"upickle person: $person")
    println(s"upickle person json: $personJson")
  }
}