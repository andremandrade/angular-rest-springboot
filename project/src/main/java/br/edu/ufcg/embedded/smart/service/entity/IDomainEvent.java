package br.edu.ufcg.embedded.smart.service.entity;

public interface IDomainEvent <E, D>{
	D toDomain();
}
