import scala.annotation.tailrec
object RadixSort {
  /**
   * Function to get the maximum value in a list of integers.
   * @param xs List of integers.
   * @return Maximum integer value.
   */
  def getMax(xs: List[Int]): Int = xs match {
    case Nil => 0
    case h :: t => Math.max(h, getMax(t))
  }

  /**
   * Function to apply Counting Sort based on the digit at a particular place.
   * @param xs List of integers.
   * @param exp Exponent representing the place value.
   * @return Sorted list based on current place value.
   */
  def countingSort(xs: List[Int], exp: Int): List[Int] = {
    val n = xs.length
    val output = Array.ofDim[Int](n)
    val count = Array.fill(10)(0)

    xs.foreach { x => count((x / exp) % 10) += 1 }

    for (i <- 1 until 10) {
      count(i) += count(i - 1)
    }

    xs.reverse.foreach { x =>
      val index = (x / exp) % 10
      output(count(index) - 1) = x
      count(index) -= 1
    }

    output.toList
  }

  /**
   * Function to implement Radix Sort.
   * @param xs List of integers to be sorted.
   * @return Sorted list.
   */
  def radixSort(xs: List[Int]): List[Int] = {
    val max = getMax(xs)
    @tailrec
    def sortRec(exp: Int, xs: List[Int]): List[Int] = {
      if (max / exp > 0) sortRec(exp * 10, countingSort(xs, exp))
      else xs
    }
    sortRec(1, xs)
  }
}