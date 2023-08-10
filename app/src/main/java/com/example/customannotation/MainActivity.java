package com.example.customannotation;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import annotation.SearchAnnotationManager;
import annotation.SearchEnum;
import callback.OnSearchCallBack;
import utils.FragmentUtils;

public class MainActivity extends AppCompatActivity implements OnSearchCallBack {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DefaultFragment defaultFragment = new DefaultFragment();
        FragmentUtils.addFragment(true, getSupportFragmentManager(), defaultFragment, R.id.fragment);
        ImageView ivBack = findViewById(R.id.iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FragmentUtils.getTopShowFragment(getSupportFragmentManager()) instanceof DefaultFragment) {
                    finish();
                } else {
                    FragmentUtils.hideAllShowFragment(true, defaultFragment, getSupportFragmentManager());
                }
            }
        });
    }

    @Override
    public void onModuleChanged(String type) {
        //根据type获取到对应的class
        SearchEnum searchEnum = SearchAnnotationManager.getInstance().getSearchEnum(type);
        if (searchEnum != null) {
            try {
                Fragment fragment = FragmentUtils.findFragment(getSupportFragmentManager(), searchEnum.getClazz());
                if (fragment == null) {
                    fragment = (Fragment) searchEnum.getClazz().newInstance();
                    FragmentUtils.addFragment(true, getSupportFragmentManager(), fragment, R.id.fragment);
                }
                FragmentUtils.hideAllShowFragment(true, fragment, getSupportFragmentManager());
            } catch (IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
}