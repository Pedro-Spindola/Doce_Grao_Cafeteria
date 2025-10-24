import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { PagamentoRequestSimples } from '../models/PagamentoRequestSimples';
import { PedidoResponse } from '../models/PedidoResponse';

@Injectable({
  providedIn: 'root'
})
export class PagamentoService {
  private readonly apiUrl = "http://192.168.1.157:8080/api/v1/pedido"
  private idPagamento!: number;

  constructor(private http: HttpClient) { }

  confirmarPagamento(pagamento: PagamentoRequestSimples): Observable<PedidoResponse> {
    return this.http.put<PedidoResponse>(`${this.apiUrl}/pagamento`, pagamento).pipe(catchError(this.handleError));
  }

  private handleError(error: any){
    console.error('Erro na API: ', error);
    return throwError(() => new Error('Erro ao consultar a API de contatos.'))
  }
  
  getIdPagamento(): number{
    return this.idPagamento;
  }

  setIdPagamento(idPagamento: number){
    this.idPagamento = idPagamento;
  }

}
