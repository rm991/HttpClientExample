package com.fsalinas;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static java.lang.System.out;

/**
 * First HttpClient Example!
 *
 */
public class Main 
{
    public static void main( String[] args ) {
        HttpClient httpClient =  HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10))
                .build();

        int statusCode = 0;
        String body = "";

        try {

            String endPoint = "https://www.google.com/";
            URI uri = URI.create(endPoint);

            HttpRequest request = HttpRequest.newBuilder().uri(uri)
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            statusCode = response.statusCode();
            body = response.body();

        }catch (Exception e) {
            e.printStackTrace();
        }

        out.printf("Status Code: %d\n", statusCode);
        out.printf("Body: %s\n", body);
    }
}
