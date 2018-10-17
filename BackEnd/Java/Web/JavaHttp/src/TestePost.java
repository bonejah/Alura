import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class TestePost {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("XPTO");
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("name", "XPOT"));
		nvps.add(new BasicNameValuePair("password", "XPTO"));
		nvps.add(new BasicNameValuePair("Content-Type", "application/json"));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));

		CloseableHttpResponse response = httpclient.execute(httpPost);

		try {
			// System.out.println(response);
			// System.out.println(response.getAllHeaders());
			// System.out.println(response.getEntity());
			// System.out.println(response.getLocale());
			// System.out.println(response.getParams());
			// System.out.println(response.getProtocolVersion());
			// System.out.println(response.getStatusLine());

			HttpEntity entity = response.getEntity();
			System.out.println(entity);
			// EntityUtils.consume(entity);

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
