package week1

import org.scalatest.FunSuite

class BracketsTest extends FunSuite {

  test("first") {
    assert(Brackets.compute("[]") == "true")
  }

  test("second") {
    assert(Brackets.compute("{}[]") == "true")
  }

  test("third") {
    assert(Brackets.compute("[()]") == "true")
  }

  test("fourth") {
    assert(Brackets.compute("(())") == "true")
  }

  test("fifth") {
    assert(Brackets.compute("{[]}()") == "true")
  }

  test("sixth") {
    assert(Brackets.compute("{") == "1")
  }

  test("seventh") {
    assert(Brackets.compute("{[}") == "3")
  }

  test("eighth") {
    assert(Brackets.compute("foo(bar);") == "true")
  }

  test("ninth") {
    assert(Brackets.compute("foo(bar[i);") == "10")
  }
}
