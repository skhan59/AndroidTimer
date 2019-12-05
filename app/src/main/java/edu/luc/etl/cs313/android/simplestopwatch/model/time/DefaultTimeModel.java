package edu.luc.etl.cs313.android.simplestopwatch.model.time;

import static edu.luc.etl.cs313.android.simplestopwatch.common.Constants.*;

/**
 * An implementation of the stopwatch data model.
 */
public class DefaultTimeModel implements TimeModel {

    private int runningTime = 0;


    @Override
    public void resetRuntime() {
        runningTime = 0;
    }

    @Override
    public void incRuntime() {
        runningTime = runningTime + SEC_PER_TICK;
    }

    @Override
    public void decRuntime() {
        runningTime = runningTime - SEC_PER_TICK;
    }

    @Override
    public int getRuntime() {
        return runningTime;
    }

}