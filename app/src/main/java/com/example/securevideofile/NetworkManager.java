package com.example.securevideofile;

import android.os.AsyncTask;

import com.example.securevideofile.errors.NetworkErrors;
import com.example.securevideofile.network.NetworkCore;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

interface ResponseListener<T> {
    void onResponse(T data, Exception exception);

}


public class NetworkManager {

    private static final String BASE_URL = "http://192.168.56.1:9000/secureVideoFile/";

    public static final String RETRIEVE_FILE = "retrieve";
    public static final String UPLOAD_FILE_PATH = "uploadFileAndGetURL";
    public static final String HELLO_PATH = "hello";


    public static void testRequest(ResponseListener<String> responseListener) {


        new NetworkCore.sendRequest(HELLO_PATH).execute((jsonResponse, exception) -> {

            if (exception != null) {
                responseListener.onResponse(null, exception);
            }


            try {
                responseListener.onResponse((String) jsonResponse, exception);
            } catch (Exception ignored) {
                responseListener.onResponse(null, new Exception("TEST REQUEST EXCEPTION"));
            }


        });

    }


}
