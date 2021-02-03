package com.anshutiwari.hostelapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_home,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageSlider imageSlider = view.findViewById(R.id.slider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.cet_logo," "));
        slideModels.add(new SlideModel(R.drawable.cet_logo," "));
        slideModels.add(new SlideModel(R.drawable.cet_logo," "));
        slideModels.add(new SlideModel(R.drawable.cet_logo," "));
        imageSlider.setImageList(slideModels,true);

        Button num1 = view.findViewById(R.id.iv_call_one);
        Button num2 = view.findViewById(R.id.iv_call_two);
        Button num3 = view.findViewById(R.id.iv_call_three);

        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                docallNumber("6371053812");
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                docallNumber("6371053812");
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                docallNumber("6371053812");
            }
        });

        Button mail1 = view.findViewById(R.id.image2);
        Button mail2 = view.findViewById(R.id.image21);
        Button mail3 = view.findViewById(R.id.image22);

        mail1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dosendMail("dineshsahu003@gmail.com");
            }
        });
        mail2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dosendMail("dineshsahu003@gmail.com");
            }
        });
        mail3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dosendMail("dineshsahu003@gmail.com");
            }
        });
        


    }
    private void docallNumber(String number ){
        String phoneNumber = "tel:" + number;
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse(phoneNumber));
        startActivity(callIntent);
    }
    private void dosendMail(String email){
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("mailto:"+ email));
        startActivity(intent);
    }
}