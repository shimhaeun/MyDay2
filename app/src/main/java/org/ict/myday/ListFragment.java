package org.ict.myday;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class ListFragment extends Fragment {

    RecyclerView listRecycler;
    RecyclerView.Adapter lAdapter;
    LinearLayoutManager manager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_list, container, false);

        initView(rootView);
        setRecycler();

        return rootView;
    }

    public void initView(View v){
        listRecycler = (RecyclerView) listRecycler.findViewById(R.id.listRecycler);
    }

    private void setRecycler(){
        manager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        lAdapter = new ListAdapter();
        listRecycler.setLayoutManager(manager);
        listRecycler.setAdapter(lAdapter);
    }


}