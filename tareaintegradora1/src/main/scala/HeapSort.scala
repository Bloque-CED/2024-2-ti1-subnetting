import scala.annotation.tailrec

/**
 * Object that implements the HeapSort algorithm for sorting a list of integers.
 */
object HeapSort {

  /**
   * Method to perform heap sort on a list of integers using a comparison function.
   *
   * @param list The list of integers to sort.
   * @return The sorted list of integers.
   */
  def heapsort(list: List[Int]): List[Int] = {
    val heapified = buildMaxHeap(list, comparable)
    sortHeap(heapified, comparable)
  }

  /**
   * Comparison function to be used in heap sort. It compares two integers.
   *
   * @param a The first integer.
   * @param b The second integer.
   * @return True if the first integer is less than the second, false otherwise.
   */
  def comparable(a: Int, b: Int): Boolean = a > b

  /**
   * Builds a max heap from a list of integers using the given comparison function.
   *
   * @param list The list of integers to build the max heap from.
   * @param comparator The comparison function.
   * @return The list of integers arranged as a max heap.
   */
  def buildMaxHeap(list: List[Int], comparator: (Int, Int) => Boolean): List[Int] = {

    @tailrec
    def heapify(index: Int, currentList: List[Int]): List[Int] = {
      if (index < 0) currentList
      else heapify(index - 1, maxHeapify(index, currentList, comparator))
    }

    heapify((list.length / 2) - 1, list)
  }

  /**
   * Applies the max heapify operation on the list using the given comparison function.
   *
   * @param index The index to start heapifying from.
   * @param list The list of integers to heapify.
   * @param comparator The comparison function.
   * @return The heapified list of integers.
   */
  def maxHeapify(index: Int, list: List[Int], comparator: (Int, Int) => Boolean): List[Int] = {
    val leftIndex = leftHeap(list, index)
    val rightIndex = rightHeap(list, index)

    val largestIndex = (leftIndex < list.length, rightIndex < list.length) match {
      case (true, true) =>
        if (comparator(list(leftIndex), list(index)) && comparator(list(leftIndex), list(rightIndex))){
          leftIndex
        } else if (comparator(list(rightIndex), list(index))){
          rightIndex
        } else {
          index
        }

      case (true, false) =>
        if (comparator(list(leftIndex), list(index))){
          leftIndex
        } else {
          index
        }

      case (false, true) =>
        if (comparator(list(rightIndex), list(index))){
          rightIndex
        } else {
          index
        }

      case (false, false) => index
    }

    if (largestIndex != index) {
      swap(list, index, largestIndex) match {
        case swappedList => maxHeapify(largestIndex, swappedList, comparator)
      }
    } else {
      list
    }
  }

  /**
   * Swaps two elements in the list at the given indices.
   *
   * @param list The list of integers.
   * @param index1 The first index.
   * @param index2 The second index.
   * @return The list with the two elements swapped.
   */
  def swap(list: List[Int], index1: Int, index2: Int): List[Int] = {
    if (index1 == index2) list
    else {
      val elem1 = list(index1)
      val elem2 = list(index2)
      list.updated(index1, elem2).updated(index2, elem1)
    }
  }

  /**
   * Sorts the heap into a sorted list using the given comparison function.
   *
   * @param list The heapified list of integers.
   * @param comparator The comparison function.
   * @return The sorted list of integers.
   */
  def sortHeap(list: List[Int], comparator: (Int, Int) => Boolean): List[Int] = {

    @tailrec
    def sort(currentList: List[Int], sortedList: List[Int]): List[Int] = {
      currentList match {
        case Nil => sortedList
        case _ =>
          val swappedList = swap(currentList, 0, currentList.length - 1)
          val element = swappedList.last
          val reducedHeap = maxHeapify(0, swappedList.init, comparator)

          sort(reducedHeap, element :: sortedList)
      }
    }

    sort(list, Nil)
  }

  /**
   * Returns the index of the left child of a node in the heap.
   *
   * @param list The heap list.
   * @param index The index of the current node.
   * @return The index of the left child.
   */
  def leftHeap(list: List[Int], index: Int): Int = {
    2 * index + 1
  }

  /**
   * Returns the index of the right child of a node in the heap.
   *
   * @param list The heap list.
   * @param index The index of the current node.
   * @return The index of the right child.
   */
  def rightHeap(list: List[Int], index: Int): Int = {
    2 * index + 2
  }
}
