package br.com.caelum.auron.shiro;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

import br.com.caelum.auron.dao.ParticipanteDao;
import br.com.caelum.auron.modelo.Participante;

public class Autenticador implements Realm {
	private ParticipanteDao participanteDao;

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		String email = usernamePasswordToken.getUsername();
		String senha = new String(usernamePasswordToken.getPassword());

		participanteDao = getParticipanteDAO();
		Participante participante = participanteDao.getParticipante(email, senha);

		if (participante != null) {
			AuthenticationInfo info = new SimpleAuthenticationInfo(email, senha, getName());
			return info;
		}

		throw new AuthenticationException();
	}

	private ParticipanteDao getParticipanteDAO() {
		Properties properties = new Properties();
		properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

		try {
			InitialContext ctx = new InitialContext(properties);
			ParticipanteDao dao = (ParticipanteDao) ctx.lookup("java:module/ParticipanteDao");
			return dao;
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String getName() {
		return this.getClass().getSimpleName();
	}

	@Override
	public boolean supports(AuthenticationToken arg0) {
		return true;
	}

}
