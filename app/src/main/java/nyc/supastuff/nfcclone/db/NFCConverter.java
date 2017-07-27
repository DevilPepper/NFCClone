package nyc.supastuff.nfcclone.db;

import android.arch.persistence.room.TypeConverter;
import android.nfc.NdefMessage;

import com.google.gson.Gson;

class NFCConverter {
    @TypeConverter
    public static NdefMessage toNFC(String json) {
        return new Gson().fromJson(json, NdefMessage.class); //lol. Hopefully this works
    }

    @TypeConverter
    public static String toJSON(NdefMessage nfc) {
        return new Gson().toJson(nfc);
    }
}
