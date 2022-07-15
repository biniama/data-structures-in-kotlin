package stack

interface Stack<T: Any> {

    fun push(item: T)

    fun pop(): T?

    fun peek(): T?

    val count: Int

    val isEmpty: Boolean
        get() = count == 0
}
