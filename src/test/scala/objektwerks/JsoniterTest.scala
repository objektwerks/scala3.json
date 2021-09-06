package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class JsoniterTest extends AnyFunSuite with Matchers {
  test("jsoniter") {
    import JsoniterCodecs._
    import com.github.plokhotnyuk.jsoniter_scala.core._

    val employee = Employee(1, "auric goldfinger")
    val employeeJson = writeToString[Employee](employee)
    employee shouldBe readFromString[Employee](employeeJson)

    println(s"jsoniter employee: $employee")
    println(s"jsoniter employee json: $employeeJson")
    
    val personJson = writeToString[Person](employee)
    employee shouldBe readFromString[Employee](personJson)
    employeeJson shouldBe personJson
    
    println(s"jsoniter person json: $personJson")
  }
}