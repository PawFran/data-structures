package week1

import org.scalatest.FunSuite

class TreeHeightTest extends FunSuite {

  test("sample 1") {
    assert(TreeHeight.compute(List(4, -1, 4, 1, 1)) == 3)
  }

  test("sample 2") {
    assert(TreeHeight.compute(List(-1, 0, 4, 0, 3)) == 4)
  }

}
