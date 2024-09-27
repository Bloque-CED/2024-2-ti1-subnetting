import RadixSort._
import CountingSort._
import HeapSort._


object Main {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)

    val heapSort = HeapSort.heapsort(list)
    println(s"Heap Sorted List: $heapSort")
    println(heapSort.size)

    val sortedList = RadixSort.radixsort(list)
    println(s"Radix Sorted List: $sortedList")
    println(sortedList.size)

    val countingSort = CountingSort.countingsort(list)
    println(s"Counting Sorted List: $countingSort")
    println(countingSort.size)


  }
}
