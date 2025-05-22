import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, tap } from 'rxjs';
import { User } from '../models/user.model';
import { Login } from '../models/login.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  public apiUrl = 'https://8080-cfcebdbedeabbbdebbefcafbdaaafdbbeddebecdf.project.examly.io/api';
  private roleSubject = new BehaviorSubject<string|null>(null);
  private userIdSubject = new BehaviorSubject<number|null>(null);
  constructor(private http:HttpClient) { }
  
  register(user:User):Observable<any>{
    return this.http.post(`${this.apiUrl}/register`,user);
  }
  login(login:Login):Observable<any>{
    return this.http.post(`${this.apiUrl}/login`,login).pipe(
      tap((res:any)=>{
        localStorage.setItem('token',res.token);
        this.roleSubject.next(res.role);
        this.userIdSubject.next(res.userId);
      })
    );
  }
  getToken():string|null{
    return localStorage.getItem('token');
  }
  getRole():Observable<string|null>{
    return this.roleSubject.asObservable();
  }
  getUserId():Observable<number|null>{
    return this.userIdSubject.asObservable();
  }
  logout():void{
    localStorage.removeItem('token');
    this.roleSubject.next(null);
    this.userIdSubject.next(null);
  }
}
