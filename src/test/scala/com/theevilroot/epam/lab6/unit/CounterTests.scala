package com.theevilroot.epam.lab6.unit

import com.theevilroot.epam.lab6.Counter
import org.scalatest.flatspec.AnyFlatSpec

class CounterTests extends AnyFlatSpec {

  "Counter function" should "return 0 on empty collection" in {
    assert(Counter.count(List(), 2, (x: Int, y: Int) => x == y) == 0)
  }

  it should "return 0 on collection without specified element" in {
    assert(Counter.count(List(1, 2, 3), 4, (x: Int, y: Int) => x == y) == 0)
  }

  it should "return size of collection when all collection's elements are equals to specified one" in {
    val collection = List(2, 2, 2, 2, 2)
    assert(Counter.count(collection, 2, (x: Int, y: Int) => x == y) == collection.size)
  }

  it should "return 4 when collection contains 4 specified elements" in {
    assert(Counter.count(List("A", "B", "B", "C", "B", "D", "B", "E"), "B", (x: String, y: String) => x.equals(y)) == 4)
  }

  it should "compare elements by compare function" in {
    assert(Counter.count(List("A", "b", "B", "d", "B", "d", "b", "E"), "B", (x: String, y: String) =>
      x.toLowerCase().equals(y.toLowerCase())) == 4)
  }

  it should "not modify collection" in {
    val origin = List(2, 3, 4, 5, 6, 5, 5, 4, 5, 2)
    val collection = origin
    Counter.count(collection, 2, (x: Int, y:Int) => x == y)
    assert(origin == collection)
  }

  "count_if" should "return 0 if collection is empty" in {
    assert(Counter.count_if[Any](List(), x => true) == 0)
  }

  it should "return 0 if all elements does not satisfy filtering condition" in {
    assert(Counter.count_if[Int](List(1, 2, 3), x => false) == 0)
  }

  it should "return number of elements less than 10" in {
    assert(Counter.count_if[Int](List(1, 2, 8, 10, 24, 9, 0), x => x < 10) == 5)
  }

  it should "return number of string elements with length greater than 3" in {
    assert(Counter.count_if[String](List("hello", "world", "asd", "scala"), x => x.length > 3) == 3)
  }

  it should "not modify collection" in {
    val origin = List("hello", "asd", "scala", "world")
    val collection = origin
    Counter.count_if[String](collection, x => x.length() > 3)
    assert(origin == collection)
  }

}
