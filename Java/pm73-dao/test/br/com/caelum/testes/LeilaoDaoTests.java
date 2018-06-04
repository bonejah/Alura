package br.com.caelum.testes;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.pm73.dao.CriadorDeSessao;
import br.com.caelum.pm73.dao.LeilaoDao;
import br.com.caelum.pm73.dao.UsuarioDao;
import br.com.caelum.pm73.dominio.Leilao;
import br.com.caelum.pm73.dominio.LeilaoBuilder;
import br.com.caelum.pm73.dominio.Usuario;

public class LeilaoDaoTests {
	private Session session;
	private LeilaoDao leilaoDao;
	private UsuarioDao usuarioDao;

	@Before
	public void antes() {
		session = new CriadorDeSessao().getSession();
		leilaoDao = new LeilaoDao(session);
		usuarioDao = new UsuarioDao(session);
		session.beginTransaction();
	}

	@After
	public void depois() {
		session.getTransaction().rollback();
		session.close();
	}

	@Test
	public void deveContarLeiloesNaoEncerrados() {
		Usuario jose = new Usuario("Jose Lima", "bruno@lima.com.br");

		Leilao ativo = new LeilaoBuilder().comDono(jose).constroi();
		Leilao encerrado = new LeilaoBuilder().comDono(jose).encerrado().constroi();

		usuarioDao.salvar(jose);
		leilaoDao.salvar(ativo);
		leilaoDao.salvar(encerrado);

		long total = leilaoDao.total();

		assertEquals(1L, total);
	}

	@Test
	public void deveRetornarZeroSeNaoHaLeiloesNovos() {
		Usuario jose = new Usuario("Jose Lima", "bruno@lima.com.br");

		Leilao encerrado = new Leilao("PS4", 2000.0, jose, false);
		Leilao tambemEncerrado = new Leilao("XBox", 2000.0, jose, false);

		encerrado.encerra();
		tambemEncerrado.encerra();

		usuarioDao.salvar(jose);
		leilaoDao.salvar(encerrado);
		leilaoDao.salvar(tambemEncerrado);

		long total = leilaoDao.total();

		assertEquals(0L, total);
	}

	@Test
	public void deveRetornarLeiloesDeProdutosNovos() {
		Usuario mauricio = new Usuario("Mauricio Aniche", "mauricio@aniche.com.br");

		Leilao produtoNovo = new Leilao("XBox", 700.0, mauricio, false);
		Leilao produtoUsado = new Leilao("Geladeira", 1500.0, mauricio, true);

		usuarioDao.salvar(mauricio);
		leilaoDao.salvar(produtoNovo);
		leilaoDao.salvar(produtoUsado);

		List<Leilao> novos = leilaoDao.novos();

		assertEquals(1, novos.size());
		assertEquals("XBox", novos.get(0).getNome());
	}

	@Test
	public void deveTrazerSomenteLeiloesAntigos() {
		Usuario mauricio = new Usuario("Mauricio Aniche", "mauricio@aniche.com.br");

		Leilao recente = new Leilao("XBox", 700.0, mauricio, false);
		Leilao antigo = new Leilao("Geladeira", 1500.0, mauricio, true);

		Calendar dataRecente = Calendar.getInstance();
		Calendar dataAntiga = Calendar.getInstance();
		dataAntiga.add(Calendar.DAY_OF_MONTH, -10);

		recente.setDataAbertura(dataRecente);
		antigo.setDataAbertura(dataAntiga);

		usuarioDao.salvar(mauricio);
		leilaoDao.salvar(recente);
		leilaoDao.salvar(antigo);

		List<Leilao> antigos = leilaoDao.antigos();

		assertEquals(1, antigos.size());
		assertEquals("Geladeira", antigos.get(0).getNome());
	}

	@Test
	public void deveTrazerSomenteLeiloesAntigosHaMaisDe7Dias() {
		Usuario mauricio = new Usuario("Mauricio Aniche", "mauricio@aniche.com.br");

		Leilao noLimite = new Leilao("XBox", 700.0, mauricio, false);

		Calendar dataAntiga = Calendar.getInstance();
		dataAntiga.add(Calendar.DAY_OF_MONTH, -7);

		noLimite.setDataAbertura(dataAntiga);

		usuarioDao.salvar(mauricio);
		leilaoDao.salvar(noLimite);

		List<Leilao> antigos = leilaoDao.antigos();

		assertEquals(1, antigos.size());
	}

	@Test
	public void deveTrazerLeiloesNaoEncerradosNoPeriodo() {
		// criando as datas
		Calendar comecoDoIntervalo = Calendar.getInstance();
		comecoDoIntervalo.add(Calendar.DAY_OF_MONTH, -10);
		Calendar fimDoIntervalo = Calendar.getInstance();
		Calendar dataDoLeilao1 = Calendar.getInstance();
		dataDoLeilao1.add(Calendar.DAY_OF_MONTH, -2);
		Calendar dataDoLeilao2 = Calendar.getInstance();
		dataDoLeilao2.add(Calendar.DAY_OF_MONTH, -20);

		Usuario mauricio = new Usuario("Mauricio Aniche", "mauricio@aniche.com.br");

		// criando os leiloes, cada um com uma data
		Leilao leilao1 = new Leilao("XBox", 700.0, mauricio, false);
		leilao1.setDataAbertura(dataDoLeilao1);
		Leilao leilao2 = new Leilao("Geladeira", 1700.0, mauricio, false);
		leilao2.setDataAbertura(dataDoLeilao2);

		// persistindo os objetos no banco
		usuarioDao.salvar(mauricio);
		leilaoDao.salvar(leilao1);
		leilaoDao.salvar(leilao2);

		// invocando o metodo para testar
		List<Leilao> leiloes = leilaoDao.porPeriodo(comecoDoIntervalo, fimDoIntervalo);

		// garantindo que a query funcionou
		assertEquals(1, leiloes.size());
		assertEquals("XBox", leiloes.get(0).getNome());
	}

	@Test
	public void naoDeveTrazerLeiloesEncerradosNoPeriodo() {
		// criando as datas
		Calendar comecoDoIntervalo = Calendar.getInstance();
		comecoDoIntervalo.add(Calendar.DAY_OF_MONTH, -10);
		Calendar fimDoIntervalo = Calendar.getInstance();
		Calendar dataDoLeilao1 = Calendar.getInstance();
		dataDoLeilao1.add(Calendar.DAY_OF_MONTH, -2);

		Usuario mauricio = new Usuario("Mauricio Aniche", "mauricio@aniche.com.br");

		// criando os leiloes, cada um com uma data
		Leilao leilao1 = new Leilao("XBox", 700.0, mauricio, false);
		leilao1.setDataAbertura(dataDoLeilao1);
		leilao1.encerra();

		// persistindo os objetos no banco
		usuarioDao.salvar(mauricio);
		leilaoDao.salvar(leilao1);

		// invocando o metodo para testar
		List<Leilao> leiloes = leilaoDao.porPeriodo(comecoDoIntervalo, fimDoIntervalo);

		// garantindo que a query funcionou
		assertEquals(0, leiloes.size());
	}

	@Test
	public void deveDeletarUmUsuario() {
		Usuario mauricio = new Usuario("Mauricio Aniche", "mauricio@aniche.com.br");
		Leilao leilao = new LeilaoBuilder().comDono(mauricio).comLance(Calendar.getInstance(), mauricio, 10000.0)
				.constroi();

		usuarioDao.salvar(mauricio);
		usuarioDao.deletar(mauricio);
		// envia tudo para o banco de dados
		session.flush(); // forçar o Hibernate a enviar comandos para o banco de dados,
		
		leilaoDao.deleta(leilao);

		// Usuario usuarioNoBanco = usuarioDao.porNomeEEmail("Mauricio Aniche", "mauricio@aniche.com.br");
		// assertNull(usuarioNoBanco);

		assertNull(leilaoDao.porId(leilao.getId()));
	}

}
