import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Account {
  id: number;
  accountNumber: string;
  customerName: string;
  balance: number;
}

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  private apiUrl = 'http://localhost:8080/api/account';

  constructor(private http: HttpClient) {}

  getAccount(): Observable<Account> {
    return this.http.get<Account>(this.apiUrl);
  }

  deposit(amount: number): Observable<Account> {
    return this.http.post<Account>(
      `${this.apiUrl}/deposit`,
      { amount }
    );
  }

  withdraw(amount: number): Observable<Account> {
    return this.http.post<Account>(
      `${this.apiUrl}/withdraw`,
      { amount }
    );
  }
}