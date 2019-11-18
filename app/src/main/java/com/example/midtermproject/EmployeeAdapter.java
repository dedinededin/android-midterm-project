package com.example.midtermproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends ArrayAdapter<Employee> {

    private Context mContext;
    private List<Employee> employeeList;
    private boolean editable;

    public EmployeeAdapter(@NonNull Context context, ArrayList<Employee> list, boolean editable) {
        super(context, 0, list);
        mContext = context;
        employeeList = list;
        this.editable = editable;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.item_employee, parent, false);

        final Employee currentEmployee = employeeList.get(position);

        TextView name = listItem.findViewById(R.id.name);
        name.setText(currentEmployee.getName());

        TextView title = listItem.findViewById(R.id.title);
        title.setText(currentEmployee.getTitle());

        TextView age = listItem.findViewById(R.id.age);
        age.setText(currentEmployee.getAge() + " years old");

        TextView yearOfExp = listItem.findViewById(R.id.year_of_experience);
        yearOfExp.setText(currentEmployee.getYearOfExperience() + " years of experience");

        TextView salary = listItem.findViewById(R.id.salary);
        salary.setText(currentEmployee.getSalary() + " TL Monthly)");

        final CheckBox isPromotedCB = listItem.findViewById(R.id.is_promoted);
        isPromotedCB.setChecked(currentEmployee.isPromoted());

        if (isPromotedCB.isChecked()) {
            title.setText("Senior " + currentEmployee.title);
        }

        if (!editable) {
            isPromotedCB.setVisibility(View.INVISIBLE);
        } else
            isPromotedCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    currentEmployee.setPromoted(isPromotedCB.isChecked());
                }
            });


        return listItem;
    }
}
