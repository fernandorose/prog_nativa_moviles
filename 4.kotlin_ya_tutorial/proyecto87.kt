// Convierte números del 1 al 5 a su representación en texto
fun convertirCastelano(valor: Int) = when (valor) {
    1 -> "uno"
    2 -> "dos"
    3 -> "tres"
    4 -> "cuatro"
    5 -> "cinco"
    else -> "error"
}

// Función principal que imprime del 1 al 6 en texto
fun main(parametro: Array<String>) {
    for(i in 1..6)
        println(convertirCastelano(i))
}
