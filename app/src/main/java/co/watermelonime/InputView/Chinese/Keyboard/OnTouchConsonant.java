package co.watermelonime.InputView.Chinese.Keyboard;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import co.watermelonime.C;
import co.watermelonime.Core.Controller;
import co.watermelonime.InputView.Chinese.Candidate.CharacterKey;
import co.watermelonime.InputView.Chinese.Candidate.PredictionArea;

public class OnTouchConsonant implements View.OnTouchListener {
    public static final char[] code = {
            'A', 'E', 'I', 'M', 'Q', 'U',
            'B', 'F', 'J', 'N', 'R', 'V',
            'C', 'G', 'K', 'O', 'S', 'W',
            'D', 'H', 'L', 'T'};

    public static void fillInPredictionAndCharacterKeys(int id) {
        if (id != 20)  // if not IUV
            C.candidateView.addView(PredictionArea.area);

        // fill in character locks
        for (CharacterKey k : CharacterKey.keys[id])
            C.candidateView.addView(k);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getPointerCount() != 1) {
            Log.e("OnTouchConsonant", "multi touched");
            return true;
        }
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                ChineseKey key = (ChineseKey) v;
                int id = key.action;
                char keyCode = code[id];
                Controller.add(keyCode, '\0');

                PredictionArea.area.removeAllViews();
                C.threadPool.submit(Controller.predict);

                C.chineseKeyboard.setKeys(Vowels.keyArray[id]);
                C.sentenceView.consonantPreview((String) key.mainText.getText());
                fillInPredictionAndCharacterKeys(id);
                System.out.println("OnTouchConsonant: " + keyCode);
        }
        return true;
    }
}
