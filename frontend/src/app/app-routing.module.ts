import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ConverterComponent } from './converter/converter.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { RegistrationComponent } from './registration/registration.component'; 
import { HistoryComponent } from './history/history.component';



const routes: Routes = [   
  {path:'history', component: HistoryComponent},
  {path:'converter', component: ConverterComponent},
  {path:'login', component: LoginPageComponent},  
  {path:'registration', component: RegistrationComponent}, 

]; 

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
