file://<WORKSPACE>/tareaintegradora1/src/main/scala/Main.scala
### dotty.tools.dotc.core.TypeError$$anon$1: Toplevel definition sortedList is defined in
  <WORKSPACE>/tareaintegradora1/src/main/scala/radixsort.scala
and also in
  <WORKSPACE>/tareaintegradora1/src/main/scala/Main.scala
One of these files should be removed from the classpath.

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.3/scala3-library_3-3.3.3.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ]
Options:



action parameters:
offset: 364
uri: file://<WORKSPACE>/tareaintegradora1/src/main/scala/Main.scala
text:
```scala
import RadixSort._
import CountingSort._
import HeapSort._


object Main {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)

    val heapSort = HeapSort.heapsort(list)
    println(s"Heap Sorted List: $heapSort")
    println(heapSort.size)

    val sortedList = RadixSort.radixsort(unsortedList)
    p@@

  }
}

```



#### Error stacktrace:

```

```
#### Short summary: 

dotty.tools.dotc.core.TypeError$$anon$1: Toplevel definition sortedList is defined in
  <WORKSPACE>/tareaintegradora1/src/main/scala/radixsort.scala
and also in
  <WORKSPACE>/tareaintegradora1/src/main/scala/Main.scala
One of these files should be removed from the classpath.