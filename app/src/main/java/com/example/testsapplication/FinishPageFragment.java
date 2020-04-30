package com.example.testsapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class FinishPageFragment extends Fragment {


    public FinishPageFragment() {
        // Required empty public constructor
    }

    public static FinishPageFragment newInstance(String param1, String param2) {
        FinishPageFragment fragment = new FinishPageFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_finish_page, container, false);
    }
}
