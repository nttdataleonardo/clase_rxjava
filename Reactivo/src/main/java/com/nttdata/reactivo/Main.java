package com.nttdata.reactivo;

import io.reactivex.rxjava3.core.Flowable;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello Programmers");

    SingleExample singleExample = new SingleExample();
    singleExample.runEndpoint();

    /*MaybeExample maybeExample = new MaybeExample();
    maybeExample.runEndpoint();*/

    /*CompletableExample completableExample = new CompletableExample();
    completableExample.runExample();*/


  }
}
