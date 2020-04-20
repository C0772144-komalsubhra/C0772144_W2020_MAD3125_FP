package com.example.c0772144_w2020_mad3125_fp.komal.Activities;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.c0772144_w2020_mad3125_fp.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Calendar;

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
        ArrayList<String> billType = new ArrayList<>();
        billType.add("MOBILE");
        billType.add("HYDRO");
        billType.add("INTERNET");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, billType);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnBillType.setAdapter(dataAdapter);

        spnBillType.setOnItemSelectedListener(this);


        addingDatePicker();
    }
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
            ((TextView) parent.getChildAt(0)).setTextSize(18);
            ((TextView) parent.getChildAt(0)).setTypeface(null, Typeface.BOLD);

            if(position == 0)
            {
                initFields();
                clearfields();
                edtUnitsUsed.setVisibility(View.INVISIBLE);
                edtAgencyName.setVisibility(View.INVISIBLE);
                btnBillAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean someFlag = false;
                        if(edtBillIdText.getText().toString().isEmpty())
                        {
                            edtBillIdText.setError("Please enter the bill ID");
                            someFlag = true;
                            return;
                        }
                        if(edtBillDateText.getText().toString().isEmpty()){
                            edtBillDateText.setError("Please enter your the bill text");
                            someFlag = true;
                            return;
                        }
                        if(edtNumberText.getText().toString().isEmpty())
                        {
                            edtNumberText.setError("Please enter your phone number");
                            someFlag = true;
                            return;
                        }
                        if(edtDataUsedText.getText().toString().isEmpty())
                        {
                            edtDataUsedText.setError("Please enter the data used");
                            someFlag = true;
                            return;
                        }
                        if(edtMinsUsedText.getText().toString().isEmpty())
                        {
                            edtMinsUsedText.setError("Please enter the mins used");
                            someFlag = true;
                            return;
                        }
                        if(edtManufacNameText.getText().toString().isEmpty())
                        {
                            edtManufacNameText.setError("Please enter the manufacturer");
                            someFlag = true;
                            return;
                        }
                        if(edtPlanNameText.getText().toString().isEmpty())
                        {
                            edtPlanNameText.setError("Please enter your plan name");
                            someFlag = true;
                            return;
                        }
                        if(!ExtensionValidation.getInstance().mobileValidation(edtNumberText.getText().toString()))
                        {
                            edtNumberText.setError("Invalid Phone number");
                            new MaterialAlertDialogBuilder(AddNewBillActivity.this)
                                    .setTitle("Invalid phone number")
                                    .setMessage("Please check the phonenumber you entered")
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                            someFlag = true;
                            return;
                        }
                        if (!someFlag)
                        {
                            Mobile mObj = new Mobile(edtBillIdText.getText().toString(),
                                    ExtensionValidation.getInstance().stringToDate(edtBillDateText.getText().toString()),
                                    Bill.BillType.Mobile,
                                    edtManufacNameText.getText().toString(),
                                    edtPlanNameText.getText().toString(),
                                    edtNumberText.getText().toString(),
                                    Integer.parseInt(edtDataUsedText.getText().toString()),
                                    Integer.parseInt(edtMinsUsedText.getText().toString()));
                            customerObj2.getCustomerBills().put(mObj.getBillId(), mObj);
                            Intent mIntent = new Intent(AddNewBillActivity.this, ShowBillDetailsActivity.class);
                            mIntent.putExtra("CustomerBills", customerObj2);
                            startActivity(mIntent);
                        }
                    }
                });
            }

            if(position == 1)
            {
                hidefields();
                clearfields();
                edtUnitsUsed.setVisibility(View.VISIBLE);
                edtAgencyName.setVisibility(View.VISIBLE);
                edtAgencyName.setHint("ENTER AGENCY NAME");
                edtUnitsUsed.setHint("ENTER UNITS USED");
                btnBillAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean someFlag = false;
                        if(edtBillIdText.getText().toString().isEmpty())
                        {
                            edtBillIdText.setError("Please enter the bill ID");
                            someFlag = true;
                            return;
                        }
                        if(edtBillDateText.getText().toString().isEmpty()){
                            edtBillDateText.setError("Please enter your the bill text");
                            someFlag = true;
                            return
                        }
                        if(edtAgencyNameText.getText().toString().isEmpty())
                        {
                            edtNumberText.setError("Please enter the agency");
                            someFlag = true;
                            return;
                        }
                        if(edtUnitsUsedText.getText().toString().isEmpty())
                        {
                            edtDataUsedText.setError("Please enter the units used");
                            someFlag = true;
                            return;
                        }
                        if(!edtBillIdText.getText().toString().contains("HY"))
                        {
                            new MaterialAlertDialogBuilder(AddNewBillActivity.this)
                                    .setTitle("Invalid bill ID")
                                    .setMessage("Hydro bill IDs must contain HY")
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                            someFlag = true;
                            return;
                        }
                        if(!someFlag) {
                            Hydro hObj = new Hydro(edtBillIdText.getText().toString(),
                                    ExtensionValidation.getInstance().stringToDate(edtBillDateText.getText().toString()),
                                    Bill.BillType.Hydro,
                                    edtAgencyNameText.getText().toString(),
                                    Integer.parseInt(edtUnitsUsedText.getText().toString()));
                            customerObj2.getCustomerBills().put(hObj.getBillId(), hObj);
                            Intent mIntent = new Intent(AddNewBillActivity.this, ShowBillDetailsActivity.class);
                            mIntent.putExtra("CustomerBills", customerObj2);
                            startActivity(mIntent);
                        }
                    }
                });


            if(position == 2)
            {
                hidefields();
                clearfields();
                edtUnitsUsed.setVisibility(View.VISIBLE);
                edtAgencyName.setVisibility(View.VISIBLE);
                edtAgencyName.setHint("ENTER PROVIDER NAME");
                edtUnitsUsed.setHint("ENTER DATA USED");
                btnBillAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean someFlag = false;
                        if(edtBillIdText.getText().toString().isEmpty())
                        {
                            edtBillIdText.setError("Please enter the bill ID");
                            someFlag = true;
                            return;
                        }
                        if(edtBillDateText.getText().toString().isEmpty()){
                            edtBillDateText.setError("Please enter your the bill text");
                            someFlag = true;
                            return;
                        }
                        if(edtAgencyNameText.getText().toString().isEmpty())
                        {
                            edtNumberText.setError("Please enter the provider");
                            someFlag = true;
                            return;
                        }
                        if(edtUnitsUsedText.getText().toString().isEmpty())
                        {
                            edtDataUsedText.setError("Please enter the data used");
                            someFlag = true;
                            return;
                        }
                        if(!edtBillIdText.getText().toString().contains("IN"))
                        {
                            new MaterialAlertDialogBuilder(AddNewBillActivity.this)
                                    .setTitle("Invalid bill ID")
                                    .setMessage("Hydro bill IDs must contain IN")
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                            someFlag = true;
                            return;
                        }
                        Internet iObj = new Internet   (edtBillIdText.getText().toString(),
                                ExtensionValidation.getInstance().stringToDate(edtBillDateText.getText().toString()),
                                Bill.BillType.Hydro,
                                edtAgencyNameText.getText().toString(),
                                Double.parseDouble(edtUnitsUsedText.getText().toString()));
                        customerObj2.getCustomerBills().put(iObj.getBillId(),iObj);
                        Intent mIntent = new Intent(AddNewBillActivity.this, ShowBillDetailsActivity.class);
                        mIntent.putExtra("CustomerBills", customerObj2);
                        startActivity(mIntent);
                    }
                });
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }

        private void addingDatePicker()
        {
            edtBillDateText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Calendar cal = Calendar.getInstance();
                    int year = cal.get(Calendar.YEAR);
                    int month = cal.get(Calendar.MONTH);
                    int day = cal.get(Calendar.DAY_OF_MONTH);

                    DatePickerDialog dialog = new DatePickerDialog(
                            AddNewBillActivity.this,
                            android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                            mDateSetListener,
                            year, month, day);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.show();
                }
            });

            mDateSetListener = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day)
                {
                    String date ="";
                    month = month + 1;
                    String monthName = getMonthName(month);
                    if(day<10) {
                        date = "0"+day + "-" + monthName + "-" + year;
                    }
                    else
                    {
                        date = day + "-" + monthName + "-" + year;
                    }
                    edtBillDateText.setText(date);
                }
            };
        }

        public static String getMonthName(int monthNumber){
            String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};
            return monthNames[monthNumber-1];
        }
        public void initFields()
        {
            edtMinsUsed.setVisibility(View.VISIBLE);
            edtNumber.setVisibility(View.VISIBLE);
            edtDataUsed.setVisibility(View.VISIBLE);
            edtMinsUsed.setVisibility(View.VISIBLE);
            edtPlanName.setVisibility(View.VISIBLE);
            edtManufacName.setVisibility(View.VISIBLE);
        }
        public void hidefields()
        {
            edtMinsUsed.setVisibility(View.INVISIBLE);
            edtNumber.setVisibility(View.INVISIBLE);
            edtDataUsed.setVisibility(View.INVISIBLE);
            edtMinsUsed.setVisibility(View.INVISIBLE);
            edtPlanName.setVisibility(View.INVISIBLE);
            edtManufacName.setVisibility(View.INVISIBLE);
        }

        public void clearfields()
        {
            edtNumberText.getText().clear();
            edtDataUsedText.getText().clear();
            edtMinsUsedText.getText().clear();
            edtPlanNameText.getText().clear();
            edtManufacNameText.getText().clear();
            edtBillDateText.getText().clear();
            edtBillIdText.getText().clear();
            edtAgencyNameText.getText().clear();
            edtDataUsedText.getText().clear();
            edtUnitsUsedText.getText().clear();
        }
}
