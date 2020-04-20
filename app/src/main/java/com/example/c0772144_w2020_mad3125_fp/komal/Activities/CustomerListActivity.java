package com.example.c0772144_w2020_mad3125_fp.komal.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0772144_w2020_mad3125_fp.Customer;
import com.example.c0772144_w2020_mad3125_fp.DataInfo;
import com.example.c0772144_w2020_mad3125_fp.DataProvider;
import com.example.c0772144_w2020_mad3125_fp.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class CustomerListActivity extends AppCompatActivity {
    private RecyclerView rvCustomerList;
    private ArrayList customerArrayList;
    private ArrayList tempCustomerArrayList;
    private ArrayList<Customer> tempCustomerListArrayList;
    private CustomerAdapter customerAdapter;
    private ImageView barAddCustomer;
    private ImageView barLogout;

    @BindView(R.id.imgBtnAddCustomer)
    ImageButton ImgBtnAddCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        ButterKnife.bind(this);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        View view = getSupportActionBar().getCustomView();

        barAddCustomer = view.findViewById(R.id.barAddCustomer);
        barLogout = view.findViewById(R.id.barLogout);

        rvCustomerList = findViewById(R.id.rvCustomerList);

        barAddCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(CustomerListActivity.this, AddCustomerActivity.class);
                startActivity(mIntent);
            }
        });

        barLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(CustomerListActivity.this, LoginActivity.class);
                startActivity(mIntent);
            }
        });

        loadCustomers();
        //readJson();
        //customerAdapter = new CustomerAdapter(DataRepository.getInstance().getCustomerDataList());
        customerAdapter = new CustomerAdapter(customerArrayList);
        RecyclerView.LayoutManager mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rvCustomerList.setLayoutManager(mLinearLayoutManager);
        rvCustomerList.setAdapter(customerAdapter);

        ImgBtnAddCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(CustomerListActivity.this, AddCustomerActivity.class);
                startActivity(mIntent);
            }
        });
    }

    private void loadCustomers()
    {
        DataProvider.getInstance().loadData();
        customerArrayList = new ArrayList();
        HashMap<String, Customer> customerHashMap = DataInfo.getInstance().getCustomerMap();
        Collection<Customer> demoValues = customerHashMap.values();
        tempCustomerArrayList = new ArrayList<>(demoValues);
        customerArrayList.addAll(tempCustomerArrayList);
    }
}
