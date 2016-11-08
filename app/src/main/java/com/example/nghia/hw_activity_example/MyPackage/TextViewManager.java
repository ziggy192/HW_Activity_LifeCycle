package com.example.nghia.hw_activity_example.MyPackage;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Nghia on 11/7/2016.
 */

public class TextViewManager {
    public static final String CREATE_KEY = "create";
    public static final String RESUME_KEY = "resume";
    public static final String START_KEY = "start";
    public static final String RESTART_KEY = "restart";
    public static final String PAUSE_KEY = "pause";
    public static final String STOP_KEY = "stop";
    public static final String DESTROY_KEY = "destroy";


    private int createCount;
    private int startCount;
    private int resumeCount;
    private int restartCount;
    private int stopCount;
    private int pauseCount;
    private int destroyCount;

    ArrayList<TextView> textViewArrayList ;

    public TextViewManager(Bundle savedBundle){


    }
}
