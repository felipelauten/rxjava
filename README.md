# Getting started with RxJava

This is one of the repositories I use for studying Java.
In here you can find a getting started with RxJava Observables.

Source: [Introduction to RxJava](https://www.youtube.com/watch?v=ZhqdnC43jMs) by 
[Hackers at Cambridge](https://www.youtube.com/c/HackersatCambridge)

## What is in here?

- A basic introduction to Rx Observables using RxJava library.
- Creating an Observable of Fibonacci numbers
- Handling fake user input through (guess what?) Observables
- Handling real user input through an Observable that reads from system in
- Some operators and logic

### Fake user input:
```java
public Observable<Integer> fakeUserInput() {
    Random random = new Random();
    return Observable.intervalRange(0, 100, 500, 50, MILLISECONDS)

            .concatMap(number -> Observable.just(random.nextInt(20))
                    .delay(random.nextInt(500), MILLISECONDS))
            .map(number -> random.nextInt(20));
}
```

### Real user input
```java
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
```

## Dependencies

You need a JDK 8 installed in your machine in order to run this. If you don't have one,
I recommend using SDKMan, it easily installs any JDK version you need. See how to download and use 
it [here](https://sdkman.io)

## How to run it?

Inside a terminal, just invoke `.gradlew` (on Mac and Linux) or `gradlew.bat` (Windows).

## Disclaimer

This is, as said, just repository I created for study purposes.
The code contained here is a slightly adapted version of the code you can see in the YouTube video series.
If you plan to use it as a reference, do it AT YOUR OWN RISK. I don't take any responsibility for what you do.

# About me
I am Felipe Lautenschlager. A java developer with years of Legacy systems experience seeking to improve
my skills on more modern frameworks (not just Java).

If you want to get in touch, feel free to send me a message:

Twitter: [@devLauten](https://twitter.com/devLauten)

LinkedIn: [felipelauten](https://linkedin.com/in/felipelauten)
