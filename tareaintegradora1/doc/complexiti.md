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


 # Complejidad para CountingSort

1. Función buildCountArray

    val counts = Array.fill(maxElement + 1)(0)
Complejidad: O(k)
Operación: Asignación de memoria y llenado del array.

 list.foreach { num => counts(num) += 1 }
Complejidad: O(n)
Operación: Para cada elemento, acceso y actualización en el array counts (O(1) cada uno).

 counts
Complejidad: O(1)
Operación: Devolución de la referencia al array.

Complejidad total de buildCountArray:
Complejidad: O(n + k)
Donde:
n es el número de elementos en la lista list.
k es el rango de valores posibles (el valor máximo en list más uno).


2. Función reconstructSortedList
   Define la función recursiva buildList(index: Int, acc: List[Int]): List[Int]
Complejidad: Depende de las llamadas recursivas.
Operación: Definición de la función interna.

 if (index >= counts.length) acc
Complejidad: O(1)
Operación: Comparación y retorno.

 else if (counts(index) > 0)
Complejidad: O(1)
Operación: Acceso al array counts y comparación.

 buildList(index + 1, List.fill(counts(index))(index) ++ acc)
Complejidad de List.fill(counts(index))(index): O(m)
Donde: m = counts(index)
Operación: Generación de una lista con elementos repetidos.
Complejidad de List.fill(...)(...) ++ acc: O(m)
Operación: Concatenación de dos listas.
Complejidad total de esta rama: O(m + m) = O(2m) = O(m)

 buildList(index + 1, acc)
Complejidad: O(1)
Operación: Incremento del índice y llamada recursiva.

Recursión:
Número de llamadas recursivas: k, donde k = counts.length
Complejidad total de la función recursiva:
La suma de todas las operaciones O(m) en las posiciones donde counts(index) > 0.
La suma total de m es igual a n, el número total de elementos en la lista original.

 buildList(0, List()).reverse
Complejidad de reverse: O(n)
Operación: Recorrido de la lista para invertirla.


Complejidad total de reconstructSortedList:
Complejidad: O(n + k)
Las operaciones en total suman O(n) debido a las posiciones donde counts(index) > 0.
Se agrega O(k) por el número de llamadas recursivas.
La operación reverse agrega O(n).


3. Función countingsort

    if (list.exists(_ < 0))
Complejidad: O(n)
Operación: Evaluación de la condición para cada elemento.

Lanzamiento de excepción si hay elementos negativos.
Complejidad: O(1)
Operación: Lanzamiento de excepción (no afecta la complejidad general si se asume que la lista es válida).

 if (list.isEmpty) list
Complejidad: O(1)
Operación: Comprobación y retorno.

 val maxElement = list.max
Complejidad: O(n)
Operación: Recorrido completo de la lista.

 val counts = buildCountArray(list, maxElement)
Complejidad: O(n + k)

reconstructSortedList(counts)
Complejidad: O(n + k)

Complejidad total de countingsort:
Suma de las operaciones:
Verificación de elementos negativos: O(n)
Verificación de lista vacía: O(1)
Encontrar el elemento máximo: O(n)
Construcción del array de conteo: O(n + k)
Reconstrucción de la lista ordenada: O(n + k)

Complejidad total:
O(n + k)

# Complejidad para RadixSort

1.Función getDigit
 (num / math.pow(10, index).toInt) % 10
Operaciones:
math.pow(10, index).toInt: 
Complejidad: O(1)
num / ...
Complejidad: O(1)
% 10
Complejidad: O(1)
Total complejidad de la función: O(1)
Conclusión de getDigit:
Complejidad: O(1)


2. Función countDigits
    if (num == 0 && acc > 0) acc
Complejidad: O(1)

 else countDigits(num / 10, acc + 1)
Complejidad: O(1)

Llamada recursiva con num reducido y acc incrementado.
Recursión:
Número de llamadas recursivas
Si d es el número de dígitos de num, entonces hay d llamadas recursivas.

Complejidad total de countDigits:
Complejidad: O(d)
Donde: d es el número de dígitos de num.
Operaciones en cada llamada: O(1)
Total: O(d * 1) = O(d)


3. Función flattenBuckets

buckets.flatten.toList
Operaciones:
buckets.flatten 
Complejidad: O(n)
Donde: n es el número total de elementos en todas las listas dentro de buckets.
.toList
Complejidad: O(n)
Total complejidad de la función: O(n)

Conclusión de flattenBuckets:
Complejidad: O(n)

4. Función fillBuckets

numbers.foreach { ... }
Complejidad: O(n)

Operaciones dentro del foreach:
 val digitValue = getDigit(num, index)
Complejidad de getDigit: O(1)

 buckets(digitValue) = num :: buckets(digitValue)
Operaciones:
buckets(digitValue)
Complejidad: O(1)
num :: buckets(digitValue)
Complejidad: O(1)
Asignación al array buckets.
Complejidad: O(1)
buckets
Complejidad: O(1)

Complejidad total de fillBuckets:
Complejidad: O(n)
Donde: n es el número de elementos en numbers.
Operaciones por elemento: O(1)
Total: O(n * 1) = O(n)

5. Función sortByDigit

if (digit == 0) list
Complejidad: O(1)
 Creación de emptyBuckets
Complejidad: O(1)
Operaciones: Asignaciones y creación de listas vacías.
 val filledBuckets = fillBuckets(list, emptyBuckets, digit - 1)
Complejidad de fillBuckets: O(n)
 sortByDigit(flattenBuckets(filledBuckets), digit - 1)
Complejidad de flattenBuckets: O(n)

Llamada recursiva a sortByDigit
Recursión:
Número de llamadas recursivas: d, donde d es el número máximo de dígitos en los números de la lista.
Complejidad por llamada:

Operaciones por llamada:
Creación de emptyBuckets: O(1)
Llamada a fillBuckets: O(n)
Llamada a flattenBuckets: O(n)
Total por llamada: O(n) + O(n) = O(n)
Complejidad total de sortByDigit:

Total: Número de llamadas * Complejidad por llamada
Complejidad: O(d * n)
Donde:
d es el número de dígitos máximos.
n es el número de elementos en la lista.

6. Función radixsort

if (list.isEmpty) list
Complejidad: O(1)

 val maxNum = list.max
Complejidad: O(n)
Operación: Recorre la lista una vez.

 val maxDigits = countDigits(maxNum)
Complejidad de countDigits: O(d)
Donde: d es el número de dígitos de maxNum.

 sortByDigit(list, maxDigits)
Complejidad de sortByDigit: O(d * n)


Complejidad total de radixsort:

Suma de las operaciones:
Verificación de lista vacía: O(1)
Encontrar maxNum: O(n)
Calcular maxDigits: O(d)
Llamada a sortByDigit: O(d * n)
Complejidad total:
O(n) + O(d) + O(d * n)
Como O(n) y O(d) son menores que O(d * n), la complejidad total es O(d * n)












