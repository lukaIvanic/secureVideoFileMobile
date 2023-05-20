package com.example.securevideofile;

import android.os.AsyncTask;
import android.util.Log;

import androidx.loader.content.AsyncTaskLoader;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class NetworkManager {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    public static final String GET_TODOS_PATH = "todos";


    public static class getTodosAsyncTask extends AsyncTask<String, Void, Void>{

        @Override
        protected Void doInBackground(String... url) {

            String response = sendRequest(url[0], null);

            Log.i("LUKA RESPONSE", response);

            return null;
        }
    }



    private static String sendRequest(String urlPath, String requestBodyString) {

        RequestType requestType = getRequestMethodForUrlPath(urlPath);

        OkHttpClient client = new OkHttpClient.Builder().build();
        MediaType mediaType = MediaType.parse("application/json");

        RequestBody requestBody =
                (requestType == RequestType.POST || requestType == RequestType.PUT) ?
                        RequestBody.create(mediaType, requestBodyString) : null;

        Request request = new Request.Builder()
                .url(BASE_URL + urlPath)
                .method(requestType.getLabel(), requestBody)
                .addHeader("accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .build();

        try {
            Response response = client.newCall(request).execute();
            return response.body() != null ? response.body().string() : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    // Helper method to get RequestType
    private static RequestType getRequestMethodForUrlPath(String path) {
        if(path == GET_TODOS_PATH){
            return RequestType.GET;
        }
        return RequestType.GET;
    }
    // Define RequestType enum
    private enum RequestType {
        GET("GET"),
        POST("POST"),
        PUT("PUT"),
        DELETE("DELETE");

        private final String label;

        RequestType(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

}
