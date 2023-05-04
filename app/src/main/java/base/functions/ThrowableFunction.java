package base.functions;

import base.exception.NioHttpServerException;

@FunctionalInterface
public interface ThrowableFunction<F, T>  {
    T apply(F value) throws NioHttpServerException;
}
