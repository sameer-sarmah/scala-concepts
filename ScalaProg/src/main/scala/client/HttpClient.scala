package client

import exceptions.CoreException
import org.apache.http.client.methods.RequestBuilder
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.message.BasicNameValuePair
import org.apache.http.util.EntityUtils
import org.apache.log4j.Logger
import java.io.IOException
import java.net.MalformedURLException

import client.HttpMethod.{HttpMethod, Value}

class HttpClient {

  def request(url: String, method: HttpMethod, headers: Map[String, String],
              queryParams: Map[String, String], jsonString: String): String = {
    val logger = Logger.getLogger("HttpClient")
    try {
      val requestBuilder: RequestBuilder = RequestBuilder.create(method.toString())
      headers.foreach(tuple => {
        requestBuilder.addHeader(tuple._1, tuple._2)
      })
      queryParams.foreach((tuple) => {
        val pair = new BasicNameValuePair(tuple._1, tuple._2)
        requestBuilder.addParameters(pair)
      })
      requestBuilder.setUri(url)


      if (method.equals(HttpMethod.POST) || method.equals(HttpMethod.PUT)) {
        val input = new StringEntity(jsonString)
        input.setContentType("application/json")
        requestBuilder.setEntity(input)
      }

      val request = requestBuilder.build()
      val client = HttpClientBuilder.create().build()
      val response = client.execute(request)


      return EntityUtils.toString(response.getEntity());


    } catch {
      case exception: MalformedURLException => {
        logger.error(exception.getMessage)
        throw new CoreException(exception.getMessage, 500)
      }

      case exception: IOException => {
        logger.error(exception.getMessage)
        throw new CoreException(exception.getMessage, 500)
      }

    }
  }
}
