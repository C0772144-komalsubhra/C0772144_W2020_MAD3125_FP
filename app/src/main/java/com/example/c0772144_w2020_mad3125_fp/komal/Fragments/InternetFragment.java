package com.example.c0772144_w2020_mad3125_fp.komal.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.c0772144_w2020_mad3125_fp.R;
import com.example.c0772144_w2020_mad3125_fp.komal.ModelClasses.Bill;

/**
 * A simple {@link Fragment} subclass.
 */
public class InternetFragment extends Fragment {

    Bill fragBillObj;
    public InternetFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle bundle = new Bundle();

        fragBillObj = (Bill) bundle.getSerializable("billDetailsObj3");

        return inflater.inflate(R.layout.fragment_internet, container, false);
    }
}
