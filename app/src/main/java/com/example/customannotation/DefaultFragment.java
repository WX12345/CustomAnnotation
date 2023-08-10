package com.example.customannotation;

import android.content.Context;
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
import callback.OnSearchCallBack;

@Search(searchenum = SearchEnum.DEFAULT)
public class DefaultFragment extends Fragment {
    //是否渲染完毕
    public boolean isLoaded = false;
    private TextView tv_pyq;
    private TextView tv_gzh;
    private TextView tv_xcx;
    private TextView tv_sph;
    private OnSearchCallBack onSearchCallBack;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnSearchCallBack) {
            onSearchCallBack = (OnSearchCallBack) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_default, container, false);
        tv_pyq = view.findViewById(R.id.tv_pyq);
        tv_gzh = view.findViewById(R.id.tv_gzh);
        tv_xcx = view.findViewById(R.id.tv_xcx);
        tv_sph = view.findViewById(R.id.tv_sph);
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
        tv_pyq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onSearchCallBack != null) {
                    onSearchCallBack.onModuleChanged(SearchConstant.PYQ);
                }
            }
        });
        tv_gzh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onSearchCallBack != null) {
                    onSearchCallBack.onModuleChanged(SearchConstant.GZH);
                }
            }
        });
        tv_xcx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onSearchCallBack != null) {
                    onSearchCallBack.onModuleChanged(SearchConstant.XCX);
                }
            }
        });
        tv_sph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onSearchCallBack != null) {
                    onSearchCallBack.onModuleChanged(SearchConstant.SPH);
                }
            }
        });
    }
}
