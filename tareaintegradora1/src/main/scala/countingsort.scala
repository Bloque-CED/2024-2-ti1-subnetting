object CountingSort {
  
  def countingSort(list: List[Int]): List[Int] = {
    if (list.isEmpty) list
    else {
      val max = list.max
      val min = list.min
      val countArray = Array.fill(max - min + 1)(0)

      // Contar la frecuencia de cada elemento
      @tailrec
      def countElements(remaining: List[Int], counts: Array[Int]): Array[Int] = {
        remaining match {
          case Nil => counts
          case head :: tail =>
            counts(head - min) += 1
            countElements(tail, counts)
        }
      }

      // Generar la lista ordenada a partir del array de conteo
      @tailrec
      def buildSortedList(counts: Array[Int], currentIndex: Int, sortedList: List[Int]): List[Int] = {
        if (currentIndex >= counts.length) sortedList
        else {
          val updatedList = List.fill(counts(currentIndex))(currentIndex + min) ::: sortedList
          buildSortedList(counts, currentIndex + 1, updatedList)
        }
      }

      val filledCounts = countElements(list, countArray)
      buildSortedList(filledCounts, 0, Nil).reverse
    }
  }
}
