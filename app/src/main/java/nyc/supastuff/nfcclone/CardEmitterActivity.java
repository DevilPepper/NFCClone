package nyc.supastuff.nfcclone;

import android.content.Intent;
import android.graphics.Bitmap;
import android.nfc.NdefMessage;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import nyc.supastuff.nfcclone.db.Fetcher;

public class CardEmitterActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private ImageView mImage;
    private NdefMessage cardData;
    private int cardID;


    private void emitData() {
        //TODO Get card data from DB and pass it to emitter
        //cardData = new NdefMessage(null, null, null);
        cardData = Fetcher.getNFC(cardID);
    }

    private void displayImage() {
        //TODO Get image from DB. If no image, leave default.
        Bitmap img = Fetcher.getImg(cardID);
        mImage.setImageBitmap(img);

        mImage.setImageResource(R.drawable.ic_dashboard_black_24dp);
        mTextMessage.bringToFront();
        mTextMessage.invalidate();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_delete:
                    //TODO Delete this card from DB. Also prevent this activity from returning.
                    //Intent deleteCard = new Intent(getApplicationContext(), CardListActivity.class);
                    //startActivity(deleteCard);
                    finish();
                    return true;
                case R.id.navigation_camera:
                    Intent updateCardImage = new Intent(getApplicationContext(), CameraActivity.class);
                    startActivity(updateCardImage);
                    displayImage();
                    return true;
                case R.id.navigation_scan:
                    Intent updateCardDetails = new Intent(getApplicationContext(), CardCopyActivity.class);
                    startActivity(updateCardDetails);
                    emitData();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_emitter);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mTextMessage = (TextView)  findViewById(R.id.textView);
        mImage       = (ImageView) findViewById(R.id.imageView);

        try
        {
            cardID = getIntent().getExtras().getInt("id");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        displayImage();
        emitData();

    }
}
