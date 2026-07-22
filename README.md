# 🎓 Sistema de Cadastro Acadêmico (CLI em Java)

Aplicação desenvolvida em **Java** voltada para o processamento, validação e manipulação de dados cadastrais acadêmicos através de interface de linha de comando (CLI).

---

## 📌 Sobre o Projeto

Este sistema simula um fluxo de cadastro e validação de informações estudantis. Ele faz uso estrito de estruturas de controle de fluxo, manipulação de strings, coleções e tratamento iterativo de entradas via `Scanner`, garantindo a integridade dos dados inseridos pelo usuário.

---

## ⚙️ Regras de Validação Implementadas

O sistema aplica rigorosamente as seguintes validações por meio de loops de repetição (`do-while`) e condicionais:

* **E-mail Institucional:** Deve obrigatoriamente conter o caractere `@`, terminar com `@empresa.com.br` e possuir um nome de usuário com pelo menos 3 caracteres antes do domínio.
* **Segurança de Senha:** Exige um comprimento mínimo de 8 caracteres, presença de pelo menos um caractere especial (`@`, `*` ou `$`), e restringe o uso de termos iniciados com "senha" ou finalizados com "1234".
* **Matrícula Acadêmica:** Validação de formato para aceitar estritamente sequências numéricas de 8 dígitos.
* **Cálculo Aproximado de Idade:** Processamento de datas no formato `dd/mm/aaaa` para estimar a idade do usuário com base em uma data de referência fixa.
* **Formatação de Documento (CPF):** Captura de string numérica com 11 dígitos e reestruturação visual automática para o padrão `XXX.XXX.XXX-XX`.
* **Padronização de Curso:** Tratamento de strings para formatação de hashtags acadêmicas (`#curso`).

---

## 🚀 Como Executar

Certifique-se de ter o **Java JDK** instalado em sua máquina.

1. Clone o repositório ou salve o arquivo do código como `Main.java`.
2. Abra o terminal na pasta onde o arquivo está salvo e compile o código:
   ```bash
   javac Main.java
     ```
## 🛠️ Tecnologias Utilizadas

Java (JDK) — Linguagem principal

Bibliotecas Nativas:
 ```bash
java.util.Scanner — Entrada de dados via terminal

java.util.HashMap / Map — Estruturas de mapeamento e referência

java.util.regex — Pattern / Matcher para expressões regulares
