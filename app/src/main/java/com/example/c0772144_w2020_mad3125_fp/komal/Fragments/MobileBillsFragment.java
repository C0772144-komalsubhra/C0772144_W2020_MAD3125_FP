package com.example.c0772144_w2020_mad3125_fp.komal.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.c0772144_w2020_mad3125_fp.R;
import com.example.c0772144_w2020_mad3125_fp.komal.ModelClasses.Bill;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MobileBillsFragment extends Fragment {

    @BindView(R.id.txtFragBillId) TextView txtFragBillId;
    @BindView(R.id.txtFragBillDate) TextView txtFragBillDate;
    @BindView(R.id.txtFragDataUsed) TextView txtFragDataUsed;
    @BindView(R.id.txtFragManufac) TextView txtFragManufac;
    @BindView(R.id.txtFragPlanName) TextView txtFragPlanName;
    @BindView(R.id.txtFragMinsUsed) TextView txtFragMinsUsed;
    @BindView(R.id.txtFragBillAmount) TextView txtFragBillAmount;
    private Bill fragBillObj;

    public MobileBillsFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        Bundle bundle = getArguments();
        fragBillObj = (Bill) bundle.getSerializable("billDetailsObj");


        View view = inflater.inflate(R.layout.fragment_mobile, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        Mobile m = DataRepository.getInstance().getMobileBill(fragBillObj.getBillId());
//        txtFragBillId.setText(m.getBillId());
    }
//        for(int i =0; i <bills.size(); i++)
//        {
//            if(bills.get(i).getBillId().contains("MB"))
//            {
//                txtBillId.setText(bills.get(i).getBillId());
//                imgBillType.setImageResource(R.drawable.mobileicon);
//                txtBillAmount.setText(HelperMethods.getInstance().doubleFormatter(bills.get(i).billCalculate()));
//                txtBillDate.setText(bills.get(i).getBillDate().toString());
//            }
//
//            if(bills.get(i).getBillId().contains("HY"))
//            {
//                txtBillId.setText(bills.get(i).getBillId());
//                imgBillType.setImageResource(R.drawable.watericon);
//                txtBillAmount.setText(HelperMethods.getInstance().doubleFormatter(bills.get(i).billCalculate()));
//                txtBillDate.setText(bills.get(i).getBillDate().toString());
//            }
//
//            if(bills.get(i).getBillId().contains("IN"))
//            {
//                txtBillId.setText(bills.get(i).getBillId());
//                imgBillType.setImageResource(R.drawable.interneticon);
//                txtBillAmount.setText(HelperMethods.getInstance().doubleFormatter(bills.get(i).billCalculate()));
//                txtBillDate.setText(bills.get(i).getBillDate().toString());
//            }
//        }
//        MainActivity mMainActivity = (MainActivity) getActivity();
//        mMainActivity.hello = "Hi From Fragment";

//        btnSubmit = view.findViewById(R.id.btnSubmit);
//        btnSubmit.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view)
//            {
//                Toast.makeText(getActivity(), "I am from RED Fragment", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
