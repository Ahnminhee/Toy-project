package com.example.minchelin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

public class RestaurantList extends AppCompatActivity {
    RecyclerView recyclerView;
    RestaurantAdapter adapter;
    String number;
    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);

        recyclerView = findViewById(R.id.recyclerView);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RestaurantAdapter();

        Intent intent = getIntent();
        number = intent.getExtras().getString("선택1");

        //Toast.makeText(getApplicationContext(), number + " 값을 받아옴", Toast.LENGTH_SHORT).show();

        Toast.makeText(getApplicationContext(),"num값 :" + num,Toast.LENGTH_SHORT).show();

        if(num == 1) {
            ListOne();
            //Toast.makeText(getApplicationContext(), "1번 호출", Toast.LENGTH_SHORT).show();
        }

        else if(num == 2) {
            ListTwo();
        }

        else if(num == 3) {
            ListThree();
        }

        else if(num == 4) {
            ListFour();
        }

        else if(num == 5) {
            ListFive();
        }

        else {
            ListOne();
        }

        recyclerView.setAdapter(adapter);
    }

    public void ListOne(){
        adapter.addItem(new Restaurant("본향", "063-858-1588",R.drawable.food1));
        adapter.addItem(new Restaurant("예지원", "063-835-1155", R.drawable.food2));
        adapter.addItem(new Restaurant("별미아구", "063-834-2286", R.drawable.food3));
        adapter.addItem(new Restaurant("동서네낙지", "063-854-1446", R.drawable.food4));
    }

    public void ListTwo() {
        adapter.addItem(new Restaurant("웰던", "063-837-8215",R.drawable.food5));
        adapter.addItem(new Restaurant("함지박레스토랑", "063-841-3211", R.drawable.food6));
        adapter.addItem(new Restaurant("갤러리인비노", "063-836-2588", R.drawable.food7));
        adapter.addItem(new Restaurant("리스토란테 콜리", "063-851-0300", R.drawable.food8));
    }

    public void ListThree() {
        adapter.addItem(new Restaurant("야미마라탕", "063-855-0507",R.drawable.food9));
        adapter.addItem(new Restaurant("소룡각", "063-837-9993", R.drawable.food10));
        adapter.addItem(new Restaurant("칭따오", "0507-0090-0730", R.drawable.food11));
        adapter.addItem(new Restaurant("국제향손짜장", "063-916-9611", R.drawable.food12));
    }

    public void ListFour() {
        adapter.addItem(new Restaurant("멘밥", "063-855-8304",R.drawable.food13));
        adapter.addItem(new Restaurant("초미당", "063-841-7679", R.drawable.food14));
        adapter.addItem(new Restaurant("요쿠야마치", "070-4388-2965", R.drawable.food15));
        adapter.addItem(new Restaurant("상무초밥", "063-833-9002", R.drawable.food16));
    }

    public void ListFive() {
        adapter.addItem(new Restaurant("메종", "010-8447-2118",R.drawable.food17));
        adapter.addItem(new Restaurant("아레라", "063-724-0001", R.drawable.food18));
        adapter.addItem(new Restaurant("카페사월", "010-5674-1745", R.drawable.food19));
        adapter.addItem(new Restaurant("빈타이", "063-918-4388", R.drawable.food20));
    }

    public void ListSix() {
        adapter.addItem(new Restaurant("떡두껍집", "010-8447-2118",R.drawable.food21));
        adapter.addItem(new Restaurant("호아빈", "063-724-0001", R.drawable.food22));
        adapter.addItem(new Restaurant("1989 india 커리", "0504-975-1258", R.drawable.food23));
        adapter.addItem(new Restaurant("고려당", "063-856-8373", R.drawable.food24));
    }
}
