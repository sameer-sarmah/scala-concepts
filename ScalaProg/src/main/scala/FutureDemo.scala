import client.{HttpClient, HttpMethod}
import com.google.gson.{GsonBuilder, JsonParser}
import exceptions.CoreException

import scala.collection.mutable.ListBuffer
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

object FutureDemo extends App {
  override def main(args: Array[String]) {
    val productIDs = ListBuffer[String]("1", "2", "3")
    val futures = ListBuffer[Future[String]]()
    productIDs.foreach((id) => {
      val future: Future[String] = getProductByIDAsync(id)
      futures += future
    })
    futures.foreach((future) => {
      future onComplete {
        case Success(product) => println(product)
        case Failure(t) => println("An error has occurred: " + t.getMessage)
      }

    })
    Thread.sleep(10000)
  }


  def getProductByID(id: String): String = {
    val httpClient = new HttpClient()
    var jsonResponse = ""
    val queryParams = Map[String, String]("$format" -> "json")
    try {
      val url = s"https://services.odata.org/Northwind/Northwind.svc/Products(${id})"
      jsonResponse = httpClient.request(url, HttpMethod.GET,
        Map[String, String](), queryParams, null)
      val gson = new GsonBuilder().setPrettyPrinting().create()
      val jp = new JsonParser()
      val je = jp.parse(jsonResponse)
      val prettyJsonString = gson.toJson(je)
      return prettyJsonString;
    } catch {
      case (e: CoreException) =>
        e.printStackTrace()
        return null;
    }
  }

  def getProductByIDAsync(id: String): Future[String] = Future[String] {
    getProductByID(id)
  }
}