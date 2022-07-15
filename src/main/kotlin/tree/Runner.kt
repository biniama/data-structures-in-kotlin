package tree

fun makeBeverageTree(): TreeNode<String> {

    val tree = TreeNode("Beverages") // root node

    val hot = TreeNode("hot")
    val cold = TreeNode("cold")

    val tea = TreeNode("tea")
    val coffee = TreeNode("coffee")
    val chocolate = TreeNode("chocolate")

    val blackTea = TreeNode("blackTea")
    val greenTea = TreeNode("greenTea")
    val chaiTea = TreeNode("chaiTea")

    val soda = TreeNode("soda")
    val milk = TreeNode("milk")

    val gingerAle = TreeNode("gingerAle")
    val bitterLemon = TreeNode("bitterLemon")

    tree.add(hot)
    tree.add(cold)

    hot.add(tea)
    hot.add(coffee)
    hot.add(chocolate)

    tea.add(blackTea)
    tea.add(greenTea)
    tea.add(chaiTea)

    cold.add(soda)
    cold.add(milk)

    soda.add(gingerAle)
    soda.add(bitterLemon)

    return tree
}

fun main() {
    val tree = makeBeverageTree()

    tree.forEachDepthFirst { /* visitor */ println(it.value) }

    tree.forEachBreadthFirst { /* visitor */ println(it.value) }

    tree.depthFirstSearch("chaiTea")

    tree.printEachLevel()
}
