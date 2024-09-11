
import scala.annotation.tailrec

/**
 * Radix Sort implementation for a generic type T.
 * It requires a function that can map the type T to a List[Int] representation.
 *
 * @tparam T the type of the elements to be sorted.
 * @param xs the list of elements of type T to be sorted.
 * @param toDigitList a function that converts elements of type T to a List[Int] for sorting.
 * @return A sorted list of elements of type T.
 */
def radixSort[T](xs: List[T])(toDigitList: T => List[Int]): List[T] = {

  /**
   * Helper function to perform counting sort on the given list of elements based on a particular digit place.
   *
   * @param xs List of elements to be sorted.
   * @param exp The digit place we are currently sorting by.
   * @param toDigitList Function to convert elements to List[Int] for sorting.
   * @return Sorted list of elements by the current digit place.
   */
  def countingSort(xs: List[T], exp: Int)(implicit toDigitList: T => List[Int]): List[T] = {
    val maxDigit = 10
    val n = xs.length
    val output = Array.ofDim[T](n)
    val count = Array.ofDim[Int](maxDigit)

    xs.foreach { x =>
      val digit = (toDigitList(x)(exp) % maxDigit)
      count(digit) += 1
    }

    for (i <- 1 until maxDigit) {
      count(i) += count(i - 1)
    }

    xs.reverse.foreach { x =>
      val digit = (toDigitList(x)(exp) % maxDigit)
      output(count(digit) - 1) = x
      count(digit) -= 1
    }

    output.toList
  }

  /**
   * Main recursive sorting function.
   *
   * @param exp The current digit place we are sorting by.
   * @param xs List of elements to be sorted.
   * @return A sorted list of elements.
   */
  @tailrec
  def sortRec(exp: Int, xs: List[T]): List[T] = {
    val maxLength = xs.map(toDigitList).map(_.length).max
    if (exp >= maxLength) xs
    else sortRec(exp + 1, countingSort(xs, exp))
  }

  sortRec(0, xs)
}

object RadixSortExample extends App {
  // Example usage with integers
  val sortedInts = radixSort(List(170, 45, 75, 90, 802, 24, 2, 66))(x => x.toString.map(_.asDigit).toList)
  println(sortedInts)  // Output: List(2, 24, 45, 66, 75, 90, 170, 802)

  // Example usage with strings (alphabetical order by characters)
  val sortedStrings = radixSort(List("banana", "apple", "grape", "orange", "kiwi"))(x => x.map(_.toInt).toList)
  println(sortedStrings)  // Output: List(apple, banana, grape, kiwi, orange)
}
