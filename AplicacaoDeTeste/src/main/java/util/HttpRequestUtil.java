package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.Gson;

public class HttpRequestUtil {

	private final String USER_AGENT = "Mozzila/5.0";
	
	public void getRequest(String url){
		// URL para get
		
		try {
			@SuppressWarnings("deprecation")
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet(url);
			request.addHeader("User-agent", USER_AGENT);
			HttpResponse response = client.execute(request);
			System.out.println("\n Enviando método 'GET' request to URL '" + url + "'");
			System.out.println("\n Response Code: " + response.getStatusLine().getStatusCode());
			// Abrindo um buffered reader para ler os parametros passados pela URL
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer result = new StringBuffer();
			String line = "";
			// Enquanto o input não foi nulo, continua adicionando novos inputs
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			// Print do resultado do GET
			System.out.println("Get - OK");
			System.out.println(result.toString());
		} catch (Exception e) {
			
		}
	}
	
	
	public void postRequest(Object obj, String url){	
		try {
			Gson gson = new Gson();
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpPost post = new HttpPost(url);
			StringEntity postEntity = new StringEntity(gson.toJson(obj));
			post.setEntity(postEntity);
			post.setHeader("Content-type", "application/json");
			HttpResponse response = httpClient.execute(post);
			System.out.println("Post - OK");
			System.out.println("\n Response Code: " + response.getStatusLine().getStatusCode());
			System.out.println(obj.toString());
		} catch (Exception e) {
			
		}
		
	}

}
