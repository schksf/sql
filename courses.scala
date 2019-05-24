import scala.collection.mutable
import scala.collection.immutable
import scala.collection.mutable.ArrayBuffer
object Scala52019 extends App {

    testFindOrder()
      def testFindOrder(): Unit = {
            val prerequisites = List(List(1, 0), List(2, 0), List(3, 1), List(3, 2))
                println(s"findOrder(4,$prerequisites) = ${findOrder(4, prerequisites)}")
                  }
        def findOrder(numCourses: Int, prerequisites: Seq[Seq[Int]]): Seq[Int] = {
              val graph: mutable.Map[Int, Seq[Int]] = mutable.Map.empty
                  val degree: mutable.Map[Int, Int] = mutable.Map.empty
                      prerequisites.foreach(i => {
                              graph(i(1)) = i(0) +: graph.getOrElse(i(1), Seq.empty[Int])
                                    degree(i(0)) = degree.getOrElse(i(0), 0) + 1
                                        })
                  val topoSort = ArrayBuffer.empty[Int]
                  val degree0: mutable.Queue[Int] = prerequisites.map(_(1)).filterNot(degree.keys.toSet contains _).distinct.to[mutable.Queue]
                  println(s"graph=$graph degree=$degree degree0=$degree0")
                  while (!degree0.isEmpty) {
                      val vertex = degree0.dequeue()
                      topoSort += vertex
                      graph.getOrElse(vertex, Seq.empty).foreach(n => {
                              degree(n) = degree(n) - 1
                              if (degree(n) == 0) 
                                       degree0.enqueue(n)
                              })
                  }
                  if (topoSort.size == numCourses)
                      topoSort
                  else 
                      Seq.empty
       }
}
