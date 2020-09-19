package com.example.minchelin;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class home extends Fragment implements View.OnClickListener{
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container, false);
        ImageButton koreanFood = view.findViewById(R.id.koreanFood);
        ImageButton westernFood = view.findViewById(R.id.westernFood);
        ImageButton chineseFood = view.findViewById(R.id.chineseFood);
        ImageButton japanFood = view.findViewById(R.id.japanFood);
        ImageButton cafe = view.findViewById(R.id.cafe);
        ImageButton etc = view.findViewById(R.id.etc);

        koreanFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RestaurantList.class);
                intent.putExtra("선택", "one");
                startActivity(intent);
            }
        });

        westernFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RestaurantList.class);
                intent.putExtra("선택", "two");
                startActivity(intent);
            }
        });

        chineseFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RestaurantList.class);
                intent.putExtra("선택", "three");
                startActivity(intent);
            }
        });

        japanFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RestaurantList.class);
                intent.putExtra("선택", "four");
                startActivity(intent);
            }
        });

        cafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RestaurantList.class);
                intent.putExtra("선택", "five");
                startActivity(intent);
            }
        });

        etc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RestaurantList.class);
                intent.putExtra("선택", "six");
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), RestaurantList.class);
        startActivity(intent);
    }

}
