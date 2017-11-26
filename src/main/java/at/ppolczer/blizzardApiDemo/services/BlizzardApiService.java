package at.ppolczer.blizzardApiDemo.services;

import at.ppolczer.blizzardApiDemo.models.CareerProfile;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class BlizzardApiService {

    private static final String PROFILE_BASE_URL = "https://eu.api.battle.net/d3/profile/";
    private static final String API_KEY = "";

    public CareerProfile getD3CareerProfile(String battleTag){

        try {

            URL url = new URL(PROFILE_BASE_URL + URLEncoder.encode(battleTag, "UTF-8") + "/?locale=en_GB&apikey=" + URLEncoder.encode(API_KEY, "UTF-8"));

            String response = queryApi(url);

            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(response, CareerProfile.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String queryApi(URL url){
        StringBuilder responseStringBuilder = new StringBuilder();

        HttpURLConnection connection = null;
        BufferedReader inputStreamReader = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            inputStreamReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            while ((line = inputStreamReader.readLine()) != null) {
                responseStringBuilder.append(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(connection != null){
                connection.disconnect();
            }
            if(inputStreamReader != null){
                try {
                    inputStreamReader.close();
                } catch (IOException e){
                    e.printStackTrace();
                }

            }
        }

        return responseStringBuilder.toString();
    }
}
