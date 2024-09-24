import RadixSort._
import CountingSort._
import HeapSort._


object Main {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)

    val heapSort = HeapSort.heapsort(list)
    println(s"Heap Sorted List: $heapSort")
    println(heapSort.size)
  }
}
