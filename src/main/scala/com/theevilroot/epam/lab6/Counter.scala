package com.theevilroot.epam.lab6

import scala.annotation.tailrec

object Counter {

  @tailrec
  def count[A](in: List[A], value: A, compare: (A, A) => Boolean, c: Int = 0): Int = in match {
    case a :: rest if compare(a, value) => count(rest, value, compare, c + 1)
    case _ :: rest => count(rest, value, compare, c)
    case Nil => c
  }

  def count_if[A](in: List[A], filter: (A) => Boolean): Int = in match {
    case a :: rest if filter(a) => 1 + count_if(rest, filter)
    case _ :: rest => count_if(rest, filter)
    case Nil => 0
  }

}
