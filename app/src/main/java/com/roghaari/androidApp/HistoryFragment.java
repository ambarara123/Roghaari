package com.roghaari.androidApp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.*;
import com.roghaari.R;

import java.util.ArrayList;
import java.util.List;
import java.lang.*;

public class HistoryFragment extends Fragment {
    com.roghaari.androidApp.recyclerAdapter adapter;

    String[] string={"1","2","3"};

    public HistoryFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Abhishek


     /*    RecyclerView rv = new RecyclerView(getContext());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(new recyclerAdapter(string));*/
        View rootView=inflater.inflate(R.layout.fragment_history,container,false);
        RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.history_recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        adapter = new recyclerAdapter(getContext(),string);

        recyclerView.setAdapter(adapter);
        /// Inflate the layout for this fragment
        return rootView;
    }



}
