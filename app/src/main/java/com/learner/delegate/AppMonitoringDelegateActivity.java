package com.learner.delegate;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.learner.R;
import com.learner.adapter.AppsListingAdapter;

import java.util.ArrayList;

/**
 * Basic delegate for MonitoringActivity.
 * Deals with rendering a List of Apps brought to
 * foreground by User during the Application-LifeCycle.
 * <p>
 * Developer: Rishabh Dutt Sharma
 * Dated: 5/23/2017.
 */
public class AppMonitoringDelegateActivity extends AppCompatActivity {

    private RecyclerView rvTasksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) supportActionBar.setTitle(R.string.title_apps_launched);

        rvTasksList = (RecyclerView) findViewById(R.id.rv_tasks_list);
        rvTasksList.setLayoutManager(new LinearLayoutManager(this));
    }

    /**
     * Display the Tasks List on User-Interface
     *
     * @param tasks
     */
    protected void displayTasks(ArrayList<String> tasks) {
        rvTasksList.setAdapter(new AppsListingAdapter(this, tasks));
    }
}
