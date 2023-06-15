package com.nttdata.reactivo;

import com.nttdata.reactivo.model.Account;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;

public class SingleExample {
  private Single<Account> getAccountById(Integer id) {
    return Single.create(emitter -> {
      if (id > 0 && id < 100) {
        emitter.onSuccess(new Account(id, "Diaz", "Bueno"));
      } else {
        emitter.onError(new Throwable("Constraint detected"));
      }
    });
  }
  public void runEndpoint() {
    Single<Account> single = this.getAccountById(45);
    single.subscribe(new SingleObserver<Account>() {
      @Override
      public void onSubscribe(@NonNull Disposable d) { }
      @Override
      public void onSuccess(@NonNull Account account) {
        System.out.println("Account: " + account);
      }
      @Override
      public void onError(@NonNull Throwable e) {
        System.out.println("Error: " + e.getMessage());
        System.out.println("HttpStatus: 500");
      }
    });
  }

  public void runExample() {
    Single<String> single = createSingle();

    single.subscribe(new SingleObserver<String>() {
      @Override
      public void onSubscribe(@NonNull Disposable d) {

      }
      @Override
      public void onSuccess(@NonNull String s) {
        System.out.println(s);
      }

      @Override
      public void onError(@NonNull Throwable e) {
        System.out.println(e.getMessage());
      }
    });
  }
  private Single<String> createSingle() {
    return Single.create(emitter -> {
      var user = fetchUser();
      if(validData(user)) {
        emitter.onSuccess(user);
      } else {
        emitter.onError(new Exception("user not found"));
      }
    });
  }
  private String fetchUser() {
    return "Nttdata";
  }
  private boolean validData(String user) {
    if(user != null)
      return true;
    else
      return false;
  }
}
