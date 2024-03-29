package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

final class CirceTest extends AnyFunSuite with Matchers:
  test("circe"):
    import io.circe.generic.auto.*
    import io.circe.syntax.*

    val employee = Employees.newEmployee
    val employeeJson = employee.asJson
    employee shouldBe employeeJson.as[Employee].toOption.get

    println(s"circe employee: $employee")
    println(s"circe employee json: $employeeJson")

    val person = employee.asInstanceOf[Person]
    val personJson = person.asJson
    person shouldBe personJson.as[Person].toOption.get

    println(s"circe person: $person")
    println(s"circe person json: $personJson")
