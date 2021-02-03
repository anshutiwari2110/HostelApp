package com.anshutiwari.hostelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MeowBottomNavigation mButtomNav;
    private static final int ID_HOME=1;
    private static final int ID_MESS=2;
    private static final int ID_COMPLAINT=3;
    private static final int ID_BED=4;
    private static final int ID_BOOK=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtomNav = (MeowBottomNavigation) findViewById(R.id.btm_nav);

        mButtomNav.add(new MeowBottomNavigation.Model(1,R.drawable.ic_menu));
        mButtomNav.add(new MeowBottomNavigation.Model(2,R.drawable.ic_mess));
        mButtomNav.add(new MeowBottomNavigation.Model(3,R.drawable.ic_complaint));
        mButtomNav.add(new MeowBottomNavigation.Model(4,R.drawable.ic_bed));
        mButtomNav.add(new MeowBottomNavigation.Model(5,R.drawable.ic_book));

        mButtomNav.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                // Toast.makeText(getApplicationContext(),"clicked item"+item.getId(),Toast.LENGTH_LONG).show();
            }
        });
        mButtomNav.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {

                switch (item.getId()){
                    case ID_HOME:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment_container,new HomeActivity()).commit();
                        break;
                    case ID_MESS:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment_container,new MessActivity()).commit();
                        break;
                    case ID_COMPLAINT:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment_container,new ComplaintActivity()).commit();
                        break;
                    case ID_BED:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment_container,new RoomActivity()).commit();
                        break;
                    case ID_BOOK:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment_container,new NotesActivity()).commit();
                        break;
                    default:
                        Toast.makeText(MainActivity.this,"icon clicked",Toast.LENGTH_LONG).show();
                        break;
                }

            }
        });
        mButtomNav.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {

            }
        });


        getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment_container,new HomeActivity()).commit();

    }
}