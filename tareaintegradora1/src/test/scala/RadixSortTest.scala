class RadixSortTest extends munit.FunSuite:

  import RadixSort.*


  test("RadixSort should sort an empty list") {
    val list = List()
    val sortedList = RadixSort.radixsort(list)
    assert(sortedList == List())
  }

  test("RadixSort should sort a list with one element") {
    val list = List(5)
    val sortedList = RadixSort.radixsort(list)
    assert(sortedList == List(5))
  }

  test("RadixSort should sort a sorted list") {
    val list = List(1, 2, 3, 4, 5)
    val sortedList = RadixSort.radixsort(list)
    assert(sortedList == List(1, 2, 3, 4, 5))
  }

  test("RadixSort should sort a reverse sorted list") {
    val list = List(5, 4, 3, 2, 1)
    val sortedList = RadixSort.radixsort(list)
    assert(sortedList == List(1, 2, 3, 4, 5))
  }

  test("RadixSort should sort a list with repeated elements") {
    val list = List(3, 5, 3, 2, 1, 4, 1)
    val sortedList = RadixSort.radixsort(list)
    assert(sortedList == List(1, 1, 2, 3, 3, 4, 5))
  }



  import scala.concurrent.duration.*
  override val munitTimeout = 10.seconds