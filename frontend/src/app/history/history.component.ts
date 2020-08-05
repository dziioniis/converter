import { Component, OnInit } from '@angular/core';
import { ExchangeService } from '../service/exchange/exchange.service';
import { Exchange } from '../entity/exchange';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit { 
  exchanges:Exchange[];

  constructor(private exchangeService: ExchangeService) { }

  ngOnInit(): void {
    this.getExchanges();
  } 

  getExchanges(){ 
    this.exchangeService.getExchanges().subscribe(data=>{ 
      this.exchanges=data;
    })
  }

}
