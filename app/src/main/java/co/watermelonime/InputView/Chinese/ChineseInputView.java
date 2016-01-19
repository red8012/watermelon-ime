package co.watermelonime.InputView.Chinese;

import android.util.Log;
import android.view.ViewGroup;

import co.watermelonime.C;
import co.watermelonime.Common.Size;

public class ChineseInputView extends ViewGroup {
    public static final int
            CHINESE = 0,
            EMOJI = 1;

    public static int mode = CHINESE;

    public ChineseInputView() {
        super(C.mainService);
        changeInputMode(CHINESE);
    }

    public void changeInputMode(final int mode) {
        ChineseInputView.mode = mode;
        removeAllViews();
        addView(C.sentenceView);
        switch (mode) {
            case CHINESE:
                addView(C.candidateView);
                addView(C.chineseKeyboard);
                break;
            case EMOJI:
                addView(C.emoji);
                break;
        }
        invalidate();
        onLayout(true, 0, 0, 0, 0);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        Log.i("ChineseInputView", "onMeasure");
        setMeasuredDimension(Size.WInputView, Size.HInputView);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (!changed) return;
        Log.i("ChineseInputView", "onLayout");
        l = 0;
        t = 0;
        C.sentenceView.layout(l, t, l + Size.WSentenceView, t + Size.HSentenceView);
        l += Size.WSentenceView;
        switch (mode) {
            case CHINESE:
                C.candidateView.layout(l, t, l + Size.WCandidateView, t + Size.HCandidateView);
                C.chineseKeyboard.layout(l, t + Size.HCandidateVisible, l + Size.WKeyboard, t + Size.HInputView);
                break;
            case EMOJI:
                C.emoji.layout(l, t, l + Size.WCandidateView, t + Size.HCandidateView);
                break;
        }

    }
}
