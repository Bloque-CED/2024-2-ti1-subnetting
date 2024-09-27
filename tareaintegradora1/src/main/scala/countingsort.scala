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
   * @param max The maximum value in the list.
   * @return A list representing the frequency of each element.
   */
  @tailrec
  def buildCountArray(list: List[Int], max: Int, counts: List[Int] = List.fill(max + 1)(0)): List[Int] = list match {
    case Nil => counts
    case x :: xs =>
      val updatedCounts = counts.updated(x, counts(x) + 1)
      buildCountArray(xs, max, updatedCounts)
  }

  /**
   * Reconstructs the sorted list from the count array.
   *
   * @param counts The count array.
   * @return The sorted list of integers.
   */
  @tailrec
  def reconstructSortedList(counts: List[Int], sortedList: List[Int] = List()): List[Int] = counts match {
    case Nil => sortedList
    case 0 :: tail => reconstructSortedList(tail, sortedList)
    case count :: tail =>
      val newList = List.fill(count)(counts.indexOf(count)) ::: sortedList
      reconstructSortedList(tail, newList)
  }
}
