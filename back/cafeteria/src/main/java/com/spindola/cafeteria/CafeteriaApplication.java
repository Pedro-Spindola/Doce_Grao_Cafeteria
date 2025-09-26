package com.spindola.cafeteria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spindola.cafeteria.model.ItemAdicional;
import com.spindola.cafeteria.model.adicionais.Acucar;
import com.spindola.cafeteria.model.adicionais.Leite;
import com.spindola.cafeteria.model.cafes.Americano;
import com.spindola.cafeteria.model.cafes.Cappuccino;
import com.spindola.cafeteria.model.interfaces.IProduto;

@SpringBootApplication
public class CafeteriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CafeteriaApplication.class, args);

		IProduto capuccino = new Cappuccino();
		IProduto americano = new Americano();
        capuccino = new Acucar(capuccino);
        americano = new Acucar(americano);
		americano = new Leite(americano);

        System.out.println("Produto: " + capuccino.getNome());
        System.out.println("Adicionais:");
        for (ItemAdicional i : capuccino.getAdicionais()) {
            System.out.println("- " + i.getNome() + " --- " + i.getValor());
        }
        System.out.println("Valor total: R$ " + capuccino.getValor());

		System.out.println("Produto: " + americano.getNome());
        System.out.println("Adicionais:");
        for (ItemAdicional i : americano.getAdicionais()) {
            System.out.println("- " + i.getNome() + " --- " + i.getValor());
        }
        System.out.println("Valor total: R$ " + americano.getValor());
	}
}
