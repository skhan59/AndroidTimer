package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

class AlarmedState implements StopwatchState {

    public AlarmedState(final StopwatchSMStateView sm) {
        this.sm = sm;
    }

    private final StopwatchSMStateView sm;

    @Override
    public void onClick() {
        sm.clockStop();
        sm.toStoppedState();
    }

    @Override
    public void onTick() {
        sm.startAlarm();
        //sm.actionInc();
        //sm.toAlarmedState();
    }

    @Override
    public void updateView() {
        sm.updateUIRuntime();
    }

    @Override
    public int getId() {
        return R.string.ALARMING;
    }
}
