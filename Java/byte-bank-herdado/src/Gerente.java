public class Gerente extends Funcionario implements Autenticavel {
	private AutenticacaoUtil  autenticacaoUtil;
	
	public Gerente() {
		this.autenticacaoUtil = new AutenticacaoUtil();
	}

	@Override
	public double getBonificacao() {
		return super.getSalario();
	}

	@Override
	public void setSenha(int senha) {
		this.autenticacaoUtil.setSenha(senha);
	}

	@Override
	public boolean autentica(int senha) {
		return this.autenticacaoUtil.autentica(senha);
	}
}
