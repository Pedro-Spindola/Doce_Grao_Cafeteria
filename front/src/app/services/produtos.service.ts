import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';

export interface Cafes {
  id: number;
  nome: string;
  descrica: string;
  valor: number;
}

@Injectable({
  providedIn: 'root'
})
export class ProdutosService {
  private readonly apiUrl = "http://localhost:8080/api/v1/produto"

  constructor(private http: HttpClient) { }

  findAll(): Observable<Cafes[]>{
    return this.http.get<Cafes[]>(`${this.apiUrl}/cafes`).pipe(catchError(this.handleError));
  }

  private handleError(error: any){
    console.error('Erro na API: ', error);
    return throwError(() => new Error('Erro ao consultar a API de contatos.'))
  }
}
