package yes.tdd.frameworks.domain.core;

@FunctionalInterface
public interface SupplierWithCheckedException<T> {
    T get() throws Exception;
}
