package com.example.midtermproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class PromoteEmployeeFragment extends Fragment {

    ListView listView;
    EmployeeAdapter employeeAdapter;
    ArrayList<Employee> employees;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_promote_employee, container, false);

        getEmployeeListFromActivity();

        listView = v.findViewById(R.id.listView);
        employeeAdapter = new EmployeeAdapter(getActivity(), employees);
        listView.setAdapter(employeeAdapter);

        return v;
    }

    private void getEmployeeListFromActivity() {
        employees = ((MainActivity) getActivity()).employees;
    }


}
