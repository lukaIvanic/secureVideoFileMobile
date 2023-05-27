package com.example.securevideofile;

import android.os.AsyncTask;
import android.util.Log;

import androidx.loader.content.AsyncTaskLoader;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class NetworkManager {

    private static final String BASE_URL = "http://192.168.0.105:9000/secureVideoFile/";

    public static final String RETRIEVE_FILE = "retrieve";
    public static final String UPLOAD_FILE = "uploadFile";


    public static class getTodosAsyncTask extends AsyncTask<String, Void, Void>{

        @Override
        protected Void doInBackground(String... values) {

            sendRequest(values[0], values[1], values[2], values[3]);

            return null;
        }
    }



    private static void sendRequest(String firstParameter, String secondParameter, String method, String path) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES);
        OkHttpClient client = builder.build();

        RequestBody requestBody;
        Request request = null;

        if (path.equalsIgnoreCase(RETRIEVE_FILE)) {
            requestBody = new FormBody.Builder()
                    .add("password", firstParameter)  // Replace with your first element and its value
                    .add("name", secondParameter)  // Replace with your second element and its value
                    .build();

            request = new Request.Builder()
                    .url(BASE_URL + RETRIEVE_FILE)  // Replace with your actual endpoint URL
                    .post(requestBody)
                    .build();
        }

        try {
            Response response = client.newCall(request).execute();
            ResponseBody responseBody = response.body();
            if (responseBody != null) {
                String responseBodyString = responseBody.string();
                System.out.println(responseBodyString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper method to get RequestType
    private static RequestType getRequestMethodForUrlPath(String path) {
//        if(path == GET_TODOS_PATH){
//            return RequestType.GET;
//        }
//        return RequestType.GET;
        return null;
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
