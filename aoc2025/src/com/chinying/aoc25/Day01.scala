package com.chinying.aoc25

import scala.collection.mutable.{ArrayBuffer, HashMap}
import java.lang.Math.floorMod

object Day01 {
  val input = io.Source.fromResource("day01.txt").getLines.toList
//   val input = """L68
// L30
// R48
// L5
// R60
// L55
// L1
// L99
// R14
// L82""".split("\n").map(_.trim).toList

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
      val parsed = parse(line)
      // scala's / operator truncates towards 0, hence need to handle differently for left and right movements
      val zeros = if (parsed > 0) {
        Math.floorDiv(acc + parsed, 100)
      } else {
        Math.floorDiv(acc - 1, 100) - Math.floorDiv(acc + parsed - 1, 100)
      }
      pw += zeros
      acc = floorMod(acc + parsed, 100)
    })
    pw // 6889 too high
  }

  private def ceil(a: Int) = Math.ceil(a).toInt
}
