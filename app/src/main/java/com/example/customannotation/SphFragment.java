package com.example.customannotation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import annotation.Search;
import annotation.SearchEnum;

@Search(searchenum = SearchEnum.SPH)
public class SphFragment extends Fragment {
    //是否渲染完毕
    public boolean isLoaded = false;
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        textView = view.findViewById(R.id.tv_text);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!isLoaded && !isHidden()) {
            init();
            isLoaded = true;
        }
    }

    private void init() {
        textView.setText("视频号");
    }
}
