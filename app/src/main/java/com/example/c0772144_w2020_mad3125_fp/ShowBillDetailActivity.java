package com.example.c0772144_w2020_mad3125_fp;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShowBillDetailActivity extends AppCompatActivity {
    private RecyclerView rvBillsList;
    public static ArrayList<Bill> billsArrayListDetail = new ArrayList<>();
    private BillsAdapter billsAdapter;
    private ImageView imgAddButton;
    private TextView txtTotalAmountValue;
}
