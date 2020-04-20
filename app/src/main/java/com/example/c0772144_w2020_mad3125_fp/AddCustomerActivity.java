package com.example.c0772144_w2020_mad3125_fp;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class AddCustomerActivity extends AppCompatActivity {
    @BindView(R.id.edtCustomerId)
    TextInputLayout edtCustomerId;
    @BindView(R.id.edtFirstName) TextInputLayout edtFirstName;
    @BindView(R.id.edtLastName) TextInputLayout edtLastName;
    @BindView(R.id.edtBirthDate) TextInputLayout edtBirthDate;
    @BindView(R.id.rdBtnMale)
    RadioButton rdBtnMale;
    @BindView(R.id.rdBtnFemale) RadioButton rdBtnFemale;
    @BindView(R.id.rdBtnOther) RadioButton rdBtnOther;
    @BindView(R.id.edtUsername) TextInputLayout edtUsername;
    @BindView(R.id.edtEmail) TextInputLayout edtEmail;
    @BindView(R.id.edtPassword) TextInputLayout edtPassword;
    @BindView(R.id.edtLocation) TextInputLayout edtLocation;

    @BindView(R.id.edtCustomerIdText)
    TextInputEditText edtCustomerIdText;
    @BindView(R.id.edtFirstNameText) TextInputEditText edtFirstNameText;
    @BindView(R.id.edtLastNameText) TextInputEditText edtLastNameText;
    @BindView(R.id.edtBirthDateText) TextInputEditText edtBirthDateText;
    @BindView(R.id.edtUsernameText) TextInputEditText edtUsernameText;
    @BindView(R.id.edtEmailText) TextInputEditText edtEmailText;
    @BindView(R.id.edtPasswordText) TextInputEditText edtPasswordText;
    @BindView(R.id.edtLocationText) TextInputEditText edtLocationText;

    @BindView(R.id.btnAdd)
    Button btnAdd;
    @BindView(R.id.btnClear) Button btnClear;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        ButterKnife.bind(this);

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.hide();

        addingDatePicker();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fieldChecker();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearfields();
            }
        });
    }

    private void addingDatePicker()
    {
        edtBirthDateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AddCustomerActivity.this,
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
                edtBirthDateText.setText(date);
            }
        };
    }

    public static String getMonthName(int monthNumber){
        String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};
        return monthNames[monthNumber-1];
    }

    public void fieldChecker()
    {
        boolean someFlag = false;
        if(edtCustomerIdText.getText().toString().isEmpty())
        {
            edtCustomerId.setError("Please enter your customer ID");
            someFlag = true;
            return;
        }
        if(edtFirstNameText.getText().toString().isEmpty()){
            edtFirstName.setError("Please enter your first name");
            someFlag = true;
            return;
        }
        if(edtLastNameText.getText().toString().isEmpty())
        {
            edtLastName.setError("Please enter your last name");
            someFlag = true;
            return;
        }
        if(edtBirthDateText.getText().toString().isEmpty())
        {
            edtBirthDate.setError("Please enter your date of birth");
            someFlag = true;
            return;
        }
        if(edtUsernameText.getText().toString().isEmpty())
        {
            edtUsername.setErrorEnabled(true);
            edtUsername.setError("Please enter your username");
            someFlag = true;
            return;
        }
        if(edtEmailText.getText().toString().isEmpty())
        {
            edtEmail.setError("Please enter your email");
            someFlag = true;
            return;
        }
        if(edtPasswordText.getText().toString().isEmpty())
        {
            edtPassword.setErrorEnabled(true);
            edtPassword.setError("Please enter your password");
            someFlag = true;
            return;
        }
        if(edtLocationText.getText().toString().isEmpty())
        {
            edtLocation.setError("Please enter your location");
            someFlag = true;
            return;
        }
        if(!HelperMethods.getInstance().emailValidation(edtEmailText.getText().toString()))
        {
            edtEmail.setError("Please enter a valid email address");
            new MaterialAlertDialogBuilder(AddCustomerActivity.this)
                    .setTitle("Invalid email address")
                    .setMessage("Please check the email you entered")
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
            Customer customer = new Customer(edtCustomerIdText.getText().toString(),
                    edtFirstNameText.getText().toString(),
                    edtLastNameText.getText().toString(),
                    getGender(),
                    edtEmailText.getText().toString(),
                    edtUsernameText.getText().toString(),
                    edtPasswordText.getText().toString(),
                    edtLocationText.getText().toString(),
                    edtBirthDateText.getText().toString(),
                    R.drawable.icon_newuser);
            DataRepository.getInstance().getCustomerMap().put(customer.getCustomerId(), customer);
            Intent mIntent = new Intent(AddCustomerActivity.this, CustomerListActivity.class);
            mIntent.putExtra("CustomerBills", customer);
            startActivity(mIntent);
        }
    }

    public String getGender()
    {
        if (rdBtnMale.isChecked()){
            return "Male";
        }
        else if (rdBtnFemale.isChecked()) {
            return "Female";
        }
        else if(rdBtnOther.isChecked())
        {
            return "Other";
        }
        return null;
    }

    public void clearfields()
    {
        edtUsernameText.getText().clear();
        edtPasswordText.getText().clear();
        edtBirthDateText.getText().clear();
        edtCustomerIdText.getText().clear();
        edtEmailText.getText().clear();
        edtLastNameText.getText().clear();
        edtFirstNameText.getText().clear();
        edtLocationText.getText().clear();

        rdBtnFemale.setChecked(false);
        rdBtnMale.setChecked(false);
        rdBtnOther.setChecked(false);
    }
}
