package cn.edu.bistu.cs.se.weather.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class toPinyin {
        public static String toPinYin(String string){
            char[] c = string.toCharArray();
            StringBuffer stringBuffer = new StringBuffer();
            for(int i = 0; i< c.length; i++){
                stringBuffer.append(toChar(c[i]));
            }
            return stringBuffer.toString();
        }
        private static String toChar(char c){
            HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
            format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
            format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
            format.setVCharType(HanyuPinyinVCharType.WITH_V);
            try{
                String[] pinYin = PinyinHelper.toHanyuPinyinStringArray(c, format);
                if(pinYin != null){
                    return pinYin[0];
                }
            }
            catch(BadHanyuPinyinOutputFormatCombination ex){
                ex.printStackTrace();
            }
            return String.valueOf(c);
        }
}
