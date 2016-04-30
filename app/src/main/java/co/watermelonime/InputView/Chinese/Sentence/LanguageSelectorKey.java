package co.watermelonime.InputView.Chinese.Sentence;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;

import co.watermelonime.C;
import co.watermelonime.Common.Colour;
import co.watermelonime.Common.Font;
import co.watermelonime.Common.Size;

public class LanguageSelectorKey extends View {
    static final OnTouchListener onTouchListener = new OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getActionMasked() != MotionEvent.ACTION_DOWN) return false;
            LanguageSelectorKey me = (LanguageSelectorKey) v;
            LanguageSelector.setInputLanguage(me.language);
            return true;
        }
    };
    static Paint rectPaint;
    public final int language;
    public float dx, dy;
    Layout textLayout;
    Drawable image;

    public LanguageSelectorKey(final int language, final String text) {
        super(C.mainService);
        setOnTouchListener(onTouchListener);
        this.language = language;
        textLayout = Font.sentence.make(text, Size.WSentenceView);
        dx = Size.WSentenceView / 2;
        dy = (Size.HLanguageSelectorKey - textLayout.getHeight()) / 2;
        setMeasuredDimension(Size.WSentenceView, Size.HLanguageSelectorKey);
        if (rectPaint == null) {
            rectPaint = new Paint();
            rectPaint.setColor(Colour.CANDIDATE);
        }
    }

    public LanguageSelectorKey(final int language, int resource) {
        super(C.mainService);
        setOnTouchListener(onTouchListener);
        this.language = language;

        image = ContextCompat.getDrawable(C.context, resource);
        dx = Size.WSentenceView * 1 / 5 + Size.u / 5;
        dy = Size.WSentenceView * 1 / 5;
        int size = Size.WSentenceView * 3 / 5;
        image.setBounds(0, 0, size, size);

        setMeasuredDimension(Size.WSentenceView, Size.HLanguageSelectorKey);
        if (rectPaint == null) {
            rectPaint = new Paint();
            rectPaint.setColor(Colour.CANDIDATE);
        }
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        Log.i("LanguageSelectorKey", "onMeasure");
        setMeasuredDimension(Size.WSentenceView, Size.HLanguageSelectorKey);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (image != null) {
            canvas.save();
            canvas.translate(dx, dy);
            image.draw(canvas);
            canvas.restore();
        }
        if (LanguageSelector.inputLanguage == language) {
            canvas.drawRect(0, 0, Size.u / 2, Size.HLanguageSelectorKey, rectPaint);
        }
        if (textLayout != null) {
            canvas.save();
            canvas.translate(dx, dy);
            textLayout.draw(canvas);
            canvas.restore();
        }

    }
}
