package chaoyang.bawei.com.chaoyang0218.utils;



import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class MyOkHttp implements Interceptor {
    private android.os.Handler handler=new android.os.Handler();
    private static final byte[] LOCK =new byte[0] ;
    private getRe getRe;
    static MyOkHttp myOkHttp;
    public static MyOkHttp setmyOkHttp(){
        if (myOkHttp==null){
            synchronized (LOCK){
            myOkHttp=new MyOkHttp();
            }
        }
        return myOkHttp;
    }
    HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            Log.i("日志拦截", "log: "+message);
        }


    });

    public void postHttp(String page, String url) {
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
         OkHttpClient httpClient= new OkHttpClient.Builder()
                 .addInterceptor(loggingInterceptor)
                 .build();
        RequestBody page1 = new FormBody.Builder()
                .add("page", page)
                .build();
        final Request requestBody = new Request.Builder()
                .url(url)
                .get()
                .build();
        httpClient.newCall(requestBody).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String s = response.body().string();
                if (response.isSuccessful()){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            getRe.getresponse(s);
                    }
                    });
                }else{

                }

            }
        });
    }
    public static void geiHttp(String url){
        Request().Builder() buider= new Request().Builder();
    }
    private void onSucces() {

    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        return null;
    }

    public interface getRe {
        void getresponse(String t);
    }
}
