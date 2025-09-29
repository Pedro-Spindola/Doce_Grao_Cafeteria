# Resumo: Métodos de Consulta por Convenção de Nomes (Spring Data JPA)

O método de consulta baseado em convenção de nomes é um recurso que permite a criação de consultas a bancos de dados **sem escrever SQL ou JPQL manualmente**. O framework (como o Spring Data JPA) interpreta o nome de um método em uma interface de repositório e **gera a consulta automaticamente**.

## Estrutura Básica do Nome do Método

Um nome de método de consulta é composto pela **Ação**, pelo separador **`By`**, pelas **Propriedades (com Operadores)** e, opcionalmente, pela **Ordenação**.

$$\text{<Ação> + By + <Propriedade(s) + Operadores> + <Ordenação (opcional)>}$$

---

## 1. As Ações (Prefixos)

As ações definem o tipo de operação que será realizada no banco de dados.

| Ação | Propósito | Retorno Comum | Exemplo de Método |
| :--- | :--- | :--- | :--- |
| **`find`, `read`, `get`, `query`** | **Recuperar** dados. São funcionalmente equivalentes; a escolha é geralmente por clareza e convenção. | Entidade, `List<Entidade>`, `Optional<Entidade>`, `Stream<Entidade>`. | `Produto **findByNome**(String nome);` |
| **`count`** | **Contar** o número de entidades que correspondem à condição. | `Long` ou `Integer`. | `**Long countByStatus**(String status);` |
| **`exists`** | **Verificar a existência** de registros que correspondem à condição. | `boolean` (`true` ou `false`). | `**boolean existsByEmail**(String email);` |
| **`delete`** ou **`remove`** | **Excluir** entidades do banco de dados que correspondam à condição. | `void` ou `Long` (número de registros excluídos). | `**Long deleteByStatusInativo**();` |

---

## 2. Palavras-Chave de Condição (Operadores)

Após o separador **`By`**, você lista as propriedades da sua entidade (em *Camel Case*) e os operadores de comparação.

| Operador | Significado | Exemplo de Método | Lógica SQL Gerada |
| :--- | :--- | :--- | :--- |
| **(Sem Operador)** | Igualdade (`=`) | `findByNome` | `... WHERE nome = ?` |
| **`And`** | Combina condições com AND | `findByNome**And**Preco` | `... WHERE nome = ? AND preco = ?` |
| **`Or`** | Combina condições com OR | `findByNome**Or**Preco` | `... WHERE nome = ? OR preco = ?` |
| **`LessThan`** | Menor que (`<`) | `findByPreco**LessThan**` | `... WHERE preco < ?` |
| **`GreaterThan`** | Maior que (`>`) | `findByData**GreaterThan**` | `... WHERE data > ?` |
| **`Containing`** | Busca por sub-string (`%valor%`) | `findByDescricao**Containing**` | `... WHERE descricao LIKE %?%` |
| **`IsNull`** | Verifica se é nulo (`IS NULL`) | `findByEndereco**IsNull**` | `... WHERE endereco IS NULL` |
| **`Between`** | Entre dois valores | `findByData**Between**` | `... WHERE data BETWEEN ? AND ?` |

---

## 3. Ordenação (Cláusula ORDER BY)

A ordenação é adicionada ao final do método, após a última condição.

| Palavra-Chave | Significado | Exemplo de Método | Lógica SQL Gerada |
| :--- | :--- | :--- | :--- |
| **`OrderBy` + `Asc`** | Ordena de forma Ascendente (A-Z, 0-9) | `...OrderByNome**Asc**` | `... ORDER BY nome ASC` |
| **`OrderBy` + `Desc`** | Ordena de forma Descendente (Z-A, 9-0) | `...OrderByPreco**Desc**` | `... ORDER BY preco DESC` |

---

## 4. O Caso Especial: Buscar Todos

Para buscar **todos** os registros, o método correto a ser usado é o **`findAll()`**, que já é fornecido pela interface base do repositório, e **não** `findByAll`.

| Ação Desejada | Método Correto |
| :--- | :--- |
| **Buscar todos os produtos** | `List<Produto> findAll();` |

---


# Resumo: Anotações de Mapeamento de Relacionamentos JPA

As anotações de relacionamento da JPA (Java Persistence API), como @OneToMany, são usadas para mapear as conexões entre classes (modelo orientado a objetos) e tabelas (modelo relacional) em um banco de dados. Elas eliminam a necessidade de escrever SQL/JPQL de JOIN manualmente.

---

## 1. @OneToOne (Um para Um)

| Característica | Detalhes |
| :--- | :--- |
| **Conceito** | Uma instância da Entidade A se relaciona com exatamente uma instância da Entidade B. |
| **Exemplo** | `Usuário` (1) ↔ (1) `Perfil` |
| **Implementação** | Em ambas as classes, o campo de relacionamento é um **objeto único**. |
| **Chave Estrangeira (FK)** | A FK está em uma das tabelas e deve ser **única** para garantir a exclusividade. |
| **Exemplo de Código (Lado Proprietário)** | ```java @OneToOne @JoinColumn(name = "perfil_id") private Perfil perfil; ``` |

---

## 2. @ManyToOne (Muitos para Um)

| Característica | Detalhes |
| :--- | :--- |
| **Conceito** | Múltiplas instâncias da Entidade A se relacionam com uma única instância da Entidade B. |
| **Exemplo** | `Produto` (Muitos) → (1) `Categoria` |
| **Implementação** | O campo de relacionamento é um **objeto único** (a entidade "Um"). |
| **Lado Proprietário** | O lado `@ManyToOne` é o **proprietário da relação** e é onde a chave estrangeira é definida. |
| **Chave Estrangeira (FK)** | A FK reside na tabela do lado "Muitos". |
| **Exemplo de Código** | ```java @ManyToOne @JoinColumn(name = "categoria_id") private Categoria categoria; ``` |

---

## 3. @OneToMany (Um para Muitos)

| Característica | Detalhes |
| :--- | :--- |
| **Conceito** | Uma instância da Entidade A se relaciona com múltiplas instâncias da Entidade B. É o inverso de `@ManyToOne`. |
| **Exemplo** | `Categoria` (1) ← (Muitos) `Produto` |
| **Implementação** | O campo de relacionamento é uma **Coleção** (`List`, `Set`, etc.) de entidades. |
| **Lado Inverso** | No mapeamento bidirecional, este lado é o **inverso (não proprietário)**. |
| **Atributo Chave** | **`mappedBy`**: É obrigatório no lado `@OneToMany` em relações bidirecionais e aponta para o nome do campo proprietário (`@ManyToOne`) na outra entidade. |
| **Exemplo de Código (Lado Inverso)** | ```java @OneToMany(mappedBy = "categoria") private List<Produto> produtos; ``` |

---

## 4. @ManyToMany (Muitos para Muitos)

| Característica | Detalhes |
| :--- | :--- |
| **Conceito** | Múltiplas instâncias da Entidade A se relacionam com múltiplas instâncias da Entidade B. |
| **Exemplo** | `Estudante` (Muitos) ↔ (Muitos) `Curso` |
| **Implementação** | O campo de relacionamento é uma **Coleção** em ambas as classes. |
| **Banco de Dados** | O JPA cria automaticamente uma **terceira tabela (tabela de junção)** para armazenar as duas chaves estrangeiras. |
| **Atributo Chave** | **`@JoinTable`**: Usado para customizar o nome da tabela de junção e as chaves estrangeiras dentro dela. |
| **Exemplo de Código (Lado Proprietário)** | ```java @ManyToMany @JoinTable(name = "estudante_curso", joinColumns = @JoinColumn(name = "estudante_id"), inverseJoinColumns = @JoinColumn(name = "curso_id")) private Set<Curso> cursos; ``` |

---

## Atributos de Configuração Essenciais

| Atributo | Padrão | Função |
| :--- | :--- | :--- |
| **`fetch`** | **`EAGER`** para `*ToOne` / **`LAZY`** para `*ToMany` | Controla quando os dados relacionados são carregados. **`LAZY`** (sob demanda) é recomendado para coleções grandes para evitar problemas de performance. |
| **`cascade`** | Nenhum | Define a propagação de operações (salvar, remover, atualizar, etc.) da entidade principal para a(s) entidade(s) relacionada(s). **`CascadeType.ALL`** propaga todas as operações. |
| **`@JoinColumn`** | Nome padrão (ex: `perfil_id`) | Define a coluna de chave estrangeira na tabela do lado proprietário da relação. |