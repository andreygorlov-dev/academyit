package exercise8;

public class CarNumber {
    /**
     * Допустимые символы для генерации серии
     */
    public static final String chars= "абвгдежзиклмнопрстуфхцчшщэюя";

    private final Integer number;
    private final Integer region;
    private final String series;
    private final String nameOwner;

    public CarNumber(Integer number, Integer region, String series, String nameOwner) {
        this.number = number;
        this.region = region;
        this.series = series;
        this.nameOwner = nameOwner;
    }

    private String getCarNumber() {
        return String.valueOf(series.charAt(0)) + number + series.substring(1) + region;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getRegion() {
        return region;
    }

    public String getSeries() {
        return series;
    }

    public String getNameOwner() {
        return nameOwner;
    }

    public String getInfo() {
        return getCarNumber() + " владелец " + nameOwner;
    }

    /**
     * Сравнение объектов осуществляется по гос номеру машины
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj instanceof String) {
            return getCarNumber().equals(String.valueOf(obj));
        } if (obj instanceof CarNumber) {
            return getCarNumber().equals(((CarNumber) obj).getCarNumber());
        }

        return false;
    }
}
