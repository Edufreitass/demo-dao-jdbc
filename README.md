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

**Entity class checklist:**
- Attributes
- Constructors
- Getters/Setters
- hashCode and equals
- toString
- implements Serializable

## DepartmentDao and SellerDao interfaces

![image](https://user-images.githubusercontent.com/56324728/90810304-1d07b580-e2f9-11ea-969f-da17c49d82e8.png)

## SellerDaoJDBC and DaoFactory

**DaoFactory**
- Essa classe expõe um método que retorna o tipo da interface, mas internamente
ela vai instanciar uma implementação, é uma forma de não expor a implementação.

**DepartmentDao e SellerDao**
- As interfaces são uma forma de deixar sua classe dependente apenas da interface e
não de uma implementação. Desta forma, você pode no futuro trocar a
implementação sem se preocupar com impactos em outras partes do código, desde
que a nova implementação atenda à interface.

## findById implementation

**SQL Query:**

```sql
SELECT seller.*,department.Name as DepName
FROM seller INNER JOIN department
ON seller.DepartmentId = department.Id
WHERE seller.Id = ?
```

![image](https://user-images.githubusercontent.com/56324728/90812487-905ef680-e2fc-11ea-89d4-a63668b5bdaa.png)

## Reusing instantiation

```java
private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
      Seller obj = new Seller();
      obj.setId(rs.getInt("Id"));
      obj.setName(rs.getString("Name"));
      obj.setEmail(rs.getString("Email"));
      obj.setBaseSalary(rs.getDouble("BaseSalary"));
      obj.setBirthDate(rs.getDate("BirthDate"));
      obj.setDepartment(dep);
      return obj;
}

private Department instantiateDepartment(ResultSet rs) throws SQLException {
      Department dep = new Department();
      dep.setId(rs.getInt("DepartmentId"));
      dep.setName(rs.getString("DepName"));
      return dep;
}
```


