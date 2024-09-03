# Diseño de Pruebas

## Objetivos de las Pruebas

Las pruebas están diseñadas para cumplir los siguientes objetivos:

1. **Verificar la Correctitud:** Asegurarse de que los algoritmos implementados (`CountingSort`, `HeapSort`, `RadixSort`) ordenen correctamente una lista de enteros en una variedad de casos.
2. **Cobertura de Casos Específicos:** Las pruebas cubrirán casos específicos, incluyendo listas vacías, listas con un solo elemento, listas ya ordenadas, listas en orden inverso, listas con elementos repetidos, listas con números negativos (cuando corresponda), y listas con números grandes.
3. **Validar la Robustez:** Evaluar la capacidad de los algoritmos para manejar entradas no triviales sin fallar ni producir resultados incorrectos.

## Casos de Prueba

Inicialmente se van a tomar casos donde la lista provenga de las siguientes formas: 
- Lista vacía
- Lista con un solo elemento
- Lista ya ordenada
- Lista en orden inverso
- Lista con elementos repetidos
- Lista con objetos mayores a 32 bits (Long)

### Pruebas para HeapSort

| Nombre de Test Case                                  | Clase     | Método  | Descripción                                                                                     | Setup                               | Entrada                                                          | Salida esperada                                              |
|------------------------------------------------------|-----------|---------|-------------------------------------------------------------------------------------------------|-------------------------------------|-----------------------------------------------------------------|-------------------------------------------------------------|
| HeapSort should sort an empty list                   | HeapSort  | heapSort | Verifica que `heapSort` permita el ordenamiento de una lista vacía                               | val heap = new HeapSort()           | heapSort(List())                                                 | List()                                                      |
| HeapSort should sort a list with one element         | HeapSort  | heapSort | Verifica que `heapSort` ordene correctamente una lista con un solo elemento                     | val heap = new HeapSort()           | heapSort(List(5))                                                | List(5)                                                     |
| HeapSort should sort a sorted list                   | HeapSort  | heapSort | Verifica que `heapSort` mantenga el orden de una lista ya ordenada                              | val heap = new HeapSort()           | heapSort(List(1, 2, 3, 4, 5))                                    | List(1, 2, 3, 4, 5)                                         |
| HeapSort should sort a reverse sorted list           | HeapSort  | heapSort | Verifica que `heapSort` ordene correctamente una lista en orden inverso                         | val heap = new HeapSort()           | heapSort(List(5, 4, 3, 2, 1))                                    | List(1, 2, 3, 4, 5)                                         |
| HeapSort should sort a list with repeated elements   | HeapSort  | heapSort | Verifica que `heapSort` ordene correctamente una lista con elementos repetidos                  | val heap = new HeapSort()           | heapSort(List(3, 5, 3, 2, 1, 4, 1))                              | List(1, 1, 2, 3, 3, 4, 5)                                   |
| HeapSort should sort a list with negative numbers    | HeapSort  | heapSort | Verifica que `heapSort` ordene correctamente una lista que contiene números negativos           | val heap = new HeapSort()           | heapSort(List(-3, -1, -2, -5, -4))                               | List(-5, -4, -3, -2, -1)                                    |
| HeapSort should sort a list with large numbers       | HeapSort  | heapSort | Verifica que `heapSort` maneje correctamente listas con números grandes                         | val heap = new HeapSort()           | heapSort(List(1000000, 999999, 1, 50, 500000))                   | List(1, 50, 500000, 999999, 1000000)                        |

### Pruebas para CountingSort

| Nombre de Test Case                                  | Clase        | Método       | Descripción                                                                                     | Setup                               | Entrada                                                          | Salida esperada                                              |
|------------------------------------------------------|--------------|--------------|-------------------------------------------------------------------------------------------------|-------------------------------------|-----------------------------------------------------------------|-------------------------------------------------------------|
| CountingSort should sort an empty list               | CountingSort | countingSort | Verifica que `countingSort` permita el ordenamiento de una lista vacía                          | val counting = new CountingSort()   | countingSort(List())                                             | List()                                                      |
| CountingSort should sort a list with one element     | CountingSort | countingSort | Verifica que `countingSort` ordene correctamente una lista con un solo elemento                | val counting = new CountingSort()   | countingSort(List(5))                                            | List(5)                                                     |
| CountingSort should sort a sorted list               | CountingSort | countingSort | Verifica que `countingSort` mantenga el orden de una lista ya ordenada                         | val counting = new CountingSort()   | countingSort(List(1, 2, 3, 4, 5))                               | List(1, 2, 3, 4, 5)                                         |
| CountingSort should sort a reverse sorted list       | CountingSort | countingSort | Verifica que `countingSort` ordene correctamente una lista en orden inverso                    | val counting = new CountingSort()   | countingSort(List(5, 4, 3, 2, 1))                               | List(1, 2, 3, 4, 5)                                         |
| CountingSort should sort a list with repeated elements | CountingSort | countingSort | Verifica que `countingSort` ordene correctamente una lista con elementos repetidos             | val counting = new CountingSort()   | countingSort(List(3, 5, 3, 2, 1, 4, 1))                         | List(1, 1, 2, 3, 3, 4, 5)                                   |
| CountingSort should sort a list with large numbers   | CountingSort | countingSort | Verifica que `countingSort` maneje correctamente listas con números grandes                    | val counting = new CountingSort()   | countingSort(List(1000000, 999999, 1, 50, 500000))              | List(1, 50, 500000, 999999, 1000000)                        |

### Pruebas para RadixSort

| Nombre de Test Case                                  | Clase     | Método    | Descripción                                                                                     | Setup                               | Entrada                                                          | Salida esperada                                              |
|------------------------------------------------------|-----------|-----------|-------------------------------------------------------------------------------------------------|-------------------------------------|-----------------------------------------------------------------|-------------------------------------------------------------|
| RadixSort should sort an empty list                  | RadixSort | radixSort | Verifica que `radixSort` permita el ordenamiento de una lista vacía                             | val radix = new RadixSort()         | radixSort(List())                                                | List()                                                      |
| RadixSort should sort a list with one element        | RadixSort | radixSort | Verifica que `radixSort` ordene correctamente una lista con un solo elemento                   | val radix = new RadixSort()         | radixSort(List(5))                                               | List(5)                                                     |
| RadixSort should sort a sorted list                  | RadixSort | radixSort | Verifica que `radixSort` mantenga el orden de una lista ya ordenada                            | val radix = new RadixSort()         | radixSort(List(1, 2, 3, 4, 5))                                  | List(1, 2, 3, 4, 5)                                         |
| RadixSort should sort a reverse sorted list          | RadixSort | radixSort | Verifica que `radixSort` ordene correctamente una lista en orden inverso                       | val radix = new RadixSort()         | radixSort(List(5, 4, 3, 2, 1))                                  | List(1, 2, 3, 4, 5)                                         |
| RadixSort should sort a list with repeated elements  | RadixSort | radixSort | Verifica que `radixSort` ordene correctamente una lista con elementos repetidos                | val radix = new RadixSort()         | radixSort(List(3, 5, 3, 2, 1, 4, 1))                            | List(1, 1, 2, 3, 3, 4, 5)                                   |
| RadixSort should sort a list with large numbers      | RadixSort | radixSort | Verifica que `radixSort` maneje correctamente listas con números grandes                       | val radix = new RadixSort()         | radixSort(List(1000000, 999999, 1, 50, 500000))                 | List(1, 50, 500000, 999999, 1000000)                        |

## Implementación de las Pruebas

Las pruebas se implementarán usando el framework ScalaTest. Cada caso de prueba se corresponderá con una función de prueba dentro de un archivo de prueba correspondiente a cada algoritmo (`CountingSortTest.scala`, `HeapSortTest.scala`, `RadixSortTest.scala`). 

Cada función de prueba seguirá la estructura de:

1. **Definir la entrada de la prueba.**
2. **Invocar el algoritmo correspondiente.**
3. **Comparar la salida del algoritmo con la salida esperada.**
4. **Generar un `assert` para validar la igualdad entre la salida esperada y la obtenida.**

## Cobertura

Las pruebas cubrirán los algoritmos de `CountingSort`, `HeapSort` y `RadixSort`, asegurando que todas las funciones implementadas en el proyecto son robustas y funcionan correctamente bajo las condiciones especificadas.

## Resultados Esperados

El éxito de estas pruebas será una confirmación de que los algoritmos de ordenamiento cumplen con las especificaciones y manejan correctamente una variedad de escenarios. Cualquier fallo en estas pruebas indicará un problema en la implementación que deberá ser corregido antes de la entrega final del proyecto.
