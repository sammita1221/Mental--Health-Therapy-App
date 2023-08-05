package com.example.sammy.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.recyclerview.widget.RecyclerView;

import com.example.sammy.AddNewTask;
import com.example.sammy.Model.TodoModel;
import com.example.sammy.R;
import com.example.sammy.Todo;
import com.example.sammy.Utils.DatabaseHandler;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder>{
    private List<TodoModel> todolist;
    private DatabaseHandler db;
    private Todo activity;
    public TodoAdapter(DatabaseHandler db, Todo activity)
    {
        this.db=db;
        this.activity=activity;
    }
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType)
    {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.task_layout,parent,false);
        return new ViewHolder(itemView);


    }
    public void onBindViewHolder(ViewHolder holder,int position) {
        db.openDatabase();
        TodoModel item = todolist.get(position);
        holder.task.setText(item.getTask());
        holder.task.setChecked(toBoolean(item.getStatus()));
        holder.task.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    db.updateStatus(item.getId(), 1);
                } else {
                    db.updateStatus(item.getId(), 0);
                }
            }

        });
    }
    private boolean toBoolean(int n)
    {
        return n!=0;
    }
    public void setTasks(List<TodoModel> todoList)
    {
        this.todolist=todoList;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return todolist.size();
    }

    public Context getContext() {
        return activity;
    }


    public void deleteItem(int position) {
        TodoModel item = todolist.get(position);
        db.deleteTask(item.getId());
        todolist.remove(position);
        notifyItemRemoved(position);
    }

    public void editItem(int position) {
        TodoModel item = todolist.get(position);
        Bundle bundle = new Bundle();
        bundle.putInt("id", item.getId());
        bundle.putString("task", item.getTask());
        AddNewTask fragment = new AddNewTask();
        fragment.setArguments(bundle);
        fragment.show(activity.getSupportFragmentManager(), AddNewTask.TAG);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        CheckBox task;
        ViewHolder(View view){
            super(view);
            task=view.findViewById(R.id.todoCheck);

        }
    }

}
