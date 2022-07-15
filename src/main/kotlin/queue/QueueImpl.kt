package queue

class QueueImpl<T: Any>: Queue<T> {

    private val queue = arrayListOf<T>()

    override val count: Int
        get() = queue.size

    override fun enqueue(item: T) {
        queue.add(item)
    }

    override fun dequeue(): T? {
        return if (isEmpty) null else queue.removeAt(0)
    }

    override fun peek(): T? = queue.getOrNull(0)
}
