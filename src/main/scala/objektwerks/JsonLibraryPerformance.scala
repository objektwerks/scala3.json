package objektwerks

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3)
@Measurement(iterations = 3)
@Fork(1)
class JsonLibraryPerformance {
  @Benchmark
  def borer(): Boolean = {
    import BorerCodecs._
    import io.bullet.borer.Json

    val employee = Employees.newEmployee
    val employeeJson = Json.encode(employee).toUtf8String
    employee == Json.decode(employeeJson.getBytes("UTF8")).to[Employee].value
  }

  @Benchmark
  def circe(): Boolean = {
    import io.circe.generic.auto._
    import io.circe.syntax._

    val employee = Employees.newEmployee
    val employeeJson = employee.asJson
    employee == employeeJson.as[Employee].toOption.get
  }
}