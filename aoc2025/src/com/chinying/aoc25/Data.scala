package com.chinying.aoc24

import io.Source

trait Data(filepath: String):
  lazy val lines = Source.fromResource(filepath).getLines
