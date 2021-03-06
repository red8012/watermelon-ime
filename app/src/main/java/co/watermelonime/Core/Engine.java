package co.watermelonime.Core;

import android.os.Process;

import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;

import java.util.ArrayList;

import co.watermelonime.C;
import co.watermelonime.Common.Timer;

public class Engine {
    public static final int separator[][][] = {
            {{1}},
            {{2}, {1, 1}},
            {{3}, {2, 1}, {1, 2}, {1, 1, 1}},
            {{4}, {2, 2}, {3, 1}, {1, 3}, {1, 2, 1}, {2, 1, 1}, {1, 1, 2}, {1, 1, 1, 1}},
            {{5}, {3, 2}, {2, 3}, {4, 1}, {1, 4}, {2, 2, 1}, {2, 1, 2}, {1, 3, 1}, {1, 2, 2}, {3, 1, 1}, {1, 1, 3}, {1, 2, 1, 1}, {1, 1, 2, 1}, {2, 1, 1, 1}, {1, 1, 1, 2}, {1, 1, 1, 1, 1}},
            {{6}, {4, 2}, {3, 3}, {2, 4}, {5, 1}, {1, 5}, {2, 2, 2}, {3, 2, 1}, {3, 1, 2}, {2, 3, 1}, {2, 1, 3}, {1, 4, 1}, {1, 3, 2}, {1, 2, 3}, {4, 1, 1}, {1, 1, 4}, {2, 1, 2, 1}, {1, 2, 2, 1}, {1, 2, 1, 2}, {2, 2, 1, 1}, {2, 1, 1, 2}, {1, 3, 1, 1}, {1, 1, 3, 1}, {1, 1, 2, 2}, {3, 1, 1, 1}, {1, 1, 1, 3}, {1, 1, 2, 1, 1}, {1, 2, 1, 1, 1}, {1, 1, 1, 2, 1}, {2, 1, 1, 1, 1}, {1, 1, 1, 1, 2}, {1, 1, 1, 1, 1, 1}},
            {{7}, {5, 2}, {4, 3}, {3, 4}, {2, 5}, {6, 1}, {1, 6}, {3, 2, 2}, {2, 3, 2}, {2, 2, 3}, {4, 2, 1}, {4, 1, 2}, {3, 3, 1}, {3, 1, 3}, {2, 4, 1}, {2, 1, 4}, {1, 5, 1}, {1, 4, 2}, {1, 3, 3}, {1, 2, 4}, {5, 1, 1}, {1, 1, 5}, {3, 1, 2, 1}, {2, 2, 2, 1}, {2, 2, 1, 2}, {2, 1, 3, 1}, {2, 1, 2, 2}, {1, 3, 2, 1}, {1, 3, 1, 2}, {1, 2, 3, 1}, {1, 2, 2, 2}, {1, 2, 1, 3}, {3, 2, 1, 1}, {3, 1, 1, 2}, {2, 3, 1, 1}, {2, 1, 1, 3}, {1, 4, 1, 1}, {1, 1, 4, 1}, {1, 1, 3, 2}, {1, 1, 2, 3}, {4, 1, 1, 1}, {1, 1, 1, 4}, {1, 2, 1, 2, 1}, {2, 1, 2, 1, 1}, {2, 1, 1, 2, 1}, {1, 2, 2, 1, 1}, {1, 2, 1, 1, 2}, {1, 1, 3, 1, 1}, {1, 1, 2, 2, 1}, {1, 1, 2, 1, 2}, {2, 2, 1, 1, 1}, {2, 1, 1, 1, 2}, {1, 3, 1, 1, 1}, {1, 1, 1, 3, 1}, {1, 1, 1, 2, 2}, {3, 1, 1, 1, 1}, {1, 1, 1, 1, 3}, {1, 1, 2, 1, 1, 1}, {1, 1, 1, 2, 1, 1}, {1, 2, 1, 1, 1, 1}, {1, 1, 1, 1, 2, 1}, {2, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 2}, {1, 1, 1, 1, 1, 1, 1}},
            {{8}, {6, 2}, {5, 3}, {4, 4}, {3, 5}, {2, 6}, {7, 1}, {1, 7}, {4, 2, 2}, {3, 3, 2}, {3, 2, 3}, {2, 4, 2}, {2, 3, 3}, {2, 2, 4}, {5, 2, 1}, {5, 1, 2}, {4, 3, 1}, {4, 1, 3}, {3, 4, 1}, {3, 1, 4}, {2, 5, 1}, {2, 1, 5}, {1, 6, 1}, {1, 5, 2}, {1, 4, 3}, {1, 3, 4}, {1, 2, 5}, {6, 1, 1}, {1, 1, 6}, {2, 2, 2, 2}, {4, 1, 2, 1}, {3, 2, 2, 1}, {3, 2, 1, 2}, {3, 1, 3, 1}, {3, 1, 2, 2}, {2, 3, 2, 1}, {2, 3, 1, 2}, {2, 2, 3, 1}, {2, 2, 1, 3}, {2, 1, 4, 1}, {2, 1, 3, 2}, {2, 1, 2, 3}, {1, 4, 2, 1}, {1, 4, 1, 2}, {1, 3, 3, 1}, {1, 3, 2, 2}, {1, 3, 1, 3}, {1, 2, 4, 1}, {1, 2, 3, 2}, {1, 2, 2, 3}, {1, 2, 1, 4}, {4, 2, 1, 1}, {4, 1, 1, 2}, {3, 3, 1, 1}, {3, 1, 1, 3}, {2, 4, 1, 1}, {2, 1, 1, 4}, {1, 5, 1, 1}, {1, 1, 5, 1}, {1, 1, 4, 2}, {1, 1, 3, 3}, {1, 1, 2, 4}, {5, 1, 1, 1}, {1, 1, 1, 5}, {2, 2, 1, 2, 1}, {2, 1, 2, 2, 1}, {2, 1, 2, 1, 2}, {1, 3, 1, 2, 1}, {1, 2, 2, 2, 1}, {1, 2, 2, 1, 2}, {1, 2, 1, 3, 1}, {1, 2, 1, 2, 2}, {3, 1, 2, 1, 1}, {3, 1, 1, 2, 1}, {2, 2, 2, 1, 1}, {2, 2, 1, 1, 2}, {2, 1, 3, 1, 1}, {2, 1, 1, 3, 1}, {2, 1, 1, 2, 2}, {1, 3, 2, 1, 1}, {1, 3, 1, 1, 2}, {1, 2, 3, 1, 1}, {1, 2, 1, 1, 3}, {1, 1, 4, 1, 1}, {1, 1, 3, 2, 1}, {1, 1, 3, 1, 2}, {1, 1, 2, 3, 1}, {1, 1, 2, 2, 2}, {1, 1, 2, 1, 3}, {3, 2, 1, 1, 1}, {3, 1, 1, 1, 2}, {2, 3, 1, 1, 1}, {2, 1, 1, 1, 3}, {1, 4, 1, 1, 1}, {1, 1, 1, 4, 1}, {1, 1, 1, 3, 2}, {1, 1, 1, 2, 3}, {4, 1, 1, 1, 1}, {1, 1, 1, 1, 4}, {2, 1, 1, 2, 1, 1}, {1, 2, 1, 2, 1, 1}, {1, 2, 1, 1, 2, 1}, {1, 1, 2, 2, 1, 1}, {1, 1, 2, 1, 2, 1}, {1, 1, 2, 1, 1, 2}, {2, 1, 2, 1, 1, 1}, {2, 1, 1, 1, 2, 1}, {1, 2, 2, 1, 1, 1}, {1, 2, 1, 1, 1, 2}, {1, 1, 3, 1, 1, 1}, {1, 1, 1, 3, 1, 1}, {1, 1, 1, 2, 2, 1}, {1, 1, 1, 2, 1, 2}, {2, 2, 1, 1, 1, 1}, {2, 1, 1, 1, 1, 2}, {1, 3, 1, 1, 1, 1}, {1, 1, 1, 1, 3, 1}, {1, 1, 1, 1, 2, 2}, {3, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 3}, {1, 1, 1, 2, 1, 1, 1}, {1, 1, 2, 1, 1, 1, 1}, {1, 1, 1, 1, 2, 1, 1}, {1, 2, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 2, 1}, {2, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 2}, {1, 1, 1, 1, 1, 1, 1, 1}},
            {{9}, {7, 2}, {6, 3}, {5, 4}, {4, 5}, {3, 6}, {2, 7}, {8, 1}, {1, 8}, {5, 2, 2}, {4, 3, 2}, {4, 2, 3}, {3, 4, 2}, {3, 3, 3}, {3, 2, 4}, {2, 5, 2}, {2, 4, 3}, {2, 3, 4}, {2, 2, 5}, {6, 2, 1}, {6, 1, 2}, {5, 3, 1}, {5, 1, 3}, {4, 4, 1}, {4, 1, 4}, {3, 5, 1}, {3, 1, 5}, {2, 6, 1}, {2, 1, 6}, {1, 7, 1}, {1, 6, 2}, {1, 5, 3}, {1, 4, 4}, {1, 3, 5}, {1, 2, 6}, {7, 1, 1}, {1, 1, 7}, {3, 2, 2, 2}, {2, 3, 2, 2}, {2, 2, 3, 2}, {2, 2, 2, 3}, {5, 1, 2, 1}, {4, 2, 2, 1}, {4, 2, 1, 2}, {4, 1, 3, 1}, {4, 1, 2, 2}, {3, 3, 2, 1}, {3, 3, 1, 2}, {3, 2, 3, 1}, {3, 2, 1, 3}, {3, 1, 4, 1}, {3, 1, 3, 2}, {3, 1, 2, 3}, {2, 4, 2, 1}, {2, 4, 1, 2}, {2, 3, 3, 1}, {2, 3, 1, 3}, {2, 2, 4, 1}, {2, 2, 1, 4}, {2, 1, 5, 1}, {2, 1, 4, 2}, {2, 1, 3, 3}, {2, 1, 2, 4}, {1, 5, 2, 1}, {1, 5, 1, 2}, {1, 4, 3, 1}, {1, 4, 2, 2}, {1, 4, 1, 3}, {1, 3, 4, 1}, {1, 3, 3, 2}, {1, 3, 2, 3}, {1, 3, 1, 4}, {1, 2, 5, 1}, {1, 2, 4, 2}, {1, 2, 3, 3}, {1, 2, 2, 4}, {1, 2, 1, 5}, {5, 2, 1, 1}, {5, 1, 1, 2}, {4, 3, 1, 1}, {4, 1, 1, 3}, {3, 4, 1, 1}, {3, 1, 1, 4}, {2, 5, 1, 1}, {2, 1, 1, 5}, {1, 6, 1, 1}, {1, 1, 6, 1}, {1, 1, 5, 2}, {1, 1, 4, 3}, {1, 1, 3, 4}, {1, 1, 2, 5}, {6, 1, 1, 1}, {1, 1, 1, 6}, {3, 2, 1, 2, 1}, {3, 1, 2, 2, 1}, {3, 1, 2, 1, 2}, {2, 3, 1, 2, 1}, {2, 2, 2, 2, 1}, {2, 2, 2, 1, 2}, {2, 2, 1, 3, 1}, {2, 2, 1, 2, 2}, {2, 1, 3, 2, 1}, {2, 1, 3, 1, 2}, {2, 1, 2, 3, 1}, {2, 1, 2, 2, 2}, {2, 1, 2, 1, 3}, {1, 4, 1, 2, 1}, {1, 3, 2, 2, 1}, {1, 3, 2, 1, 2}, {1, 3, 1, 3, 1}, {1, 3, 1, 2, 2}, {1, 2, 3, 2, 1}, {1, 2, 3, 1, 2}, {1, 2, 2, 3, 1}, {1, 2, 2, 2, 2}, {1, 2, 2, 1, 3}, {1, 2, 1, 4, 1}, {1, 2, 1, 3, 2}, {1, 2, 1, 2, 3}, {4, 1, 2, 1, 1}, {4, 1, 1, 2, 1}, {3, 2, 2, 1, 1}, {3, 2, 1, 1, 2}, {3, 1, 3, 1, 1}, {3, 1, 1, 3, 1}, {3, 1, 1, 2, 2}, {2, 3, 2, 1, 1}, {2, 3, 1, 1, 2}, {2, 2, 3, 1, 1}, {2, 2, 1, 1, 3}, {2, 1, 4, 1, 1}, {2, 1, 1, 4, 1}, {2, 1, 1, 3, 2}, {2, 1, 1, 2, 3}, {1, 4, 2, 1, 1}, {1, 4, 1, 1, 2}, {1, 3, 3, 1, 1}, {1, 3, 1, 1, 3}, {1, 2, 4, 1, 1}, {1, 2, 1, 1, 4}, {1, 1, 5, 1, 1}, {1, 1, 4, 2, 1}, {1, 1, 4, 1, 2}, {1, 1, 3, 3, 1}, {1, 1, 3, 2, 2}, {1, 1, 3, 1, 3}, {1, 1, 2, 4, 1}, {1, 1, 2, 3, 2}, {1, 1, 2, 2, 3}, {1, 1, 2, 1, 4}, {4, 2, 1, 1, 1}, {4, 1, 1, 1, 2}, {3, 3, 1, 1, 1}, {3, 1, 1, 1, 3}, {2, 4, 1, 1, 1}, {2, 1, 1, 1, 4}, {1, 5, 1, 1, 1}, {1, 1, 1, 5, 1}, {1, 1, 1, 4, 2}, {1, 1, 1, 3, 3}, {1, 1, 1, 2, 4}, {5, 1, 1, 1, 1}, {1, 1, 1, 1, 5}, {2, 1, 2, 1, 2, 1}, {1, 2, 2, 1, 2, 1}, {1, 2, 1, 2, 2, 1}, {1, 2, 1, 2, 1, 2}, {3, 1, 1, 2, 1, 1}, {2, 2, 1, 2, 1, 1}, {2, 2, 1, 1, 2, 1}, {2, 1, 2, 2, 1, 1}, {2, 1, 2, 1, 1, 2}, {2, 1, 1, 3, 1, 1}, {2, 1, 1, 2, 2, 1}, {2, 1, 1, 2, 1, 2}, {1, 3, 1, 2, 1, 1}, {1, 3, 1, 1, 2, 1}, {1, 2, 2, 2, 1, 1}, {1, 2, 2, 1, 1, 2}, {1, 2, 1, 3, 1, 1}, {1, 2, 1, 1, 3, 1}, {1, 2, 1, 1, 2, 2}, {1, 1, 3, 2, 1, 1}, {1, 1, 3, 1, 2, 1}, {1, 1, 3, 1, 1, 2}, {1, 1, 2, 3, 1, 1}, {1, 1, 2, 2, 2, 1}, {1, 1, 2, 2, 1, 2}, {1, 1, 2, 1, 3, 1}, {1, 1, 2, 1, 2, 2}, {1, 1, 2, 1, 1, 3}, {3, 1, 2, 1, 1, 1}, {3, 1, 1, 1, 2, 1}, {2, 2, 2, 1, 1, 1}, {2, 2, 1, 1, 1, 2}, {2, 1, 3, 1, 1, 1}, {2, 1, 1, 1, 3, 1}, {2, 1, 1, 1, 2, 2}, {1, 3, 2, 1, 1, 1}, {1, 3, 1, 1, 1, 2}, {1, 2, 3, 1, 1, 1}, {1, 2, 1, 1, 1, 3}, {1, 1, 4, 1, 1, 1}, {1, 1, 1, 4, 1, 1}, {1, 1, 1, 3, 2, 1}, {1, 1, 1, 3, 1, 2}, {1, 1, 1, 2, 3, 1}, {1, 1, 1, 2, 2, 2}, {1, 1, 1, 2, 1, 3}, {3, 2, 1, 1, 1, 1}, {3, 1, 1, 1, 1, 2}, {2, 3, 1, 1, 1, 1}, {2, 1, 1, 1, 1, 3}, {1, 4, 1, 1, 1, 1}, {1, 1, 1, 1, 4, 1}, {1, 1, 1, 1, 3, 2}, {1, 1, 1, 1, 2, 3}, {4, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 4}, {1, 2, 1, 1, 2, 1, 1}, {1, 1, 2, 1, 2, 1, 1}, {1, 1, 2, 1, 1, 2, 1}, {2, 1, 1, 2, 1, 1, 1}, {2, 1, 1, 1, 2, 1, 1}, {1, 2, 1, 2, 1, 1, 1}, {1, 2, 1, 1, 1, 2, 1}, {1, 1, 2, 2, 1, 1, 1}, {1, 1, 2, 1, 1, 1, 2}, {1, 1, 1, 3, 1, 1, 1}, {1, 1, 1, 2, 2, 1, 1}, {1, 1, 1, 2, 1, 2, 1}, {1, 1, 1, 2, 1, 1, 2}, {2, 1, 2, 1, 1, 1, 1}, {2, 1, 1, 1, 1, 2, 1}, {1, 2, 2, 1, 1, 1, 1}, {1, 2, 1, 1, 1, 1, 2}, {1, 1, 3, 1, 1, 1, 1}, {1, 1, 1, 1, 3, 1, 1}, {1, 1, 1, 1, 2, 2, 1}, {1, 1, 1, 1, 2, 1, 2}, {2, 2, 1, 1, 1, 1, 1}, {2, 1, 1, 1, 1, 1, 2}, {1, 3, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 3, 1}, {1, 1, 1, 1, 1, 2, 2}, {3, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 3}, {1, 1, 1, 2, 1, 1, 1, 1}, {1, 1, 1, 1, 2, 1, 1, 1}, {1, 1, 2, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 2, 1, 1}, {1, 2, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 2, 1}, {2, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 2}, {1, 1, 1, 1, 1, 1, 1, 1, 1}}
    };

    public final static ArrayList<String> dictResult = new ArrayList<>(16);
    final static public StringBuilder
            sql = new StringBuilder(2048),
            pSQL = new StringBuilder(2048),
            pinyin = new StringBuilder(32),
            ziLock = new StringBuilder(16),   // after dict select or direct zi pinyin
            ziOrig = new StringBuilder(16),   // before dict select
            sentence = new StringBuilder(16);
    final static ArrayList<StringBuilder>[][] queryResult = new ArrayList[10][]; // [length][start at][i]
    final static String[][] resultPriority = new String[10][];
    final static int[][] resultCost = new int[10][];
    final static ArrayList<StringBuilder>
            candidateLeft = new ArrayList<>(16),
            candidateRight = new ArrayList<>(16),
            wordsInDictRight = new ArrayList<>(24);
    final static String[] qs = {
            "select * from(", //0
            "select group_concat(c),group_concat((o<1001)+abs(o%2<<1)+((o<0)<<2),''),min(o)from(select c,o from s", //1
            " where p in(", //2
            "and c glob'", //3
            "group by c order by o)union all ", //4
            "group by c order by o))", //5
    };
    final static int qs0Length = qs[0].length();
    final static String[] pq = {
            "select c,p from(",
            "select c,p,o from s",
            " where p glob'",
            "'and c glob'",
            "'and o<1001 union all ",
            "'and o<1001)group by c order by o,length(c) limit 3"
    };
    final static int pq0Length = pq[0].length();
    final static String[] predictionResults = new String[3];
    final static StringBuilder[] predictionPinyin = new StringBuilder[3];
    final static int[] predictionStartPosition = new int[3];
    final static String[] arg = new String[1];
    public static SQLiteDatabase db;
    static Cursor cursor = null;
    static int separatorAnswer[];

    public static void init() throws Exception {
        // open DB
        android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_DISPLAY);
        for (int i = 0; i < predictionPinyin.length; i++) {
            predictionPinyin[i] = new StringBuilder(18);
        }
        sql.append(qs[0]);
        pSQL.append(pq[0]);
//        for (int i = 0; i < 3; i++)
//            predictionResults[i] = new StringBuilder(9);

        if (db != null && db.isOpen()) return;
        SQLiteDatabase.loadLibs(C.mainService);
        db = SQLiteDatabase.openDatabase(
                C.mainService.getDatabasePath(C.DBFileName).getAbsolutePath(),
                "",
                null,
                SQLiteDatabase.OPEN_READWRITE | SQLiteDatabase.NO_LOCALIZED_COLLATORS
        );

        cursor = db.rawQuery("select v from meta where k='version'", null);
        cursor.moveToNext();
        if (cursor.getLong(0) != C.DBVersion) throw new Exception("Database upgrade needed");
        cursor.close();

        db.execSQL("PRAGMA synchronous = OFF;");
        db.execSQL("PRAGMA temp_store = MEMORY;");
        cursor = db.rawQuery("PRAGMA mmap_size=16777216;", null);
        cursor.moveToNext();
        cursor.close();
        cursor = db.rawQuery("PRAGMA journal_mode = OFF;", null);
        cursor.moveToNext();
        cursor.close();
        cursor = db.rawQuery("PRAGMA locking_mode = EXCLUSIVE;", null);
        cursor.moveToNext();
        cursor.close();

        Transform.init();
        for (int i = 1; i <= 9; i++) {
            queryResult[i] = new ArrayList[9 - i + 1];
            resultPriority[i] = new String[9 - i + 1];
            resultCost[i] = new int[9 - i + 1];
        }
        // warm up engine
        final String[]
                p = {"GuLbFaTiKhLnLrWbLu", "E4SuCaH3KjAaMt", "GuLbFaTiKhLnLrWbLu"},
                z = {"你我他????所以", "的是嗎了很吧就", "?????????"};
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < z[j].length(); i++) {
                Engine.pinyin.append(p[j].substring(i + i, i + i + 2));
                Engine.ziLock.append(z[j].substring(i, i + 1));
                Engine.queryDB();
                Engine.readQueryResult();
                Engine.makeSeparator();
                Engine.makeSentence();
            }
            Engine.clear();
        }
        Learner.init();
    }

    public static void close() {
        try {
            cursor.close();
        } catch (Exception e) {
        }
        try {
            db.close();
        } catch (Exception e) {
        }
    }

    public static void clear() {
        pinyin.setLength(0);
        ziLock.setLength(0);
        ziOrig.setLength(0);
        sentence.setLength(0);
        for (int i = 1; i <= 9; i++)
            for (int j = 0; j < 9 - i + 1; j++) {
                BufferedSplitter.releaseArrayList(queryResult[i][j]);
                queryResult[i][j] = null;
            }
        candidateLeft.clear();
        candidateRight.clear();
    }

    public static boolean isEmpty() {
        return getLength() == 0;
    }

    public static int getLength() {
        return pinyin.length() / 2;
    }


    public static void add(final char keyCode) {
        pinyin.append(keyCode);
//        System.out.println("Engine add" + pinyin);
    }

    public static void add(final char keyCode, final char characterLock) {
        pinyin.append(keyCode);
        ziLock.append(characterLock);
        ziOrig.append(characterLock);
//        System.out.println("Engine add" + pinyin);
    }

    public static void setZiLock(final int index, final char zi) {
        ziLock.setCharAt(index, zi);
        sentence.setCharAt(index, zi);
    }

    /**
     * STEP 1: select database
     * select * from(select group_concat(c)from(select distinct c from s1 where p in('Qp')and c glob'?'order by o))
     * select * from(select group_concat(c)from(select distinct c from s1 where p in('Ln')and c glob'?'order by o)union all select group_concat(c)from(select c from s2 where p in('QpLn')and c glob'??'order by o))
     */
    public static void queryDB() {
        sql.setLength(qs0Length);
        final int length = getLength(), pinyinLength = length + length;

        sql.append(qs[1]); // select group_concat(c)from(select distinct c from s
        sql.append('1');
        sql.append(qs[2]); //  where p in(
        Transform.expandQuery(pinyin, pinyinLength - 2, Engine.sql);
        sql.append(')');
        if (needGlobbing(length - 1, length)) {
            sql.append(qs[3]); // and c glob'
            sql.append(ziLock, length - 1, length);
            sql.append('\'');
        }

        for (int i = length - 2; i >= 0; i--) {
            sql.append(qs[4]); // order by o)union all
            sql.append(qs[1]);
            sql.append(length - i);
            sql.append(qs[2]); //  where p in(
            Transform.expandQuery(pinyin, i + i, Engine.sql);
            sql.append(')');
            if (needGlobbing(i, length)) {
                sql.append(qs[3]); // and c glob'
                sql.append(ziLock, i, length);
                sql.append('\'');
            }
        }
        sql.append(qs[5]);
//        System.out.println(sql);
//        System.out.println(pinyin);
//        System.out.println(ziLock);
        cursor = db.rawQuery(sql.toString(), null);
    }

    static boolean needGlobbing(int start, int end) {
        for (int i = start; i < end; i++)
            if (ziLock.charAt(i) != '?') return true;
        return false;
    }

    public static void queryDict(final int index) {
        arg[0] = pinyin.substring(index * 2, index * 2 + 2);
        cursor = db.rawQuery("select z, c from d where p=? order by o", arg);
        dictResult.clear();
        while (cursor.moveToNext()) {
            dictResult.add(cursor.getString(0));
            dictResult.add(cursor.getString(1));
        }
        cursor.close();
    }

    public static void readQueryResult() {
        int i = 1, end = getLength();
        while (cursor.moveToNext()) {
            String result = cursor.getString(0); // 0 based
//            System.out.println("STRING: " + result);

            ArrayList<StringBuilder> list = queryResult[i][end - i];
            BufferedSplitter.releaseArrayList(list);
            queryResult[i][end - i] = result == null ? null : BufferedSplitter.split(result);
            resultPriority[i][end - i] = result == null ? null : cursor.getString(1);
            resultCost[i][end - i] = result == null ? Integer.MAX_VALUE : cursor.getInt(2);
//            Logger.d("S: %s, F: %s", result, cursor.getString(1));
//            if (result != null) {
//                for (CharSequence s : queryResult[i][end - i])
//                    System.out.print(s + "/");
//                System.out.println("#");
//            }
            i++;
        }
        cursor.close();
    }

    public static void makeSeparator() throws Exception {
        boolean found;
        int counter, cost;
        int bestCost = Integer.MAX_VALUE;
        final int length = getLength();
        try {
            for (int[] a : separator[length - 1]) {
                found = true;
                counter = 0;
                cost = 0;
                for (int b : a) {
                    if (queryResult[b][counter] == null) {
                        found = false;
                        break;
                    }
                    cost += resultCost[b][counter];
                    counter += b;
                }
                if (found && cost < bestCost) {
                    separatorAnswer = a;
                    bestCost = cost;
//                    return;
                }
            }
            if (bestCost < Integer.MAX_VALUE) return;
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new Exception("No matched separator");
    }

    public static void makeSentence() {
        int counter = 0;
        sentence.setLength(0);
        for (int i : separatorAnswer) {
            // find proper index for get
            String priority = resultPriority[i][counter];
            int selectedIndex = 0, len = priority.length();
            for (int j = 0; j < len; j++)
                if (priority.charAt(j) > '1') {
                    selectedIndex = j;
                    break;
                }

            // get word
            sentence.append(queryResult[i][counter].get(selectedIndex));
            counter += i;
        }
        // force apply character lock
        int len = getLength();
        for (int i = 0; i < len; i++) {
            char c = ziLock.charAt(i);
            if (c != '?') sentence.setCharAt(i, c);
        }
    }

    public static void makeCandidateLeft() {
        candidateLeft.clear();
        for (int i = getLength() - 1; i > 0; i--)
            if (queryResult[i][0] != null) {
                ArrayList<StringBuilder> list = queryResult[i][0];
                String priority = resultPriority[i][0];
                int end = list.size();
                for (int j = 0; j < end; j++) {
                    char p = priority.charAt(j);
                    if (p == '2' || p == '0') continue;
                    candidateLeft.add(list.get(j));
                }
            }
    }

    public static void makeCandidateRight() {
        int length = getLength();
        candidateRight.clear();
        for (int i = getLength(); i > 0; i--)
            if (queryResult[i][length - i] != null) {
                ArrayList<StringBuilder> list = queryResult[i][length - i];
                String priority = resultPriority[i][length - i];
                int end = list.size();
                for (int j = 0; j < end; j++) {
                    char p = priority.charAt(j);
                    if (p == '2' || p == '0') continue;
                    candidateRight.add(list.get(j));
                }
            }
    }

    public static String pop(final int popLength) {
        int originalLength = getLength();
        if (popLength >= originalLength) {
            String result = sentence.toString();
            clear();
            return result;
        }
        String result = sentence.substring(0, popLength);
        sentence.delete(0, popLength);
        ziLock.delete(0, popLength);
        ziOrig.delete(0, popLength);
        pinyin.delete(0, popLength * 2);

        int newLength = originalLength - popLength;
        for (int i = 1; i <= newLength; i++)
            for (int j = 0; j <= newLength - i; j++) {
                BufferedSplitter.releaseArrayList(queryResult[i][j]);
                queryResult[i][j] = queryResult[i][j + popLength];
                queryResult[i][j + popLength] = null;
                resultPriority[i][j] = resultPriority[i][j + popLength];
                resultPriority[i][j + popLength] = null;
                resultCost[i][j] = resultCost[i][j + popLength];
                resultCost[i][j + popLength] = Integer.MAX_VALUE;
            }
        for (int i = 1; i <= originalLength; i++)
            for (int j = Math.max(newLength - i + 1, 0); j <= originalLength - i; j++) {
                BufferedSplitter.releaseArrayList(queryResult[i][j]);
                queryResult[i][j] = null;
                resultPriority[i][j] = null;
                resultCost[i][j] = Integer.MAX_VALUE;
            }

        makeCandidateLeft();
        makeCandidateRight();
        try {
            makeSeparator();
        } catch (Exception e) {
            e.printStackTrace();
            Engine.clear();
            C.sentenceView.display();
            Controller.displayCandidates();
            return result;
        }
        makeSentence();

        return result;
    }

    public static String pop() {
        return pop(separatorAnswer[0]);
    }

    public static void delCharacter() { // TODO: 2016/3/1 check! moved from old Engine
        int length = pinyin.length();
        if (length == 0 || length == 2) clear();
        else if (length % 2 != 0) {
            if (C.debug) System.err.println("Error: On del character, pinyin not even!");
        } else {
            pinyin.delete(length - 2, length);
            int end = ziLock.length();
            ziLock.delete(end - 1, end);
            ziOrig.delete(end - 1, end);
            for (int start = 0; start < end; start++) {
                BufferedSplitter.releaseArrayList(queryResult[end - start][start]);
                queryResult[end - start][start] = null;
            }
        }
    }

    public static void delConsonant() {
        int length = pinyin.length();
        if (length % 2 != 1) {
            if (C.debug) System.err.println("Error: On del consonant, pinyin not odd!");
        } else {
            pinyin.delete(length - 1, length);
        }
    }

    public static void queryPrediction() {
        for (int i = 0; i < 3; i++)
            predictionResults[i] = null;
        if (pinyin.length() < 3) return;
        Timer.t(847);
        int resultCount = 0;

        int len = pinyin.length();
        for (int start = 0; start < len - 1; start += 2) {
            pSQL.setLength(pq0Length);
            for (int end = len + 1; end <= 18; end += 2) {
                if (end != len + 1) pSQL.append(pq[4]); // ' union all
                pSQL.append(pq[1]); // select c, o from s
                pSQL.append((end - start) / 2);
                pSQL.append(pq[2]); //  where p glob '
                pSQL.append(Transform.toGlob(pinyin, start));
                for (int i = len; i < end; i++) pSQL.append('?');
                pSQL.append(pq[3]); // ' and c glob '
                pSQL.append(ziOrig, start / 2, len / 2);
                for (int i = len; i < end; i += 2) pSQL.append('?');
            }
            pSQL.append(pq[5]);

//            System.out.println(pSQL);
            Cursor pCursor = db.rawQuery(pSQL.toString(), null);
            boolean shouldBreak = false;
            while (pCursor.moveToNext()) {
                predictionStartPosition[resultCount] = start / 2;
                predictionResults[resultCount] = pCursor.getString(0);
                StringBuilder pp = predictionPinyin[resultCount++];
                pp.setLength(0);
                pp.append(pCursor.getString(1));
                if (resultCount >= 3) {
                    shouldBreak = true;
                    pCursor.close();
                    break;
                }
            }
            pCursor.close();
            if (shouldBreak) break;
        }
        Timer.t(847, "Query prediction");

//        for (int i = 0; i < 3; i++)
//            System.out.print(" " + predictionResults[i]);
//        System.out.println();
    }

//    public static ArrayList<StringBuilder> getWordsInDictLeft(int position) {
//        wordsInDictLeft.clear();
//        for (int len = position + 1; len > 1; len--) {
//            int startAt = position + 1 - len;
//            copyArrayList(queryResult[len][startAt], wordsInDictLeft);
//        }
//        return wordsInDictLeft;
//    }

    public static ArrayList<StringBuilder> getWordsInDictRight(int position) {
        wordsInDictRight.clear();
        for (int len = getLength() - position; len > 1; len--) {
            copyArrayList(queryResult[len][position], wordsInDictRight);
        }
        return wordsInDictRight;
    }

    static void copyArrayList(ArrayList<StringBuilder> from, ArrayList<StringBuilder> to) {
        if (from == null) return;
        int len = from.size();
        for (int i = 0; i < len; i++)
            to.add(from.get(i));
    }
}

