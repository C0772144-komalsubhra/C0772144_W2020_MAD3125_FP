package com.example.c0772144_w2020_mad3125_fp.komal.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.c0772144_w2020_mad3125_fp.R;
import com.example.c0772144_w2020_mad3125_fp.komal.ModelClasses.Bill;

public class HydroBillsFragment extends Fragment {

    Bill fragBillObj;

    public HydroBillsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle bundle = new Bundle();
        fragBillObj = (Bill) bundle.getSerializable("billDetailsObj2");
        Toast.makeText(getActivity(), "Sorry boy, still hydro null", Toast.LENGTH_SHORT).show();

        return inflater.inflate(R.layout.fragment_hydro, container, true);
    }
}

