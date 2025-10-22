import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {
  private readonly apiUrl = "http://localhost:8080/api/v1/pedido"

  constructor(private http: HttpClient) { }
}
