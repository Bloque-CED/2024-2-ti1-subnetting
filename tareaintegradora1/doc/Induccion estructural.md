**CountingSort**

**Paso Base:**

Para el caso base, si la lista de entrada está vacía, la función
devuelve una lista vacía, ya que no hay elementos para ordenar.

**Hipótesis Inductiva:**

Supongamos que el algoritmo funciona correctamente para una lista de
tamaño n, es decir, para cualquier lista de longitud n, countingSort
devolverá una lista correctamente ordenada.

**Paso Inductivo:**

Ahora, consideremos una lista de longitud n+1. Según el algoritmo,
primero se construye un array de conteo usando countElements que cuenta
la frecuencia de cada valor. Ya hemos supuesto por la hipótesis
inductiva que countElements funciona correctamente para listas de
longitud n, por lo que el nuevo elemento (la cabeza de la lista)
simplemente se agrega al array de conteo en la posición correspondiente.
Luego, buildSortedList utiliza este array de conteo para reconstruir la
lista ordenada. Dado que los elementos restantes ya están ordenados por
la hipótesis inductiva, agregar un nuevo elemento y posicionarlo
correctamente en la lista mantendrá la lista ordenada.

**HeapSort**

**Paso Base:**

En el caso base, cuando la lista tiene 0 o 1 elementos, no hay nada que
ordenar, ya que una lista vacía o de un solo elemento está naturalmente
ordenada. El algoritmo simplemente devuelve la lista tal como está. Este
caso se maneja implícitamente en la recursión del algoritmo, ya que la
lista vacía se devolverá en la base de la recursión.

**Hipótesis Inductiva:**

Supongamos que el algoritmo heapsort funciona correctamente para una
lista de tamaño n, es decir, después de construir un MaxHeap y aplicar
el algoritmo de ordenamiento, la lista de tamaño n queda correctamente
ordenada.

**Paso Inductivo:**

Para una lista de tamaño n+1:

1.  **Construcción del MaxHeap:**

> Usamos buildMaxHeap, que invoca heapify de manera recursiva. Por la
> hipótesis inductiva, suponemos que la función heapify construye
> correctamente un MaxHeap para cualquier sublista de tamaño n.
>
> El proceso de maxHeapify se asegura de que el nuevo elemento insertado
> en la lista sea comparado con sus hijos, y si no cumple la propiedad
> del heap, se intercambia con el hijo mayor. Esto se repite hasta que
> se restaure la propiedad del MaxHeap.

2.  **Ordenamiento:**

> Una vez construido el MaxHeap, el algoritmo comienza a intercambiar el
> mayor elemento (raíz) con el último elemento de la lista. Después de
> cada intercambio, se reduce el tamaño del heap en uno, y se vuelve a
> aplicar maxHeapify para restaurar la propiedad del MaxHeap en la lista
> restante de tamaño n, que ya estaba correctamente ordenada por la
> hipótesis inductiva.
>
> Esto asegura que el nuevo elemento se coloque en la posición correcta
> y por lo tanto, la lista de tamaño n+1 está correctamente ordenada.

**RadixSort**

**Paso Base:**

El caso base de radixSort es cuando la lista está vacía, ya que no hay
elementos que ordenar.

**Hipótesis Inductiva:**

Supongamos que radixSort funciona correctamente para una lista de tamaño
n, es decir, el algoritmo ordena correctamente los n elementos aplicando
countingSortByDigit a cada posición decimal (unidad, decena, etc.).

**Paso Inductivo:**

Consideremos ahora una lista de tamaño n+1:

1.  **Conteo por dígitos:**

> La función countingSortByDigit se encarga de ordenar los elementos de
> la lista según su valor en una posición decimal específica (dígitos de
> derecha a izquierda). El proceso de agrupación en buckets se asegura
> de que los elementos se distribuyan correctamente en función del
> dígito actual.
>
> Por la hipótesis inductiva, asumimos que countingSortByDigit ordena
> correctamente cualquier lista de tamaño n en función de un dígito.
> Para una lista de tamaño n+1, el nuevo elemento simplemente se agrupa
> en el bucket correspondiente según su valor en el dígito actual, lo
> que preserva el orden de los n elementos restantes.

2.  **Ordenación por cada dígito:**

> La función sortAtDigit aplica countingSortByDigit a cada posición
> decimal, comenzando desde las unidades hasta el dígito más
> significativo. Esto asegura que, después de ordenar todos los dígitos,
> la lista completa esté en orden ascendente.
>
> Al procesar una lista de tamaño n+1, el nuevo elemento será colocado
> correctamente durante cada iteración de countingSortByDigit, lo que
> garantiza que la lista final esté correctamente ordenada, preservando
> el orden de los elementos ya ordenados por los dígitos menos
> significativos.
