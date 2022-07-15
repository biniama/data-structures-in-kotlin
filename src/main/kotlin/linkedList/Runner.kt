package linkedList

fun main() {
    val list = Node(value = 1, next = Node(value = 2, next = Node(value = 3, next = Node(value = 4, next = Node(value = 5)))))

    println(list)
    list.printInReverse()
}
