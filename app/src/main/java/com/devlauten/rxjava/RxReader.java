package com.devlauten.rxjava;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RxReader {

    Observable<String> lines(BufferedReader reader) {
        return Observable.<String>create(subscriber -> {
            String line;

            while (StringUtils.isNotBlank(line = reader.readLine())) {
                subscriber.onNext(line);

                if(subscriber.isDisposed()) {
                    break;
                }
            }

            subscriber.onComplete();
        }).subscribeOn(Schedulers.io());
    }

    Observable<String> linesFromInput() {
        return lines(new BufferedReader(new InputStreamReader(System.in)));
    }
}
