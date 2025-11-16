package observer;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;

public class OldClientMain {
    private static final String URL_API = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";

    public static void main(String[] args) {
        fetchEURORate();
    }

    private static void fetchEURORate() {
        try {
            URL url = new URL(URL_API);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null){
                response.append(line);
            }
            JSONArray jsonArray = new JSONArray(response.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (jsonObject.getString("ccy").equals("EUR")){
                    String buy = jsonObject.getString("buy");
                    String string = jsonObject.getString("sale");
                    System.out.printf("[%s] EUR->UAH Buy=%s | Sale=%s\n", LocalDate.now(), buy, string);
                }
            }

        } catch (IOException e) {
            System.out.println("API error: " + e.getMessage());
        }
    }
}


