package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

class StoppedState implements StopwatchState {

    public StoppedState(final StopwatchSMStateView sm) {
        this.sm = sm;
    }

    private final StopwatchSMStateView sm;

    private int tickCount = 0;

    //when clicked increment timer and start counter for 3 seconds
    @Override
    public void onClick() {
        if(sm.getTime() == 99) {
            //BEEP
            sm.toRunningState();
        }
        else if(sm.getTime() == 0) {
            sm.actionInc();
            sm.clockStart();
            tickCount = 0;
        }
        else {
            sm.actionInc();
            tickCount = 0;
        }
    }

    @Override
    public void onTick() {
        if (tickCount == 3 && sm.getTime() != 0) {
            sm.startAlarm();
            sm.toRunningState();
        } else {
            tickCount++;
        }
    }

    @Override
    public void updateView() {
        sm.updateUIRuntime();
    }

    @Override
    public int getId() {
        return R.string.STOPPED;
    }
}
