package com.roghaari.androidApp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.roghaari.R;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

public class DashboardFragment extends Fragment implements View.OnClickListener {
    private static TextView personName;
    private static View view;
    private static Button logOut;
    private static SlidingUpPanelLayout slidingUpPanelLayout;

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //personName.setText("ambar");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.main_screen, container, false);
        personName = (TextView) view.findViewById(R.id.personName);
        logOut = (Button) view.findViewById(R.id.logOut);
        slidingUpPanelLayout = (SlidingUpPanelLayout) view.findViewById(R.id.sliding_layout);
        personName.setText("ambar");
        logOut.setOnClickListener(this);

        slidingUpPanelLayout.setScrollableViewHelper(new NestedScrollableViewHelper());

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.logOut:
               // finish();

                SharedPrefManager.getInstance(getContext()).logout();
                break;

        }
    }

}
