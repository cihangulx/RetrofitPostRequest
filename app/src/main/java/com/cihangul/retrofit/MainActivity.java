package com.cihangul.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_view);
        button=(Button)findViewById(R.id.button);
        editText=(EditText)findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listele(editText.getText().toString());
            }
        });


    }

    public void listele(String isim){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://cihangul.com/android/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Connect connect = retrofit.create(Connect.class);
        Call<List<Kullanici>> call =connect.getKullanici(isim);
        call.enqueue(new Callback<List<Kullanici>>() {
            @Override
            public void onResponse(Call<List<Kullanici>> call, Response<List<Kullanici>> response) {

                if (response.code()==200){
                    List<Kullanici> kullaniciList =response.body();
                    ListAdapter listAdapter= new ListAdapter(kullaniciList,MainActivity.this);

                    listView.setAdapter(listAdapter);
                    listAdapter.notifyDataSetChanged();
                }


            }

            @Override
            public void onFailure(Call<List<Kullanici>> call, Throwable t) {

            }
        });
    }
}
