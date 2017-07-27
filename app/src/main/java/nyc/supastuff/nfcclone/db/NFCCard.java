package nyc.supastuff.nfcclone.db;

import android.graphics.Bitmap;

public class NFCCard {
    private Bitmap img;
    private int id;

    public void     setImg(Bitmap img)  { this.img = img; }
    public Bitmap   getImg()            { return this.img; }

    public void     setId(int id)       { this.id = id; }
    public int      getId()             { return this.id; }
}
