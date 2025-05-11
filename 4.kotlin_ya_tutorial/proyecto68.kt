fun main(parametro: Array<String>) {
    var cant1 = 0
    var cant2 = 0

    // Cuenta cuántos valores son 0 y cuántos son 1, 5 o 10
    for(i in 1..10) {
        print("Ingrese un valor entero:")
        val valor = readLine()!!.toInt()
        when (valor) {
            0 -> cant1++
            1, 5, 10 -> cant2++
        }
    }

    println("Cantidad de números 0 ingresados: $cant1")
    println("Cantidad de números 1, 5 o 10 ingresados: $cant2")
}