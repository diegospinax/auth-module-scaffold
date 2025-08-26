package co.pragma.model.role.valueObject;

abstract class RoleField<T> {
    public T value;

    public RoleField(T value) {
        this.value = value;
        this.validate();
    }

    public void validate() {}
}
