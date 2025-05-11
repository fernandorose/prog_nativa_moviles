// ===== Capítulo 1: Empezando con Kotlin =====

// Ejemplo Hola Mundo
fun main(args: Array<String>) {
    println("Hello, world!")
}

// Hola mundo usando una declaración de objeto
object App {
    @JvmStatic fun main(args: Array<String>) {
        println("Hello World!")
    }
}

// Hola mundo usando un objeto compañero
class App {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            println("Hello World!")
        }
    }
}

// Lectura de entrada desde la línea de comandos
fun main(args: Array<String>) {
    println("Enter two numbers")
    val (a, b) = readLine()!!.split(' ')
    println("Max number is: ${maxNum(a.toInt(), b.toInt())}")
}

fun maxNum(a: Int, b: Int): Int {
    return if (a > b) a else b
}

// ===== Capítulo 2: Advertencias de Kotlin =====

// Llamando a toString() en un tipo anulable
fun example(view: View) {
    val text1 = view.textField?.text.toString() ?: "" // Incorrecto
    val text2 = view.textField?.text?.toString() ?: "" // Correcto
}

// ===== Capítulo 3: Anotaciones =====

// Declarar una anotación
annotation class Strippable

// Meta-anotaciones
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class Fancy

// ===== Capítulo 4: Arrays =====

// Arreglos Genéricos
val empty = emptyArray<String>()
val strings = Array<String>(5) { i -> "Item #$i" }
strings[2] = "ChangedItem"

// Arreglos de primitivos
val intArray = intArrayOf(1, 2, 3)
val doubleArray = doubleArrayOf(1.2, 5.0)

// Iterar Array
val asc = Array(5) { i -> (i * i).toString() }
for (s in asc) {
    println(s)
}

// ===== Capítulo 5: Bucles en Kotlin =====

// Repetir una acción x veces
repeat(10) { i ->
    println("Loop iteration ${i + 1}")
}

// Bucle sobre iterables
val list = listOf("Hello", "World", "!")
for (str in list) {
    print(str)
}

// Iterando sobre un mapa
val map = mapOf(1 to "foo", 2 to "bar", 3 to "baz")
for ((key, value) in map) {
    println("Map[$key] = $value")
}

// ===== Capítulo 6: Colecciones =====

// Usando la lista
val list = listOf("Item 1", "Item 2", "Item 3")
println(list)

// Usando el mapa
val map = mapOf(1 to "Item 1", 2 to "Item 2", 3 to "Item 3")
println(map)

// ===== Capítulo 7: Configurando la compilación de Kotlin =====
// (Ejemplos de configuración Gradle - no aplicable en un archivo .kt)

// ===== Capítulo 8: Coroutines =====
/*
import kotlinx.coroutines.*

fun main() = runBlocking {
    launch {
        delay(1000L)
        println("World!")
    }
    println("Hello,")
}
*/
// Nota: Requiere dependencia kotlinx-coroutines-core

// ===== Capítulo 11: Edificio DSL (Profundización) =====
class Person {
    var name: String = ""
    var age: Int = 0
}

fun person(block: Person.() -> Unit): Person {
    return Person().apply(block)
}

val p = person {
    name = "Ana"
    age = 30
}

// ===== Capítulo 9: Declaraciones condicionales =====

// Declaración if estándar
val str = "Hello!"
if (str.length == 0) {
    print("Empty string!")
} else if (str.length > 5) {
    print("Long string!")
} else {
    print("Short string!")
}

// When-statement
when {
    str.length == 0 -> print("Empty string!")
    str.length > 5 -> print("Long string!")
    else -> print("Short string!")
}

// ===== Capítulo 10: Delegación de clase =====
interface Foo {
    fun example()
}

class Bar {
    fun example() {
        println("Hello, world!")
    }
}

class Baz(b: Bar) : Foo by b

// ===== Capítulo 11: Edificio DSL (Profundización) =====
class Person {
    var name: String = ""
    var age: Int = 0
}

fun person(block: Person.() -> Unit): Person {
    return Person().apply(block)
}

val p = person {
    name = "Ana"
    age = 30
}

// ===== Capítulo 12: Enumerar =====
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

// ===== Capítulo 13: Equivalentes de flujo de Java 8 =====

// Filtrar una lista
val numbers = listOf(1, 2, 3, 4, 5, 6)
val even = numbers.filter { it % 2 == 0 }

// Convertir elementos y concatenarlos
val things = listOf(1, 2, 3)
val joined = things.joinToString(", ")

// ===== Capítulo 14: Excepciones =====
fun example() {
    try {
        // código que puede lanzar excepción
    } catch (e: Exception) {
        println("Error: ${e.message}")
    } finally {
        println("Cleanup")
    }
}

// ===== Capítulo 15: Extensiones Kotlin para Android (Completo) =====
/*
// En un Activity:
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        textView.text = "Hola Kotlin" // Acceso directo a vistas
        button.setOnClickListener { 
            Toast.makeText(this, "Click!", Toast.LENGTH_SHORT).show()
        }
    }
}
*/

// ===== Capítulo 16: Funciones =====

// Función básica
fun sayMyName(name: String): String {
    return "Your name is $name"
}

// Función abreviada
fun sayMyNameShort(name: String) = "Your name is $name"

// Lambda
val isPositive = { x: Int -> x > 0 }
val filtered = listOf(-2, -1, 0, 1, 2).filter(isPositive)

// ===== Capítulo 17: Fundamentos de Kotlin (Completo) =====
// Ejemplo de seguridad nula
fun getLength(text: String?): Int {
    return text?.length ?: 0
}

// Smart casts
fun demo(x: Any) {
    if (x is String) {
        println(x.length) // x es automáticamente casteado a String
    }
}


// ===== Capítulo 18: Gamas =====
for (i in 1..10) print(i) // 1 al 10
for (i in 10 downTo 1 step 2) print(i) // 10, 8, 6, 4, 2

// ===== Capítulo 19: Genéricos =====
class Box<T>(t: T) {
    var value = t
}
val box = Box<Int>(1)

// ===== Capítulo 20: Herencia de clase =====
open class Base(val prop: String)
class Derived(prop: String) : Base(prop)

// ===== Capítulo 21: Instrumentos de cuerda =====
val str = "Hello"
println(str[1]) // 'e'
val multiline = """
    Line 1
    Line 2
""".trimIndent()

// ===== Capítulo 22: Interfaces =====
interface MyInterface {
    fun bar()
    fun foo() {
        println("Default implementation")
    }
}

// ===== EJEMPLOS COMBINADOS KOTLIN (Capítulos 23-38) =====
// Notas importantes:
// 1. Algunos ejemplos requieren dependencias específicas (Android, JUnit, etc.)
// 2. Los ejemplos de DSL y builders son simplificados para mostrar el concepto básico
// 3. Las corrutinas requieren el contexto adecuado para ejecutarse

// ===== Capítulo 23: JUnit =====
// Requiere dependencia JUnit

class MyTest {
    @get:Rule
    val tempFolder = TemporaryFolder()

    @Test
    fun test() {
        val file = tempFolder.newFile("test.txt")
        // pruebas con el archivo
    }
}

// ===== Capítulo 24: Kotlin para desarrolladores de Java =====
// Diferencias clave con Java:
val name: String = "Kotlin" // Tipo explícito (opcional)
var mutableVar = 42        // Variable mutable
val immutableVal = "Hola"  // Variable inmutable (final)

// if como expresión
val max = if (a > b) a else b

// when (mejorado switch)
val description = when {
    x == 0 -> "cero"
    x > 0 -> "positivo"
    else -> "negativo"
}

// ===== Capítulo 25: Lambdas básicas =====
val sum = { a: Int, b: Int -> a + b }
val positives = listOf(-2, -1, 0, 1, 2).filter { it > 0 }

// Lambda con receptor
val stringBuilder = StringBuilder().apply {
    append("Hello")
    append(" ")
    append("World")
}

// ===== Capítulo 26: Logging en Kotlin =====
// Requiere dependencia kotlin-logging
/*
private val logger = KotlinLogging.logger {}
class MyClass {
    fun doSomething() {
        logger.info("Información importante")
    }
}
*/

// ===== Capítulo 27: Métodos de extensión =====
fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)
println("Hola".addEnthusiasm(3)) // Hola!!!

// Extensión para Int
fun Int.isEven() = this % 2 == 0
println(4.isEven()) // true

// ===== Capítulo 28: Modificadores de visibilidad =====
class VisibilityExample {
    public val publicProp = "Público"    // Visible en todas partes (por defecto)
    private val privateProp = "Privado"  // Solo esta clase
    internal val internalProp = "Interno" // Mismo módulo
    protected val protectedProp = "Protegido" // Clase y subclases
}

// ===== Capítulo 29: Modismos =====
// Data class (DTO)
data class User(val name: String, val age: Int)

// Uso de let para null safety
val nullableString: String? = "Kotlin"
nullableString?.let { 
    println(it.uppercase()) // Solo se ejecuta si no es null
}

// Uso de apply para inicialización
val myTextView = TextView(context).apply {
    text = "Hola"
    textSize = 16f
}

// ===== Capítulo 30: Objetos singleton =====
object DatabaseManager {
    init {
        println("Inicializando conexión a BD")
    }
    
    fun query(sql: String) {
        // ejecutar consulta
    }
}

// Uso:
DatabaseManager.query("SELECT * FROM users")

// ===== Capítulo 31: Parámetros Vararg =====
fun printAll(vararg messages: String) {
    for (m in messages) println(m)
}
printAll("Hola", "Mundo", "Kotlin")

// Operador spread
val items = arrayOf("uno", "dos", "tres")
printAll(*items)

// ===== Capítulo 32: Propiedades delegadas =====
import kotlin.properties.Delegates

// Lazy initialization
val lazyValue: String by lazy {
    println("Calculando valor")
    "Resultado"
}

// Observable property
var observed by Delegates.observable(0) { _, old, new ->
    println("Cambiado de $old a $new")
}

// ===== Capítulo 33: RecyclerView en Kotlin =====
// Ejemplo simplificado (requiere Android)
/*
class MyAdapter(private val items: List<String>) : 
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position]
    }

    override fun getItemCount() = items.size
}
*/

// ===== Capítulo 34: Reflexión =====
// Obtener clase
val stringClass = String::class
println(stringClass.simpleName) // String

// Obtener propiedades de una clase
data class Person(val name: String, val age: Int)
val properties = Person::class.memberProperties
properties.forEach { println(it.name) }

// ===== Capítulo 35: Regex =====
val regex = Regex("\\d+") // Coincide con uno o más dígitos
println(regex.matches("123")) // true
println(regex.matches("abc")) // false

// Extraer grupos
val dateRegex = Regex("(\\d{2})/(\\d{2})/(\\d{4})")
val matchResult = dateRegex.find("15/07/2023")
matchResult?.let {
    println("Día: ${it.groupValues[1]}")
    println("Mes: ${it.groupValues[2]}")
    println("Año: ${it.groupValues[3]}")
}

// ===== Capítulo 36: Seguridad nula =====
// Safe call operator
val length: Int? = nullableString?.length

// Elvis operator (proporciona valor por defecto)
val safeLength = nullableString?.length ?: 0

// Not-null assertion (solo cuando estás seguro)
val forcedLength = nullableString!!.length

// ===== Capítulo 37: Tipo de alias =====
typealias UserList = List<User>
typealias AuthCallback = (User, String) -> Boolean

fun processUsers(users: UserList, callback: AuthCallback) {
    // implementación
}

// ===== Capítulo 38: Tipo de constructores seguros =====
// Builder type-safe para HTML
class HTML {
    fun body(init: Body.() -> Unit) = Body().apply(init)
}

class Body {
    fun p(init: P.() -> Unit) = P().apply(init).toString()
}

class P {
    var text = ""
    override fun toString() = "<p>$text</p>"
}

fun html(init: HTML.() -> Unit): HTML = HTML().apply(init)

// Uso:
val htmlContent = html {
    body {
        p {
            text = "Hola mundo"
        }
    }
}