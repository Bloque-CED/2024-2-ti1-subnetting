package test.scala

import munit.FunSuite
import CountingSort

class CountingSortTest extends FunSuite {
  test("CountingSort should sort an empty list") {
   val list = List()
   val sortedList = CountingSort.countingsort(list)
   assert(sortedList == List())
 }

 test("CountingSort should sort a list with one element") {
   val list = List(5)
   val sortedList = CountingSort.countingsort(list)
   assert(sortedList == List(5))
 }

 test("CountingSort should sort a sorted list") {
   val list = List(1, 2, 3, 4, 5)
   val sortedList = CountingSort.countingsort(list)
   assert(sortedList == List(1, 2, 3, 4, 5))
 }

 test("CountingSort should sort a reverse sorted list") {
   val list = List(5, 4, 3, 2, 1)
   val sortedList = CountingSort.countingsort(list)
   assert(sortedList == List(1, 2, 3, 4, 5))
 }

 test("CountingSort should sort a list with repeated elements") {
   val list = List(3, 5, 3, 2, 1, 4, 1)
   val sortedList = CountingSort.countingsort(list)
   assert(sortedList == List(1, 1, 2, 3, 3, 4, 5))
 }

 test("CountingSort should sort a list with negative elements") {
   val list = List(-3, -1, -2, -5, -4)
   val sortedList = CountingSort.countingsort(list)
   assert(sortedList == List(-5, -4, -3, -2, -1))
 }

 test("CountingSort should sort a list with large numbers") {
   val list = List(1000000, 999999, 1, 50, 500000)
   val sortedList = CountingSort.countingsort(list)
   assert(sortedList == List(1, 50, 500000, 999999, 1000000))
 }


}