package chaoyang.bawei.com.chaoyang0218.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import chaoyang.bawei.com.chaoyang0218.R;
import chaoyang.bawei.com.chaoyang0218.utils.MyOkHttp;
import chaoyang.bawei.com.chaoyang0218.view.RVAdapter;

public class MainActivity extends AppCompatActivity  {

    private RecyclerView re_view;
    private List<String> list=new ArrayList<>();
    private RVAdapter adapter;
    .;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        re_view = findViewById(R.id.re_view);
        for (int i=0;i<20;i++){
            list.add("这是"+i);
        };
        adapter = new RVAdapter(this);
        //re_view.setAdapter(adapter);

        MyOkHttp myOkHttp. = new MyOkHttp();
        myOkHttp.getHttp("1","http://365jia.cn/news/api3/365jia/news/headline?page=");
    }
}
