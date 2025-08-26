package co.pragma.model.user.valueObject;

public abstract class UserField<T> {
    public T value;

    public UserField(T value) {
        this.value = value;
        this.validate();
    }

    public void validate() {}
}
