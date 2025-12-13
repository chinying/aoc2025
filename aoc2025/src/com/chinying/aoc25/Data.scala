package com.chinying.aoc25

import io.Source

trait Data(filepath: String):
  lazy val lines = Source.fromResource(filepath).getLines
