import RadixSort._
import CountingSort._
import HeapSort._


object Main {
  def main(args: Array[String]): Unit = {
    val unsortedList = List(170, 45, 75, 90, 802, 24, 2, 66)

    // RadixSort
    val radixSorted = RadixSort.radixSort(unsortedList)
    println(s"Radix Sorted List: $radixSorted")

    // CountingSort
    val countingSorted = CountingSort.countingSort(unsortedList)
    println(s"Counting Sorted List: $countingSorted")

    // HeapSort
    val heapSorted = HeapSort.heapSort(unsortedList)
    println(s"Heap Sorted List: $heapSorted")
  }
}
