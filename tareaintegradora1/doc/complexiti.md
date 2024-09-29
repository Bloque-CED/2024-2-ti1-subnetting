# Complejidad para HeapSort

1. Función comparable
   Complejidad: O(1)
   Operaciones: Una operación de comparación.
2. Función leftHeap
    Complejidad: O(1)
    Operaciones: Una operación de multiplicación y una de suma.
3. Función rightHeap
    Complejidad: O(1)
    Operaciones: Una operación de multiplicación y una de suma.
   4. Función swap
      if (index1 == index2) list
       Complejidad: O(1)
      val elem1 = list(index1)
      Complejidad: O(n)
      val elem2 = list(index2)
       Complejidad: O(n)
      list.updated(index1, elem2)
       Complejidad: O(n)
      .updated(index2, elem1)
       Complejidad: O(n)
      Complejidad total de swap: O(n)

   5. Función maxHeapify


 val leftIndex = leftHeap(list, index)
Complejidad de leftHeap: O(1)

 val rightIndex = rightHeap(list, index)
Complejidad de rightHeap: O(1)

 Determinación de largestIndex
Comparaciones y accesos:
Accesos a list(index), list(leftIndex), list(rightIndex)
Cada acceso es O(n) en List.
Número de accesos: Hasta 3

Total complejidad de accesos: O(n) * número de accesos = O(n)


Comparaciones con comparator:

Complejidad: O(1) por comparación.
Número de comparaciones: Hasta 3

 if (largestIndex != index)
Complejidad: O(1)

 Realiza un swap y llamada recursiva a maxHeapify
Complejidad de swap: O(n)

Llamada recursiva a maxHeapify:
Máximo número de llamadas recursivas: O(log n)

 else list
Complejidad: O(1)

Complejidad total de maxHeapify:

En el peor caso:

Número de llamadas recursivas: O(log n)
Operaciones por llamada:
Accesos a elementos: O(n)
Comparaciones: O(1)
Swap: O(n)
Complejidad por llamada: O(n)
Complejidad total: O(n log n)


 6. Función buildMaxHeap
     heapify((list.length / 2) - 1, list)
 Inicialización del índice: O(1)

   Función interna heapify:
Número de llamadas: O(n)
En cada llamada:
if (index < 0) currentList
Complejidad: O(1)

 else heapify(index - 1, maxHeapify(index, currentList, comparator))
Llama a maxHeapify:
Complejidad de maxHeapify: O(n log n) 

Complejidad total de buildMaxHeap:
Número de llamadas a maxHeapify: O(n)
Complejidad por llamada a maxHeapify: O(n log n)
Complejidad total: O(n * n log n) = O(n² log n)

7. Función sortHeap
   Función interna sort:
Número de llamadas: O(n)
En cada llamada:
 currentList match { ... }
Patrón de coincidencia: O(1)

 val swappedList = swap(currentList, 0, currentList.length - 1)
Complejidad de swap: O(n)

 val element = swappedList.last
Acceso al último elemento en una List: O(n)

 val reducedHeap = maxHeapify(0, swappedList.init, comparator)
Complejidad de maxHeapify: O(n log n)

 Llamada recursiva a sort
Complejidad: Depende de las operaciones anteriores.


Complejidad total de sortHeap:
Número de llamadas: O(n)
Complejidad por llamada: O(n log n)
(Debido a swap, acceso a last, y maxHeapify)
Complejidad total: O(n * n log n) = O(n² log n)

8. Función heapSort
   Complejidad de buildMaxHeap: O(n² log n)
   Complejidad de sortHeap: O(n² log n)
   Complejidad total: O(n² log n)

Complejidad total de HeapSort: O(n² log n)

# Complejidad para QuickSort

      







