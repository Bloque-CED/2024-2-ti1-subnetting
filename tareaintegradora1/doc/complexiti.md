# Complejidad para HeapSort

El HeapSort implementado consta de las siguientes partes principales:

1. `heapsort`: Función principal que orquesta el proceso de ordenamiento.
2. `buildMaxHeap`: Construye el heap máximo inicial.
3. `maxHeapify`: Mantiene la propiedad de heap máximo.
4. `sortHeap`: Extrae repetidamente el elemento máximo y reordena el heap.

### 1. Construcción del Heap (buildMaxHeap)
Complejidad: O(n)
Aunque parece que debería ser O(n log n) debido a las n/2 llamadas a maxHeapify,
cada una con complejidad O(log n), en realidad es más eficiente. 
Esto se debe a que la mayoría de los nodos están en la parte inferior del árbol 
y requieren poco o ningún trabajo. Por lo tanto, la complejidad es O(n).

### 2. Mantenimiento del Heap (maxHeapify)
Complejidad: O(log n)
Esta función mantiene la propiedad de heap máximo.
En el peor caso, un elemento puede "hundirse" desde la raíz hasta una hoja, 
lo que implica una altura de log n.

### 3. Ordenamiento del Heap (sortHeap)
Complejidad: O(n log n)
Esta función realiza n extracciones,
cada una seguida de un maxHeapify. 
Cada extracción es O(1) y cada maxHeapify es O(log n), 
resultando en una complejidad total de O(n log n).

## Ecuación de Recurrencia

La relación de recurrencia para el tiempo de ejecución T(n) del algoritmo HeapSort puede expresarse como:

T(n) = T(n-1) + O(log n)

Donde:
- T(n-1) representa la llamada recursiva para ordenar el heap reducido.
- O(log n) representa la complejidad de maxHeapify en cada iteración.

## Desarrollo de la Ecuación de Recurrencia

Expandiendo la ecuación:

T(n) = T(n-1) + O(log n)
= [T(n-2) + O(log(n-1))] + O(log n)
= [T(n-3) + O(log(n-2))] + O(log(n-1)) + O(log n)
...
= T(1) + O(log 2) + O(log 3) + ... + O(log(n-1)) + O(log n)
= O(1) + O(log 2 + log 3 + ... + log(n-1) + log n)
= O(log(n!))

Utilizando la aproximación de Stirling para n!, sabemos que:

log(n!) ≈ n log n - n + O(log n)

Por lo tanto:

T(n) ≈ O(n log n)

Esta expansión demuestra que la complejidad temporal del HeapSort es O(n log n).







