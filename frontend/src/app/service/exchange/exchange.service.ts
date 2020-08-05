import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http'; 
import {Observable} from 'rxjs';
import {Router} from "@angular/router";
import { Exchange } from 'src/app/entity/exchange';
@Injectable({
  providedIn: 'root'
}) 

export class ExchangeService {

  constructor(private http: HttpClient,private router: Router) { }  
  public saveExchange(exchange:Exchange):Observable<any>{ 
  return this.http.post('http://localhost:8080/saveExchange',exchange);
} 
 
public getExchanges():Observable<Exchange[]>{  
  return this.http.get<Exchange[]>('http://localhost:8080/getExchanges');
   } 
}
