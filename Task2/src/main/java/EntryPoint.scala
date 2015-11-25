import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext._

/**
 * @author Nikita Liashevich on 11/25/15.
 */
object EntryPoint {
  def main(args: Array[String]) {

    val sc = new SparkContext(new SparkConf().setAppName("NodeEdgesWeight"))

    val file = sc.textFile("hdfs://localhost:8020" + args(0))

    val mapped = file.map(mapper).reduceByKey((a,b)=> a + b)

    val reduced = mapped.reduceByKey((a,b)=> a + b).sortByKey().map(pair => pair._1 + "\t" + pair._2)

    reduced.saveAsTextFile("hdfs://localhost:8020" + args(1))
  }


  def mapper(line: String): (Long, Long) = {
    val tokens = line.split("\t")

    val nodeId    = tokens(1).toLong
    val weight = tokens(2).toLong
    (nodeId, weight)
  }
}
