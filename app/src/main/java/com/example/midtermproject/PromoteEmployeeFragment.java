package com.example.midtermproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class PromoteEmployeeFragment extends Fragment {

    ListView listView;
    EmployeeAdapter employeeAdapter;
    ArrayList<Employee> temporaryEmployees;
    Button submitButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_promote_employee, container, false);

        temporaryEmployees = new ArrayList<>();
        getEmployeeListFromActivity();

        listView = v.findViewById(R.id.listView);
        employeeAdapter = new EmployeeAdapter(getActivity(), temporaryEmployees, true);
        listView.setAdapter(employeeAdapter);

        submitButton = v.findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();
            }
        });

        return v;
    }

    private void showAlertDialog() {
        StringBuilder promotedEmployees = new StringBuilder();
        boolean flag = false;
        for (Employee e : temporaryEmployees) {
            if (e.isPromoted()) {
                flag = true;
                promotedEmployees.append(e.name);
                promotedEmployees.append("\n");
            }
        }


        if (flag) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

            builder.setTitle("Promoted employees:");
            builder.setMessage(promotedEmployees);
            builder.setNegativeButton("Cancel", null);
            builder.setPositiveButton("Approve", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    ((MainActivity) getActivity()).employees = temporaryEmployees;
                }
            });

            builder.show();

        } else {
            Toast.makeText(getActivity(), "No employees selected.", Toast.LENGTH_LONG).show();
        }


    }

    private void getEmployeeListFromActivity() {
        ArrayList<Employee> employeeArrayList = ((MainActivity) getActivity()).employees;

        for (Employee e : employeeArrayList) {
            Employee x = new Employee();

            x.name = e.name;
            x.title = e.title;
            x.salary = e.salary;
            x.yearOfExperience = e.yearOfExperience;
            x.age = e.age;
            x.isPromoted = e.isPromoted;

            temporaryEmployees.add(x);

        }

    }


}
