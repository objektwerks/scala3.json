Scala Json
----------
>Feature tests and performance benchmarks across 7 Scala json libraries:
* Jsoniter, Circe, uPickle, ZioJson

Test
----
1. sbt clean test

Benchmark
---------
>See Performance class for details.
1. sbt jmh:run

Results
-------
>OpenJDK Runtime Environment Zulu17.30+51-CA (build 17.0.1+12-LTS), Scala 2.13.7, Apple M1
1. jsoniter - 0.126
2. circe - 0.164
3. upickle - 0.353
4. ziojson - 0.380
>Total time: 1405s (23:25), 10 warmups, 10 iterations, in microseconds, completed 2021.12.12