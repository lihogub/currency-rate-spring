package ru.lihogub.currencyrate.service;

import org.springframework.stereotype.Service;

@Service
public interface GiphyService {
    /**
     * Returns URL of random positive gif.
     *
     * @return URl of positive gif.
     * @author Oleg Lihogub
     */
    String getPositiveGifUrl();

    /**
     * Returns URL if random negative gif.
     *
     * @return URl of negative gif.
     * @author Oleg Lihogub
     */
    String getNegativeGifUrl();
}
