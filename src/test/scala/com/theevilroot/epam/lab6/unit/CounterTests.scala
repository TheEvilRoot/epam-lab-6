package com.theevilroot.epam.lab6.unit

import com.theevilroot.epam.lab6.Counter
import org.scalatest.flatspec.AnyFlatSpec

class CounterTests extends AnyFlatSpec {

  "count" should "return 0 on empty collection" in {
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

  it should "not modify collection" in {
    val origin = List(2, 3, 4, 5, 6, 5, 5, 4, 5, 2)
    val collection = origin
    Counter.count(collection, 2)
    assert(origin == collection)
  }

  "counter" should "return 0 if collection is empty" in {
    val counter: List[Any] => Int = Counter.counter[Any](_ => true)
    assert(counter(List()) == 0)
  }

  it should "return 0 if all elements does not satisfy filtering condition" in {
    val counter: List[Int] => Int = Counter.counter[Int](_ => false)
    assert(counter(List(1, 2, 3)) == 0)
  }

  it should "return number of elements less than 10" in {
    val counter: List[Int] => Int = Counter.counter[Int](x => x < 10)
    assert(counter(List(1, 2, 8, 10, 24, 9, 0)) == 5)
  }

  it should "return number of string elements with length greater than 3" in {
    val counter: List[String] => Int = Counter.counter[String](x => x.length > 3)
    assert(counter(List("hello", "world", "asd", "scala")) == 3)
  }

  it should "not modify collection" in {
    val counter: List[String] => Int = Counter.counter[String](x => x.length > 3)
    val origin = List("hello", "asd", "scala", "world")
    val collection = origin
    counter(collection)
    assert(origin == collection)
  }

}
