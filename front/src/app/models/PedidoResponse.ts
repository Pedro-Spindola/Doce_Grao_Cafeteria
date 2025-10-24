import { StatusPedido } from "./enums/StatusPedido";
import { ItemPedidoResponse } from "./ItemPedidoResponse";
import { PagamentoResponse } from "./PagamentoResponse";

export interface PedidoResponse {
  senhaRetirada: string;
  statusPedido: StatusPedido;
  pagamento: PagamentoResponse;
  itensComprados: ItemPedidoResponse[];
}