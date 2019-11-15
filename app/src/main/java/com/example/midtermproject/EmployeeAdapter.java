package com.example.midtermproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends ArrayAdapter<Employee> {

    private Context mContext;
    private List<Employee> moviesList;

    public EmployeeAdapter(@NonNull Context context,ArrayList<Employee> list) {
        super(context, 0 , list);
        mContext = context;
        moviesList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.item_employee,parent,false);

        Employee currentEmployee = moviesList.get(position);

        TextView name = listItem.findViewById(R.id.name);
        name.setText(currentEmployee.getName());

        TextView title = listItem.findViewById(R.id.title);
        title.setText(currentEmployee.getTitle());

        TextView age = listItem.findViewById(R.id.age);
        age.setText(currentEmployee.getAge()+"");

        TextView yearOfExp = listItem.findViewById(R.id.year_of_experience);
        yearOfExp.setText(currentEmployee.getYearOfExperience()+"");

        TextView salary = listItem.findViewById(R.id.salary);
        salary.setText(currentEmployee.getSalary()+"");


        return listItem;
    }
}
