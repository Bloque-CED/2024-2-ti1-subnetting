package SortingAlgorithms

import org.scalatest.funsuite.AnyFunSuite

class HeapSortTest extends AnyFunSuite {

  test("HeapSort should sort an empty list") {
    assert(HeapSort.heapSort(List()) == List())
  }

  test("HeapSort should sort a list with one element") {
    assert(HeapSort.heapSort(List(5)) == List(5))
  }

  test("HeapSort should sort a sorted list") {
    assert(HeapSort.heapSort(List(1, 2, 3, 4, 5)) == List(1, 2, 3, 4, 5))
  }

  test("HeapSort should sort a reverse sorted list") {
    assert(HeapSort.heapSort(List(5, 4, 3, 2, 1)) == List(1, 2, 3, 4, 5))
  }

  test("HeapSort should sort a list with repeated elements") {
    assert(HeapSort.heapSort(List(3, 5, 3, 2, 1, 4, 1)) == List(1, 1, 2, 3, 3, 4, 5))
  }

  test("HeapSort should sort a list with negative elements") {
    assert(HeapSort.heapSort(List(-3, -1, -2, -5, -4)) == List(-5, -4, -3, -2, -1))
  }

  test("HeapSort should sort a list with large numbers") {
    assert(HeapSort.heapSort(List(1000000, 999999, 1, 50, 500000)) == List(1, 50, 500000, 999999, 1000000))
  }
}
