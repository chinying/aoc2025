package com.chinying.aoc25

import scala.collection.mutable.{ArrayBuffer, HashMap}
import java.lang.Math.floorMod

object Day01 {
  // val input = io.Source.fromResource("day01.txt").getLines.toList
  val input = """L68
L30
R48
L5
R60
L55
L1
L99
R14
L82""".split("\n").map(_.trim).toList

  // def parse(line: String) = line.split("\\s+")
  def parse(line: String): Int = {
    val dirStr = line.head
    val dir = dirStr match {
      case 'R' => 1
      case 'L' => -1
    }
    val steps = line.tail.toInt
    steps * dir
  }

  def part1 = {
    val start = 50
    var acc = start
    var pw = 0
    input.foreach(line => {
      var parsed = parse(line)
      acc = (acc + parsed) % 100
      if (acc == 0) pw += 1
    })
    pw
  }

  def part2 = {
    val start = 50
    var acc = start
    var pw = 0
    input.foreach(line => {
      var parsed = parse(line)
      val next = acc + parsed
      val (quotient, remainder) = (next / 100, floorMod(next, 100))
      pw += Math.abs(quotient)
      println(s"next: $next, quotient: $quotient, remainder: $remainder, pw: $pw")
      acc = remainder
    })
    pw // 6889 too high
  }

  private def ceil(a: Int) = Math.ceil(a).toInt
}
