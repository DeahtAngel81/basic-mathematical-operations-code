package fenixProjectsAndroid// Programa simples demonstrando as 4 operações básicas da matemática em Kotlin
// Soma, Subtração, Multiplicação e Divisão (com tratamento para divisão por zero)
//
// Observação sobre o símbolo $ em Kotlin:
// - Dentro de strings (entre aspas), o $ é usado para interpolação de variáveis e expressões.
//   Ex.: "Valor = $a" coloca o valor da variável a dentro da string.
//   Ex.: "Soma = ${fenixProjectsAndroid.somar(a, b)}" usa ${ ... } para avaliar uma expressão mais complexa.

fun somar(a: Double, b: Double): Double = a + b
fun subtrair(a: Double, b: Double): Double = a - b
fun multiplicar(a: Double, b: Double): Double = a * b
fun dividir(a: Double, b: Double): Double? = if (b == 0.0) null else a / b

fun main() {
    // Agora vamos ler os valores do teclado (entrada padrão)
    // Dica: você pode digitar números com vírgula ou ponto; vamos aceitar ambos
    print("Informe o primeiro número: ")
    val entradaA = readLine()

    print("Informe o segundo número: ")
    val entradaB = readLine()

    // Validação e conversão segura para Double
    fun parseNumero(txt: String?): Double? {
        if (txt == null) return null
        val normalizado = txt.trim().replace(',', '.')
        return normalizado.toDoubleOrNull()
    }

    val a = parseNumero(entradaA)
    val b = parseNumero(entradaB)

    if (a == null || b == null) {
        println("Entrada inválida. Certifique-se de digitar números válidos (ex.: 12.5 ou 12,5).")
        return
    }

    // Perguntar qual operação executar
    println("Escolha a operação: + para soma, - para subtração, * para multiplicação, / para divisão")
    print("Operação: ")
    val op = readLine()?.trim()

    when (op) {
        "+" -> println("Soma: ${somar(a, b)}")
        "-" -> println("Subtração: ${subtrair(a, b)}")
        "*" -> println("Multiplicação: ${multiplicar(a, b)}")
        "/" -> {
            val resultadoDivisao = dividir(a, b)
            if (resultadoDivisao == null) {
                println("Divisão: erro - divisão por zero não é permitida")
            } else {
                println("Divisão: $resultadoDivisao")
            }
        }
        else -> {
            // Se a operação não for reconhecida, mostramos todas as operações como alternativa
            println("Operação não reconhecida. Mostrando todos os resultados possíveis para os números informados.")
            println("Operando A = $a, Operando B = $b")
            println("Soma: ${somar(a, b)}")
            println("Subtração: ${subtrair(a, b)}")
            println("Multiplicação: ${multiplicar(a, b)}")
            val resultadoDivisao = dividir(a, b)
            if (resultadoDivisao == null) {
                println("Divisão: erro - divisão por zero não é permitida")
            } else {
                println("Divisão: $resultadoDivisao")
            }
        }
    }
}