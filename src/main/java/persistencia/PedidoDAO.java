package persistencia;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.*;

public class PedidoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void inserir(Pedido ped) {

		Session sessao = HibernateUtil.getSessionfactory().openSession();

		try {

			Transaction t = sessao.beginTransaction();
			sessao.save(ped);
			t.commit();

		} finally {
			sessao.close();
		}
	}

	public static void actionRetornar(Pedido ped) {
		Session sessao = HibernateUtil.getSessionfactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.update(ped);
		t.commit();
		sessao.close();
	}

	public static List<Pedido> listagem(String filtro) {
		Session sessao = HibernateUtil.getSessionfactory().openSession();
		Query consulta;
		if(filtro.trim().length() == 0){
			consulta = sessao.createQuery("from Pedido order by pes_id");
		} else {
			consulta = sessao.createQuery("from Pedido "
					+ "where pes_id = parametro order by pes_id");
			consulta.setString("parametro", "%" + filtro + "%");
		}
		List<Pedido> lista = consulta.list();
		sessao.close();
		return lista;
}
}
