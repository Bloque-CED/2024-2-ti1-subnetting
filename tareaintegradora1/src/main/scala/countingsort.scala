import scala.annotation.tailrec

/**
 * Object that implements the CountingSort algorithm for sorting a list of integers.
 */
object CountingSort {

  /**
   * Sorts a list of non-negative integers using the CountingSort algorithm.
   *
   * @param list The list of integers to sort.
   * @return The sorted list of integers.
   */
  def countingsort(list: List[Int]): List[Int] = {
    if (list.isEmpty) list
    else {
      // Obtenemos el valor máximo de la lista solo dentro de esta función
      val maxElement = list.max
      val counts = buildCountArray(list, maxElement)
      reconstructSortedList(counts)
    }
  }

  /**
   * Builds the count array that stores the frequency of each element in the list.
   *
   * @param list The list of integers.
   * @param maxElement The maximum value in the list.
   * @return An array representing the frequency of each element.
   */
  def buildCountArray(list: List[Int], maxElement: Int): Array[Int] = {
    // Inicializar un array de conteo con el tamaño adecuado
    val counts = Array.fill(maxElement + 1)(0)

    // Llenar el array con las frecuencias de los elementos
    list.foreach { num => counts(num) += 1 }

    counts
  }

  /**
   * Reconstructs the sorted list from the count array.
   *
   * @param counts The count array.
   * @return The sorted list of integers.
   */
  def reconstructSortedList(counts: Array[Int]): List[Int] = {
    @tailrec
    def buildList(index: Int, acc: List[Int]): List[Int] = {
      if (index >= counts.length) acc
      else if (counts(index) > 0)
        buildList(index, acc ++ List.fill(counts(index))(index)) // Agregar ocurrencias del número
      else
        buildList(index + 1, acc) // Avanzar al siguiente índice
    }

    buildList(0, List())
  }
}

