fun main(parametro: Array<String>) {
    // Ingreso de fecha
    print("Ingrese día:")
    val dia = readLine()!!.toInt()
    print("Ingrese mes:")
    val mes = readLine()!!.toInt()
    print("Ingrese Año:")
    val año = readLine()!!.toInt()

    // Verifica si el mes es del primer trimestre
    if (mes == 1 || mes == 2 || mes == 3)
        print("Corresponde al primer trimestre")
}