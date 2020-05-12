package week1

import org.scalatest.FunSuite

class BracketsTest extends FunSuite {

  test("first") {
    assert(Brackets.compute("[]") == "Success")
  }

  test("second") {
    assert(Brackets.compute("{}[]") == "Success")
  }

  test("third") {
    assert(Brackets.compute("[()]") == "Success")
  }

  test("fourth") {
    assert(Brackets.compute("(())") == "Success")
  }

  test("fifth") {
    assert(Brackets.compute("{[]}()") == "Success")
  }

  test("sixth") {
    assert(Brackets.compute("{") == "1")
  }

  test("seventh") {
    assert(Brackets.compute("{[}") == "3")
  }

  test("eighth") {
    assert(Brackets.compute("foo(bar);") == "Success")
  }

  test("ninth") {
    assert(Brackets.compute("foo(bar[i);") == "10")
  }
}
