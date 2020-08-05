import { Component, OnInit } from '@angular/core';
import { CurrencyService } from '../service/currency/currency.service';
import { Currency } from '../entity/currency';
import { Exchange } from '../entity/exchange';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import {ExchangeService} from '../service/exchange/exchange.service'
import { UserService } from '../service/user/user-service';


@Component({
  selector: 'app-converter',
  templateUrl: './converter.component.html',
  styleUrls: ['./converter.component.css']
})
export class ConverterComponent implements OnInit {
  currencies:Currency[]; 
  currenciesNames:String[];
  constructor(private currencyService: CurrencyService,private exchangeService: ExchangeService,private userService:UserService) { } 
  initialCurrencyName:string="Выберите валюту";
  gettingCurrencyName:string="Выберите валюту"; 
  valueInitialCurrency:number; 
  valueGettingCurrency:number;
  count:number; 
  exchangeSum:number; 
  exchange:Exchange=new Exchange; 
  currentDate:string;

  ngOnInit(): void { 
    this.getCurrenciesNames()
   
  } 
  public getCurrencies(): void {  

    this.currencyService.getCurrencies().subscribe(data=>{ 
      this.currencies=data; 
    }) 
  }  
  public getCurrenciesNames():void{
  this.currencyService.getCurrenciesNames().subscribe(data=>{ 
    this.currenciesNames=data;
  }) 
} 
     
    public putinitialCurrencyName(name:string):void{  
    this.initialCurrencyName=name; 
    }  
     
    public putGettingCurrencyName(name:string):void{  
      this.gettingCurrencyName=name;
    } 
     
    converting():Exchange{   
      this.exchange.gettingCurrencyName=this.gettingCurrencyName; 
      this.exchange.initialCurrencyName=this.initialCurrencyName;
      let today = new Date();
      let date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
      let time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
      let dateTime = date+' '+time
      this.exchange.data=dateTime.toString(); 
      this.exchange.count=this.count;  
      this.exchangeService.saveExchange(this.exchange).subscribe(data=>{  
        this.exchangeSum=data
      })
    
      return null;
    } 

    logOut():void{ 
      this.userService.logout(Number.parseInt(localStorage.getItem("id")));
    }
  
   

} 

