package GeMM

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._
import chisel3.experimental.BundleLiterals._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation


class adderT extends FreeSpec with ChiselScalatestTester {

  "GeMM adder" in {
    test(new adder()){ dut =>
        dut.clock.step(100)
        }
    }
}