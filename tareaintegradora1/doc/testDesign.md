# Diseño de Pruebas

## Objetivos de las Pruebas

Las pruebas están diseñadas para cumplir los siguientes objetivos:

1. **Verificar la Correctitud:** Asegurarse de que los algoritmos implementados (`CountingSort`, `HeapSort`, `RadixSort`) ordenen correctamente una lista de enteros en una variedad de casos.
2. **Cobertura de Casos Específicos:** Las pruebas cubrirán casos específicos, incluyendo listas vacías, listas con un solo elemento, listas ya ordenadas, listas en orden inverso, listas con elementos repetidos, listas con números negativos (cuando corresponda), y listas con números grandes.
3. **Validar la Robustez:** Evaluar la capacidad de los algoritmos para manejar entradas no triviales sin fallar ni producir resultados incorrectos.

## Casos de Prueba

Inicialmente se van a tomar casos donde la lista provenga de las siguientes formas: 
- Lista vacia
- Lista con un solo elemento
- Lista ya ordenada
- Lista en orden inverso
- Lista con elementos repetidos
- Lista con objetos mayores a 32 bits (Long)

### Pruebas para Heap Sort

| Nombre de Test Case | Clase | Metodo | Descripcion | Setup | Entrada | Salida esperada|
|---------------------|-------|--------|-------------|-------|---------|----------------|
|HeapSort should sort an empty list| HeapSort | heapSort | Verifica que <span style="color: green;">heapSort</span> permita el ordenamiento de una lista vacia | val controller = new Controller() | heapSort(<span style="color: yellow;">List()</span>) | List() |
|HeapSort should sort a list with one element| HeapSort | heapSort | Verifica que <span style="color: green;">heapSort</span> permita el ordenamiento de una lista con un solo elemento y no retorne ningun error por contener un unico objeto | val controller = new Controller() <br> val heap = new HeapSort() | heapSort(<span style="color: yellow;">List(New Object())</span>) | List(New Object()) | HeapSort should sort a sorted list | HeapSort | heapSort | Verifica que <span style="color: green;">heapSort</span> soporte el ordenamiento de una lista ya ordenada | val controller = new Controller() val heap = new HeapSort() | heapSort(<span style="color: yellow;">List(Object_1, Object_2, Object_3, Object_4,...,Object_n)</span>) | List(Object_1, Object_2, Object_3, Object_4,...,Object_n) | 





- **Descripción:** Verifica que el algoritmo maneja correctamente una lista vacía.
- **Entrada:** `List()`
- **Salida Esperada:** `List()`
- **Aplicable a:** `CountingSort`, `HeapSort`, `RadixSort`

### 2. Lista con un Solo Elemento

- **Descripción:** Verifica que el algoritmo no modifique una lista que contiene un solo elemento.
- **Entrada:** `List(5)`
- **Salida Esperada:** `List(5)`
- **Aplicable a:** `CountingSort`, `HeapSort`, `RadixSort`

### 3. Lista ya Ordenada

- **Descripción:** Verifica que el algoritmo no altere una lista que ya está en orden ascendente.
- **Entrada:** `List(1, 2, 3, 4, 5)`
- **Salida Esperada:** `List(1, 2, 3, 4, 5)`
- **Aplicable a:** `CountingSort`, `HeapSort`, `RadixSort`

### 4. Lista en Orden Inverso

- **Descripción:** Verifica que el algoritmo ordene correctamente una lista que está en orden descendente.
- **Entrada:** `List(5, 4, 3, 2, 1)`
- **Salida Esperada:** `List(1, 2, 3, 4, 5)`
- **Aplicable a:** `CountingSort`, `HeapSort`, `RadixSort`

### 5. Lista con Elementos Repetidos

- **Descripción:** Verifica que el algoritmo maneje correctamente una lista con elementos duplicados.
- **Entrada:** `List(3, 5, 3, 2, 1, 4, 1)`
- **Salida Esperada:** `List(1, 1, 2, 3, 3, 4, 5)`
- **Aplicable a:** `CountingSort`, `HeapSort`, `RadixSort`

### 6. Lista con Números Negativos

- **Descripción:** Verifica que el algoritmo maneje correctamente listas que contienen números negativos.
- **Entrada:** `List(-3, -1, -2, -5, -4)`
- **Salida Esperada:** `List(-5, -4, -3, -2, -1)`
- **Aplicable a:** `HeapSort`, `RadixSort` (si se adapta el algoritmo para manejar números negativos)

### 7. Lista con Números Grandes

- **Descripción:** Verifica que el algoritmo maneje correctamente listas con números grandes.
- **Entrada:** `List(1000000, 999999, 1, 50, 500000)`
- **Salida Esperada:** `List(1, 50, 500000, 999999, 1000000)`
- **Aplicable a:** `CountingSort`, `HeapSort`, `RadixSort`

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

