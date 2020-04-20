package com.theevilroot.epam.lab6

import scala.annotation.tailrec

object Counter {

  @tailrec
  def count[A](in: List[A], value: A, c: Int = 0): Int = in match {
    case a :: rest if a == value => count(rest, value, c + 1)
    case _ :: rest => count(rest, value, c)
    case Nil => c
  }

}
