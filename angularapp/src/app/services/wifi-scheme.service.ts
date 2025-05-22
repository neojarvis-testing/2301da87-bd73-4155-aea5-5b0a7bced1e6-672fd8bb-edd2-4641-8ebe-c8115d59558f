import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { WifiScheme } from '../models/wifi-scheme.model';

@Injectable({
  providedIn: 'root'
})
export class WifiSchemeService {
  public apiUrl = 'https://8080-cfcebdbedeabbbdebbefcafbdaaafdbbeddebecdf.project.examly.io/api/wifiScheme';
  constructor(private http:HttpClient) { }
  private getAuthHeader(){
    return {
      headers:new HttpHeaders({Authorization: `Bearer ${localStorage.getItem('token')}`})
    };
  }

  getAllWifiScheme():Observable<WifiScheme[]>{
    return this.http.get<WifiScheme[]>(this.apiUrl,this.getAuthHeader());
  }
  getWifiSchemeById(id:number):Observable<WifiScheme>{
    return this.http.get<WifiScheme>(`${this.apiUrl}/${id}`,this.getAuthHeader());
  }
  addWifiScheme(data:WifiScheme):Observable<WifiScheme>{
    return this.http.post<WifiScheme>(this.apiUrl,data,this.getAuthHeader());
  } 
  updateWifiScheme(id:number, data:WifiScheme):Observable<WifiScheme>{
    return this.http.put<WifiScheme>(`${this.apiUrl}/${id}`,data, this.getAuthHeader());
  }
  deleteWifiSchemeById(id:number):Observable<void>{
    return this.http.delete<void>(`${this.apiUrl}/${id}`,this.getAuthHeader());
  } 
}
