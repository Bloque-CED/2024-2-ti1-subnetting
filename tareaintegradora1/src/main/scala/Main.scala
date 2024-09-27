import RadixSort._
import CountingSort._
import HeapSort._

object Main {
  def main(args: Array[String]): Unit = {
    val list = List(4, 2, 2, 8, 3, 3, 1)  // Lista de prueba sin negativos

    val heapSort = HeapSort.heapsort(list)
    println(s"Heap Sorted List: $heapSort")
    println(s"Heap Sorted List Size: ${heapSort.size}")

    val sortedList = RadixSort.radixsort(list)
    println(s"Radix Sorted List: $sortedList")
    println(s"Radix Sorted List Size: ${sortedList.size}")

    val countingSort = CountingSort.countingsort(list)
    println(s"Counting Sorted List: $countingSort")
    println(s"Counting Sorted List Size: ${countingSort.size}")
  }
}
