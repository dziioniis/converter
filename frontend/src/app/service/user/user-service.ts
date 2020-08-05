import { Injectable } from '@angular/core'; 
import { HttpClient} from '@angular/common/http'; 
import {User} from 'src/app/entity/user'; 
import {Observable} from 'rxjs';
import {Router} from "@angular/router";



@Injectable({
  providedIn: 'root'
})
export class UserService{

  constructor( private http: HttpClient,private router: Router) { } 
   
  auntenticate(user:User){   
   
        this.http.post('http://localhost:8080/log',user).subscribe((data:User)=>{ 
        if (data==null)  { 
        alert ("The username or password that you entered not match. please,double-check and try again.") 
        } 
        else{
        localStorage.setItem('username', data.username); 
        localStorage.setItem('id',data.id.toString()) 
   
        this.router.navigate(['converter']);
        }
    }) 
  } 

  registrate(user:User){  
    const fd = new FormData(); 
    fd.append('username',user.username); 
    fd.append('password',user.password); 
   this.http.post('http://localhost:8080/registration',fd).subscribe((data:string)=>{ 
        if (data==null)  { 
        alert ("The username or password that you entered not match. please,double-check and try again.") 
        } 
        else{ 
        alert ("great, you did it!")
        } 
    })  
    this.router.navigate(['login']);
  }  

   
  logout(id:Number):void{
    this.http.post('http://localhost:8080/exit',id).subscribe((data:string)=>{ 
      if (data==null)  { 
        alert ("The username or password that you entered not match. please,double-check and try again.") 
        } 
        else{ 
          localStorage.removeItem('id'); 
          localStorage.removeItem('username');  
        }
    }) 
    this.router.navigate(['login']);
  } 
   

}
