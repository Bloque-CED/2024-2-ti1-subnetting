import org.scalatest.funsuite.AnyFunSuite

class CountingSortTest extends AnyFunSuite {
  test("CountingSort should sort a list of integers") {
    val list = List(4, 10, 3, 5, 1)
    val sortedList = CountingSort.countingSort(list)
    assert(sortedList == List(1, 3, 4, 5, 10))
  }
}
