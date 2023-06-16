package org.example;

import netscape.javascript.JSObject;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {

        String urlString = "https://api.chucknorris.io/jokes/random";
        URL url=null;
        HttpURLConnection connection=null;
        int connectionCode=0;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            System.out.println("getting exception");
        }

        //connection to server
        try {
            connection = (HttpURLConnection)url.openConnection(); //if we get any exception while creating connection to below code will not work  but its ok kyu ki if connection
                                                                    // stablish nhi hui to there is no need for connection code
            connectionCode = connection.getResponseCode();
        } catch (Exception e) {

            System.out.println("getting exception");
        }
        if(connectionCode==200){

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder APIData = new StringBuilder();
            String readLine=null;

            while((readLine = in.readLine())!=null){
                APIData.append(readLine);
            }
            in.close();

            JSONObject APIJsonResponse = new JSONObject(APIData.toString());
            System.out.println(APIJsonResponse.get("value"));
        }
        else{
            System.out.println("API call could not be complete");
        }

    }
}