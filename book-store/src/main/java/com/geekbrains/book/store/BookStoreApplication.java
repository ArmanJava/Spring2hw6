package com.geekbrains.book.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookStoreApplication {
	// Домашнее задание:
	// 1. Разбиваетесь на команды по 3 человека и выбираете руководителя;
	// 2. Создаете под тестовый проект на гите репозиторий и работаете там все вместе;
	// 3. Необходимо сделать тестовый веб-проект, где есть следующие сущности:
	// Товар, Документ, Мебель (требований к сущностям особых нет)
	// и под каждую сущность делаете RestController, Service, Repository
	// * Безопасность подключать не надо
	// 4. В качесте СУБД берем PostgreSQL, для миграции - Flyway

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
}
