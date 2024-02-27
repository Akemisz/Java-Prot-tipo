# Java-Prototipo

O protótipo de nosso sistema consiste em uma área de membros voltados para cursos e ebooks sobre saúde e qualidade de vida.

Link de acesso ao figma: 
- https://www.figma.com/file/vBl0qh73W7SGXPEab4L4cF/JavaSystem?type=design&node-id=0%3A1&mode=design&t=819eqEGATiOPpIge-1

## Requisitos

- [ ] CRUD Movimentações
- [ ] CRUD Categorias
- [ ] Dashboard
- [ ] Autenticação

## Endpoints

### Categorias

`GET` /categorias

Lista todas as categorias disponíveis.

`200` Sucesso!

--

`POST` /categorias

Cria nova categoria

| campo | tipo | obrigatório | descrição 
|-------|------|:-------------:|----------
| nome|string|✅|Um nome curto para identificar a categoria
|descrição|string|✅|Cursos e ebooks sobre exercícios físicos e atividades físicas para saúde e bem-estar.

**Código de status**
`201` Sucesso


--

`Get` /categoria/{id}/cursos

Retorna uma lista de todos os cursos disponíveis em uma categoria específica.

--

`GET` /categorias/{id}/ebooks

Retorna uma lista de todos os ebooks disponíveis em uma categoria específica.


--

`POST` /categorias/{id}/cursos

Cria um novo curso dentro de uma categoria específica.

--

`POST` /categorias/{id}/ebooks

Cria um novo ebook dentro de uma categoria específica.

-- 


`GET` /categorias/{id}

Retorna os detalhes de uma categoria específica, incluindo os cursos e ebooks relacionados.

**Código de status**
`200` Sucesso
`404` id não encontrado

--

`PUT` /categorias/{id}

Atualiza os detalhes de uma categoria existente.

| campo | tipo | obrigatório | descrição 
|-------|------|:-------------:|----------
| nome|string|✅|Nova categoria
|descrição|string|✅|Novo nome da descrição

**Código de status**
`201` Criado com sucesso
`404` Validação falou

--

`DELETE` /categorias/{id}

Remove uma categoria existente, juntamente com todos os cursos e ebooks associados.

**Códigos de status**

`204` Apagado com sucesso
`404` id não encontrado

```js
{
    "id": 1,
    "nome": "Exercícios Físicos",
    "descricao": "Cursos e ebooks sobre exercícios físicos e atividades físicas para saúde e bem-estar." 
}
```