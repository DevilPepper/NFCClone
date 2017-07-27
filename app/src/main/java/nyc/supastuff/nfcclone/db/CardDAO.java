package nyc.supastuff.nfcclone.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.Update;
import android.graphics.Bitmap;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
@TypeConverters({BitmapConverter.class, NFCConverter.class})
public interface CardDAO {

    @Query("select * from CardModel")
    LiveData<List<CardModel>> getAllCards();

    @Query("select * from CardModel where id = :id")
    CardModel getCardByID(int id);

    @Update(onConflict = REPLACE)
    void updateCard(CardModel cardModel);

    @Insert(onConflict = REPLACE)
    void addCard(CardModel cardModel);

    @Delete
    void deleteCard(CardModel cardModel);
}
