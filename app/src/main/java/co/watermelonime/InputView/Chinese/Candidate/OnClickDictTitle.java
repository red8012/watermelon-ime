package co.watermelonime.InputView.Chinese.Candidate;

import android.view.View;

public class OnClickDictTitle implements View.OnClickListener{
    @Override
    public void onClick(View v) {
        DictController.clearCandidate();
        int index = ((DictTitle)v).index;
        DictController.showLayer2Dictionary(index);
    }
}
