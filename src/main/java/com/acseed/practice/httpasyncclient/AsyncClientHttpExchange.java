package com.acseed.practice.httpasyncclient;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.util.EntityUtils;

/**
 * Created by caohongchen on 17/1/13.
 */
public class AsyncClientHttpExchange {
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        CloseableHttpAsyncClient httpAsyncClient = HttpAsyncClients.createDefault();

        try {
            httpAsyncClient.start();
            HttpGet request = new HttpGet("http://www.baidu.com");
            Future<HttpResponse> future = httpAsyncClient.execute(request, null);
            HttpResponse response = future.get();
            System.out.println("Response: " + response.getStatusLine());
            System.out.println(EntityUtils.toString(response.getEntity(), "utf8"));
            System.out.println("Shutting down");
        } finally {
            httpAsyncClient.close();
        }
        System.out.println("Done");
    }
}
