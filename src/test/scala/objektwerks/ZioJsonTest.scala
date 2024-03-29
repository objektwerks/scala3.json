package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

final class ZioJsonTest extends AnyFunSuite with Matchers:
  test("zio"):
    import zio.json.*
    import ZioJsonCodecs.given

    val employee = Employees.newEmployee
    val employeeJson = employee.toJson
    employee shouldBe employeeJson.fromJson[Employee].getOrElse( Employee(0, "") )

    println(s"zio employee: $employee")
    println(s"zio employee json: $employeeJson")

    val person = employee.asInstanceOf[Person]
    val personJson = person.toJson
    person shouldBe personJson.fromJson[Person].getOrElse( Employee(0, "") )

    println(s"zio person: $person")
    println(s"zio person json: $personJson")
