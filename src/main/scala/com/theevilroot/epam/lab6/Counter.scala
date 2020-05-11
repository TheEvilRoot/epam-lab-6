package com.theevilroot.epam.lab6

object Counter {

  def foldl[A, B](f: (A, B) => B, a: B, in: List[A]): B = in match {
    case x :: rest => f(x, foldl(f, a, rest))
    case Nil => a
  }

  def map[A, B](in: List[A], f: A => B): List[B] =
    foldl[A, List[B]]((x, list) => list.appended(f(x)), List(), in)

  def count[A](in: List[A], value: A): Int =
    foldl[Int, Int]((x, y) => x + y, 0, map[A, Int](in, {
      case a if a == value => 1
      case _ => 0
    }))

  def counter[A](filter: A => Boolean)(in: List[A]): Int =
    foldl[Int, Int]((x, y) => x + y, 0, map[A, Int](in, {
      case a if filter(a) => 1
      case _ => 0
    }))

}