package com.example.volleyexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.volleyexample.adapter.MusicAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    private RequestQueue requestQueue;
    private StringRequest stringRequest;
    private String url = "http://www.mocky.io/v2/5d21a0332f00002101c462d2";

    private ViewPager pager;
    private Button btn;

    private ArrayList<Music> musicList = new ArrayList<>();

    private MusicAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.pager);

//        btn = findViewById(R.id.btn1);
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                sendAndRequestResponse();
//            }
//        });

        setUpAdapter();

        sendAndRequestResponse();
    }

    private void setUpAdapter() {

        adapter = new MusicAdapter(getSupportFragmentManager(), musicList);

        pager.setAdapter(adapter);
    }

    private void sendAndRequestResponse(){

        requestQueue = Volley.newRequestQueue(this);

        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    JSONObject jsonObject1 = jsonObject.getJSONObject("feed");

                    parseResponseFromJson(jsonObject1);

                    adapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG, "Error :" + error.toString());
            }
        });

        requestQueue.add(stringRequest);
    }

    private void parseResponseFromJson(JSONObject jsonResponse) throws JSONException {
        JSONArray jsonResults = jsonResponse.getJSONArray("results");

        for (int i = 0; i < jsonResults.length(); i++) {
            JSONObject r = jsonResults.getJSONObject(i);

            String artistName = r.getString("artistName");
            String id = r.getString("id");
            String name = r.getString("name");
            String url = r.getString("artworkUrl100");

            Music music = new Music(artistName, id, name, url);

            musicList.add(music);
        }
    }
}
