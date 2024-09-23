object RadixSort {
  
  def radixSort(list: List[Int]): List[Int] = {
    if (list.isEmpty) list
    else {
      val max = list.max
      val digits = max.toString.length

      // Aplicar countingSort a cada posición decimal (unidad, decena, centena, etc.)
      @tailrec
      def sortAtDigit(remainingDigit: Int, currentList: List[Int]): List[Int] = {
        if (remainingDigit >= digits) currentList
        else {
          val sortedAtDigit = countingSortByDigit(currentList, remainingDigit)
          sortAtDigit(remainingDigit + 1, sortedAtDigit)
        }
      }

      sortAtDigit(0, list)
    }
  }

  private def countingSortByDigit(list: List[Int], digit: Int): List[Int] = {
    val radix = 10
    val buckets = Array.fill(radix)(List.empty[Int])

    // Contar la frecuencia de cada dígito en la posición actual
    @tailrec
    def distributeToBuckets(remaining: List[Int], buckets: Array[List[Int]]): Array[List[Int]] = {
      remaining match {
        case Nil => buckets
        case head :: tail =>
          val digitValue = (head / math.pow(10, digit).toInt) % radix
          buckets(digitValue) = head :: buckets(digitValue)
          distributeToBuckets(tail, buckets)
      }
    }

    // Recoger los valores ordenados
    @tailrec
    def collectFromBuckets(buckets: Array[List[Int]], currentIndex: Int, sortedList: List[Int]): List[Int] = {
      if (currentIndex >= buckets.length) sortedList
      else {
        val updatedList = buckets(currentIndex).reverse ::: sortedList
        collectFromBuckets(buckets, currentIndex + 1, updatedList)
      }
    }

    val filledBuckets = distributeToBuckets(list, buckets)
    collectFromBuckets(filledBuckets, 0, Nil).reverse
  }
}
