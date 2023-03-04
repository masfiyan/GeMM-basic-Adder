package GeMM
import chisel3.util.experimental.loadMemoryFromFile
import scala.io.Source
import chisel3._
import chisel3.util._
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.ArrayBuffer

class adder extends Module {
  val io = IO(new Bundle {
    val out = Output(SInt(32.W))
  })
  val mem = Mem(1024, SInt(32.W))
  loadMemoryFromFile (mem,"/home/asfiyan/Desktop/readmat2")
  val mem2 = Mem(1024, SInt(32.W))
  val reg = RegInit(0.U(32.W))
  val a = 0.U
  val arr1 = RegInit(VecInit(Seq.fill(4)(0.S(32.W))))
  val arr2 = RegInit(VecInit(Seq.fill(4)(0.S(32.W))))
  val result = RegInit(VecInit(Seq.fill(4)(0.S(32.W))))
  val f = scala.io.Source.fromFile("/home/asfiyan/Desktop/readmat2")
  val lines = f.getLines().toArray
  f.close()
  val pw = new java.io.PrintWriter(new java.io.File("output.txt"))
  when (reg <= 3.U && reg < 5.U) { 
    arr1(reg) := mem.read(reg)
    arr2(reg) := mem.read(reg+4.U)
    io.out  := 0.S
    reg := reg + 1.U
  }.elsewhen (reg <= 7.U && reg < 8.U ){
    result(reg-8.U) := arr2(reg-4.U) + arr1(reg-8.U)
    reg := reg + 1.U
    dontTouch(result)
    io.out := 0.S
  }.elsewhen(reg <= 11.U && reg < 12.U) {
    mem.write(reg,result(reg - 8.U))
    io.out := 0.S
    reg := reg + 1.U
  }.elsewhen (reg <= 23.U && reg < 24.U) {
    io.out := 0.S
    reg := reg + 1.U
  }.elsewhen (reg <= 27.U && reg < 28.U) {
    io.out := mem.read(reg - 16.U)
    reg := reg + 1.U
  }.otherwise {
    io.out := 0.S
  }
  }