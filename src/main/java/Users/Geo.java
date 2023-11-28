package Users;

class Geo {
    private double lat;
    private double lng;

    public Geo(double lat, double lng) {
        setLat(lat);
        setLng(lng);
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Geo {\n\t\t" +
                "lat = '" + lat + '\'' +
                ",\n\t\tlng = '" + lng + '\'' +
                "\n\t\t}";
    }
}
