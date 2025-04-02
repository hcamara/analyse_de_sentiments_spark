import org.apache.spark.sql.SparkSession

// Create or get the SparkSession
val spark = SparkSession.builder()
  .appName("SentimentAnalysis")
  .master("local[*]")
  .getOrCreate()

// Now you can use spark.read to read data
val data = spark.read.option("header", "true").csv("path_to_your_data.csv")

// Perform operations like showing data
data.show()

// Stop the Spark session after use
spark.stop()