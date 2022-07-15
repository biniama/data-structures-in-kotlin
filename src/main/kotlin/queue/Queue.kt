package queue

interface Queue<T: Any> {

    fun enqueue(item: T)

    fun dequeue(): T?

    fun peek(): T?

    val count: Int

    val isEmpty: Boolean
        get() = count == 0
}
