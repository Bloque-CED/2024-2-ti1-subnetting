import scala.annotation.tailrec

/**
 * Object that implements the CountingSort algorithm for sorting a list of integers.
 */
object CountingSort {

  /**
   * Sorts a list of non-negative integers using the CountingSort algorithm.
   *
   * @param list The list of integers to sort.
   * @return The sorted list of integers.
   */
  def countingsort(list: List[Int]): List[Int] = {
    // Verify that the list only contains non-negative integers
    if (list.exists(_ < 0)) {
      throw new IllegalArgumentException("CountingSort only works with non-negative integers.")
    }

    if (list.isEmpty) list
    else {
      val maxElement = list.max
      val counts = buildCountArray(list, maxElement)
      reconstructSortedList(counts)
    }
  }

  /**
   * Builds the count array that stores the frequency of each element in the list.
   *
   * @param list The list of integers.
   * @param maxElement The maximum value in the list.
   * @return An array representing the frequency of each element.
   */
  def buildCountArray(list: List[Int], maxElement: Int): Array[Int] = {
    val counts = Array.fill(maxElement + 1)(0)
    list.foreach { num => counts(num) += 1 }
    counts
  }

  /**
   * Reconstructs the sorted list from the count array.
   *
   * @param counts The count array.
   * @return The sorted list of integers.
   */
  def reconstructSortedList(counts: Array[Int]): List[Int] = {
    @tailrec
    def buildList(index: Int, acc: List[Int]): List[Int] = {
      if (index >= counts.length) acc
      else if (counts(index) > 0)
        buildList(index + 1, List.fill(counts(index))(index) ++ acc) //change the concatenation to the beginning
      else
        buildList(index + 1, acc)
    }
    buildList(0, List()).reverse //revert the list to keep the order
  }
}
