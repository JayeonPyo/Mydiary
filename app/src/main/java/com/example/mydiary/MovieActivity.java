package com.example.mydiary;

import android.app.ProgressDialog;
import android.graphics.Movie;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

    public class MovieActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private MyRecyclerViewAdapter adapter;
    ArrayList<Data> dataList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_activity);

       // recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        dataList = new ArrayList<Data>();


        recyclerView = (RecyclerView)findViewById(R.id.recycler_view1);
        recyclerView.setLayoutManager(new GridLayoutManager(MovieActivity.this, 2));

        MyAsyncTask mAsyncTask = new MyAsyncTask();
        mAsyncTask.execute();



        //LayoutManager
     //   recyclerView.setLayoutManager(new GridLayoutManager(MovieActivity.this, 2));
    }





//execute( ) 명령어를 통해 AsyncTask을 실행합니다.


   // AsyncTask로 백그라운드 작업을 실행하기 전에 onPreExcuted( )실행됩니다. 이 부분에는 이미지 로딩 작업이라면 로딩 중 이미지를 띄워 놓기 등, 스레드 작업 이전에 수행할 동작을 구현합니다.


   // 새로 만든 스레드에서 백그라운드 작업을 수행합니다. execute( ) 메소드를 호출할 때 사용된 파라미터를  전달 받습니다.




    public class MyAsyncTask extends AsyncTask<String, Void, Data[]> {

//첫번째 인자는 doinground 메소드에 선언하는 매개변수의 타입 지정
        //두번째 인자는 onprogressupdate 메소드에 선언하는 가변인수 매겨변수의 타입을 정함
        //세번째 인자는 onpostexecute 메소드에 선언하는 매개변수의 타입을 정함



        ProgressDialog progressDialog = new ProgressDialog(MovieActivity.this);

        //네트워크 통신 전 셋팅해야 할 것들을 위의 메소드 공간에 작성
       @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage("\t로딩중...");

           progressDialog.show();
        }

        //스레드로 일처리를 해주는 곳
        //json을 사용해서 Api를 가져오기
        @Override
        protected Data[] doInBackground(String... strings) {

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json?key=451f608c5da2b0f5abd1cc0fc9a9cd2a")
                    .build();
            try {
                Response response = client.newCall(request).execute();

                //gson을 이용 json을 자바 객체로 전환하기기
                Gson gson= new GsonBuilder().create();
                JsonParser parser = new JsonParser();
                JsonElement rootObject = parser.parse(response.body().charStream())
                        .getAsJsonObject().get("results");
                Data[] posts = gson.fromJson(rootObject, Data[].class);
                return posts;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        //스레드가 일을 끝 마치고 리턴 값으로 result를 넘겨준다.

        @Override
        protected void onPostExecute(Data[] result) {
            super.onPostExecute(result);
            progressDialog.dismiss();

           // Data[] d = {
                //    new Data("제목","ㅇㅇ","/adw6Lq9FiC9zjYEpOqfq03ituwp.jpg","A ticking-time-bomb insomniac and a slippery soap salesman channel primal male aggression into a shocking new form of therapy. Their concept catches on, with underground \"fight clubs\" forming in every town, until an eccentric gets in the way and ignites an out-of-control spiral toward oblivion."
               //     ,"/mMZRKb3NVo5ZeSPEIaNW9buLWQ0.jpg","1999-10-15")
          //  };


            //arrylist 차례대로 넣기기
         /*    if(result.length > 0)
          for(Data p : result){
              dataList.add(p);



               }*/







            //Adapter setting 해주기
            adapter = new MyRecyclerViewAdapter(MovieActivity.this,dataList);
            recyclerView.setAdapter(adapter);



        }

    }



}
