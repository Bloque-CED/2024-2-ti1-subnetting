// countingsort.scala

object CountingSort {
  /**
   * Counting sort implementation for non-negative integers.
   * @param xs List of integers.
   * @return Sorted list of integers.
   */
  def countingSort(xs: List[Int]): List[Int] = {
    if (xs.isEmpty) return xs
    val max = xs.max
    val count = Array.fill(max + 1)(0)
    xs.foreach(x => count(x) += 1)

    val sortedList = for {
      (n, freq) <- count.zipWithIndex
      _ <- 1 to n
    } yield freq

    sortedList.toList
  }
}

