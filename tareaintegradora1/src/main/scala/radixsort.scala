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
  def countDigits(num: Int): Int = {
    @tailrec
    def count(num: Int, acc: Int): Int = {
      if (num == 0 && acc > 0) acc
      else count(num / 10, acc + 1)
    }
    count(num, 0)
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
      val emptyBuckets = Array.fill(10)(List.empty[Int])

      // Recorrer la lista y actualizar los buckets en una sola pasada
      @tailrec
      def fillBuckets(numbers: List[Int], buckets: Array[List[Int]]): Array[List[Int]] = {
        numbers match {
          case Nil => buckets
          case head :: tail =>
            val digitValue = getDigit(head, digit - 1)
            buckets(digitValue) = head :: buckets(digitValue)
            fillBuckets(tail, buckets)
        }
      }

      // Llenar los buckets y luego aplanar en una sola pasada
      @tailrec
      def flattenBuckets(buckets: Array[List[Int]], result: List[Int] = List.empty): List[Int] = {
        if (buckets.isEmpty) result
        else flattenBuckets(buckets.tail, buckets.head.reverse ::: result)
      }

      val filledBuckets = fillBuckets(list, emptyBuckets)
      val flattenedList = flattenBuckets(filledBuckets)

      // Llamada recursiva de cola para el siguiente dígito
      sortByDigit(flattenedList, digit - 1)
    }
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
