package com.example.nghia.hw_activity_example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String CREATE_KEY = "create";
    public static final String RESUME_KEY = "resume";
    public static final String START_KEY = "start";
    public static final String RESTART_KEY = "restart";
    public static final String PAUSE_KEY = "pause";
    public static final String STOP_KEY = "stop";
    public static final String DESTROY_KEY = "destroy";


    private static final String TAG = MainActivity.class.toString();

    private Button buttonGoTo2ndActivity;
    protected TextView tvCreate;
    protected TextView tvStart;
    protected TextView tvResume;
    protected TextView tvRestart;
    protected TextView tvStop;
    protected TextView tvPause;
    protected TextView tvDestroy;


    private int createCount;
    private int startCount;
    private int resumeCount;
    private int restartCount;
    private int stopCount;
    private int pauseCount;
    private int destroyCount;
    Bundle mainBundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getReferences();
        loadBundle(savedInstanceState);
        setupUI();

        incView(CREATE_KEY);
    }

    void incView(String viewKey) {
        switch (viewKey) {
            case CREATE_KEY:
                createCount++;
                tvCreate.setText(String.format("onCreate: %s", createCount));
                break;
            case START_KEY:
                startCount++;
                tvStart.setText(String.format("onStart: %s", startCount));
                break;
            case RESUME_KEY:
                resumeCount++;
                tvResume.setText(String.format("onResume: %s", resumeCount));
                break;
            case RESTART_KEY:
                restartCount++;
                tvRestart.setText(String.format("onRestart: %s", restartCount));
                break;
            case STOP_KEY:
                stopCount++;
                tvStop.setText(String.format("onStop: %s", stopCount));
                break;
            case PAUSE_KEY:
                pauseCount++;
                tvPause.setText(String.format("onPause: %s", pauseCount));
                break;
            case DESTROY_KEY:
                destroyCount++;
                tvDestroy.setText(String.format("onDestroy: %s", destroyCount));
                break;
        }

    }

    public void updateTextViews() {
        tvCreate.setText(String.format("onCreate: %s", createCount));
        tvStart.setText(String.format("onStart: %s", startCount));
        tvResume.setText(String.format("onResume: %s", resumeCount));
        tvRestart.setText(String.format("onRestart: %s", restartCount));
        tvStop.setText(String.format("onStop: %s", stopCount));
        tvPause.setText(String.format("onPause: %s", pauseCount));
        tvDestroy.setText(String.format("onDestroy: %s", destroyCount));
    }

    public void loadBundle(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            createCount = (int) savedInstanceState.get(CREATE_KEY);
            startCount = (int) savedInstanceState.get(START_KEY);
            resumeCount = (int) savedInstanceState.get(RESUME_KEY);
            restartCount = (int) savedInstanceState.get(RESTART_KEY);
            stopCount = (int) savedInstanceState.get(STOP_KEY);
            pauseCount = (int) savedInstanceState.get(PAUSE_KEY);
            destroyCount = (int) savedInstanceState.get(DESTROY_KEY);

        } else {
            setCounts(0);

        }
        updateTextViews();
    }

    public void setupUI() {
        buttonGoTo2ndActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, String.format("buttonGoTo2ndActivity: onClicked"));


                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    public void getReferences() {
        buttonGoTo2ndActivity = (Button) findViewById(R.id.btn_goTo2ndActivity);
        getTextViewReferences();
    }

    public void getTextViewReferences() {

        tvCreate = (TextView) findViewById(R.id.tv_on_create);
        tvStart = (TextView) findViewById(R.id.tv_on_start);
        tvResume = (TextView) findViewById(R.id.tv_on_resume);
        tvRestart = (TextView) findViewById(R.id.tv_on_restart);
        tvStop = (TextView) findViewById(R.id.tv_on_stop);
        tvPause = (TextView) findViewById(R.id.tv_on_pause);
        tvDestroy = (TextView) findViewById(R.id.tv_on_destroy);

    }


    public void setCounts(int value) {

        createCount = value;
        startCount = value;
        resumeCount = value;
        restartCount = value;
        stopCount = value;
        pauseCount = value;
        destroyCount = value;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        incView(RESUME_KEY);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
        incView(START_KEY);
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop");
        incView(STOP_KEY);
        if (mainBundle != null)
            mainBundle.putInt(STOP_KEY, stopCount);
        super.onStop();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause");
        incView(PAUSE_KEY);
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");
        incView(DESTROY_KEY);
        if (mainBundle != null)
            mainBundle.putInt(DESTROY_KEY, destroyCount);
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "onSaveInstanceState");
        super.onSaveInstanceState(outState);
        outState.putInt(CREATE_KEY, createCount);
        outState.putInt(START_KEY, startCount);
        outState.putInt(RESTART_KEY, restartCount);
        outState.putInt(RESUME_KEY, resumeCount);
        outState.putInt(PAUSE_KEY, pauseCount);
        outState.putInt(STOP_KEY, stopCount);
        outState.putInt(DESTROY_KEY, destroyCount);
        mainBundle = outState;
    }
}
