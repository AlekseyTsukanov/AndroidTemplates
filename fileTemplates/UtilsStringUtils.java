package ${PACKAGE_NAME};


import android.content.Context;
import android.support.annotation.StringRes;

public class ${NAME} {
    public static String getAddressStringFromByte(byte[] address) {
        if (address == null || address.length !=6) {
            return null;
        }
        return String.format("%02X:%02X:%02X:%02X:%02X:%02X",
                address[0], address[1], address[2], address[3], address[4],
                address[5]);
    }

    public static String formatToDecimal(String text, int decimal) {
        return String.format(text, decimal);
    }

    public static String formatToDecimal(Context context, @StringRes int text, int decimal) {
        return formatToDecimal(context.getResources().getString(text), decimal);
    }

    public static String formatToString(String text, String string) {
        return String.format(text, string);
    }

    public static String formatToString(Context context, @StringRes int text, String string) {
        return formatToString(context.getResources().getString(text), string);
    }
}
