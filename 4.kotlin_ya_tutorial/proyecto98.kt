// Carga e imprime un arreglo de sueldos
fun main(parametro: Array<String>) {
    val sueldos: IntArray
    sueldos = IntArray(5)
    // Carga de sus elementos por teclado
    for(i in 0..4) {
        print("Ingrese sueldo:")
        sueldos[i] = readLine()!!.toInt()
    }
    // Impresión de sus elementos
    for(i in 0..4) {
        println(sueldos[i])
    }
}
