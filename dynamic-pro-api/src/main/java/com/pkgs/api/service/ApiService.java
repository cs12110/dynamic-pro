package com.pkgs.api.service;

/**
 * TODO: ApiService
 *
 * <p>
 *
 * @author cs12110 create at 2019-03-30 13:30
 * <p>
 * @since 1.0.0
 */
public interface ApiService<T, P> {

    /**
     * deal with p, and return t
     *
     * @param param param
     * @return T
     */
    public T dealWith(P param);
}
