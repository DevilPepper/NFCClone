package nyc.supastuff.nfcclone;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import nyc.supastuff.nfcclone.db.Fetcher;
import nyc.supastuff.nfcclone.db.NFCCard;

public class CardListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Intent cardLoad = new Intent(getApplicationContext(), CardEmitterActivity.class);
                startActivity(cardLoad);
            }
        });

        List<NFCCard> list = Fetcher.getData();

        System.err.println("The list!!");
        System.err.println(list);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list.toArray());

        ListView listview = (ListView) findViewById(R.id.theList);

        listview.setAdapter(adapter);

        //TODO This thing
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {

                NFCCard card = (NFCCard) parent.getItemAtPosition(position);

                Intent cardLoad = new Intent(getApplicationContext(), CardEmitterActivity.class);
                Bundle b = new Bundle();
                int cardId = card.getId();
                b.putInt("id", cardId);
                cardLoad.putExtras(b);
                startActivity(cardLoad);
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_card_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
