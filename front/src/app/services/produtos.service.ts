import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { CafeResponse } from '../models/CafeResponse';

@Injectable({
  providedIn: 'root'
})
export class ProdutosService {
  private readonly apiUrl = "http://localhost:8080/api/v1/produto"
  private cafes: CafeResponse[] = [];

  constructor(private http: HttpClient) { }

  findAll(): Observable<CafeResponse[]>{
    return this.http.get<CafeResponse[]>(`${this.apiUrl}/cafes`).pipe(catchError(this.handleError));
  }

  private handleError(error: any){
    console.error('Erro na API: ', error);
    return throwError(() => new Error('Erro ao consultar a API de contatos.'))
  }

  obterCafes(): CafeResponse[] {
    return this.cafes;
  }

  adicionarListaCafe(cafe: CafeResponse[]): void {
    this.cafes = cafe;
  }
}
