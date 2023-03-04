package GeMM

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._
import chisel3.experimental.BundleLiterals._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation


class read_matT extends FreeSpec with ChiselScalatestTester {

  "GeMM read from Matrix" in {
    test(new read_mat()){ dut =>
        dut.clock.step(200)
        }
    }
}