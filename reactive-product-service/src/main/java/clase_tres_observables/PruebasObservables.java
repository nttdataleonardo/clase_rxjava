package clase_tres_observables;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class PruebasObservables {

    public static void main(String[] args) {
        nombresQueEmpiezanConA("Maria", "Aron", "Jose").subscribe(System.out::println);
        nombresQueEmpiezanConA("amalia", "Anthony", "Marcelo").subscribe(System.out::println);
        nombresQueEmpiezanConA("Carmen", "AMERICO", "Karina").subscribe(System.out::println);
        nombresQueEmpiezanConA("Isela", "Christina", "Carolina").subscribe(System.out::println);
    }

    public static Observable<String> nombresQueEmpiezanConA(String... names) {
        return Observable.fromArray(names)
                .filter(nombre -> nombre.toLowerCase().startsWith("a"))
                .map(String::toUpperCase);
    }
}
