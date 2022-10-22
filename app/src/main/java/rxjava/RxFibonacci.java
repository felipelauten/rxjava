package rxjava;

import io.reactivex.rxjava3.core.Observable;

public class RxFibonacci {
    static Observable<Integer> fibs() {
        return Observable.create(subscriber -> {
            // Do some work
            int prev = 0;
            int current = 1;

            subscriber.onNext(prev);
            subscriber.onNext(current);

            while(!subscriber.isDisposed()) {
                int oldPrev = prev;
                prev = current;
                current += oldPrev;

                subscriber.onNext(current);
            }
        });
    }
}
