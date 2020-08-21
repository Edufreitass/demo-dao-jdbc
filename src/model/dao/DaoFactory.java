package model.dao;

import db.DB;
import model.dao.impl.DepartmentDaoJDBC;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

	/*
	 * Essa classe expõe um método que retorna o tipo da interface, mas internamente
	 * ela vai instanciar uma implementação, é uma forma de não expor a implementação.
	 */

	/*
	 * A interface é uma forma de deixar sua classe dependente apenas da interface e
	 * não de uma implementação. Desta forma, você pode no futuro trocar a
	 * implementação sem se preocupar com impactos em outras partes do código, desde
	 * que a nova implementação atenda à interface.
	 */

	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}
	
	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC(DB.getConnection());
	}

}
