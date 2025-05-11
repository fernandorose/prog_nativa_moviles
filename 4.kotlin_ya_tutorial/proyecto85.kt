// Retorna la superficie de un cuadrado (versión simplificada)
fun retornarSuperficie(lado: Int) = lado * lado

// Función principal
fun main(parametro: Array<String>) {
    print("Ingrese el valor del lado del cuafrado:")
    val la = readLine()!!.toInt()
    println("La superficie del cuadrado es ${retornarSuperficie(la)}")
}
