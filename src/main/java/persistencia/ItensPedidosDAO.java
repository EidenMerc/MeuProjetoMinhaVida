package persistencia;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.*;

public class ItensPedidosDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void inserir(Itens_pedido iten) {

		Session sessao = HibernateUtil.getSessionfactory().openSession();

		try {
			Transaction t = sessao.beginTransaction();
			sessao.save(iten);
			t.commit();

		} finally {
			sessao.close();
		}
	}
}
