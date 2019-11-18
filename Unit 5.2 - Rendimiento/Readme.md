Profiler useful commands (VisualVM)
====================================
Download tool: https://visualvm.github.io/download.html

Intellij -> Settings -> Plugins -> Browse repository -> VisualVM Launcher -> install -> restart IDE

mvn exec:java -Papp

Contiperf
=========

Defining an attribute of type ContiPerfRule with the annotation @Rule in your class activates ContiPerf.
- Load Testing: @PerfTest
- Timed testing @Required


```
public class SmokeTest 
{
	@Rule
	public ContiPerfRule i = new ContiPerfRule();
	@Test
	@PerfTest(invocations = 1000, threads = 20)
	@Required(max = 1200, average = 250)
	public void test1() throws Exception {
	Thread.sleep(200);
}
```

Execute testse with contiperf
- mvn test

Execute tests ignoring contiperf
- mvn test -DargLine="-Dcontiperf.active=false"

- @PerfTest(invocations = 300)
Executes the test 300 times, regardless of the number of threads. If left out, ContiPerf defaults to invocations=1, ignoring the 'threads‘ counts

- @PerfTest(threads=30)
Executes the test in 30 concurrent threads. The total number of 'invocations' is distributed evenly over the threads. Thus, for invocations=300, threads=30, each thread performs 10 invocations.
If left out, ContiPerf defaults to a single thread.

- @PerfTest(duration = 20000)
Executes the test repeatedly for at least 20,000 milliseconds (20 seconds)

- @Required(throughput = 20)
Requires to have at least 20 test executions per second

- @Required(average = 50)
Requires an average execution time of not more than 50 milliseconds

- @Required(median = 45)
Requires that 50% of all executions do not take longer than 45 milliseconds

- @Required(max = 2000)
Requires that no invocation takes more than 2000 milliseconds (2 seconds)

- @Required(totalTime = 5000)
Requires that the sum of all execution times is not more than 5000 milliseconds (5 seconds)

- @Required(percentile90 = 3000)
Requires that 90% of all executions do not take longer than 3000 milliseconds

- @Required(percentile95 = 5000)
Requires that 95% of all executions do not take longer than 5000 milliseconds

- @Required(percentile99 = 10000)
Requires that 99% of all executions do not take longer than 10000 milliseconds

- @Required(percentiles = "66:200,96:500"):
Requires that 66% of all executions do not take longer than 200 milliseconds and 96% of all executions do not take longer than 500 milliseconds


Log4J
=====
https://es.wikipedia.org/wiki/Log4j


Simple Logging Façade for Java (SLFJ)
======================================
http://www.slf4j.org/

