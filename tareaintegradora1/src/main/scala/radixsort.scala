import scala.annotation.tailrec

/**
 * Object that implements the RadixSort algorithm for sorting a list of integers with a single tail recursion.
 */
object RadixSort {

  /**
   * Method to perform radix sort on a list of integers.
   *
   * @param list The list of integers to sort.
   * @return The sorted list of integers.
   */
  def radixsort(list: List[Int]): List[Int] = {
    if (list.isEmpty) list
    else {
      val maxNum = list.max
      val maxDigits = countDigits(maxNum)
      sortByDigit(list, maxDigits)
    }
  }

  /**
   * Counts the number of digits in an integer.
   *
   * @param num The integer to count the digits.
   * @return The number of digits.
   */
  def countDigits(num: Int, acc: Int = 0): Int = {
    if (num == 0 && acc > 0) acc
    else countDigits(num / 10, acc + 1)
  }

  /**
   * Sorts the list by processing each digit using a single tail recursion.
   *
   * @param list The list of integers to sort.
   * @param maxDigits The maximum number of digits in the largest number.
   * @return The sorted list of integers.
   */
  @tailrec
  def sortByDigit(list: List[Int], digit: Int): List[Int] = {
    if (digit == 0) list
    else {
      // Create empty buckets as lists for each digit (0-9)
      val emptyBuckets = Array(
        List.empty[Int], List.empty[Int], List.empty[Int], List.empty[Int],
        List.empty[Int], List.empty[Int], List.empty[Int], List.empty[Int],
        List.empty[Int], List.empty[Int]
      )

      // Fill buckets for the current digit
      val filledBuckets = fillBuckets(list, emptyBuckets, digit - 1)

      // Flatten the buckets into a single list and recurse for the next digit
      sortByDigit(flattenBuckets(filledBuckets), digit - 1)
    }
  }

  /**
   * Fills the buckets based on the current digit value.
   *
   * @param numbers The list of numbers to distribute into buckets.
   * @param buckets The array of buckets to fill.
   * @param index The index of the current digit being processed.
   * @return The filled buckets.
   */
  private def fillBuckets(numbers: List[Int], buckets: Array[List[Int]], index: Int): Array[List[Int]] = {
    numbers.foreach { num =>
      val digitValue = getDigit(num, index)
      buckets(digitValue) = num :: buckets(digitValue)
    }
    buckets
  }

  /**
   * Flattens the filled buckets into a single sorted list.
   *
   * @param buckets The array of filled buckets.
   * @return A flattened list containing all elements from the buckets.
   */
  private def flattenBuckets(buckets: Array[List[Int]]): List[Int] = {
    buckets.flatten.toList
  }

  /**
   * Retrieves the digit at a specific index from a number.
   *
   * @param num The number to extract the digit from.
   * @param index The index of the digit (0 is the least significant digit).
   * @return The digit at the specified index.
   */
  def getDigit(num: Int, index: Int): Int = {
    (num / math.pow(10, index).toInt) % 10
  }
}
