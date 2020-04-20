package com.example.c0772144_w2020_mad3125_fp.komal.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0772144_w2020_mad3125_fp.R;
import com.example.c0772144_w2020_mad3125_fp.komal.Model.Bill;

import java.util.ArrayList;

public class ShowBillDetailActivity extends AppCompatActivity {
    private RecyclerView rvBillsList;
    public static ArrayList<Bill> billsArrayListDetail = new ArrayList<>();
    private BillsAdapter billsAdapter;
    private ImageView imgAddButton;
    private TextView txtTotalAmountValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bill_details);

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setTitle("Bills");

        Intent mIntent = getIntent();
        Customer customerObj = mIntent.getParcelableExtra("CustomerBills");
        billsArrayListDetail = customerObj.getBills();

        txtTotalAmountValue = findViewById(R.id.txtTotalAmountValue);

        if(!billsArrayListDetail.isEmpty())
        {
            txtTotalAmountValue.setText("TOTAL " + ExtensionValidation.getInstance().doubleFormatter(customerObj.getTotalAmount()));
        }


        rvBillsList = findViewById(R.id.rvBillsList);
        billsAdapter = new BillsAdapter(this.billsArrayListDetail);

        RecyclerView.LayoutManager mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        billsAdapter.notifyDataSetChanged();
        rvBillsList.setLayoutManager(mLinearLayoutManager);
        rvBillsList.setAdapter(billsAdapter);

        imgAddButton = findViewById(R.id.imgAddBill);
        imgAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(ShowBillDetailActivity.this, AddNewBillActivity.class);
                mIntent.putExtra("CustomerBills2", customerObj);
                startActivity(mIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_customerlist, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuAdd:
                Intent addBill = new Intent(ShowBillDetailsActivity.this, AddNewBillActivity.class);
                startActivity(addBill);
                break;
            case R.id.mnuLogout:
                Intent logoutIntent = new Intent(ShowBillDetailsActivity.this, LoginActivity.class);
                startActivity(logoutIntent);
                break;
            case R.id.mnuAbout:
                Intent aboutIntent = new Intent(ShowBillDetailsActivity.this, AboutActivity.class);
                startActivity(aboutIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public ArrayList<Bill> getBillsArrayList()
    {
        return this.billsArrayListDetail;
    }
}
