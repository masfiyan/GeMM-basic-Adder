package GeMM
import chisel3.util.experimental.loadMemoryFromFile
import scala.io.Source
import chisel3._
import chisel3.util._
class read_mat extends Module {
  val io = IO (new Bundle {
	val out = Output(SInt(32.W))
  })
	val imemm = Mem(1024,SInt(32.W))
    loadMemoryFromFile (imemm,"/home/asfiyan/Desktop/readmat")
	val reg = RegInit(0.U(32.W))
		io.out := imemm.read(reg)
		reg := reg + 1.U
}