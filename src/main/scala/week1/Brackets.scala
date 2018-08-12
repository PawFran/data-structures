package week1

import java.util.Scanner

import scala.collection.mutable

/**
  * Input Format. Input contains one string S which consists of big and small latin letters, digits, punctuation
  * marks and brackets from the set []{}().
  * Constraints. The length of S is at least 1 and at most 10 5 .
  * Output Format. If the code in S uses brackets correctly, output “Success" (without the quotes). Otherwise,
  * output the 1-based index of the first unmatched closing bracket, and if there are no unmatched closing
  * brackets, output the 1-based index of the first unmatched opening bracket.
  */
object Brackets extends App {
  private val scanner = new Scanner(System.in)

  private val input = scanner.nextLine()

  print(compute(input))

  def compute(expression: String): String = {
    val stack = new mutable.Stack[Char]

    def isOpeningBracket(char: Char) = Set('[', '{', '(').contains(char)
    def isClosingBracket(char: Char) = Set(']', '}', ')').contains(char)

    def matches(opening: Char, closing: Char) = opening match {
      case '[' => closing == ']'
      case '{' => closing == '}'
      case '(' => closing == ')'
    }

    var lastOnStackIdx = -1

    for (i <- expression.toCharArray.indices) {
      val char = expression(i)
      if (isOpeningBracket(char)) {
        if (stack.isEmpty) {
          lastOnStackIdx = i
        }
        stack.push(char)
      } else if (isClosingBracket(char)) {
        if (!matches(stack.pop(), char)) {
          return (i + 1).toString
        }
      }
    }

    if (stack.nonEmpty) {
      (lastOnStackIdx + 1).toString
    } else {
      "Success"
    }
  }
}
