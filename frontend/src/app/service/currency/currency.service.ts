import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http'; 
import {Observable} from 'rxjs';
import {Router} from "@angular/router";
import { Currency } from 'src/app/entity/currency';

@Injectable({
  providedIn: 'root'
})
export class CurrencyService {

  constructor(private http: HttpClient,private router: Router) { } 
  
getCurrencies():Observable<Currency[]>{  
  return this.http.get<Currency[]>('http://localhost:8080/getCurrencies');
   }  
   getCurrenciesNames():Observable<String[]>{  
    return this.http.get<String[]>('http://localhost:8080/getCurrenciesNames');
     } 
  }
  