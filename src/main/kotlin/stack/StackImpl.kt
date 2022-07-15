package stack

class StackImpl<T : Any> : Stack<T> {

    private var store = arrayListOf<T>()

    override fun pop(): T? {
        return store.removeLastOrNull()
    }

    override fun peek(): T? {
        return store.lastOrNull()
    }

    override val count: Int
        get() = store.size

    override fun push(item: T) {
        store.add(item)
    }
}
