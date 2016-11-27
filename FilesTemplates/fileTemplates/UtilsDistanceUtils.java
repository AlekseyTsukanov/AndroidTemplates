package ${PACKAGE_NAME};


public class ${NAME} {
    public static double calculateDistance(double lat1, double lng1, double lat2, double lng2) {
        double radLat1 = (lat1 * Math.PI) / 180.0;
        double radLng1 = (lng1 * Math.PI) / 180.0;
        double radLat2 = (lat2 * Math.PI) / 180.0;
        double radLng2 = (lng2 * Math.PI) / 180.0;
        return 6371290.681855 * (Math.acos(Math.sin(radLat1) * Math.sin(radLat2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.cos(radLng2 - radLng1)));
    }
}
