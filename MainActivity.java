package riaz.example.com.newzapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import riaz.example.com.newzapp.Adapter.RecyclerNewzAdapter;
import riaz.example.com.newzapp.Objects.ArticlesDetails;
import riaz.example.com.newzapp.Objects.NewzDetailsObj;

public class MainActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    ApiInterface apiService;
    RecyclerView newz_recycler;
    ArrayList<ArticlesDetails> article_arr;
    RecyclerNewzAdapter adapter;
    Button mtv,espn,google;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newz_recycler= (RecyclerView) findViewById(R.id.newz_recycler);

        mtv= (Button) findViewById(R.id.mtv);
        espn= (Button) findViewById(R.id.espn);
        google= (Button) findViewById(R.id.google_newz);

        newz_recycler.setHasFixedSize(true);
        newz_recycler.setLayoutManager(new LinearLayoutManager(this));

        article_arr=new ArrayList<>();

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);

        adapter=new RecyclerNewzAdapter(article_arr,getApplicationContext());
        newz_recycler.setAdapter(adapter);

        apiService=ApiClient.getClient().create(ApiInterface.class);

        Call<NewzDetailsObj> call=apiService.getNewzDetails("bbc-news","top","c558563e7d184d5d9d1c458d01ef31b4");//  abc-news-au

        progressDialog.show();

        call.enqueue(new Callback<NewzDetailsObj>() {
            @Override
            public void onResponse(Call<NewzDetailsObj> call, Response<NewzDetailsObj> response) {

                if (response.isSuccessful()){
                    if (response.body().getStatus().equals("ok")){

                        article_arr.clear();

                        for (int i=0;i<response.body().getArticles().size();i++) {
                            article_arr.add(new ArticlesDetails(response.body().getArticles().get(i).getAuthor(),
                                            response.body().getArticles().get(i).getTitle(),
                                            response.body().getArticles().get(i).getDescription(),
                                            response.body().getArticles().get(i).getUrl(),
                                            response.body().getArticles().get(i).getUrlToImage(),
                                            response.body().getArticles().get(i).getPublishedAt()
                                            ));
                        }
                        adapter.notifyDataSetChanged();

                        progressDialog.dismiss();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Please Try again !", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "No Newz Updates for now", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<NewzDetailsObj> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Failed...Please Try again !", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });

        mtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<NewzDetailsObj> call=apiService.getNewzDetails("mtv-news","top","c558563e7d184d5d9d1c458d01ef31b4");//  abc-news-au

                progressDialog.show();

                call.enqueue(new Callback<NewzDetailsObj>() {
                    @Override
                    public void onResponse(Call<NewzDetailsObj> call, Response<NewzDetailsObj> response) {

                        if (response.isSuccessful()){
                            if (response.body().getStatus().equals("ok")){

                                article_arr.clear();

                                for (int i=0;i<response.body().getArticles().size();i++) {
                                    article_arr.add(new ArticlesDetails(response.body().getArticles().get(i).getAuthor(),
                                            response.body().getArticles().get(i).getTitle(),
                                            response.body().getArticles().get(i).getDescription(),
                                            response.body().getArticles().get(i).getUrl(),
                                            response.body().getArticles().get(i).getUrlToImage(),
                                            response.body().getArticles().get(i).getPublishedAt()
                                    ));
                                }
                                adapter.notifyDataSetChanged();

                                progressDialog.dismiss();
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Please Try again !", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                        }
                        else {
                            Toast.makeText(MainActivity.this, "No Newz Updates for now", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<NewzDetailsObj> call, Throwable t) {

                        Toast.makeText(MainActivity.this, "Failed...Please Try again !", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                });

            }
        });

        espn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<NewzDetailsObj> call=apiService.getNewzDetails("espn","top","c558563e7d184d5d9d1c458d01ef31b4");//  abc-news-au

                progressDialog.show();

                call.enqueue(new Callback<NewzDetailsObj>() {
                    @Override
                    public void onResponse(Call<NewzDetailsObj> call, Response<NewzDetailsObj> response) {

                        if (response.isSuccessful()){
                            if (response.body().getStatus().equals("ok")){

                                article_arr.clear();

                                for (int i=0;i<response.body().getArticles().size();i++) {
                                    article_arr.add(new ArticlesDetails(response.body().getArticles().get(i).getAuthor(),
                                            response.body().getArticles().get(i).getTitle(),
                                            response.body().getArticles().get(i).getDescription(),
                                            response.body().getArticles().get(i).getUrl(),
                                            response.body().getArticles().get(i).getUrlToImage(),
                                            response.body().getArticles().get(i).getPublishedAt()
                                    ));
                                }
                                adapter.notifyDataSetChanged();

                                progressDialog.dismiss();
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Please Try again !", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                        }
                        else {
                            Toast.makeText(MainActivity.this, "No Newz Updates for now", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<NewzDetailsObj> call, Throwable t) {

                        Toast.makeText(MainActivity.this, "Failed...Please Try again !", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                });

            }
        });


        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<NewzDetailsObj> call=apiService.getNewzDetails("google-news","top","c558563e7d184d5d9d1c458d01ef31b4");//  abc-news-au

                progressDialog.show();

                call.enqueue(new Callback<NewzDetailsObj>() {
                    @Override
                    public void onResponse(Call<NewzDetailsObj> call, Response<NewzDetailsObj> response) {

                        if (response.isSuccessful()){
                            if (response.body().getStatus().equals("ok")){

                                article_arr.clear();

                                for (int i=0;i<response.body().getArticles().size();i++) {
                                    article_arr.add(new ArticlesDetails(response.body().getArticles().get(i).getAuthor(),
                                            response.body().getArticles().get(i).getTitle(),
                                            response.body().getArticles().get(i).getDescription(),
                                            response.body().getArticles().get(i).getUrl(),
                                            response.body().getArticles().get(i).getUrlToImage(),
                                            response.body().getArticles().get(i).getPublishedAt()
                                    ));
                                }
                                adapter.notifyDataSetChanged();

                                progressDialog.dismiss();
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Please Try again !", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                        }
                        else {
                            Toast.makeText(MainActivity.this, "No Newz Updates for now", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<NewzDetailsObj> call, Throwable t) {

                        Toast.makeText(MainActivity.this, "Failed...Please Try again !", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                });

            }
        });

    }
}
