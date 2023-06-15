package com.nttdata.reactivo;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;

public class CompletableExample {


  public void runExample() {
    //Simulando un Endpoint o un métodos de base de datos
    Completable completable =  createCompletable(10);

    completable.subscribe(new CompletableObserver() {
      @Override
      public void onSubscribe(@NonNull Disposable d) {
        System.out.println("Call to Subscribe");
      }

      @Override
      public void onComplete() {
        System.out.println("HttpStatus: 204");
      }

      @Override
      public void onError(@NonNull Throwable e) {
        System.out.println("codeError: NT120");
        System.out.println("Description: Error en tiempo de ejecución");
        System.out.println(e.getMessage());
      }
    });

  }

  private Completable createCompletable(Integer id) {
    //return Completable.
    return Completable.fromAction(deleteItemFromDBAction(id));
  }

  private Action deleteItemFromDBAction(Integer id) {
    return new Action() {
      @Override
      public void run() throws Throwable {
        if (id.equals(19)) {
          System.out.println("Deleting item " + id + " from DB");
        } else {
          //throw new Throwable("Throwable - Error in Action, Not found id: " + id);
          throw new RuntimeException("Runtime - Error in Action: 500");
        }
        //throw new RuntimeException("Runtime - Error in Action");
        //throw new Throwable("Throwable - Error in Action");
      }
    };

  }
}
