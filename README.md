# Projeto MyMusic

O projeto MyMusic visa desenvolver novos serviços para substituir a camada de APIs de uma aplicação legada que está em um servidor monolítico, utilizando o banco de dados existente.

## 📄 Estrutura

### Arquitetura

O projeto está estruturado com a arquitetura hexagonal, por sua reusabilidade de código, alta coesão, baixo acoplamento e independência de tecnologia.
Nesta arquitetura as classes de um sistema são divididas em dois "hexágonos" principais:
- Interno, que contém as classes relacionadas com o negócio do sistema.
- Externo, que contém classes relacionadas com infraestrutura, tecnologias e responsáveis pela integração com sistemas externos.

- A comunicação entre esses hexágonos é feita através de portas e adaptadores

Considerando a entidade ```Song``` como um exemplo, temos então a seguinte separação de classes:
- Hexágono interno:
    * Song, SongDTO, SongEntity
- Hexágono externo:
    * SongRespositoryPort, SongRespository, SpringSongRepository
    * SongServicePort, SongServiceImp
    * SongController

### Commits
Os commits do projeto são baseados em uma simplificação da especificação [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/).
Os 3 tipos de commit que utilizaremos são:
- **feat**: nova funcionalidade;
- **fix**: correção de bugs e erros;
- **ref**: refatoração de código antigo.


É importante seguir a prefixação definida, com a coesão do que foi registrado e sua descrição.

## 🛠️ Ferramentas e definições

- **Versão do Java**: 11
- **IDE**: IntelliJ
- **Modelo de Gerenciamento do versionamento**: Git Flow e Git Flow Tool
- **Arquitetura**: Arquitetura Hexagonal
- **Link do Repositório**: myMusic-CheckerLovers
- **SetUp**:
    * [Jacoco](https://www.eclemma.org/jacoco/)
    * [Lombok](https://projectlombok.org/)
    * [Maven](https://maven.apache.org/)
    * [SpringBoot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
    * [Swagger](https://swagger.io/docs/)
- **CI**: CircleCI

## 📋 Stories

<!-- 
Status badges:
To do: [status](https://img.shields.io/badge/-TO%20DO-lightgrey)
In progress: [status](https://img.shields.io/badge/-IN%20PROGRESS-blue)
Done: [status](https://img.shields.io/badge/-DONE-green)
-->

| Story                        | Descrição                                                          | Status                                                       |
|------------------------------|--------------------------------------------------------------------|--------------------------------------------------------------|
| Buscar novas músicas         | Adicionar o sistema de busca de músicas, com filtro opcional       | ![status](https://img.shields.io/badge/-IN%20PROGRESS-blue)  |
| Adicionar música na playlist | Adicionar o sistema de playlists, com adição de músicas à playlist | ![status](https://img.shields.io/badge/-TO%20DO-lightgrey)   |        |

## ✒ Equipe

- [Jenifer Nakabar Alencar](https://github.com/jenifernakabaralencar)
- [João Victor Bohana](https://github.com/joaobohana-ciandt)
- [João Vitor Garcia Andrade](https://github.com/jaao-cietweb)
- [Melissa Lewartoski Wong](https://github.com/mlewartoski)
- [Ricardo Barbosa de Sousa](https://github.com/rsousa-ciandt)

## 🎁 Expressões de gratidão

O grupo gostaria de deixar suas palavras de agradecimento à equipe de mentores do Tomorrow's Talents, à equipe de apoio da TechCamps e aos senseis do projeto.