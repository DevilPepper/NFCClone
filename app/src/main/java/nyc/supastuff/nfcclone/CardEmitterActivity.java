package nyc.supastuff.nfcclone;

import android.content.Context;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class CardEmitterActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private ImageView mImage;
    private NdefMessage cardData;
    private int cardID;

    private Context that;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_delete:
                    //TODO Delete this card from DB. Also prevent this activity from returning.
                    Intent deleteCard = new Intent(that, CardListActivity.class);
                    that.startActivity(deleteCard);
                    return true;
                case R.id.navigation_camera:
                    Intent updateCardImage = new Intent(that, CameraActivity.class);
                    that.startActivity(updateCardImage);
                    displayImage();
                    return true;
                case R.id.navigation_scan:
                    Intent updateCardDetails = new Intent(that, CardCopyActivity.class);
                    that.startActivity(updateCardDetails);
                    emitData();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        that = this.getApplicationContext();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_emitter);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mTextMessage = (TextView)  findViewById(R.id.textView);
        mImage       = (ImageView) findViewById(R.id.imageView);

        //TODO set cardID somehow;
        displayImage();
        emitData();
    }

    private void emitData() {
        //TODO Get card data from DB and pass it to emitter
        //cardData = new NdefMessage(null, null, null);
    }

    private void displayImage() {
        //TODO Get image from DB. If no image, leave default.
        mImage.setImageResource(R.drawable.ic_dashboard_black_24dp);
        mTextMessage.bringToFront();
    }
}
