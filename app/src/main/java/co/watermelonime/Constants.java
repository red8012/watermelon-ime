package co.watermelonime;

import java.util.HashMap;

public class Constants {
    public static final int ZHUYIN = 0, PINYIN = 1;
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
    public static final String kb1[][] = {
            {//Zhuyin
                    "ㄅ", "ㄉ", "ㄍ", "ㄐ", "ㄓ", "ㄗ",
                    "ㄆ", "ㄊ", "ㄎ", "ㄑ", "ㄔ", "ㄘ",
                    "ㄇ", "ㄋ", "ㄏ", "ㄒ", "ㄕ", "ㄙ",
                    "ㄈ\n符號", "ㄌ", "ㄧㄨㄩ\n...其他", "ㄖ\n符號"},
            {//pinyin
                    "b", "d", "g", "j", "zh", "z",
                    "p", "t", "k", "q", "ch", "c",
                    "m", "n", "h", "x", "sh", "s",
                    "f\n符号", "l", "aeowy\n...其他", "r\n符号"},
    };
    public static final String kb1code[] =
            {"A", "E", "I", "M", "Q", "U",
                    "B", "F", "J", "N", "R", "V",
                    "C", "G", "K", "O", "S", "W",
                    "D", "H", "L", "T"};
    public static final String kb2[][] = {
            {
                    "　ㄧㄨ\nㄚㄚㄚ", "ㄞ", "ㄢ", "ㄧㄨㄩ\nㄢㄢㄢ", "ㄧㄨ\nㄞㄞ", "ㄧ",
                    "　ㄧㄨ\nㄛㄛㄛ", "ㄟ", "ㄣ", "ㄧㄨㄩ\nㄣㄣㄣ", "ㄨㄩ\nㄟㄝ", "ㄨ",
                    "ㄜㄝ", "ㄠ", "ㄤ", "ㄧㄨ\nㄤㄤ", "ㄧ\nㄠ", "ㄩ",
                    "ㄧ\nㄝ", "ㄡ", "ㄥㄦ", "ㄧㄨㄩ\nㄥㄥㄥ", "ㄧ\nㄡ"},
            {
                    " a\nia\nua", "ai", "an", "ian\nuan\nüan", "uai", "i",
                    " o\nuo", "ei", "en", "in\nun\nün", "ui\nüe", "u",
                    "e\nê", "ao", "ang", "iang\nuang", "iao", "ü",
                    "ie", "ou", "eng\ner ", " ing\n ong\niong", "iu"},
            {
                    " a\nya\nwa", "ai", "an", " yan\n wan\nyuan", "wai\nyai", "yi",
                    " o\nyo\nwo", "ei", "en", "yin\nwen\nyun", "wui\nyue", "wu",
                    "e\nê", "ao", "ang", "yang\nwang", "yao", "yu",
                    "ye", "ou", "eng\ner ", "ying\nwong\nyong", "you"},
            {
                    "a\n?a", "ai", "an", "?an", "?ai", "i",
                    "o\n?o", "ei", "en", "?n", "ei/ui\nüe", "u",
                    "e/ê", "ao", "ang", "?ang", "iao", "ü",
                    "ie", "ou", "eng", "?ng", "iu"}
    };
    public static final String kb2code[] = {
            "a", "e", "i", "m", "q", "u",
            "b", "f", "j", "n", "r", "v",
            "c", "g", "k", "o", "s", "keyboardWidth",
            "d", "h", "l", "p", "t"};
    public static final int[][] keysToChange = {
            {4, 10, 12, 15, 17, 19, 22}, // 0
            {4, 8, 15, 17},
            {5, 16, 17, 18, 22},
            {1, 2, 4, 6, 7, 8, 11, 12, 13, 14, 19, 20},
            {16, 17, 18, 22},
            {4, 15, 16, 17, 18, 22}, // 5
            {4, 10, 12, 15, 17, 22},
            {4, 7, 8, 15, 17, 22},
            {5, 7, 16, 17, 18, 22},
            {1, 2, 4, 6, 7, 8, 11, 12, 13, 14, 19, 20},
            {7, 16, 17, 18, 22}, // 10
            {4, 7, 15, 16, 17, 18, 22},
            {4, 10, 15, 17},
            {4},
            {5, 16, 17, 18, 22},
            {1, 2, 4, 6, 7, 8, 11, 12, 13, 14, 19, 20}, // 15
            {16, 17, 18, 21, 22},
            {4, 7, 15, 16, 17, 18, 22},
            {1, 3, 4, 5, 9, 10, 12, 13, 15, 17, 18, 22},
            {4, 8},
            {}, // 20
            {0, 1, 4, 7, 15, 16, 17, 18, 22},
    };
    public static final String[][] textToChange = {
            {"比", "吧", "被", "把", "不", "別", "並"},
            {"的", "但", "得", "地"},
            {"個", "跟", "過", "各", "搞"},
            {null, null, "及", null, null, "僅", "即", null, null, "將", null, "就"},
            {"之", "只", "著", "至"},
            {"在", "最", "再", "做", "怎", "作"},
            {"拍", "排", null, "派", null, null},
            {"它", "他", "她", "牠", "太", null},
            {null, "開", null, null, "可", null},
            {null, "前", "其", null, null, "卻", "去", "且", null, null, null, null},
            {"超", null, null, null, null},
            {"此", "才", "從", null, null, null, null},
            {"買", "賣", "嗎", "嘛"},
            {"你"},
            {"和", "會", "或", "還", "很"},
            {null, "先", null, null, null, "想", "須", "些", "向", "像", "型", "性"},
            {"是", "時", null, "使", "事"},
            {"雖", "所", null, "似", null, null, null},
            {"非", "『", "』", "\"", "「", "」", "+", "&", "（", "）", "=", "…"},
            {"啦", "了"},
            {},
            {"─", "：", "、", "；", "？", "。", "！", "‧", "，"}
    };
    public static final String[][] vowelToChange = {
            {"u", "a", "f", "a", "v", "d", "p"},
            {"1", "i", "2", "3"},
            {"c", "j", "b", "c", "g"},
            {null, null, "u", null, null, "n", "u", null, null, "o", null, "t"},
            {"u", "u", "4", "u"},
            {"e", "r", "e", "b", "5", "b"},
            {"e", "e", null, "e", null, null},
            {"a", "a", "a", "a", "e", null},
            {null, "e", null, null, "c", null},
            {null, "m", "u", null, null, "r", "keyboardWidth", "d", null, null, null, null},
            {"g", null, null, null, null},
            {"u", "e", "p", null, null, null, null},
            {"e", "e", "a", "a"},
            {"u"},
            {"6", "r", "b", "7", "j"},
            {null, "m", null, null, null, "o", "keyboardWidth", "d", "o", "o", "p", "p"},
            {"u", "u", null, "u", "u"},
            {"r", "b", null, "u", null, null, null},
            {"f", "『", "』", "\"", "「", "」", "+", "&", "（", "）", "=", "…"},
            {"a", "8"},
            {},
            {null, null, null, null, null, null, null, null, null}
    };
    public static final String[][] colemak = {
            {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"},
            {"q", "keyboardWidth", "f", "p", "g", "j", "l", "u", "y", ";"},
            {"a", "r", "s", "t", "d", "h", "n", "e", "i", "o"},
            {"z", "x", "c", "v", "b", "k", "m", ",", ".", "/"},
    };
    public static final String number[] = {
            "$", "¥", "€", "<", ">", "#",
            "7", "8", "9", "(", ")", "%",
            "4", "5", "6", "+", "×", "÷",
            "1", "2", "3", "-", "*", "/",
            "0", ".", ",", "="};
    public static final String chineseNumber[] = {
            "年", "月", "日", "時", "分", "秒",
            "七", "八", "九", "十", "百", "千",
            "四", "五", "六", "萬", "億", "兆",
            "一", "二", "三", "度", "元", "號",
            "〇", "‧", "負", "⬆"};
    public static final String chineseCapital[] = {
            "年", "月", "日", "時", "分", "秒",
            "柒", "捌", "玖", "拾", "佰", "仟",
            "肆", "伍", "陸", "萬", "億", "兆",
            "壹", "貳", "參", "度", "圓", "號",
            "零", "點", "負", "⬆"};
    final public static String[] simpleFace = {
            ":)", ":-)", "^_^", ">_<", "0.0", "@_@", "╰_╯", "〒_〒", "╯﹏╰", ":D", ":P", ":("
    };
    final public static String[] emojiFace = {
            "(╯^╰〉", "(•ิ_•ิ)?", "o_O ||", "\\^o^/", "(-_-;)",
            "(×_×)", "(^ム^)", ">///<", "(・ェ・)", "(・_・)",
            "(≧∀≦)", "(≧_≦)", "(≧o≦)", "(≧д≦)", "(≧ロ≦)",
            "(＾∀＾)", "(＾_＾)", "(＾o＾)", "(＾д＾)", "(＾ロ＾)",
            "(⌒∀⌒)", "(⌒_⌒)", "(⌒o⌒)", "(⌒д⌒)", "(⌒ロ⌒)",
            "(・∀・)", "(・_・)", "(・o・)", "(・д・)", "(・ロ・)",
            "(￣∀￣)", "(￣_￣)", "(￣o￣)", "(￣д￣)", "(￣ロ￣)",
            "(=∀=)", "(=_=)", "(=o=)", "(=д=)", "(=ロ=)",
            "(Ｔ∀Ｔ)", "(Ｔ_Ｔ)", "(ＴoＴ)", "(ＴдＴ)", "(ＴロＴ)"
    };
    final public static String[] complexFace = {
            "(^_-)-☆", "(*^﹏^*)", "Y(^_^)Y",
            "＼(^o^)／", "(*^_^*)", "(#^.^#)",
            "(*´Д｀)", "	*\\(^_^)/",
            "(ﾟ∀ﾟ)o彡", "*\\( ^ v ^ )/*",
            "\\(╯-╰)/", "(￣∠ ￣)ﾉ",
            ">_<|||", ">\"<||||",
            "|(- _-)|", "m(_　_)m",
            "`(*^﹏^*)′", "(＠_＠;)",
            "(~_~;)", "(→_→)", "(´・ω・`)",
            "(-_-メ)", "(~_~メ)", "(‵▽′)Ψ"
    };
    final public static String[] singleMark = {
            "£", "₤", "€", "￥", "$", "￠", "¢", "฿", "₩", "₫",
            "♪", "♬", "♭", "♯", "仝", "彡", "々", "〆", "〒", "♨",
            "◎", "※", "✔", "✘", "♀", "♂", "☎", "™", "®", "©",
            "・", "〃", "゛", "゜", "｜", "☞", "±", "∅", "⊕", "°",
            "≪", "≫", "≦", "≧", "≒", "≠", "×", "÷", "∋", "∌",
            "⊂", "⊃", "⊆", "⊇", "∩", "∪", "∧", "∨", "∈", "∉",
            "∑", "√", "∀", "∂", "∃", "∇", "∝", "∞", "∠", "∟",
            "∴", "∵", "‖", "∫", "∬", "∮", "§", "‰", "%", "Å",
            "♠", "♥", "♦", "♣", "●", "■", "◆", "▲", "▼", "★",
            "♤", "♡", "♢", "○", "♧", "□", "◇", "△", "▽", "☆"
    };
    final public static String[] pair = {
            "（", "）", "｛", "｝", "【", "】", "〔", "〕", "〈", "〉",
            "「", "」", "『", "』", "《", "》", "〝", "〟", "［", "］",
            "(", ")", "{", "}", "[", "]", "“", "”", "‘", "’",
            "↑", "↓", "←", "→", "↖", "↘", "↗", "↙", "↕", "↔",
            "⇑", "⇓", "⇐", "⇒", "⇖", "⇘", "⇗", "⇙", "↺", "↻",
            "⇧", "⇩", "⇦", "⇨", "↶", "↷"
    };
    public static final String faceAndPeople =
            "😋 😜 😝 😠 😩 😲 😞 😵 😰 😒 😍 😤 😘 😚 😷 😳 😃 😅 😆 😁 😂 😊 ☺ 😄 😢 😭 😨 😣 😡 😌 😖 😔 😱 😪 😏 😓 😥 😫 😉 😺 😸 😹 😽 😻 😿 😾 😼 🙀 💡 💢 💣 💤 💥 💦 💧 💨 💩 💪 💫 💬 👤 👦 👧 👨 👩 👪 👫 👮 👯 👰 👱 👲 👳 👴 👵 👶 👷 👸 👹 👺 👻 👼 👽 👾 👿 💀 💁 💂 💃 🙅 🙆 🙇 🙋 🙍 🙎 👀 👂 👃 👄 👅 🙌 🙏 ✊ ✋ ✌ 👊 👍 ☝ 👆 👇 👈 👉 👋 👏 👌 👎 👐 ";
    public static final String animalAndPlants =
            "🍀 🌷 🌱 🍁 🌸 🌹 🍂 🍃 🌺 🌻 🌴 🌵 🌾 🌽 🍄 🌰 🌼 🌿 🍒 🍌 🍎 🍊 🍓 🍉 🍅 🍆 🍈 🍍 🍇 🍑 🍏 🐌 🐍 🐎 🐔 🐗 🐫 🐘 🐨 🐒 🐑 🐙 🐚 🐛 🐜 🐝 🐞 🐠 🐡 🐢 🐤 🐥 🐦 🐣 🐧 🐩 🐟 🐬 🐭 🐯 🐱 🐳 🐴 🐵 🐶 🐷 🐻 🐹 🐺 🐮 🐰 🐸 🐾 🐲 🐼 🐽 🙈 🙊 🙉";
    public static final String foodAndClothing =
            "🍔 🍙 🍰 🍜 🍞 🍳 🍦 🍟 🍡 🍘 🍚 🍝 🍛 🍢 🍣 🍱 🍲 🍧 🍖 🍥 🍠 🍕 🍗 🍨 🍩 🍪 🍫 🍬 🍭 🍮 🍯 🍤 🍴 ☕ 🍸 🍺 🍵 🍶 🍷 🍻 🍹 👞 👟 👠 👡 👢 👣 👓 👕 👖 👑 👔 👒 👗 👘 👙 👚 👛 👜 👝 💄 ";
    public static final String placeAndVehicle =
            "🏠 🏡 🏢 🏣 🏥 🏦 🏧 🏨 🏩 🏪 🏫 ⛪ ⛲ 🏬 🏯 🏰 🏭 ⚓ 🏮 🗻 🗼 🗽 🗾 🗿 🚲 🚶 🚃 🚇 🚄 🚅 🚗 🚙 🚌 🚏 🚢 ✈ ⛵ 🚉 🚀 🚤 🚕 🚚 🚒 🚑 🚓 ⛽ 🅿 🚥 🚧 🚨 🚹 🚺 🛀 🚻 🚽 🚾 🚼 🚪 🚬 🚭 ♿ 🚩 ⚠ ⛔ ♻ ";
    public static final String activities =
            "♨ ⛺ 🎠 🎡 🎢 💅 💆 💇 💈 🎽 ⚾ ⛳ 🎾 ⚽ 🎿 🏀 🏁 🏂 🏃 🏄 🏆 🏈 🏊 🎣 🎤 🎥 🎦 🎧 🎨 🎩 🎪 🎫 🎬 🎭 🎮 🀄 🎯 🎰 🎱 🎲 🎳 🎴 🃏 🎵 🎶 🎷 🎸 🎹 🎺 🎻 🎼 〽 💉 💊 🎀 🎁 🎂 🎄 🎅 🎌 🎆 🎈 🎉 🎍 🎎 🎓 🎒 🎏 🎇 🎐 🎃 🎊 🎋 🎑 💱 💹 💏 💐 💑 💒 🔞 ";
    public static final String things =
            "💰 💲 💳 💴 💵 💸 🔥 🔦 🔧 🔨 🔩 🔪 🔫 🔮 🔯 🔰 🔱 📟 ☎ 📞 📱 📲 📝 📠 ✉ 📨 📩 📪 📫 📮 📰 📢 📣 📡 📤 📥 📦 📧 ✒ 💺 💻 ✏ 📎 💼 💽 💾 💿 📀 ✂ 📍 📃 📄 📅 📁 📂 📓 📖 📔 📕 📗 📘 📙 📚 📛 📜 📋 📆 📊 📈 📉 📇 📌 📒 📏 📐 📑 📷 📹 📺 📻 📼 💋 💌 💍 💎 📶 📳 📴 ";
    public static final String marks =
            "☀ ☁ ☔ ⛄ ⚡ 🌀 🌁 🌂 🌃 🌄 🌅 🌆 🌇 🌈 ❄ ⛅ 🌉 🌊 🌋 🌌 🌏 🌑 🌔 🌓 🌙 🌕 🌛 🌟 🌠 🕐 🕑 🕒 🕓 🕔 🕕 🕖 🕗 🕘 🕙 🕚 🕛 ⌚ ⌛ ⏰ ⏳ ♈ ♉ ♊ ♋ ♌ ♍ ♎ ♏ ♐ ♑ ♒ ♓ ⛎ 🔊 🔋 🔌 🔍 🔎 🔒 🔓 🔏 🔐 🔑 🔔 ☑ 🔘 🔖 🔗 🅰 🅱 🆎 🅾 🆑 🆒 🆓 🆔 🆕 🆖 🆗 🆘 🆙 🆚 🈁 🈂 🈲 🈳 🈴 🈵 🈶 🈚 🈷 🈸 🈹 🈯 🈺 ㊙ ㊗ 🉐 🉑 ♥ ♠ ♦ ♣ 🚫 ✔ ➕ ➖ ✖ ➗ 💠 ✨ ✴ ✳ ";
    final static String kagi1 = "615PA3yNM5vP1R3rA3799i53np",
            kagi2 = "33",
            kagi3 = "MnwWIqK";
    public static HashMap<String, String> toAlt = new HashMap<>();
    public static HashMap<String, String> toGrave = new HashMap<>();
    public static HashMap<String, String> toAcute = new HashMap<>();
    public static HashMap<String, String> toHead = new HashMap<>();
    public static HashMap<String, String> toCaron = new HashMap<>();
    public static HashMap<String, String> toTilde = new HashMap<>();

    // emoji
    public static HashMap<String, String> toUmlaut = new HashMap<>();
    public static HashMap<String, String> toBar = new HashMap<>();
    public static HashMap<String, String> toHook = new HashMap<>();

    static {
        toAlt.put("1", "ə");
        toAlt.put("2", "ĳ");
        toAlt.put("3", "ł");
        toAlt.put("4", "ŋ");
        toAlt.put("5", "ø");
        toAlt.put("6", "ơ");
        toAlt.put("7", "þ");
        toAlt.put("8", "æ");
        toAlt.put("9", "œ");
        toAlt.put("0", "ß");

        toAlt.put("q", "€"); // empty
        toAlt.put("keyboardWidth", "¢"); // empty
        toAlt.put("f", "φ");
        toAlt.put("p", "π");
        toAlt.put("g", "γ");
        toAlt.put("j", "ξ");
        toAlt.put("l", "λ");
        toAlt.put("u", "θ");
        toAlt.put("y", "υ");
        toAlt.put(";", "¥"); // empty

        toAlt.put("a", "α");
        toAlt.put("r", "ρ");
        toAlt.put("s", "σ");
        toAlt.put("t", "τ");
        toAlt.put("d", "δ");
        toAlt.put("h", "η");
        toAlt.put("n", "ν");
        toAlt.put("e", "ε");
        toAlt.put("i", "ι");
        toAlt.put("o", "ο");

        toAlt.put("z", "ζ");
        toAlt.put("x", "χ");
        toAlt.put("c", "ψ");
        toAlt.put("v", "ω");
        toAlt.put("b", "β");
        toAlt.put("k", "κ");
        toAlt.put("m", "μ");
        toAlt.put(",", "≤");
        toAlt.put(".", "≥");
        toAlt.put("/", "÷"); // empty
    }

    static { // àèìǹ òùẁỳ
        toGrave.put("a", "à");
        toGrave.put("e", "è");
        toGrave.put("i", "ì");
        toGrave.put("n", "ǹ");
        toGrave.put("o", "ò");
        toGrave.put("u", "ù");
        toGrave.put("keyboardWidth", "ẁ");
        toGrave.put("y", "ỳ");
    }

    static { // áćéǵíḱĺńóṕŕśúẃýź
        toAcute.put("a", "á");
        toAcute.put("c", "ć");
        toAcute.put("e", "é");
        toAcute.put("g", "ǵ");
        toAcute.put("i", "í");
        toAcute.put("k", "ḱ");
        toAcute.put("l", "ĺ");
        toAcute.put("n", "ń");
        toAcute.put("o", "ó");
        toAcute.put("p", "ṕ");
        toAcute.put("r", "ŕ");
        toAcute.put("s", "ś");
        toAcute.put("u", "ú");
        toAcute.put("keyboardWidth", "ẃ");
        toAcute.put("y", "ý");
        toAcute.put("z", "ź");
        toAcute.put("8", "ǽ");
    }

    static { // âĉḓêĝĥîĵḽṋôŝṱûŵŷẑ
        toHead.put("a", "â");
        toHead.put("c", "ĉ");
//		toHead.put("d", "ḓ");
        toHead.put("e", "ê");
        toHead.put("g", "ĝ");
        toHead.put("h", "ĥ");
        toHead.put("i", "î");
        toHead.put("j", "ĵ");
//		toHead.put("l", "ḽ");
//		toHead.put("n", "ṋ");
        toHead.put("o", "ô");
        toHead.put("s", "ŝ");
//		toHead.put("t", "ṱ");
        toHead.put("u", "û");
        toHead.put("keyboardWidth", "ŵ");
        toHead.put("y", "ŷ");
        toHead.put("z", "ẑ");
    }

    static { // ǎčďěǧȟǐǰǩľňǒřšťǔž
//		toCaron.put("a", "ǎ");
        toCaron.put("c", "č");
        toCaron.put("d", "ď");
        toCaron.put("e", "ě");
        toCaron.put("g", "ǧ");
        toCaron.put("h", "ȟ");
//		toCaron.put("i", "ǐ");
        toCaron.put("j", "ǰ");
        toCaron.put("k", "ǩ");
        toCaron.put("l", "ľ");
        toCaron.put("n", "ň");
//		toCaron.put("o", "ǒ");
        toCaron.put("r", "ř");
        toCaron.put("s", "š");
        toCaron.put("t", "ť");
//		toCaron.put("u", "ǔ");
        toCaron.put("z", "ž");
    }

    static { // ãḛĩñõũ åů
        toTilde.put("a", "ã");
//		toTilde.put("e", "ḛ");
        toTilde.put("i", "ĩ");
        toTilde.put("n", "ñ");
        toTilde.put("o", "õ");
        toTilde.put("u", "ũ");
        toTilde.put("1", "å");
        toTilde.put("8", "ů");
    }

    static { // äëïöẗüẅẍÿ
        toUmlaut.put("a", "ä");
        toUmlaut.put("e", "ë");
//		toUmlaut.put("h", "ḧ");
        toUmlaut.put("i", "ï");
        toUmlaut.put("o", "ö");
//		toUmlaut.put("t", "ẗ");
        toUmlaut.put("u", "ü");
        toUmlaut.put("keyboardWidth", "ẅ");
//		toUmlaut.put("x", "ẍ");
        toUmlaut.put("y", "ÿ");
        toUmlaut.put("s", "ß");
        toUmlaut.put("q", "œ");
    }

    static { // āḇḏēḡẖīḵḻṉōṟūȳẕ āēīōūȳ  ⱥƀȼđɇǥħɨɉꝁłøᵽɍŧɏƶ
        toBar.put("a", "ā");
        toBar.put("e", "ē");
        toBar.put("i", "ī");
        toBar.put("o", "ō");
        toBar.put("u", "ū");
//		toBar.put("6", "ȳ");

//		toBar.put("a", "ⱥ");
//		toBar.put("b", "ƀ");
//		toBar.put("c", "ȼ");
        toBar.put("d", "đ");
//		toBar.put("e", "ɇ");
//		toBar.put("g", "ǥ");
        toBar.put("h", "ħ");
        toBar.put("i", "ɨ");
//		toBar.put("j", "ɉ");
//		toBar.put("k", "ꝁ");
        toBar.put("l", "ł");
//		toBar.put("o", "ø");
//		toBar.put("p", "ᵽ");
//		toBar.put("r", "ɍ");
        toBar.put("t", "ŧ");
//		toBar.put("y", "ɏ");
//		toBar.put("z", "ƶ");
    }

    static { // ąçęģįķļņǫşţų ąęįǫų çḑȩģḩķļņŗşţ
        toHook.put("a", "ą");
        toHook.put("e", "ę");
        toHook.put("i", "į");
        toHook.put("o", "ǫ");
        toHook.put("u", "ų");

        toHook.put("c", "ç");
//		toHook.put("d", "ḑ");
//		toHook.put("e", "ȩ");
        toHook.put("g", "ģ");
//		toHook.put("h", "ḩ");
        toHook.put("k", "ķ");
        toHook.put("l", "ļ");
        toHook.put("n", "ņ");
        toHook.put("r", "ŗ");
        toHook.put("s", "ş");
        toHook.put("t", "ţ");
    }
}

