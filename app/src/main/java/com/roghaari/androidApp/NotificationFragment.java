package com.roghaari.androidApp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.roghaari.R;

public class NotificationFragment extends Fragment {
    recyclerAdapter adapter2;
    String[] string={"1","2","3"};
    public NotificationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_notification,container,false);
        RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.notification_recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        adapter2 = new recyclerAdapter(getContext(),string);

        recyclerView.setAdapter(adapter2);
        /// Inflate the layout for this fragment
        return rootView;
    }

}
