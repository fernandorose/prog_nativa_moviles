// Paso de funciones como parámetro para realizar operaciones

// Función de orden superior que recibe dos valores y una función
fun operar(v1: Int, v2: Int, fn: (Int, Int) -> Int) : Int {
    return fn(v1, v2)
}

// Funciones matemáticas básicas
fun sumar(x1: Int, x2: Int) = x1 + x2
fun restar(x1: Int, x2: Int) = x1 - x2
fun multiplicar(x1: Int, x2: Int) = x1 * x2
fun dividir(x1: Int, x2: Int) = x1 / x2

fun main(parametro: Array<String>) {
    val resu1 = operar(10, 5, ::sumar)
    println("La suma de 10 y 5 es $resu1")

    val resu2 = operar(5, 2, ::sumar)
    println("La suma de 5 y 2 es $resu2")

    println("La resta de 100 y 40 es ${operar(100, 40, ::restar)}")
    println("El producto entre 5 y 20 es ${operar(5, 20, ::multiplicar)}")
    println("La división entre 10 y 5 es ${operar(10, 5, ::dividir)}")
}
