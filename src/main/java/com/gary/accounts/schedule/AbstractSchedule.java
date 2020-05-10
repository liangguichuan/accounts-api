package com.gary.accounts.schedule;

public abstract class AbstractSchedule {

    protected void getLock(){
        doSchedule();
    }

    abstract void doSchedule();
}
