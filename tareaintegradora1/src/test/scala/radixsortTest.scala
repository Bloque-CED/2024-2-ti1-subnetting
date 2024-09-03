package SortingAlgorithms

import org.scalatest.funsuite.AnyFunSuite

class RadixSortTest extends AnyFunSuite {

  test("RadixSort should sort an empty list") {
    assert(RadixSort.radixSort(List()) == List())
  }

  test("RadixSort should sort a list with one element") {
    assert(RadixSort.radixSort(List(5)) == List(5))
  }

  test("RadixSort should sort a sorted list") {
    assert(RadixSort.radixSort(List(1, 2, 3, 4, 5)) == List(1, 2, 3, 4, 5))
  }

  test("RadixSort should sort a reverse sorted list") {
    assert(RadixSort.radixSort(List(5, 4, 3, 2, 1)) == List(1, 2, 3, 4, 5))
  }

  test("RadixSort should sort a list with repeated elements") {
    assert(RadixSort.radixSort(List(3, 5, 3, 2, 1, 4, 1)) == List(1, 1, 2, 3, 3, 4, 5))
  }

  test("RadixSort should sort a list with negative elements") {
    assert(RadixSort.radixSort(List(-3, -1, -2, -5, -4)) == List(-5, -4, -3, -2, -1))
  }

  test("RadixSort should sort a list with large numbers") {
    assert(RadixSort.radixSort(List(1000000, 999999, 1, 50, 500000)) == List(1, 50, 500000, 999999, 1000000))
  }
}
