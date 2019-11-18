package com.example.midtermproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class ListEmployeeFragment extends Fragment {

    ListView listViewPromoted, listViewNotPromoted;
    EmployeeAdapter employeePromotedAdapter, employeeNotPromotedAdapter;
    ArrayList<Employee> employees;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list_employee, container, false);

        getEmployeeListFromActivity();

        listViewPromoted = v.findViewById(R.id.promotedListView);
        listViewNotPromoted = v.findViewById(R.id.notPromotedListView);

        employeePromotedAdapter = new EmployeeAdapter(getActivity(), filterPromoted(true),false);
        employeeNotPromotedAdapter = new EmployeeAdapter(getActivity(), filterPromoted(false),false);

        listViewPromoted.setAdapter(employeePromotedAdapter);
        listViewNotPromoted.setAdapter(employeeNotPromotedAdapter);


        return v;
    }

    private ArrayList<Employee> filterPromoted(boolean b) {
        ArrayList<Employee> filteredList = new ArrayList<>();
        for (Employee e : employees) {
            if (e.isPromoted == b) {
                filteredList.add(e);
            }
        }
        return filteredList;
    }


    private void getEmployeeListFromActivity() {
        employees = ((MainActivity) getActivity()).employees;
    }

}
