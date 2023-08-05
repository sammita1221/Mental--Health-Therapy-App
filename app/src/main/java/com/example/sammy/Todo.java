package com.example.sammy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import com.example.sammy.Adapter.TodoAdapter;
import com.example.sammy.Model.TodoModel;
import com.example.sammy.Utils.DatabaseHandler;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Todo extends AppCompatActivity implements DialogCloseListener {
    private RecyclerView taskRecyclerView;
    private TodoAdapter tasksAdapter;
    private FloatingActionButton fab;
    private DatabaseHandler db;
    private List<TodoModel> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        getSupportActionBar().hide();
        db = new DatabaseHandler(this);
        db.openDatabase();
        taskList= new ArrayList<>();
        taskRecyclerView=findViewById(R.id.taskRecycle);
        taskRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        tasksAdapter=new TodoAdapter(db,this);
        taskRecyclerView.setAdapter(tasksAdapter);
        ItemTouchHelper itemTouchHelper = new
                ItemTouchHelper(new RecyclerItemTouchHelper(tasksAdapter));
        itemTouchHelper.attachToRecyclerView(taskRecyclerView);
        fab = findViewById(R.id.fab);
        taskList = db.getAllTasks();
        Collections.reverse(taskList);

        tasksAdapter.setTasks(taskList);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNewTask.newInstance().show(getSupportFragmentManager(), AddNewTask.TAG);
            }
        });



    }
    @Override
    public void handleDialogClose(DialogInterface dialog){
        taskList = db.getAllTasks();
        Collections.reverse(taskList);
        tasksAdapter.setTasks(taskList);
        tasksAdapter.notifyDataSetChanged();
    }
}