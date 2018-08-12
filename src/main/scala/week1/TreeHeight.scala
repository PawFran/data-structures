package week1

import java.util.Scanner
import collection.mutable

/**
  * Input Format. The first line contains the number of nodes n. The second line contains n integer numbers
  * from −1 to n − 1 — parents of nodes. If the i-th one of them (0 ≤ i ≤ n − 1) is −1, node i is the root,
  * otherwise it’s 0-based index of the parent of i-th node. It is guaranteed that there is exactly one root.
  * It is guaranteed that the input represents a tree.
  * Constraints. 1 ≤ n ≤ 10 5 .
  * Output Format. Output the height of the tree.
  */
object TreeHeight extends App {
  private val scanner = new Scanner(System.in)

  private val nodesNumber = scanner.nextLine().toInt
  private val parentsIndices = scanner.nextLine().split(" ").map(_.toInt).toList

  print(compute(parentsIndices))

  def compute(parentsIndices: List[Int]): Int = {
    val nodes = for (idx <- parentsIndices.indices) yield new Tree(idx, children = mutable.ListBuffer.empty, parent = parentsIndices(idx))

    nodes.foreach { node =>
      if (node.parent != -1) {
        nodes(node.parent).children += node
      }
    }

    def height(tree: Tree, accumulator: Int = 0): Int = {
      if (tree.children.isEmpty) accumulator
      else tree.children.map(child => height(child, accumulator) + 1).max
    }

    val root = nodes.find(_.parent == -1).get

    height(root, 1)
  }

  class Tree(val value: Int, var children: mutable.ListBuffer[Tree], val parent: Int)
}

