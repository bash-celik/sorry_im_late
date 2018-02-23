package com.gengar.sorryimlate;

import com.orm.SugarRecord;

import java.util.Calendar;

public class LateDB extends SugarRecord{

    private Calendar date;

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public LateDB(Calendar date) {
        this.date = date;
    }

    public LateDB() {
    }
}
