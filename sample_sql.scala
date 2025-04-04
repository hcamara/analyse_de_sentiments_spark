import org.apache.spark.sql.SparkSession


object SentimentAnalysis {
  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder()
    .appName("Spark SQL Example")
    .master("local[*]")
    .getOrCreate()

    // Charger des données en DataFrame
    val df = spark.read.option("header", "true").csv("sentiments.csv")

    // Exécution d'une requête SQL
    df.createOrReplaceTempView("data_table")
    val result = spark.sql("SELECT * FROM data_table")

    // Afficher les résultats
    result.show()

    spark.stop()

  }
}