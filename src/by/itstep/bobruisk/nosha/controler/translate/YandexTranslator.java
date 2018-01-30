package by.itstep.bobruisk.nosha.controler.translate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author nosha translate text by Yandex API
 */
public class YandexTranslator implements Translatable {

	private static final String PATH = "https://translate.yandex.net/api/v1.5/tr.json/translate";

	// API key from yandex
	private static final String KEY = "?key=trnsl.1.1.20180116T120517Z.f7b1ed2d45f51bba.27cda06b43ebd1c7c98acb18e430e572ae16518f";
	private static final String LANG = "&lang=";


	@Override
	public String getString(String string, String lang) {

		try {

			URL url = new URL(new StringBuilder(PATH).append(KEY).append("&text=" + URLEncoder.encode(string, "UTF-8"))
					.append(LANG + lang).toString());
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();

			InputStream input = connection.getInputStream();
			BufferedReader buffer = new BufferedReader(new InputStreamReader(input));
			String jsonString = buffer.readLine();
			JSONObject json = new JSONObject(jsonString);

			String request = json.optString("text").toString();
			return formateText(request);
		} catch (

		MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return "WTF";

	}

	/**
	 * @param string
	 * @return string without "[" and "]" characters
	 */
	private String formateText(String string) {

		return string.substring(2, string.length() - 2);

	}
}
