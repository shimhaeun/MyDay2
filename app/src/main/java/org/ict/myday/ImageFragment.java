package org.ict.myday;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class ImageFragment extends Fragment {

    private RecyclerView imageRecycler;
    private RecyclerView.Adapter mAdapter;
    private StaggeredGridLayoutManager manager;
    public ArrayList<Object> mImageList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate
                (R.layout.fragment_image, container, false);

        initView(rootView);

        setRecycler();

        return rootView;

    }

    public void initView(View v){
        imageRecycler = (RecyclerView)v.findViewById(R.id.imageRecycler);
    }

    private void setRecycler(){
        manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        mAdapter = new ImgTabAdapter(mImageList);

        imageRecycler.setLayoutManager(manager);
        imageRecycler.setAdapter(mAdapter);
    }
}