package com.example.securevideofile.network;

import static com.example.securevideofile.NetworkManager.*;

import android.os.AsyncTask;

import com.example.securevideofile.NetworkManager;
import com.example.securevideofile.errors.NetworkErrors;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkCore {

    public static class sendRequest extends AsyncTask<sendRequest.ResponseCallback, Void, Void> {

        public interface ResponseCallback<T> {
            void onResponse(String jsonResponse, Exception exception);
        }

        private String urlPath;

        public sendRequest(String urlPath) {
            this.urlPath = urlPath;
        }

        @Override
        protected Void doInBackground(ResponseCallback... responseCallback) {


            RequestType requestType = getRequestMethodForUrlPath(urlPath);

            if(requestType == null){
                responseCallback[0].onResponse(null, NetworkErrors.INVALID_REQUEST_TYPE.getException());
                return null;
            }



            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("text/plain");
            Request request = new Request.Builder()
                    .url(urlPath)
                    .method("GET", null)
                    .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8")
                    .addHeader("Accept-Language", "en-US,en;q=0.8")
                    .addHeader("Cache-Control", "no-cache")
                    .build();

            try {
                Response response = client.newCall(request).execute();
                if (response.body() != null) {
                    String responseBody = response.body().string();
                    responseCallback[0].onResponse(responseBody, null);
                } else {
                    throw new Exception("Empty html body.");
                }
                response.close();
            } catch (Exception e) {
                responseCallback[0].onResponse(null, e);
                e.printStackTrace();
            }

            return null;
        }
    }


    // Helper method to get RequestType
    private static RequestType getRequestMethodForUrlPath(String path)  {

        switch (path) {
            case UPLOAD_FILE_PATH:
                return RequestType.POST;
            case HELLO_PATH:
                return RequestType.GET;
            default:
                return null;
        }

    }


    private enum RequestType {
        POST("POST"),
        GET("GET");

        private final String label;

        RequestType(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

}
