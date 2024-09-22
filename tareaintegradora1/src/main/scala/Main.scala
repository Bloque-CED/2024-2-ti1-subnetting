import RadixSort._
import CountingSort._
import HeapSort._


object Main {
  def main(args: Array[String]): Unit = {
    val unsortedList = List(170, 45, 75, 90, 802, 24, 2, 66)

    val heapSorted = HeapSort.heapsort(unsortedList, true)
    println(s"Heap Sorted List: $heapSorted")
  }
}
