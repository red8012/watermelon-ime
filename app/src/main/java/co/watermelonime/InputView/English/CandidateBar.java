package co.watermelonime.InputView.English;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputConnection;

import com.orhanobut.logger.Logger;

import co.watermelonime.C;
import co.watermelonime.Common.Colour;
import co.watermelonime.Common.Font;
import co.watermelonime.Common.Size;
import co.watermelonime.Core.EnglishPredictor;
import co.watermelonime.Core.NavigationKeyListener;
import co.watermelonime.R;

public class CandidateBar extends ViewGroup {
    public static CandidateBar me;
    static boolean applicable = true;
    NavigationKey left, right, delete;

    public CandidateBar() {
        super(C.mainService);
        EnglishPredictor.init();
        CandidateButton.init();
        setBackgroundColor(Colour.CANDIDATE);
        setMeasuredDimension(Size.WInputView, Size.HInputView);
        left = new NavigationKey(R.drawable.nav_left, 1);
        right = new NavigationKey(R.drawable.nav_right, 1);
        delete = new NavigationKey(R.drawable.forward_delete, 0);
        left.setOnTouchListener(new NavigationKeyListener(KeyEvent.KEYCODE_DPAD_LEFT));
        right.setOnTouchListener(new NavigationKeyListener(KeyEvent.KEYCODE_DPAD_RIGHT));
        delete.setOnTouchListener(new NavigationKeyListener(KeyEvent.KEYCODE_FORWARD_DEL));
        addView(left);
        addView(right);
        addView(delete);
        me = this;
    }

    public static void delete() {
        if (!applicable) return;
        int length = EnglishPredictor.completionBuffer.length();
        if (length > 0) {
            EnglishPredictor.completionBuffer.delete(length - 1, length);
            Logger.d("completion buffer: %s", EnglishPredictor.completionBuffer);
        }
        predict();
    }

    public static void learn(String s) {
        if (!applicable) return;
        if (EnglishPredictor.completionBuffer.length() == 0) return;
        Logger.d("learn: %s", EnglishPredictor.completionBuffer);
        EnglishPredictor.learn(s);
    }

    public static void learn() {
        learn(EnglishPredictor.completionBuffer.toString());
    }

    public static void commit(CharSequence text) {
        char c = text.charAt(0);
        if (EnglishKeyboard.needAddSpaceBeforeCommit) {
            EnglishKeyboard.needAddSpaceBeforeCommit = false;
            if (!(EnglishKeyboard.mode == EnglishKeyboard.PUNCTUATION ||
                    c == '.' || c == ',' || c == '@'))
                C.commit(" ");
        }
        C.commit(text);
        if (!applicable) {
            return;
        }
        if (!Character.isLetter(text.charAt(0))) {
            learn();
            reset();
            return;
        }
//        if (EnglishKeyboard.mode == EnglishKeyboard.PUNCTUATION ||
//                c == '.' || c == ',' || c == '@')
//            reset();
        if (EnglishPredictor.completionBuffer.length() > 16) {
            Logger.d(">16 set not applicable");
            setApplicable(false);
            return;
        }
        EnglishPredictor.completionBuffer.append(text);
        predict();
        Logger.d("committed, completion buffer: %s", EnglishPredictor.completionBuffer);
    }

    public static void predict() {
        predict(null);
    }

    public static void predict(String previousWord) {
        if (!applicable) {
            clear();
            return;
        }
        try {
            String[] predictions;
            if (previousWord == null) {
                predictions = EnglishPredictor.getPredictions();
                if (predictions == null) {
                    CandidateButton button = CandidateButton.pool[0];
                    String text = EnglishPredictor.completionBuffer.toString();
                    int w = (int) CandidateButton.measureText(text);
                    int padding = Size.WEnglishCandidateUsableSpace - w;
                    button.setText(text, w, padding, Font.englishCandidateBlue);
                    me.removeView(button);
                    me.addView(button, me.getChildCount() - 1);
                    button.needSeparator = false;
                    me.removeView(CandidateButton.pool[1]);
                    me.removeView(CandidateButton.pool[2]);
                    me.onLayout(true, 0, 0, Size.WInputView, Size.HEnglishKey);
                    return;
                }
            } else predictions = EnglishPredictor.getNextPredictions(previousWord);


            int i, totalWidth = 0, end = 0;

            for (; end < predictions.length; end++) {
                int w = (int) CandidateButton.measureText(predictions[end]);
                if (totalWidth + w > Size.WEnglishCandidateUsableSpace * 0.9) break;
                CandidateButton.width[end] = w;
                totalWidth += w;
            }

            int padding = (Size.WEnglishCandidateUsableSpace - totalWidth) / end;

            for (i = 0; i < end; i++) {
                CandidateButton button = CandidateButton.pool[i];
                button.setText(predictions[i], CandidateButton.width[i], padding);
                me.removeView(button);
                me.addView(button, me.getChildCount() - 1);
                button.needSeparator = i < end - 1;
            }

            for (; i < 3; i++)
                me.removeView(CandidateButton.pool[i]);

            me.onLayout(true, 0, 0, Size.WInputView, Size.HEnglishKey);
//            C.englishKeyboard.layout(0, 0, 0, 0);
//            me.invalidate();
//            button.invalidate();
        } catch (Exception e) {
            clear();
            e.printStackTrace();
        }
    }

    public static void clear() {
        for (int i = 0; i < 3; i++)
            me.removeView(CandidateButton.pool[i]);
        me.onLayout(true, 0, 0, Size.WInputView, Size.HEnglishKey);
    }

    public static void setApplicable(boolean b) {
        applicable = b;
        Logger.d("applicable: %b", b);
        if (!b) {
            EnglishPredictor.completionBuffer.setLength(0);
            clear();
        }
    }

    public static void reset() {
        if (C.inputView.getChildAt(0) == C.englishKeyboard) {
            Logger.d("Reset buffer!!!");
            EnglishPredictor.completionBuffer.setLength(0);
            InputConnection connection = C.mainService.getCurrentInputConnection();
            try {
                CharSequence textBefore = connection.getTextBeforeCursor(1, 0);
                Logger.d("text before: |%s", textBefore);
                setApplicable(!Character.isLetter(textBefore.charAt(0)));
            } catch (Exception e) {
                setApplicable(true);
            }
            predict();
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        Logger.d("CandidateBar onLayout %d", getChildCount());
        l = t = 0;
        int len = getChildCount() - 1;
        for (int i = 0; i < len; i++) {
            View v = getChildAt(i);
            int width = v.getMeasuredWidth();
            if (i == 2) l += Size.u;
            v.layout(l, t, l + width, Size.HEnglishKey);
            l += width;
        }
        delete.layout(Size.WInputView - Size.WEnglishKey, 0, Size.WInputView, Size.HEnglishKey);
    }
}
