import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class TesteGet {

	public static void main(String[] args) throws Exception, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://stackoverflow.com");
		CloseableHttpResponse response = httpclient.execute(httpGet);

		try {
			System.out.println(response.getStatusLine());
			System.out.println(response);
			System.out.println(response.getEntity());
			HttpEntity entity = response.getEntity();
			

			if (entity != null) {
				InputStream content = entity.getContent();
				try {
					String theString = IOUtils.toString(content, Charsets.UTF_8); 
					System.out.println(theString);
				} catch (Exception e) {
					System.err.println("Erro: " + e.getMessage());
				} finally {
					content.close();
				}
			}	
			
		} catch (Exception e) {
			System.err.println("Erro: " + e.getMessage());
		} finally {
			response.close();
		}
	}

}
