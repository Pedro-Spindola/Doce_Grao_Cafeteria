import { CafeResponse } from "./CafeResponse";

export interface ItemPedidoResponse {
  quantidade: number;
  cafe: CafeResponse;
  valorTotalItem: number;
}