class HeapSortTest extends munit.FunSuite:

  import HeapSort.*

  test("HeapSort should sort a list of integers") {
    val list = List(4, 10, 3, 5, 1)
    val sortedList = HeapSort.heapsort(list)
    assertEquals(sortedList, List(1, 3, 4, 5, 10))
  }

  test("HeapSort should handle an empty list") {
    val list = List()
    val sortedList = HeapSort.heapsort(list)
    assertEquals(sortedList, List())
  }

  test("HeapSort should handle a list with one element") {
    val list = List(1)
    val sortedList = HeapSort.heapsort(list)
    assertEquals(sortedList, List(1))
  }

  test("HeapSort should handle a list with duplicate elements") {
    val list = List(4, 10, 3, 5, 1, 4)
    val sortedList = HeapSort.heapsort(list)
    assertEquals(sortedList, List(1, 3, 4, 4, 5, 10))
  }

  import scala.concurrent.duration.*
  override val munitTimeout = 10.seconds
