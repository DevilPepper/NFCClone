package nyc.supastuff.nfcclone.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {CardModel.class}, version = 1)
public abstract class CardoDB extends RoomDatabase {
    private static CardoDB INSTANCE;

    public static CardoDB getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), CardoDB.class, "card_db")
                            .build();
        }
        return INSTANCE;
    }

    public abstract CardDAO cardoModel();

}
