fun main(parametro: Array<String>) {
    // Solicita al usuario la medida del lado del cuadrado
    print("Ingrese la medida del lado del cuadrado:")
    val lado = readLine()!!.toInt()

    // Calcula el perímetro
    val perimetro = lado * 4
    println("El perímetro del cuadrado es $perimetro")
}