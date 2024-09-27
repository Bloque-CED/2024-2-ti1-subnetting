import scala.annotation.tailrec

/**
 * Object that implements the RadixSort algorithm for sorting a list of integers.
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
      sortByDigit(list, 0, maxDigits)
    }
  }

  /**
   * Counts the number of digits in an integer.
   *
   * @param num The integer to count the digits.
   * @return The number of digits.
   */
  @tailrec
  def countDigits(num: Int, count: Int = 0): Int = {
    if (num == 0 && count > 0) count
    else countDigits(num / 10, count + 1)
  }

  /**
   * Sorts the list by each digit starting from the least significant digit.
   *
   * @param list The list of integers to sort.
   * @param currentDigit The current digit index to sort by.
   * @param maxDigits The maximum number of digits in the largest number.
   * @return The sorted list of integers.
   */
  @tailrec
  def sortByDigit(list: List[Int], currentDigit: Int, maxDigits: Int): List[Int] = {
    if (currentDigit >= maxDigits) list
    else {
      val buckets = createBuckets(list, currentDigit)
      val flattenedList = buckets.flatten
      sortByDigit(flattenedList, currentDigit + 1, maxDigits)
    }
  }

  /**
   * Creates buckets for each digit (0-9) based on the current digit index.
   *
   * @param list The list of integers to bucket.
   * @param digitIndex The current digit index to use for bucketing.
   * @return A list of lists, where each sublist contains numbers in the same bucket.
   */
  def createBuckets(list: List[Int], digitIndex: Int): List[List[Int]] = {
    val emptyBuckets = List.fill(10)(List.empty[Int])

    @tailrec
    def fillBuckets(numbers: List[Int], buckets: List[List[Int]]): List[List[Int]] = {
      numbers match {
        case Nil => buckets
        case head :: tail =>
          val digit = getDigit(head, digitIndex)
          val updatedBuckets = buckets.updated(digit, head :: buckets(digit))
          fillBuckets(tail, updatedBuckets)
      }
    }

    fillBuckets(list, emptyBuckets).map(_.reverse)
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
