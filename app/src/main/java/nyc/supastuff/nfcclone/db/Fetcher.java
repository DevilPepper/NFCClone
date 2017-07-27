package nyc.supastuff.nfcclone.db;

import android.graphics.Bitmap;
import android.nfc.NdefMessage;

import java.util.List;
import java.util.ArrayList;

public class Fetcher {
    public static ArrayList<NFCCard> getData()
    {
        ArrayList<NFCCard> data = new ArrayList<>();
        data.add(new NFCCard());
        data.add(new NFCCard());
        //return new ArrayList<Bitmap>();
        return data;
    }

    public static Bitmap getImg(int id)
    {
        return Bitmap.CREATOR.newArray(3)[0];
    }

    public static NdefMessage getNFC(int id)
    {
        return new NdefMessage(null, null, null);
    }

}
