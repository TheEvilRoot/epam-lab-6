package com.theevilroot.epam.lab6.unit

import com.theevilroot.epam.lab6.Counter
import org.scalatest.flatspec.AnyFlatSpec

class CounterTests extends AnyFlatSpec {

  "Counter function" should "return 0 on empty collection" in {
    assert(Counter.count(List(), 2) == 0)
  }

  it should "return 0 on collection without specified element" in {
    assert(Counter.count(List(1, 2, 3), 4) == 0)
  }

  it should "return size of collection when all collection's elements are equals to specified one" in {
    val collection = List(2, 2, 2, 2, 2)
    assert(Counter.count(collection, 2) == collection.size)
  }

  it should "return 4 when collection contains 4 specified elements" in {
    assert(Counter.count(List("A", "B", "B", "C", "B", "D", "B", "E"), "B") == 4)
  }

  it should "compare elements by it's equals function" in {
    assert(Counter.count(List("A", "b", "B", "d", "B", "d", "b", "E"), "B") == 2)
  }

  it should "not modify collection" in {
    val origin = List(2, 3, 4, 5, 6, 5, 5, 4, 5, 2)
    val collection = origin
    Counter.count(collection, 2)
    assert(origin == collection)
  }

}
