package com.bonovo.loadbigmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView bitmapText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bitmapText = (ImageView) findViewById(R.id.IVBitmap);

        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(),R.drawable.audio3);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(),R.drawable.biz_chat_comment_send_prs);


        Bitmap bitmap = Bitmap.createBitmap(bitmap1.getWidth(),bitmap2.getHeight(), Bitmap.Config.ARGB_8888);


        Canvas canvas = new Canvas(bitmap);
        canvas.drawBitmap(bitmap1,0,0,null);

        Paint paint = new Paint();

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DARKEN));

        float left  = bitmap1.getWidth() -bitmap2.getWidth();

        float top = bitmap1.getHeight() - bitmap2.getHeight();

        canvas.drawBitmap(bitmap2,left,top,paint);

        bitmapText.setImageBitmap(bitmap);





    }
}
