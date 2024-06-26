package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class BorerTest extends AnyFunSuite with Matchers:
  test("borer"):
    import io.bullet.borer.Json
    import BorerCodecs.given

    val utf8 = "UTF8"

    val employee = Employees.newEmployee
    val employeeJson = Json.encode(employee).toUtf8String
    employee shouldBe Json.decode(employeeJson.getBytes(utf8)).to[Employee].value

    println(s"borer employee: $employee")
    println(s"borer employee json: $employeeJson")
    
    val person = employee.asInstanceOf[Person]
    val personJson = Json.encode(person).toUtf8String
    person shouldBe Json.decode(personJson.getBytes(utf8)).to[Person].value

    println(s"borer person: $person")
    println(s"borer person json: $personJson")