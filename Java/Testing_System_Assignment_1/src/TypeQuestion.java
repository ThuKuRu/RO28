public class TypeQuestion {
    int             typeID;

    TypeName        typeName;

    public enum  TypeName{
        ESSAY, MULTIPLE_CHOICE;
    }

    @Override
    public String toString() {
        return "TypeQuestion{" +
                "typeID=" + typeID +
                ", typeName=" + typeName +
                '}';
    }
}
