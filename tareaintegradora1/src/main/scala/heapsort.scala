
// heapsort.scala

object HeapSort {

  /**
   * Heapify a subtree rooted at index i.
   * @param xs List of integers (as an ArrayBuffer).
   * @param n Size of the heap.
   * @param i Index of the root element.
   */
  def heapify(xs: Array[Int], n: Int, i: Int): Unit = {
    var largest = i
    val left = 2 * i + 1
    val right = 2 * i + 2

    if (left < n && xs(left) > xs(largest)) largest = left
    if (right < n && xs(right) > xs(largest)) largest = right

    if (largest != i) {
      val swap = xs(i)
      xs(i) = xs(largest)
      xs(largest) = swap
      heapify(xs, n, largest)
    }
  }

  /**
   * HeapSort implementation.
   * @param xs List of integers.
   * @return Sorted list of integers.
   */
  def heapSort(xs: List[Int]): List[Int] = {
    val arr = xs.toArray
    val n = arr.length

    for (i <- n / 2 - 1 to 0 by -1) {
      heapify(arr, n, i)
    }

    for (i <- n - 1 to 1 by -1) {
      val temp = arr(0)
      arr(0) = arr(i)
      arr(i) = temp
      heapify(arr, i, 0)
    }
    arr.toList
  }
}
