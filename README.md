## Padrão de projeto DAO (Data Access Object)

**Referências:**
https://www.devmedia.com.br/dao-pattern-persistencia-de-dados-utilizando-o-padrao-dao/30999
https://www.oracle.com/technetwork/java/dataaccessobject-138824.html

**Ideia geral do padrão DAO:**
- Para cada entidade, haverá um objeto **responsável por fazer acesso a dados relacionado a esta
entidade**. Por exemplo:
  - Cliente: ClienteDao
  - Produto: ProdutoDao
  - Pedido: PedidoDao
- Cada DAO será definido por uma interface.
- A injeção de dependência pode ser feita por meio do padrão de projeto Factory

![image](https://user-images.githubusercontent.com/56324728/90800594-40c3ff00-e2eb-11ea-84ab-f23f8f381da9.png)

## Creating project and git repository

**Project:** http://github.com/acenelio/demo-dao-jdbc

**Checklist:**
- Github: create a new project
  - **NOTE**: choose .gitignore type as Java
- Eclipse: create new java project with MySQLConnector library
  - Copy db package and db.properties from: https://github.com/acenelio/jdbc5
- Create local repository and push to Github:
        
      git init
      git remote add origin https://github.com/acenelio/jdbc-dao-demo.git
      git pull origin master
      git add .
      git commit -m "Project created"
      git push -u origin master
 
## Department entity class

**Entity class checklist:**
- Attributes
- Constructors
- Getters/Setters
- hashCode and equals
- toString
- implements Serializable

![image](https://user-images.githubusercontent.com/56324728/90803554-49b6cf80-e2ef-11ea-826c-26653786224a.png)

## Seller entity class

(video)
