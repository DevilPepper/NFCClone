package nyc.supastuff.nfcclone.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.graphics.Bitmap;
import android.nfc.NdefMessage;

@Entity
public class CardModel {

    @PrimaryKey(autoGenerate = true)
    public final int id;
    @TypeConverters(NFCConverter.class)
    public NdefMessage NFCData;
    @TypeConverters(BitmapConverter.class)
    public Bitmap image;

    public CardModel(int id, NdefMessage NFCData, Bitmap image) {
        this.id = id;
        this.NFCData = NFCData;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public NdefMessage getNFCData() {
        return NFCData;
    }

    public void setNFCData(NdefMessage NFCData) {
        this.NFCData = NFCData;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
