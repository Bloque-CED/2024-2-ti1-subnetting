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


# Análisis de Complejidad del Counting Sort

## Estructura del Algoritmo

El Counting Sort implementado consta de las siguientes partes principales:

1. `countingSort`: Función principal que orquesta el proceso de ordenamiento.
2. `countElements`: Cuenta la frecuencia de cada elemento.
3. `buildSortedList`: Genera la lista ordenada a partir del array de conteo.


### 1. Encontrar el rango (dentro de countingSort)

Complejidad: O(n)
Esta fase requiere recorrer toda la lista una vez para encontrar el mínimo y el máximo.

### 2. Contar elementos (dentro de countElements)
Complejidad: O(n)
Se recorre la lista de entrada una vez, incrementando los contadores correspondientes.

### 3. Construir la lista ordenada (dentro de buildSortedList)
Complejidad: O(n + k), donde k es el rango de los elementos (max - min + 1)
Se recorre el array de conteo una vez, generando la lista ordenada.

## Complejidad Total
T(n) = O(n) + O(n) + O(n + k) = O(n + k)
Donde:
n es el número de elementos en la lista de entrada
k es el rango de los elementos (max - min + 1)

## Desarrollo de la Ecuación de Recurrencia

Aunque el Counting Sort no tiene una ecuación de recurrencia global tradicional como
T(n) = aT(n/b) + f(n), podemos analizar  la complejidad en sus componentes recursivos:

1. Para `countElements`:

   T(n) = T(n-1) + O(1)
   = [T(n-2) + O(1)] + O(1)
   = [T(n-3) + O(1)] + O(1) + O(1)
   ...
   = T(1) + (n-1) * O(1)
   = O(n)

   Esta ecuación se resuelve a O(n)

2. Para `buildSortedList`:

   T(k) = T(k-1) + O(n/k)
   = [T(k-2) + O(n/(k-1))] + O(n/k)
   = [T(k-3) + O(n/(k-2))] + O(n/(k-1)) + O(n/k)
   ...
   = T(1) + O(n/1) + O(n/2) + ... + O(n/k)
   = O(n * (1/1 + 1/2 + ... + 1/k))
   = O(n * log(k))
   ≈ O(n + k)  

   Donde k es el rango de los elementos 
y n/k es el número promedio de elementos por valor único.

3. Complejidad total:

   T(n) = O(n) + O(n) + O(n + k)
   = O(n + k)

   Donde:
    - El primer O(n) proviene de encontrar el rango (max y min)
    - El segundo O(n) proviene de contar los elementos
    - O(n + k) proviene de construir la lista ordenada

Por lo tanto, la complejidad total del Counting Sort es O(n + k),
donde n es el número de elementos y k es el rango de los valores.










