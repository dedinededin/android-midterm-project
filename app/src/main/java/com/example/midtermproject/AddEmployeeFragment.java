package com.example.midtermproject;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class AddEmployeeFragment extends Fragment {

    EditText name, age, salary, title, experince;
    Button addButton;
    Employee e;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.register_employee, container, false);

        e = new Employee();

        name = v.findViewById(R.id.name);
        age = v.findViewById(R.id.age);
        salary = v.findViewById(R.id.salary);
        title = v.findViewById(R.id.title);
        experince = v.findViewById(R.id.year_of_experience);


        addButton = v.findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateForm()) {
                    e.setName(name.getText().toString());
                    e.setAge(Integer.parseInt(age.getText().toString()));
                    e.setSalary(Integer.parseInt(salary.getText().toString()));
                    e.setTitle(title.getText().toString());
                    e.setYearOfExperience(Integer.parseInt(experince.getText().toString()));

                    addEmployee();
                    cleanForm();
                    Toast.makeText(getActivity(), "Employee Added Succesfully", Toast.LENGTH_LONG).show();
                }
            }
        });

        return v;

    }

    private void cleanForm() {
        name.getText().clear();
        age.getText().clear();
        salary.getText().clear();
        title.getText().clear();
        experince.getText().clear();

        e = new Employee();
    }

    private boolean validateForm() {
        if (TextUtils.isEmpty(name.getText())) {
            name.setError("Name is required.");
            return false;
        } else if (TextUtils.isEmpty(age.getText())) {
            age.setError("Age is required.");
            return false;
        } else if (TextUtils.isEmpty(salary.getText())) {
            salary.setError("Salary is required.");
            return false;
        } else if (TextUtils.isEmpty(title.getText())) {
            title.setError("Title is required.");
            return false;
        } else if (TextUtils.isEmpty(experince.getText())) {
            experince.setError("Experience is required.");
            return false;
        } else return true;


    }

    public void addEmployee() {
        ((MainActivity) getActivity()).employees.add(e);
    }


}