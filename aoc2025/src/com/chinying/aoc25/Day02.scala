package com.chinying.aoc25

import scala.collection.immutable.NumericRange

lazy object Day02 extends Data("day02.txt") {
  // val input = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124"
  val input = lines.next
  def parse(line: String): List[NumericRange.Inclusive[Long]] = {
    line.split(",").map(pair => {
      pair.split("-").map(_.toLong) match {
        case Array(start, end) => start to end
        case _ => throw new IllegalArgumentException(s"Invalid pair: $pair")
      }
    }).toList
  }

  def isValid(num: Long) = {
    var numStr = num.toString
    val (left, right) = numStr.splitAt(numStr.length / 2)
    left == right
  }

  def gather(range: NumericRange.Inclusive[Long]) = {
    range.foldLeft(List.empty[Long])((acc, i) => if (isValid(i)) i :: acc else acc)
  }

  def part1 = {
    val ranges = parse(input)
    var acc = 0L
    ranges.foreach(range => {
      acc = acc + gather(range).sum
    })
    acc
  }
}