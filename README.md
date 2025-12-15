# Desafio GitHub Search

Aplicativo Android desenvolvido como desafio para buscar e listar repositórios públicos de um usuário do GitHub.

---

## 📱 Sobre o projeto

O **GitHub Search App** é um aplicativo Android simples onde o usuário informa um **nome de usuário do GitHub** e, ao clicar em **Confirmar**, o app:

* Busca e exibe os **repositórios públicos** do usuário
* Permite **abrir o repositório no navegador** ao clicar no item da lista
* Permite **compartilhar o link do repositório** pelo botão de compartilhamento

---

## 🧩 Funcionalidades

* Campo para informar o nome de usuário do GitHub
* Botão **Confirmar** para buscar os repositórios
* Listagem de repositórios públicos
* Clique no repositório abre o navegador
* Botão para compartilhar o link do repositório

---

## 🏗️ Arquitetura

O projeto segue uma separação de responsabilidades simples, inspirada em MVC:

* **controller**: controle de fluxo e regras de negócio
* **data**: comunicação com a API 
* **domain**: modelos de dados
* **helpers**: utilidades 
* **ui**: Activities e Adapters

---

## 📂 Estrutura de pastas

```
src
├── androidTest
│   └── java/br/com/dev/searchapp
├── main
│   ├── java/br/com/dev/searchapp
│   │   ├── controller
│   │   ├── data
│   │   ├── domain
│   │   ├── helpers
│   │   └── ui
│   │       └── adapter
│   └── res
│       ├── drawable
│       ├── layout
│       ├── values
│       └── xml
└── test
    └── java/br/com/dev/searchapp
```

---

## 🔌 Tecnologias utilizadas

* **Kotlin**
* **Android SDK**
* **RecyclerView**
* **Retrofit**
* **ConstraintLayout**
* **GitHub REST API**

---

## 🖼️ Preview

![Preview do App](<img width="1080" height="2340" alt="tela-inicial" src="https://github.com/user-attachments/assets/0992d0f2-8e4f-485b-a2a6-5431b6af7b5c" />)

---

## 🚀 Como executar o projeto

1. Clone o repositório
2. Abra no **Android Studio**
3. Sincronize o Gradle
4. Execute em um emulador ou dispositivo físico

---
