package yes.tdd.frameworks.domain.core;

@FunctionalInterface
public interface RunnableWithCheckedException {
    void run() throws Exception;
}
