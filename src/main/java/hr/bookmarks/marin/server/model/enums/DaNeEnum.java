package hr.bookmarks.marin.server.model.enums;

public enum DaNeEnum {
    NE(0), //
    DA(1);

    private Integer value;

    private DaNeEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static DaNeEnum fromValue(Integer value) {
        for (DaNeEnum enumeration : DaNeEnum.values()) {
            if (enumeration.getValue().equals(value)) {
                return enumeration;
            }
        }
        return null;
    }
}
