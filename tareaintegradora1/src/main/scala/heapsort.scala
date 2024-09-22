import scala.annotation.tailrec


//TODO: ask about max-heap and min-heap

object HeapSort {

  // Método general de HeapSort que puede ordenar de manera ascendente o descendente
  def heapsort(list: List[Int], isMaxHeap: Boolean): List[Int] = {
    val heapified = buildHeap(list, isMaxHeap)
    sortHeap(heapified, isMaxHeap)
  }

  // Construye un heap (MaxHeap o MinHeap según "isMaxHeap")
  private def buildHeap(list: List[Int], isMaxHeap: Boolean): List[Int] = {
    @tailrec
    def heapify(index: Int, currentList: List[Int]): List[Int] = {
      index match {
        case index if index < 0 => currentList
        case index => heapify(index - 1, heapifyNode(index, currentList, isMaxHeap))
      }
    }

    //First in execute before the heapify method with @tailrec
    heapify((list.length / 2) - 1, list)
  }

  // Aplica MaxHeapify o MinHeapify dependiendo del valor de "isMaxHeap"
  //TODO: Check the logic
  private def heapifyNode(index: Int, list: List[Int], isMaxHeap: Boolean): List[Int] = {
    val leftIndex = 2 * index + 1
    val rightIndex = 2 * index + 2
    val size = list.length

    val chosenIndex = (leftIndex < size, rightIndex < size) match {
      case (true, true) =>
        if (isMaxHeap) {
          if (list(leftIndex) > list(index) && list(leftIndex) >= list(rightIndex)) leftIndex
          else if (list(rightIndex) > list(index)) rightIndex
          else index
        } else {
          if (list(leftIndex) < list(index) && list(leftIndex) <= list(rightIndex)) leftIndex
          else if (list(rightIndex) < list(index)) rightIndex
          else index
        }
      case (true, false) =>
        if (isMaxHeap) {
          if (list(leftIndex) > list(index)) leftIndex else index
        } else {
          if (list(leftIndex) < list(index)) leftIndex else index
        }
      case (false, true) =>
        if (isMaxHeap) {
          if (list(rightIndex) > list(index)) rightIndex else index
        } else {
          if (list(rightIndex) < list(index)) rightIndex else index
        }
      case (false, false) => index
    }

    if (chosenIndex != index) {
      swap(list, index, chosenIndex) match {
        case swappedList => heapifyNode(chosenIndex, swappedList, isMaxHeap)
      }
    } else {
      list
    }
  }

  // Intercambia dos elementos en la lista
  //TODO: ask about pattern matching here
  private def swap(list: List[Int], index1: Int, index2: Int): List[Int] = {
    if (index1 == index2) list
    else {
      val elem1 = list(index1)
      val elem2 = list(index2)
      list.updated(index1, elem2).updated(index2, elem1)
    }
  }

  // Ordena el heap extraído
  private def sortHeap(list: List[Int], isMaxHeap: Boolean): List[Int] = {
    @tailrec
    def sort(currentList: List[Int], sortedList: List[Int]): List[Int] = {
      currentList match {
        case Nil => sortedList
        case _ =>
          val swappedList = swap(currentList, 0, currentList.length - 1)
          val element = swappedList.last
          val reducedHeap = heapifyNode(0, swappedList.init, isMaxHeap)

          sort(reducedHeap, element :: sortedList)
      }
    }

    sort(list, Nil)
  }
}
