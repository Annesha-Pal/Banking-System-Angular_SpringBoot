import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CurrencyPipe } from '@angular/common';
import { Account, AccountService } from './account.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [FormsModule, CurrencyPipe],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit {

  account: Account | null = null;
  amount: number = 0;
  message: string = '';

  constructor(private accountService: AccountService) {}

  ngOnInit(): void {
    this.loadAccount();
  }

  loadAccount(): void {
    this.accountService.getAccount().subscribe({
      next: (data) => this.account = data,
      error: () => this.message = 'Unable to load account.'
    });
  }

  deposit(): void {
    if (this.amount <= 0) {
      this.message = 'Enter a valid amount.';
      return;
    }

    this.accountService.deposit(this.amount).subscribe({
      next: (data) => {
        this.account = data;
        this.amount = 0;
        this.message = 'Deposit successful!';
      },
      error: (error) => {
        this.message = error.error?.detail || 'Deposit failed.';
      }
    });
  }

  withdraw(): void {
    if (this.amount <= 0) {
      this.message = 'Enter a valid amount.';
      return;
    }

    this.accountService.withdraw(this.amount).subscribe({
      next: (data) => {
        this.account = data;
        this.amount = 0;
        this.message = 'Withdrawal successful!';
      },
      error: (error) => {
        this.message = error.error?.detail || 'Withdrawal failed.';
      }
    });
  }
}