package SortingAlgorithms

import org.scalatest.funsuite.AnyFunSuite

class CountingSortTest extends AnyFunSuite {

  test("CountingSort should sort an empty list") {
    assert(CountingSort.countingSort(List()) == List())
  }

  test("CountingSort should sort a list with one element") {
    assert(CountingSort.countingSort(List(5)) == List(5))
  }

  test("CountingSort should sort a sorted list") {
    assert(CountingSort.countingSort(List(1, 2, 3, 4, 5)) == List(1, 2, 3, 4, 5))
  }

  test("CountingSort should sort a reverse sorted list") {
    assert(CountingSort.countingSort(List(5, 4, 3, 2, 1)) == List(1, 2, 3, 4, 5))
  }

  test("CountingSort should sort a list with repeated elements") {
    assert(CountingSort.countingSort(List(3, 5, 3, 2, 1, 4, 1)) == List(1, 1, 2, 3, 3, 4, 5))
  }

  test("CountingSort should sort a list with negative elements") {
    assert(CountingSort.countingSort(List(-3, -1, -2, -5, -4)) == List(-5, -4, -3, -2, -1))
  }

  test("CountingSort should sort a list with large numbers") {
    assert(CountingSort.countingSort(List(1000000, 999999, 1, 50, 500000)) == List(1, 50, 500000, 999999, 1000000))
  }
}

