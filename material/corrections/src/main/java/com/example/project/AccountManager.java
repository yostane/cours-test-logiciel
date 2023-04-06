package com.example.project;

record Account(String owner, int balance) {
}

record Product(String name, int price) {
}

public class AccountManager {
  static boolean checkAccount(Account account, int amount) {
    if (account.balance() >= amount) {
      return true;
    }
    return false;
  }

  static Account buy(Account account, Product product) {
    if (checkAccount(account, product.price())) {
      System.out.printf("Produit acheté: %s\n", product.name());
      return new Account(account.owner(), account.balance() - product.price());
    } else {
      System.out.println("Echec de la transaction");
      return account;
    }
  }
}
