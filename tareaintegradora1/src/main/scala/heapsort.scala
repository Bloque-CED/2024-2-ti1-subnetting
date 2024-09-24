import scala.annotation.tailrec

object HeapSort {

  // Método de HeapSort de alto orden que recibe una función de comparación como parámetro
  def heapsort(list: List[Int]): List[Int] = {
    val heapified = buildMaxHeap(list, comparable)
    sortHeap(heapified, comparable)
  }

  //
  def comparable(a: Int, b: Int): Boolean = a < b

  // Construye un MaxHeap usando la función de comparación
  def buildMaxHeap(list: List[Int], comparator: (Int, Int) => Boolean): List[Int] = {

    @tailrec
    def heapify(index: Int, currentList: List[Int]): List[Int] = {
      if (index < 0) currentList
      else heapify(index - 1, maxHeapify(index, currentList, comparator))
    }

    heapify((list.length / 2) - 1, list)
  }

  // Aplica MaxHeapify utilizando la función de comparación
  def maxHeapify(index: Int, list: List[Int], comparator: (Int, Int) => Boolean): List[Int] = {
    val leftIndex = leftHeap(list, index)
    val rightIndex = rightHeap(list, index)

    val largestIndex = (leftIndex < list.length, rightIndex < list.length) match {
      case (true, true) =>
        if (comparator(list(leftIndex), list(index)) && comparator(list(leftIndex), list(rightIndex))){
          leftIndex
        } else if (comparator(list(rightIndex), list(index))){
          rightIndex
        } else {
          index
        }

      case (true, false) =>
        if (comparator(list(leftIndex), list(index))){
          leftIndex
        } else {
          index
        }

      case (false, true) =>
        if (comparator(list(rightIndex), list(index))){
          rightIndex
        } else {
          index
        }

      case (false, false) => index
    }

    if (largestIndex != index) {
      swap(list, index, largestIndex) match {
        case swappedList => maxHeapify(largestIndex, swappedList, comparator)
      }
    } else {
      list
    }
  }

  // Intercambia dos elementos en la lista
  def swap(list: List[Int], index1: Int, index2: Int): List[Int] = {
    if (index1 == index2) list
    else {
      val elem1 = list(index1)
      val elem2 = list(index2)
      list.updated(index1, elem2).updated(index2, elem1)
    }
  }

  // Pasa del arbol a list nuevamente pero ya ordenado
  def sortHeap(list: List[Int], comparator: (Int, Int) => Boolean): List[Int] = {

    @tailrec
    def sort(currentList: List[Int], sortedList: List[Int]): List[Int] = {
      currentList match {
        case Nil => sortedList
        case _ =>
          val swappedList = swap(currentList, 0, currentList.length - 1)
          val element = swappedList.last
          val reducedHeap = maxHeapify(0, swappedList.init, comparator)

          sort(reducedHeap, element :: sortedList)
      }
    }

    sort(list, Nil)
  }

  def leftHeap(list: List[Int], index: Int): Int = {
    2 * index + 1
  }

  def rightHeap(list: List[Int], index: Int): Int = {
    2 * index + 2
  }
}