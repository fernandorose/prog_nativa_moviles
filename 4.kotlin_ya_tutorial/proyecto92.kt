// Muestra un título subrayado con un carácter especificado
fun tituloSubrayado(titulo: String, caracter: String = "*") {
    println(titulo)
    for(i in 1..titulo.length)
        print(caracter)
    println()
}

// Función principal que llama a la función con distintos parámetros
fun main(parametro: Array<String>) {
    tituloSubrayado("Sistema de Administracion")
    tituloSubrayado("Ventas", "-")
}
