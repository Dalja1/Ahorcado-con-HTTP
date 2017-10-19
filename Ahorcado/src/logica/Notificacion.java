/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Juan Benitez
 */
public class Notificacion {
    
public final static String AUTH_KEY_FCM = "AIzaSyCDC3_WjHficpITUcxYknJmbNvQUjqPkPw";
public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";
public final static String TOKEN = "fkcLSP9tDBo:APA91bGy-Qnh9Asl3aXTKLlbLC9NwLDNReMfbYd7WofT6zCq87bPs-MCSwAHsInLYjEjlo5ZzGX7c1vqf0g7yUPKu27lswdCIsnsJpKmyfwtn7w3cSgDDxyp1xBKioNiMMYydhIyj2cB";

    public void enviarPushNotification(String mensaje)
        throws IOException, JSONException {
    //String result = "";
        
   String authKey = AUTH_KEY_FCM; // You FCM AUTH key
   String FMCurl = API_URL_FCM; 
   String Token = TOKEN;
    URL url = new URL(FMCurl);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

    conn.setUseCaches(false);
    conn.setDoInput(true);
    conn.setDoOutput(true);

    conn.setRequestMethod("POST");
    conn.setRequestProperty("Authorization", "key=" +authKey);
    conn.setRequestProperty("Content-Type", "application/json");

    JSONObject json = new JSONObject();

    json.put("to", Token.trim() );
    JSONObject info = new JSONObject();
    info.put("title", "Nuevo Juego"); // Notification title
    info.put("body", "Se ha iniciado un nuevo juego con la palabra: "+mensaje); // Notification
                                                            // body
    json.put("notification", info);
    
    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
    wr.write(json.toString());
    wr.flush();
    conn.getInputStream();
}
    
    
}
