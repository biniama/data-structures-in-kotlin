package tree

import queue.QueueImpl

class TreeNode<T: Any>(val value: T) {
    private val children: MutableList<TreeNode<T>> = mutableListOf()

    fun add(child: TreeNode<T>) = children.add(child)

    fun forEachDepthFirst(visit: Visitor<T>) {
        // call visit as part of this function
        visit(this)

        children.forEach {
            it.forEachDepthFirst(visit)
        }
    }

    // search by Level
    fun forEachBreadthFirst(visit: Visitor<T>) {
        visit(this)

        // create a queue
        val queue = QueueImpl<TreeNode<T>>()

        // put all the children of the tree to the queue
        children.forEach {
            queue.enqueue(it)
        }

        // read the first element in the queue
        var node = queue.dequeue()

        //while node is not null,
        while(node != null) {
            visit(node)
            // add all the childen to the queue
            node.children.forEach { queue.enqueue(it) }
            // take out the first element from the queue
            node = queue.dequeue()
        }
    }

    fun depthFirstSearch(value: T): TreeNode<T>?{
        var result: TreeNode<T>? = null

        forEachDepthFirst {
            if (it.value == value) {
                result = it
                println("Found value ${it.value}")
            }
        }
        return result
    }

    fun printEachLevel() {
        val queue = QueueImpl<TreeNode<T>>()

        var nodesLeftInCurrentLevel = 0

        queue.enqueue(this)
        while(queue.isEmpty.not()) {
            nodesLeftInCurrentLevel = queue.count

            while(nodesLeftInCurrentLevel > 0) {
                val node = queue.dequeue()

                if (node != null) {
                    println("${node.value}")

                    node.children.forEach { queue.enqueue(it) }
                    nodesLeftInCurrentLevel--
                } else {
                    break
                }
            }
        }
    }
}

// Visitor<T> is a function that takes a TreeNode and returns nothing
typealias Visitor<T> = (TreeNode<T>) -> Unit
