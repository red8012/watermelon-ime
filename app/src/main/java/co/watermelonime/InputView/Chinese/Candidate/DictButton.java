package co.watermelonime.InputView.Chinese.Candidate;

import android.util.Log;

import java.util.ArrayList;

public class DictButton extends CandidateButton {

    final static ArrayList<DictButton> pool = new ArrayList<>(64);
    final static OnClickDict onClickDict = new OnClickDict();

    public DictButton() {
        super();
        setOnClickListener(onClickDict);
    }

    public static void init() {
        for (int i = 0; i < 63; i++)
            pool.add(new DictButton());
    }

    public static DictButton get(String s) {
        DictButton d;
        Log.w("DictButton", s);
        if (pool.isEmpty()) {
            d = new DictButton();
        } else
            d = pool.remove(pool.size() - 1);
        d.setText(s, 0, true, 0);
        return d;
    }

    public void release() {
        pool.add(this);
    }
}