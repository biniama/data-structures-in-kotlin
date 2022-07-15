package stack

fun main() {
    println("((((()))))".isValidateParentheses())
    println("({]".isValidateParentheses())
    println("((".isValidateParentheses())
    println("([{}])".isValidateParentheses())
    println("([{)}]".isValidateParentheses())
}

fun String.isValidateParentheses(): Boolean {
    val stack = StackImpl<Char>()

    for (char in this) {
        when (char) {
            '(', '[', '{' -> {
                stack.push(char)
            }
            ')' -> {
                return if (stack.isEmpty) {
                    false
                } else {
                    stack.pop() == '('
                }
            }
            ']' -> {
                return if (stack.isEmpty) {
                    false
                } else {
                    stack.pop() == '('
                }
            }
            '}' -> {
                return if (stack.isEmpty) {
                    false
                } else {
                    stack.pop() == '{'
                }
            }
        }
    }
    return stack.isEmpty
}
