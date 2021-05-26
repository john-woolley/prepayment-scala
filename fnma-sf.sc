import org.apache.spark.sql.SparkSession
val spark = SparkSession
  .builder()
  .appName("FNMA Single Family Model")
  .master("spark://192.168.2.5:7077")
  .config("spark.driver.memory","10g")
  .config("spark.executor.memory","20g")
  .getOrCreate()
val sc = spark.sparkContext
val sql = spark.sqlContext
val df = sql.read.format("csv")
  .option("inferSchema","true")
  .option("delimiter","|")
  .option("header","false")
  .load("/mnt/data/Performance_2000Q1.txt")
df.show(truncate=true)
