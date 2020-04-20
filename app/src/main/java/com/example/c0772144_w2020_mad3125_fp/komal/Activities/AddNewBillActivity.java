package com.example.c0772144_w2020_mad3125_fp.komal.Activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.c0772144_w2020_mad3125_fp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class AddNewBillActivity extends AppCompatActivity {
    @BindView(R.id.spnBillType)
    Spinner spnBillType;
    @BindView(R.id.edtBillId)
    TextInputLayout edtBillId;
    @BindView(R.id.edtBillIdText)
    TextInputEditText edtBillIdText;
    @BindView(R.id.edtNumber) TextInputLayout edtNumber;
    @BindView(R.id.edtNumberText) TextInputEditText edtNumberText;
    @BindView(R.id.edtBillDate) TextInputLayout edtBillDate;
    @BindView(R.id.edtBillDateText) TextInputEditText edtBillDateText;
    @BindView(R.id.edtDataUsed) TextInputLayout edtDataUsed;
    @BindView(R.id.edtDataUsedText) TextInputEditText edtDataUsedText;
    @BindView(R.id.edtMinsUsed) TextInputLayout edtMinsUsed;
    @BindView(R.id.edtMinsUsedText) TextInputEditText edtMinsUsedText;
    @BindView(R.id.edtManufacName) TextInputLayout edtManufacName;
    @BindView(R.id.edtManufacNameText) TextInputEditText edtManufacNameText;
    @BindView(R.id.edtPlanName) TextInputLayout edtPlanName;
    @BindView(R.id.edtPlanNameText) TextInputEditText edtPlanNameText;
    @BindView(R.id.edtUnitsUsed) TextInputLayout edtUnitsUsed;
    @BindView(R.id.edtUnitsUsedText) TextInputEditText edtUnitsUsedText;
    @BindView(R.id.edtAgencyName) TextInputLayout edtAgencyName;
    @BindView(R.id.edtAgencyNameText) TextInputEditText edtAgencyNameText;
    @BindView(R.id.btnBillAdd)
    Button btnBillAdd;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    Customer customerObj2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_bill);
        ButterKnife.bind(this);

        Intent mIntent = getIntent();
        customerObj2 = mIntent.getParcelableExtra("CustomerBills2");

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.hide();
}
